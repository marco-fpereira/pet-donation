package com.each.bd2.PetDonation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_adotante")
public class Adotante extends Usuario{

    private Double rendaMensal;

    @JsonIgnore
    @OneToMany(mappedBy = "adotante")
    private List<Adocao> adocao = new ArrayList<>();

    public Adotante() {
    }

    public Adotante(String nome, String cpf, Date data_nasc, String telefone, Endereco endereco, Double rendaMensal) {
        super(nome, cpf, data_nasc, telefone, endereco);
        this.rendaMensal = rendaMensal;
    }

    public Double getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(Double rendaMensal) {
        this.rendaMensal = rendaMensal;
    }

    public List<Adocao> getAdocao() {
        return adocao;
    }
}
