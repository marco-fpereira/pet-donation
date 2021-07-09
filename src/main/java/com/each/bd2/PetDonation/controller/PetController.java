package com.each.bd2.PetDonation.controller;

import com.each.bd2.PetDonation.dto.CadastroPetDTO;
import com.each.bd2.PetDonation.entities.Pet;
import com.each.bd2.PetDonation.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/pet")
public class PetController {

    @Autowired
    PetRepository petRepository;

    @GetMapping
    public String petHome(Model model){
        return "";
    }

    @GetMapping(value = "/cadastro")
    public String cadastroPet(@Valid CadastroPetDTO petDTO, BindingResult result){
        if(result.hasErrors()) return "cadastro";

        Pet p = petDTO.toPet();
        petRepository.save(p);
        return "redirect:/usuario/home";
    }

}
