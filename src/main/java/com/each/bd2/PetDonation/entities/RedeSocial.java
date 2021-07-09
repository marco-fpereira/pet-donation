package com.each.bd2.PetDonation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_rede_social")
public class RedeSocial implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rede;
    private String nome;
    private String url;
    private String email;
    private String usuario;
    private String senha;

    @ManyToOne
    @JoinColumn(name = "id_ong")
    private Ong ong;

    public RedeSocial() {
    }

    public RedeSocial(String nome, String url, String email, String usuario, String senha, Ong ong) {
        this.nome = nome;
        this.url = url;
        this.email = email;
        this.usuario = usuario;
        this.senha = senha;
        this.ong = ong;
    }

    public Long getId_rede() {
        return id_rede;
    }

    public void setId_rede(Long id_rede) {
        this.id_rede = id_rede;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Ong getOng() {
        return ong;
    }

    public void setOng(Ong ong) {
        this.ong = ong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RedeSocial that = (RedeSocial) o;
        return id_rede.equals(that.id_rede);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_rede);
    }
}
