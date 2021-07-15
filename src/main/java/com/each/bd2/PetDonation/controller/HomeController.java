package com.each.bd2.PetDonation.controller;

import com.each.bd2.PetDonation.dto.CadastroUsuarioDTO;
import com.each.bd2.PetDonation.entities.Endereco;
import com.each.bd2.PetDonation.entities.Usuario;
import com.each.bd2.PetDonation.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("home")
public class HomeController {

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public String home(Model model){

        return "home";
    }

    @GetMapping("cadastro")
    public String cadastro(CadastroUsuarioDTO cadastroUsuarioDTO){
        return "usuario/cadastro";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }


}
