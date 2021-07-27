package com.each.bd2.PetDonation.repository;

import com.each.bd2.PetDonation.entities.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;

@Repository
public class UsuarioRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Usuario usuario){
        entityManager.createNativeQuery(
                "INSERT INTO tb_usuario (cpf, data_nasc, nome, telefone, id_endereco, username) " +
                        "VALUES (?, ?, ?, ?, ?, ?)")
                .setParameter(1, usuario.getCpf())
                .setParameter(2, usuario.getData_nasc())
                .setParameter(3, usuario.getNome())
                .setParameter(4, usuario.getTelefone())
                .setParameter(5, usuario.getEndereco().getId_endereco())
                .setParameter(6, usuario.getUser().getUsername())
                .executeUpdate();
    }

    public Usuario findById(long id_usuario){
        try {
        return (Usuario) entityManager.createNativeQuery(
                "SELECT * FROM tb_usuario " +
                        "WHERE id_usuario = ?", Usuario.class)
                .setParameter(1, id_usuario)
                .getSingleResult();
        } catch (NoResultException e){
            System.out.println("Entidade nao encontrada para a query");
            return new Usuario();
        }
    }

    public Usuario findByUsername(String username) {
        try {
            return (Usuario) entityManager.createNativeQuery(
                    "SELECT *, 0 AS clazz_ FROM tb_usuario WHERE username = ?",  Usuario.class)
                    .setParameter(1, username)
                    .getSingleResult();
        } catch (NoResultException e){
            System.out.println("Entidade nao encontrada para a query");
            return new Usuario();
        }
    }

    public BigInteger getLastInsertId(){
        return (BigInteger) entityManager.createNativeQuery("SELECT LAST_INSERT_ID()").getSingleResult();
    }
}
