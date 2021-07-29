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
    private String medidaTemporal;

//    @NotBlank(message = "O campo porte do pet é obrigatório")
    private String porte;

    private String descricao;

//    @NotBlank(message = "O campo espécie do pet é obrigatório")
    private String especie;

    @NotBlank(message = "O campo raça do pet é obrigatório")
    private String raca;

//    @NotBlank(message = "O campo gênero do pet é obrigatório")
    private String genero;

    private boolean castrado;

    private String urlImagem;

    public Pet toPet(){
        return new Pet(
                this.nomePet, this.especie, this.raca, this.genero, this.castrado,
                this.medidaTemporal.equals("Anos") ? idade : 0,
                this.medidaTemporal.equals("Meses") ? idade : 0,
                this.porte, StatusPet.DISPONIVEL.toString(), this.descricao,
                this.urlImagem == null || this.urlImagem.equals("") ?
                    "https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/65761296352685.5eac4787a4720.jpg" :
                    this.urlImagem
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

    public String getMedidaTemporal() {
        return medidaTemporal;
    }

    public void setMedidaTemporal(String medidaTemporal) {
        this.medidaTemporal = medidaTemporal;
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

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
}
