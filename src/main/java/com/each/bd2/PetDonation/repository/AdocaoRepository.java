package com.each.bd2.PetDonation.repository;

import com.each.bd2.PetDonation.entities.Adocao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;

@Repository
public class AdocaoRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Adocao adocao){
        entityManager.createNativeQuery("INSERT INTO tb_adocao" +
                "(data_adocao, status, ad_id_usuario, res_id_usuario, id_pet) VALUES (?, ?, ?, ?, ?)")
                .setParameter(1, adocao.getDataAdocao())
                .setParameter(2, adocao.getStatus())
                .setParameter(3, adocao.getAdotante().getId_usuario())
                .setParameter(4, adocao.getResponsavel().getId_usuario())
                .setParameter(5, adocao.getPet().getId_pet())
                .executeUpdate();
    }
}
