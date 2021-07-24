package com.each.bd2.PetDonation.service;

import com.each.bd2.PetDonation.dto.CadastroUsuarioDTO;
import com.each.bd2.PetDonation.entities.Endereco;
import com.each.bd2.PetDonation.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    @Transactional
    public Endereco save(CadastroUsuarioDTO cadastroUsuarioDTO) {
        Endereco endereco = cadastroUsuarioDTO.toEndereco();
        enderecoRepository.save(endereco);
        endereco.setId_endereco(enderecoRepository.getLastInsertId().longValue());
        return endereco;
    }


}
