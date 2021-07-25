package com.each.bd2.PetDonation.entities;

import com.each.bd2.PetDonation.config.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity(name = "tb_usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
    private String nome;
    private String cpf;
    private Date data_nasc;
    private String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private Users user;

    @ManyToOne  // essa anotação define que essa classe um relacionamento muitos para um com a classe enderço
    @JoinColumn(name = "id_endereco")   // junta-se as tabelas por meio do id da outra classe
    private Endereco endereco;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")    // mapeado pelo nome do objeto dessa classe criado na outra classe da relação
    private List<Doacao> doacao = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(String nome, String cpf, Date data_nasc, String telefone, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.data_nasc = data_nasc;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
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

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id_usuario.equals(usuario.id_usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_usuario);
    }
}
