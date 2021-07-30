package com.each.bd2.PetDonation.service;

import com.each.bd2.PetDonation.entities.Adocao;
import com.each.bd2.PetDonation.repository.AdocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdocaoService {

    @Autowired
    AdocaoRepository adocaoRepository;

    @Transactional
    public void save(Adocao adocao){
        adocaoRepository.save(adocao);
    }

    public Adocao findByIdAdotante(Long id){
        return null;
    }

    public Adocao findByIdResponsavel(Long id){
        return null;
    }

    public Adocao findByIdPet(Long id){
        return null;
    }

    @Transactional
    public void updateStatusByIdPet(Long pet_id, Long adotante_id, String status) {
        adocaoRepository.updateStatusByIdPet(pet_id, adotante_id, status);
    }
}
