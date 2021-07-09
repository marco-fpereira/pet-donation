package com.each.bd2.PetDonation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_pet")
public class Pet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pet;
    private String especie;
    private String raca;
    private String sexo;
    private Boolean castrado;
    private Integer idadeAnos;
    private Integer idadeMeses;
    private Float peso;
    private String porte;
    private String disponivel;
    private String descricao;

    @OneToOne(mappedBy = "pet")
    private Adocao adocao;

    @JsonIgnore
    @OneToMany(mappedBy = "pet")
    private List<ProcVet> procVet = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_responsavel")
    private Responsavel responsavel;

    public Pet() {
    }

    public Pet(String especie, String raca, String sexo, Boolean castrado, Integer idadeAnos, Integer idadeMeses, Float peso, String porte, String disponivel) {
        this.especie = especie;
        this.raca = raca;
        this.sexo = sexo;
        this.castrado = castrado;
        this.idadeAnos = idadeAnos;
        this.idadeMeses = idadeMeses;
        this.peso = peso;
        this.porte = porte;
        this.disponivel = disponivel;
    }

    public Long getId_pet() {
        return id_pet;
    }

    public void setId_pet(Long id_pet) {
        this.id_pet = id_pet;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Boolean getCastrado() {
        return castrado;
    }

    public void setCastrado(Boolean castrado) {
        this.castrado = castrado;
    }

    public Integer getIdadeAnos() {
        return idadeAnos;
    }

    public void setIdadeAnos(Integer idadeAnos) {
        this.idadeAnos = idadeAnos;
    }

    public Integer getIdadeMeses() {
        return idadeMeses;
    }

    public void setIdadeMeses(Integer idadeMeses) {
        this.idadeMeses = idadeMeses;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(String disponivel) {
        this.disponivel = disponivel;
    }

    public Adocao getAdocao() {
        return adocao;
    }

    public void setAdocao(Adocao adocao) {
        this.adocao = adocao;
    }

    public List<ProcVet> getProcVet() {
        return procVet;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }
}
