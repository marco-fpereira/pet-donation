package com.each.bd2.PetDonation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_ong")
public class Ong implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ong;
    private String nome;
    private String cpfResponsavel;
    private String nomeResponsavel;
    private String email;
    private String telefone;

    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @JsonIgnore
    @OneToMany(mappedBy = "ong")
    private List<Doacao> doacao = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "ong")
    private List<RedeSocial> redeSocial = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "ong")
    private List<DadosBancarios> dadosBancarios = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "ong")
    private List<Despesa> despesas = new ArrayList<>();

    public Ong() {
    }

    public Ong(String nome, String cpfResponsavel, String nomeResponsavel, String email, String telefone, Endereco endereco) {
        this.nome = nome;
        this.cpfResponsavel = cpfResponsavel;
        this.nomeResponsavel = nomeResponsavel;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Long getId_ong() {
        return id_ong;
    }

    public void setId_ong(Long id_ong) {
        this.id_ong = id_ong;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfResponsavel() {
        return cpfResponsavel;
    }

    public void setCpfResponsavel(String cpfResponsavel) {
        this.cpfResponsavel = cpfResponsavel;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Doacao> getDoacao() {
        return doacao;
    }

    public List<RedeSocial> getRedeSocial() {
        return redeSocial;
    }

    public List<DadosBancarios> getDadosBancarios() {
        return dadosBancarios;
    }

    public List<Despesa> getDespesas() {
        return despesas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ong ong = (Ong) o;
        return id_ong.equals(ong.id_ong);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_ong);
    }
}
