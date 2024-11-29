
package com.mycompany.upx2;

public class Profissional {
    private int idProfissional; // ID gerado pelo banco
    private String nome;
    private String cpf;
    private String rg;
    private String especialidade;
    private String telefone;
    private String email;

    public Profissional(String nome, String cpf, String rg, String especialidade, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.especialidade = especialidade;
        this.telefone = telefone;
        this.email = email;
    }

    public Profissional(int idProfissional, String nome, String cpf, String rg, String especialidade, String telefone, String email) {
        this.idProfissional = idProfissional;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.especialidade = especialidade;
        this.telefone = telefone;
        this.email = email;
    }

    public int getIdProfissional() {
        return idProfissional;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
}
