package com.each.bd2.PetDonation.service;

import com.each.bd2.PetDonation.entities.Adotante;
import com.each.bd2.PetDonation.entities.Responsavel;
import com.each.bd2.PetDonation.repository.AdotanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdotanteService {

    @Autowired
    AdotanteRepository adotanteRepository;

    public Adotante findByUsername(String username){
        return adotanteRepository.findByUsername(username);
    }

    public Adotante findById(Long id){
        return adotanteRepository.findById(id);
    }

}
