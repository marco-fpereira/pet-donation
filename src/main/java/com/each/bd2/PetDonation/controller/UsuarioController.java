package com.each.bd2.PetDonation.controller;

import com.each.bd2.PetDonation.config.Users;
import com.each.bd2.PetDonation.dto.CadastroUsuarioDTO;
import com.each.bd2.PetDonation.entities.Endereco;
import com.each.bd2.PetDonation.entities.Pet;
import com.each.bd2.PetDonation.entities.Responsavel;
import com.each.bd2.PetDonation.entities.Usuario;
import com.each.bd2.PetDonation.entities.enums.StatusPet;
import com.each.bd2.PetDonation.service.EnderecoService;
import com.each.bd2.PetDonation.service.PetService;
import com.each.bd2.PetDonation.service.ResponsavelService;
import com.each.bd2.PetDonation.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ResponsavelService responsavelService;

    @Autowired
    PetService petService;

    @Autowired
    EnderecoService enderecoService;

    @GetMapping("home")
    public String home(Model model, Principal principal){
        Responsavel responsavel = responsavelService.findByUsername(principal.getName());
        if(responsavel != null) {
            model.addAttribute("meuspets", responsavelService.findPetsById(responsavel.getId_usuario()));
            return "usuario/responsavel/homeresponsavel";
        }else {
            List<Pet> petsDisponiveis = petService.findByStatus(StatusPet.DISPONIVEL.toString());
            model.addAttribute("petsdisponiveis", petsDisponiveis);
            return "usuario/adotante/homeadotante";
        }
    }

    @PostMapping("novo")
    public String novo(@Valid CadastroUsuarioDTO cadastroUsuarioDTO, BindingResult result){
        if(result.hasErrors()) return "usuario/cadastro";
        if(!cadastroUsuarioDTO.getSenha().equals(cadastroUsuarioDTO.getConfirmacaoSenha())){
            result.rejectValue("confirmacaoSenha", "error.confirmacaoSenha", "A senha e sua confirmação não correspondem");
            return "usuario/cadastro";
        }
        if(usuarioService.findUsersById(cadastroUsuarioDTO.getEmail()) != null){
            result.rejectValue("email", "error.email", "O e-mail informado já existe");
            return "usuario/cadastro";
        }
        Endereco endereco = enderecoService.save(cadastroUsuarioDTO);
        Users user = usuarioService.saveUsers(cadastroUsuarioDTO);
        Usuario usuario = usuarioService.saveUsuario(cadastroUsuarioDTO, user, endereco.getId_endereco());

        boolean isResp = cadastroUsuarioDTO.getTipoUsuario().equalsIgnoreCase("responsavel");
        if(isResp) usuarioService.executeResponsavelSave(usuario);
        else usuarioService.executeAdotanteSave(usuario);
        return "redirect:/login";
    }

    @GetMapping("perfil/{id_usuario}")
    public String perfil(@PathVariable("id_usuario") String id_usuario, Model model){
        model.addAttribute("usuario", usuarioService.findUsuarioById(Long.parseLong(id_usuario)));
        return "usuario/perfil";    // -> FALTA CONSTRUIR ESSA TELA
    }

//    @ExceptionHandler(IllegalArgumentException.class)
//    public String error(){
//        return "redirect:/home";
//    }
}
