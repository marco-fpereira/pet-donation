package com.each.bd2.PetDonation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_veterinario")
public class Veterinario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_veterinario;
    private String nome;
    private String cpf;
    private String crmv;
    private String telefone;

    @JsonIgnore
    @OneToMany(mappedBy = "veterinario")
    private List<ProcVet> procVets = new ArrayList<>();

    public Veterinario() {
    }

    public Veterinario(String nome, String cpf, String crmv, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.crmv = crmv;
        this.telefone = telefone;
    }

    public Long getId_veterinario() {
        return id_veterinario;
    }

    public void setId_veterinario(Long id_veterinario) {
        this.id_veterinario = id_veterinario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<ProcVet> getProcVets() {
        return procVets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veterinario that = (Veterinario) o;
        return id_veterinario.equals(that.id_veterinario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_veterinario);
    }
}
