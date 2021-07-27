package com.each.bd2.PetDonation.controller;

import com.each.bd2.PetDonation.entities.Responsavel;
import com.each.bd2.PetDonation.service.ResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("responsavel")
public class ResponsavelController {

    @Autowired
    ResponsavelService responsavelService;

    @GetMapping("home")
    public String home(Model model, Principal principal){
        Responsavel responsavel = responsavelService.findByUsername(principal.getName());

        model.addAttribute("meuspets", responsavel.getPets());
        return "usuario/responsavel/homeresponsavel";
    }

    @GetMapping("aceiteadocao")
    public String aceiteAdocao(){
        return "usuario/responsavel/aceiteadocao";
    }

    @GetMapping("aceito")
    public String adocaoAceita(){
        return null;
    }

    @GetMapping("rejeitado")
    public String adocaoRejeitada(){
        return null;
    }
}
