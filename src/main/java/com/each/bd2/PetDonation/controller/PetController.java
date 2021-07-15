package com.each.bd2.PetDonation.controller;

import com.each.bd2.PetDonation.dto.CadastroPetDTO;
import com.each.bd2.PetDonation.entities.Pet;
import com.each.bd2.PetDonation.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import javax.validation.Valid;

@Controller
@RequestMapping("pet")
public class PetController {

    @Autowired
    PetRepository petRepository;

    @GetMapping
    public String petHome(Model model){
        return "";
    }

    @GetMapping("cadastro")
    public String cadastroPet(CadastroPetDTO cadastroPetDTO){
        return "pet/cadastro";
    }

    @PostMapping("novo")
    public String novo(@Valid CadastroPetDTO cadastroPetDTO, BindingResult result){
        if(result.hasErrors()) return "pet/cadastro";

        Pet p = cadastroPetDTO.toPet();
        petRepository.save(p);
        return "redirect:/home";
    }

}
