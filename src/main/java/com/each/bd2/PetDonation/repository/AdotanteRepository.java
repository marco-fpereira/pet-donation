package com.each.bd2.PetDonation.repository;

import com.each.bd2.PetDonation.entities.Adotante;
import com.each.bd2.PetDonation.entities.Responsavel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

@Repository
public class AdotanteRepository /*extends JpaRepository<Adotante, Long>*/ {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Transactional
    public void save(Adotante adotante){
        entityManager.createNativeQuery(
                "INSERT INTO tb_adotante (id_usuario, renda_mensal) VALUES (?, ?)")
                .setParameter(1, adotante.getId_usuario())
                .setParameter(2, adotante.getRendaMensal())
                .executeUpdate();
    }

    public Adotante findById(long id_adotante){
        return (Adotante) entityManager.createNativeQuery(
                "SELECT * FROM tb_responsavel WHERE id_usuario = ?", Adotante.class)
                .setParameter(1, id_adotante)
                .getSingleResult();
    }

    public Adotante findByUsername(String username) {
        return (Adotante) usuarioRepository.findByUsername(username);
    }
}
