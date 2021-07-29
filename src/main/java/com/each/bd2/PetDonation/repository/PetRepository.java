package com.each.bd2.PetDonation.repository;

import com.each.bd2.PetDonation.entities.Pet;
import com.each.bd2.PetDonation.entities.Responsavel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PetRepository{

    @PersistenceContext
    EntityManager entityManager;

    public List<Pet> findAll(){
        try {
            return (List<Pet>) entityManager.createNativeQuery("SELECT * FROM tb_pet", Pet.class).getResultList();
        } catch (NoResultException e){
            System.out.println("Nenhum valor encontrado");
            return new ArrayList<Pet>();
        }
    }

    public void save(Pet pet){
        entityManager.createNativeQuery(
                "INSERT INTO tb_pet (nome_pet, especie, raca, sexo, castrado, idade_anos, idade_meses, porte, status, descricao, url_imagem, id_responsavel)" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")
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
                .setParameter(11, pet.getUrlImagem())
                .setParameter(12, pet.getResponsavel().getId_usuario())
                .executeUpdate();
    }

    public Pet findById(long id){
        try{
            return (Pet) entityManager.createNativeQuery(
                "SELECT * FROM tb_pet WHERE id_pet = ?", Pet.class)
                .setParameter(1, id)
                .getSingleResult();
        } catch (NoResultException e){
            System.out.println("Nenhum valor encontrado");
            return new Pet();
        }
    }

    public List<Pet> findByStatus(String status){
        try{
            return (List<Pet>) entityManager.createNativeQuery("SELECT * FROM tb_pet WHERE status = ?", Pet.class)
                .setParameter(1, status)
                .getResultList();
        } catch (NoResultException e){
            System.out.println("Nenhum valor encontrado");
            return new ArrayList<Pet>();
        }
    }

    public void updateStatus(Long pet_id, String status) {
        entityManager.createNativeQuery("UPDATE tb_pet SET status = ? " +
                "WHERE id_pet = ?")
                .setParameter(1, status)
                .setParameter(2, pet_id)
                .executeUpdate();
    }

    public Responsavel findResponsavel(Long id_pet) {
        try{
            return (Responsavel) entityManager.createNativeQuery(
            "SELECT tb_usuario.id_usuario, tb_usuario.cpf, tb_usuario.data_nasc, tb_usuario.nome," +
                    " tb_usuario.telefone, tb_usuario.id_endereco, tb_usuario.username  FROM tb_responsavel " +
                    "JOIN tb_usuario ON tb_responsavel.id_usuario = tb_usuario.id_usuario " +
                    "JOIN tb_pet ON tb_pet.id_responsavel = tb_responsavel.id_usuario " +
                    "WHERE tb_pet.id_pet = ?", Responsavel.class)
                    .setParameter(1, id_pet)
                    .getSingleResult();
        } catch (NoResultException e){
            System.out.println("Nenhum valor encontrado");
            return new Responsavel();
        }
    }
}
