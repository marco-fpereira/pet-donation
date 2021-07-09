package com.each.bd2.PetDonation.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_proc_vet")
public class ProcVet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_procedimento;
    private String nomeProc;
    private String descricao;
    private Double custo;
    private Date dataProc;

    @ManyToOne
    @JoinColumn(name = "id_pet")
    private Pet pet;

    @OneToOne(mappedBy = "procVet")
    private Despesa despesa;

    @ManyToOne
    @JoinColumn(name = "id_veterinario")
    private Veterinario veterinario;

    public ProcVet() {
    }

    public ProcVet(String nomeProc, String descricao, Double custo, Date dataProc, Pet pet, Despesa despesa, Veterinario veterinario) {
        this.nomeProc = nomeProc;
        this.descricao = descricao;
        this.custo = custo;
        this.dataProc = dataProc;
        this.pet = pet;
        this.despesa = despesa;
        this.veterinario = veterinario;
    }

    public Long getId_procedimento() {
        return id_procedimento;
    }

    public void setId_procedimento(Long id_procedimento) {
        this.id_procedimento = id_procedimento;
    }

    public String getNomeProc() {
        return nomeProc;
    }

    public void setNomeProc(String nomeProc) {
        this.nomeProc = nomeProc;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }

    public Date getDataProc() {
        return dataProc;
    }

    public void setDataProc(Date dataProc) {
        this.dataProc = dataProc;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Despesa getDespesa() {
        return despesa;
    }

    public void setDespesa(Despesa despesa) {
        this.despesa = despesa;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcVet procVet = (ProcVet) o;
        return id_procedimento.equals(procVet.id_procedimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_procedimento);
    }
}
