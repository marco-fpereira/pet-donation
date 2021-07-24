package com.each.bd2.PetDonation.controller;

import com.each.bd2.PetDonation.entities.enums.StatusPet;
import com.each.bd2.PetDonation.repository.PetRepository;
import com.each.bd2.PetDonation.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("adotante")
public class AdotanteController {

    @Autowired
    PetService petService;

    @GetMapping("home")
    public String home(Model model){
        model.addAttribute("petsdisponiveis", petService.findByStatus(StatusPet.DISPONIVEL.toString()));
        return "usuario/adotante/homeadotante";
    }

    @GetMapping("adocao/{pet_id}")
    public String adocao(@PathVariable("pet_id") String pet_id,  Model model){
        model.addAttribute("pet", petService.findById(Long.parseLong(pet_id)));
        return "usuario/adotante/adocao";
    }
}
