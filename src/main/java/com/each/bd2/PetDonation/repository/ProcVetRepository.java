package com.each.bd2.PetDonation.repository;

import com.each.bd2.PetDonation.entities.ProcVet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcVetRepository extends JpaRepository<ProcVet, Long> {

}
