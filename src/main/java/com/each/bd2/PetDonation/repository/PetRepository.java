package com.each.bd2.PetDonation.repository;

import com.each.bd2.PetDonation.entities.Pet;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PetRepository /*implements JpaRepository<Pet, Long>*/ {

    @PersistenceContext
    EntityManager entityManager;

    public List<Pet> findAll(){
        return (List<Pet>) entityManager.createNativeQuery("SELECT * FROM tb_pet", Pet.class).getResultList();
    }

    public void save(Pet pet){
        entityManager.createNativeQuery(
                "INSERT INTO tb_pet (nomePet, especie, raca, sexo, castrado, idadeAnos, idadeMeses, porte, status, descricao)" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")
                .setParameter(1, pet.getNomePet())
                .setParameter(2, pet.getEspecie())
                .setParameter(3, pet.getRaca())
                .setParameter(4, pet.getSexo())
                .setParameter(5, pet.getCastrado())
                .setParameter(6, pet.getIdadeAnos())
                .setParameter(7, pet.getIdadeMeses())
                .setParameter(8, pet.getPorte())
                .setParameter(9, pet.getStatus())
                .setParameter(10, pet.getDescricao())
                .executeUpdate();
    }

    public Pet findById(long id){
        return (Pet) entityManager.createNativeQuery(
                "SELECT * FROM tb_pet WHERE id_pet = ?", Pet.class)
                .setParameter(1, id)
                .getSingleResult();
    }

    public List<Pet> findByStatus(String status){
        return entityManager.createNativeQuery("SELECT * FROM tb_pet WHERE status = ?")
                .setParameter(1, status)
                .getResultList();
    }
}
