package com.each.bd2.PetDonation.repository;

import com.each.bd2.PetDonation.entities.Doacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoacaoRepository extends JpaRepository<Doacao, Long> {
}
