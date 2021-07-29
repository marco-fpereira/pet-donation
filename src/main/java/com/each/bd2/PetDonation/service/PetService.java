package com.each.bd2.PetDonation.service;

import com.each.bd2.PetDonation.entities.Pet;
import com.each.bd2.PetDonation.entities.enums.StatusPet;
import com.each.bd2.PetDonation.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PetService {

    @Autowired
    PetRepository petRepository;

    public List<Pet> findByStatus(String status){
        return petRepository.findByStatus(status);
    }

    public Pet findById(Long id){
        return petRepository.findById(id);
    }

    @Transactional
    public void save(Pet pet){
        petRepository.save(pet);
    }

    @Transactional
    public void updateStatusEmAdocao(Long pet_id) {
        petRepository.updateStatus(pet_id, StatusPet.EM_DOACAO.toString());
    }
}
