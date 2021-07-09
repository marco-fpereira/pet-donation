package com.each.bd2.PetDonation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_responsavel")
public class Responsavel extends Usuario{

    @JsonIgnore
    @OneToMany(mappedBy = "responsavel")
    private List<Adocao> adocao = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "responsavel")
    private List<Pet> pets = new ArrayList<>();

    public Responsavel() {
    }

    public Responsavel(String nome, String cpf, Date data_nasc, String telefone, Endereco endereco) {
        super(nome, cpf, data_nasc, telefone, endereco);
    }

    public List<Adocao> getAdocao() {
        return adocao;
    }

    public List<Pet> getPets() {
        return pets;
    }
}
