package com.each.bd2.PetDonation.dto;


import com.each.bd2.PetDonation.entities.Endereco;
import com.each.bd2.PetDonation.entities.Usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CadastroUsuarioDTO {
    @Email(message = "Campo email inválido ou vazio. Ex: joao.carlos@gmail.com")
    private String email;
    @NotBlank(message = "O campo senha é obrigatório")
    private String senha;

    @NotBlank(message = "O campo nome é obrigatório")
    private String nome;
    @Pattern(regexp = "[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2}", message = "Campo CPF inválido ou vazio. Ex: 123.456.789-10")
    private String cpf;
    @Pattern(regexp = "^(((0[1-9]|[12][0-9]|30)[-/]?(0[13-9]|1[012])|31[-/]?(0[13578]|1[02])|(0[1-9]|1[0-9]|2[0-8])[-/]?02)[-/]?[0-9]{4}|29[-/]?02[-/]?([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00))$", message = "Campo data inválido ou vazio. Exemplo de data válida no formato dd/mm/yyyy: 01/01/2021")
    private String data_nasc;
    @Pattern(regexp = "(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})", message = "Campo telefone inválido ou vazio. Ex: 11 98888-8888")
    private String telefone;

    @NotBlank(message = "O campo logradouro é obrigatório")
    private String logradouro;
    @PositiveOrZero(message = "Campo número inválido ou vazio. Campo deve ser um inteiro positivo")
    private Integer numero;
    @NotBlank(message = "O campo bairro é obrigatório")
    private String bairro;
    @NotBlank(message = "O campo cidade é obrigatório")
    private String cidade;
    @NotBlank(message = "O campo estado é obrigatório")
    private String estado;
    private String complemento;
    @Pattern(regexp = "^\\d{5}-\\d{3}$", message = "Campo CEP inválido ou vazio. Exemplo de CEP válido: 99999-999")
    private String cep;

    public Usuario toUsuario() {
        Date dataNascFromString = null;
        try {
            if (this.data_nasc.contains("/"))
                dataNascFromString = new SimpleDateFormat("dd/MM/yyyy").parse(this.data_nasc);
            else dataNascFromString = new SimpleDateFormat("dd-MM-yyyy").parse(this.data_nasc);
        } catch(ParseException e){}
        return new Usuario(this.nome, this.cpf, dataNascFromString, this.telefone, toEndereco());
    }

    public Endereco toEndereco() {
        return new Endereco(this.logradouro, this.numero, this.bairro, this.cidade, this.estado,
                this.complemento == null ? "" : this.complemento, this.cep);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
