package com.each.bd2.PetDonation.dto;

import com.each.bd2.PetDonation.entities.Pet;
import com.each.bd2.PetDonation.entities.enums.StatusPet;

import javax.validation.constraints.NotBlank;

public class CadastroPetDTO {

    @NotBlank(message = "O campo nome do pet é obrigatório")
    private String nomePet;

    private Integer idadeAnos;
    private Integer idadeMeses;

    @NotBlank(message = "O campo porte do pet é obrigatório")
    private String porte;

    private String descricao;

    @NotBlank(message = "O campo espécie do pet é obrigatório")
    private String especie;

    @NotBlank(message = "O campo raça do pet é obrigatório")
    private String raca;

    @NotBlank(message = "O campo gênero do pet é obrigatório")
    private String genero;

    @NotBlank(message = "É obrigatório informar se o pet é castrado ou não")
    private Boolean castrado;

    public Pet toPet(){
        return new Pet(
                this.especie, this.raca, this.genero, this.castrado,
                this.idadeAnos != null ? this.idadeAnos : 0,
                this.idadeMeses != null ? this.idadeMeses : 0,
                0.00F, this.porte, StatusPet.DISPONIVEL.toString()
        );
    }

    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
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

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Boolean getCastrado() {
        return castrado;
    }

    public void setCastrado(Boolean castrado) {
        this.castrado = castrado;
    }
}
