package com.each.bd2.PetDonation.repository;

import com.each.bd2.PetDonation.entities.Adotante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdotanteRepository extends JpaRepository<Adotante, Long> {
}
