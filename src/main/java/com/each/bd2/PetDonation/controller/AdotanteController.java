package com.each.bd2.PetDonation.controller;

import com.each.bd2.PetDonation.entities.Adocao;
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
import java.time.LocalDateTime;

@Controller
@RequestMapping("adotante")
public class AdotanteController {

    @Autowired
    PetService petService;

    @Autowired
    AdocaoService adocaoService;

    @Autowired
    AdotanteService adotanteService;

    @Autowired
    ResponsavelService responsavelService;

    @GetMapping("home")
    public String home(Model model){
        model.addAttribute("petsdisponiveis", petService.findByStatus(StatusPet.DISPONIVEL.toString()));
        return "usuario/adotante/homeadotante";
    }

    @GetMapping("adocao/{id}")
    public String adocao(@PathVariable(value = "id", required = false) Long pet_id, Model model){
        model.addAttribute("pet", petService.findById(pet_id));
        return "usuario/adotante/adocao";
    }

    @GetMapping("interesseadotar/{pet_id}")
    public String interesseAdotar(@PathVariable("pet_id") String pet_id, Principal principal, Model model){
        Adocao adocao = new Adocao(
                LocalDateTime.now(),
                StatusAdocao.EM_ABERTO.toString(),
                adotanteService.findByUsername(principal.getName()),
                petService.findResponsavel(Long.parseLong(pet_id)),
                petService.findById(Long.parseLong(pet_id)));
        adocaoService.save(adocao);
        petService.updateStatusEmAdocao(Long.parseLong(pet_id));
        return "redirect:/usuario/home";
    }
}
