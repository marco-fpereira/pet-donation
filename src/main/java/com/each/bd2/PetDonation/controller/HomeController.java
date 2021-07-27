package com.each.bd2.PetDonation.controller;

import com.each.bd2.PetDonation.dto.CadastroUsuarioDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("home")
public class HomeController {

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
