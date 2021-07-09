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
    public ResponseEntity novo(@Valid CadastroUsuarioDTO cadastroUsuarioDTO, BindingResult result){
        // if(result.hasErrors()) return "usuario/cadastro";
        if(result.hasErrors()) return new ResponseEntity(result.getFieldErrors(), HttpStatus.BAD_REQUEST);

        Endereco endereco = cadastroUsuarioDTO.toEndereco();
        enderecoRepository.save(endereco);

        Usuario usuario = cadastroUsuarioDTO.toUsuario();
        usuario.setEndereco(endereco);
        usuarioRepository.save(usuario);
        //return "redirect:/login"
        return new ResponseEntity(endereco, HttpStatus.CREATED);
    }
}
