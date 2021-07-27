package com.each.bd2.PetDonation.repository;

import com.each.bd2.PetDonation.entities.Pet;
import com.each.bd2.PetDonation.entities.Responsavel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ResponsavelRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    UsuarioRepository usuarioRepository;

    public void save(Responsavel responsavel){
        entityManager.createNativeQuery(
            "INSERT INTO tb_responsavel (id_usuario) VALUES (?)")
                .setParameter(1, responsavel.getId_usuario())
                .executeUpdate();
    }

    public Responsavel findById(long id_responsavel){
        try {
        return (Responsavel) entityManager.createNativeQuery(
                "SELECT * FROM tb_usuario " +
                        "JOIN tb_responsavel ON tb_responsavel.id_usuario = tb_usuario.id_usuario" +
                        "WHERE id_usuario = ?", Responsavel.class)
                .setParameter(1, id_responsavel)
                .getSingleResult();
        } catch (NoResultException e){
            System.out.println("Entidade nao encontrada para a query");
            return new Responsavel();
        }
    }

    public Responsavel findByUsername(String username){
        try {
            return (Responsavel) entityManager.createNativeQuery(
                    "SELECT *, 0 AS clazz_ FROM tb_usuario " +
                            "JOIN tb_responsavel ON tb_responsavel.id_usuario = tb_usuario.id_usuario " +
                            "WHERE tb_usuario.username = ?", Responsavel.class)
                    .setParameter(1, username)
                    .getSingleResult();
        } catch (NoResultException e){
            System.out.println("Entidade nao encontrada para a query");
            return null;
        }
    }

    public List<Pet> findPetsByUsername(String username) {
        try{
            return (List<Pet>) entityManager.createNativeQuery(
        "SELECT id_pet, castrado, descricao, especie, idade_anos, idade_meses, " +
                "nome_pet, porte, raca, sexo, status, url_imagem, id_responsavel " + "FROM tb_pet " +
                "JOIN tb_usuario ON tb_pet.id_responsavel = tb_usuario.id_usuario " +
                "WHERE tb_usuario.username = ?", Pet.class)
            .setParameter(1, username)
            .getResultList();
        } catch (NoResultException e){
            System.out.println("Entidade nao encontrada para a query");
            return new ArrayList<Pet>();
        }
    }

    public List<Pet> findPetsById(Long id) {
        try{
            return (List<Pet>) entityManager.createNativeQuery(
            "SELECT * FROM tb_pet WHERE id_responsavel = ?", Pet.class)
                    .setParameter(1, id)
                    .getResultList();
        } catch (NoResultException e){
            System.out.println("Entidade nao encontrada para a query");
            return new ArrayList<Pet>();
        }
    }
}
