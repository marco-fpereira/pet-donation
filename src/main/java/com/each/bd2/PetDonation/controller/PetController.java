package com.each.bd2.PetDonation.controller;

import com.each.bd2.PetDonation.dto.CadastroPetDTO;
import com.each.bd2.PetDonation.entities.Pet;
import com.each.bd2.PetDonation.entities.Responsavel;
import com.each.bd2.PetDonation.entities.enums.StatusPet;
import com.each.bd2.PetDonation.service.PetService;
import com.each.bd2.PetDonation.service.ResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("pet")
public class PetController {

    @Autowired
    PetService petService;

    @Autowired
    ResponsavelService responsavelService;

    @GetMapping
    public String petHome(Model model){
        return "";
    }

    @GetMapping("cadastro")
    public String cadastroPet(CadastroPetDTO cadastroPetDTO){
        return "pet/cadastro";
    }

    @PostMapping("novo")
    public String novo(@Valid CadastroPetDTO cadastroPetDTO, BindingResult result, Principal principal, Model model){
        if(result.hasErrors()) return "pet/cadastro";

        Pet p = cadastroPetDTO.toPet();
        Responsavel responsavel = responsavelService.findByUsername(principal.getName());
        p.setResponsavel(responsavel);
        petService.save(p);
        return "redirect:/usuario/home";
    }

    @GetMapping("adocao/{id_pet}")
    public String adocao(@PathVariable("id_pet")String id_pet, Model model){
        Pet pet = petService.findById(Long.parseLong(id_pet));
        model.addAttribute("responsavel", responsavelService.findById(pet.getResponsavel().getId_usuario()));
        model.addAttribute("pet", pet);
        return "usuario/adotante/adocao";
    }

}
