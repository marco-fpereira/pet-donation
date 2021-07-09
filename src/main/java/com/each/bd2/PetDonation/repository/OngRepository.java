package com.each.bd2.PetDonation.repository;

import com.each.bd2.PetDonation.entities.Ong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OngRepository extends JpaRepository<Ong, Long> {

}
