package com.each.bd2.PetDonation.controller;

import com.each.bd2.PetDonation.dto.CadastroUsuarioDTO;
import com.each.bd2.PetDonation.entities.Endereco;
import com.each.bd2.PetDonation.entities.Usuario;
import com.each.bd2.PetDonation.repository.EnderecoRepository;
import com.each.bd2.PetDonation.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @PostMapping("novo")
    public String novo(@Valid CadastroUsuarioDTO cadastroUsuarioDTO, BindingResult result){
        if(result.hasErrors()) return "usuario/cadastro";
        if(!cadastroUsuarioDTO.getSenha().equals(cadastroUsuarioDTO.getConfirmacaoSenha())){
            ObjectError obj = new ObjectError("cadastroUsuarioDTO.getConfirmacaoSenha()", "A senha e sua confirmação não correspondem");
            result.addError(obj);
            // https://stackoverflow.com/questions/12107503/adding-error-message-to-spring-3-databinder-for-custom-object-fields
            return "usuario/cadastro";
        }
        Endereco endereco = cadastroUsuarioDTO.toEndereco();
        enderecoRepository.save(endereco);

        Usuario usuario = cadastroUsuarioDTO.toUsuario();
        usuario.setEndereco(endereco);
        usuarioRepository.save(usuario);
        return "redirect:/login";
    }
}
