package com.each.bd2.PetDonation.dto;

import com.each.bd2.PetDonation.entities.Pet;
import com.each.bd2.PetDonation.entities.enums.StatusPet;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

public class CadastroPetDTO {

    @NotBlank(message = "O campo nome do pet é obrigatório")
    private String nomePet;

    @PositiveOrZero(message = "Campo idade inválido ou vazio. Campo deve ser um inteiro positivo")
    private Integer idade;
    private Boolean idadeAnos;
    private Boolean idadeMeses;

//    @NotBlank(message = "O campo porte do pet é obrigatório")
    private String porte;

    private String descricao;

//    @NotBlank(message = "O campo espécie do pet é obrigatório")
    private String especie;

    @NotBlank(message = "O campo raça do pet é obrigatório")
    private String raca;

//    @NotBlank(message = "O campo gênero do pet é obrigatório")
    private String genero;

    private Boolean castrado;

    public Pet toPet(){
        return new Pet(
                this.especie, this.raca, this.genero, this.castrado,
                this.idadeAnos ? idade : 0,
                this.idadeMeses ? idade : 0,
                0.00F, this.porte, StatusPet.DISPONIVEL.toString()
        );
    }

    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public boolean isIdadeAnos() {
        return idadeAnos;
    }

    public void setIdadeAnos(boolean idadeAnos) {
        this.idadeAnos = idadeAnos;
    }

    public boolean isIdadeMeses() {
        return idadeMeses;
    }

    public void setIdadeMeses(boolean idadeMeses) {
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
