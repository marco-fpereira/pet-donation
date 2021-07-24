package com.each.bd2.PetDonation.repository;

import com.each.bd2.PetDonation.entities.Responsavel;
import com.each.bd2.PetDonation.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

@Repository
public class UsuarioRepository /*extends JpaRepository<Usuario, Long>*/ {

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
        return (Usuario) entityManager.createNativeQuery(
                "SELECT * FROM tb_usuario " +
                        "WHERE id_usuario = ?", Usuario.class)
                .setParameter(1, id_usuario)
                .getSingleResult();
    }

    public Usuario findByUsername(String username) {
        return (Usuario) entityManager.createNativeQuery(
                "SELECT * FROM tb_usuario WHERE username = ?",  Usuario.class)
                .setParameter(1, username)
                .getSingleResult();
    }

    public BigInteger getLastInsertId(){
        return (BigInteger) entityManager.createNativeQuery("SELECT LAST_INSERT_ID()").getSingleResult();
    }
}
