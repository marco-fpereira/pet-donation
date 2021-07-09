package com.each.bd2.PetDonation.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_adocao")
public class Adocao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_adocao;
    private Date dataAdocao;
    private String status;

    @ManyToOne
    @JoinColumn(name = "ad_id_usuario")
    private Adotante adotante;

    @ManyToOne
    @JoinColumn(name = "res_id_usuario")
    private Responsavel responsavel;

    @OneToOne
    @JoinColumn(name = "id_pet")
    private Pet pet;

    public Adocao() {}

    public Adocao(Date dataAdocao, String status, Adotante adotante, Responsavel responsavel, Pet pet) {
        this.dataAdocao = dataAdocao;
        this.status = status;
        this.adotante = adotante;
        this.responsavel = responsavel;
        this.pet = pet;
    }

    public Long getId_adocao() {
        return id_adocao;
    }

    public void setId_adocao(Long id_adocao) {
        this.id_adocao = id_adocao;
    }

    public Date getDataAdocao() {
        return dataAdocao;
    }

    public void setDataAdocao(Date dataAdocao) {
        this.dataAdocao = dataAdocao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Adotante getAdotante() {
        return adotante;
    }

    public void setAdotante(Adotante adotante) {
        this.adotante = adotante;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adocao adocao = (Adocao) o;
        return id_adocao.equals(adocao.id_adocao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_adocao);
    }
}
