package com.each.bd2.PetDonation.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_despesa")
public class Despesa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_despesa;
    private Double valor;
    private Date dataDespesa;

    @ManyToOne
    @JoinColumn(name = "id_ong")
    private Ong ong;

    @OneToOne/*(fetch = FetchType.LAZY, cascade = CascadeType.ALL)*/
    @JoinColumn(name = "id_procedimento")
    private ProcVet procVet;

    public Despesa() {
    }

    public Despesa(Double valor, Date dataDespesa, Ong ong, ProcVet procVet) {
        this.valor = valor;
        this.dataDespesa = dataDespesa;
        this.ong = ong;
        this.procVet = procVet;
    }

    public Long getCod_despesa() {
        return cod_despesa;
    }

    public void setCod_despesa(Long cod_despesa) {
        this.cod_despesa = cod_despesa;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDataDespesa() {
        return dataDespesa;
    }

    public void setDataDespesa(Date dataDespesa) {
        this.dataDespesa = dataDespesa;
    }

    public Ong getOng() {
        return ong;
    }

    public void setOng(Ong ong) {
        this.ong = ong;
    }

    public ProcVet getProcVet() {
        return procVet;
    }

    public void setProcVet(ProcVet procVet) {
        this.procVet = procVet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Despesa despesa = (Despesa) o;
        return cod_despesa.equals(despesa.cod_despesa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cod_despesa);
    }
}
