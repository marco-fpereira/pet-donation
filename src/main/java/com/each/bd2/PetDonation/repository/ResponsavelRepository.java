package com.each.bd2.PetDonation.repository;

import com.each.bd2.PetDonation.entities.Responsavel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

@Repository
public class ResponsavelRepository /*extends JpaRepository<Responsavel, Long>*/ {

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
        return (Responsavel) entityManager.createNativeQuery(
                "SELECT * FROM tb_responsavel " +
                        "JOIN tb_usuario on tb_responsavel.id_usuario = tb_usuario.id_usuario" +
                        "WHERE id_usuario = ?", Responsavel.class)
                .setParameter(1, id_responsavel)
                .getSingleResult();
    }

    public Responsavel findByUsername(String username) {
        return (Responsavel) usuarioRepository.findByUsername(username);
    }
}
