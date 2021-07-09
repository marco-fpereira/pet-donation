package com.each.bd2.PetDonation.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_doacao")
public class Doacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_doacao;
    private Double valor;
    private Date data_doacao;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_ong")
    private Ong ong;

    public Doacao() {
    }

    public Doacao(Double valor, Date data_doacao, Usuario usuario, Ong ong) {
        this.valor = valor;
        this.data_doacao = data_doacao;
        this.usuario = usuario;
        this.ong = ong;
    }

    public Long getCod_doacao() {
        return cod_doacao;
    }

    public void setCod_doacao(Long cod_doacao) {
        this.cod_doacao = cod_doacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getData_doacao() {
        return data_doacao;
    }

    public void setData_doacao(Date data_doacao) {
        this.data_doacao = data_doacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        Doacao doacao = (Doacao) o;
        return cod_doacao.equals(doacao.cod_doacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cod_doacao);
    }
}
