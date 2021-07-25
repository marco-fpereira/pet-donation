package com.each.bd2.PetDonation.repository;

import com.each.bd2.PetDonation.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.util.List;

@Repository
public class EnderecoRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Endereco endereco){
        entityManager.createNativeQuery("INSERT INTO tb_endereco" +
                "(bairro, cep, cidade, complemento, estado, logradouro, numero)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?)")
                .setParameter(1, endereco.getBairro())
                .setParameter(2, endereco.getCep())
                .setParameter(3, endereco.getCidade())
                .setParameter(4, endereco.getComplemento())
                .setParameter(5, endereco.getEstado())
                .setParameter(6, endereco.getLogradouro())
                .setParameter(7, endereco.getNumero())
                .executeUpdate();
    }

    public BigInteger getLastInsertId(){
        return (BigInteger) entityManager.createNativeQuery("SELECT LAST_INSERT_ID()").getSingleResult();
    }
}
