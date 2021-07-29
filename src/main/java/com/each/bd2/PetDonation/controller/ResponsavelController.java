package com.each.bd2.PetDonation.controller;

import com.each.bd2.PetDonation.entities.Responsavel;
import com.each.bd2.PetDonation.service.PetService;
import com.each.bd2.PetDonation.service.ResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("responsavel")
public class ResponsavelController {

    @Autowired
    ResponsavelService responsavelService;

    @Autowired
    PetService petService;

    @GetMapping("home")
    public String home(Model model, Principal principal){
        Responsavel responsavel = responsavelService.findByUsername(principal.getName());

        model.addAttribute("meuspets", responsavel.getPets());
        return "usuario/responsavel/homeresponsavel";
    }

    @GetMapping("aceiteadocao/{id}")
    public String aceiteAdocao(@PathVariable(value = "id", required = false) Long pet_id, Model model){
        model.addAttribute("pet", petService.findById(pet_id));
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
