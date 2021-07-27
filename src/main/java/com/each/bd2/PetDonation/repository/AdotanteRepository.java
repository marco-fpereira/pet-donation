package com.each.bd2.PetDonation.repository;

import com.each.bd2.PetDonation.entities.Adotante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
public class AdotanteRepository {

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
        try {
            return (Adotante) entityManager.createNativeQuery(
                    "SELECT * FROM tb_adotante WHERE id_usuario = ?", Adotante.class)
                    .setParameter(1, id_adotante)
                    .getSingleResult();
        } catch (NoResultException e){
            System.out.println("Entidade nao encontrada para a query");
            return new Adotante();
        }
    }

    public Adotante findByUsername(String username) {
        try {
            return (Adotante) usuarioRepository.findByUsername(username);
        } catch (NoResultException e){
            System.out.println("Entidade nao encontrada para a query");
            return new Adotante();
        }
    }
}
