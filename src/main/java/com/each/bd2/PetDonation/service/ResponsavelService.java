package com.each.bd2.PetDonation.service;

import com.each.bd2.PetDonation.entities.Pet;
import com.each.bd2.PetDonation.entities.Responsavel;
import com.each.bd2.PetDonation.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponsavelService {

    @Autowired
    ResponsavelRepository responsavelRepository;

    public Responsavel findByUsername(String username){
        return responsavelRepository.findByUsername(username);
    }

    public Responsavel findById(Long id){
        return responsavelRepository.findById(id);
    }

    public List<Pet> findPetsById(Long id){
        return responsavelRepository.findPetsById(id);
    }
}
