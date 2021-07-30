package com.each.bd2.PetDonation.controller;

import com.each.bd2.PetDonation.entities.Responsavel;
import com.each.bd2.PetDonation.entities.enums.StatusAdocao;
import com.each.bd2.PetDonation.entities.enums.StatusPet;
import com.each.bd2.PetDonation.service.AdocaoService;
import com.each.bd2.PetDonation.service.AdotanteService;
import com.each.bd2.PetDonation.service.PetService;
import com.each.bd2.PetDonation.service.ResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("responsavel")
public class ResponsavelController {

    @Autowired
    ResponsavelService responsavelService;

    @Autowired
    PetService petService;

    @Autowired
    AdotanteService adotanteService;

    @Autowired
    AdocaoService adocaoService;

    @GetMapping("home")
    public String home(Model model, Principal principal){
        Responsavel responsavel = responsavelService.findByUsername(principal.getName());

        model.addAttribute("meuspets", responsavel.getPets());
        return "usuario/responsavel/homeresponsavel";
    }

    @GetMapping("aceiteadocao/{id}")
    public String aceiteAdocao(@PathVariable(value = "id", required = false) Long pet_id, Model model){
        model.addAttribute("adotante", adotanteService.findByIdPet(pet_id));
        model.addAttribute("pet", petService.findById(pet_id));
        return "usuario/responsavel/aceiteadocao";
    }

    @GetMapping("aceito")
    public String adocaoAceita(
            @RequestParam(value = "id_pet", required = false) Long id_pet,
            @RequestParam(value = "id_adotante", required = false) Long id_adotante){
        adocaoService.updateStatusByIdPet(id_pet, id_adotante, StatusAdocao.ACEITA.toString());
        petService.updateStatus(id_pet, StatusPet.DOADO.toString());
        return "redirect:/usuario/home";
    }

    @GetMapping("rejeitado")
    public String adocaoRejeitada(
            @RequestParam(value = "id_pet", required = false) Long id_pet,
            @RequestParam(value = "id_adotante", required = false) Long id_adotante){
        adocaoService.updateStatusByIdPet(id_pet, id_adotante, StatusAdocao.REJEITADA.toString());
        petService.updateStatus(id_pet, StatusPet.DISPONIVEL.toString());
        return "redirect:/usuario/home";
    }
}
