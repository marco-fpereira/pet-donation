package com.each.bd2.PetDonation.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_dados_bancarios")
public class DadosBancarios implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_conta;
    private String cpf_cnpj;
    private Integer codigoBanco;
    private String agencia;
    private String conta;
    private String pix;

    @ManyToOne
    @JoinColumn(name = "id_ong")
    private Ong ong;

    public DadosBancarios() {
    }

    public DadosBancarios(String cpf_cnpj, Integer codigoBanco, String agencia, String conta, String pix, Ong ong) {
        this.cpf_cnpj = cpf_cnpj;
        this.codigoBanco = codigoBanco;
        this.agencia = agencia;
        this.conta = conta;
        this.pix = pix;
        this.ong = ong;
    }

    public Long getId_conta() {
        return id_conta;
    }

    public void setId_conta(Long id_conta) {
        this.id_conta = id_conta;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public Integer getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(Integer codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getPix() {
        return pix;
    }

    public void setPix(String pix) {
        this.pix = pix;
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
        DadosBancarios that = (DadosBancarios) o;
        return id_conta.equals(that.id_conta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_conta);
    }
}
