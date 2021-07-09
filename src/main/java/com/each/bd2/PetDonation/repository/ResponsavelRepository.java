package com.each.bd2.PetDonation.repository;

import com.each.bd2.PetDonation.entities.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Long> {

}
