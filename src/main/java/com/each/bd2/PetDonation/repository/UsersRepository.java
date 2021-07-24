package com.each.bd2.PetDonation.repository;

import com.each.bd2.PetDonation.config.Users;
import com.each.bd2.PetDonation.entities.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
public class UsersRepository{

    @PersistenceContext
    EntityManager entityManager;

    public void save(Users users){
        entityManager.createNativeQuery(
                "INSERT INTO users (username, enabled, password) VALUES (?, ?, ?)")
                .setParameter(1, users.getUsername())
                .setParameter(2, true)
                .setParameter(3, users.getPassword())
                .executeUpdate();
    }

    public Users findById(String username){
        try {
            return (Users) entityManager.createNativeQuery(
                    "SELECT * FROM users WHERE username = ?", Users.class)
                    .setParameter(1, username)
                    .getSingleResult();
        } catch (NoResultException result){
            return null;
        }
    }
}
