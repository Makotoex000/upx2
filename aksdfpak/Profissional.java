/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aksdfpak;

/**
 *
 * @author david
 */
    public class Profissional {
    String id_profissional;
    String nome;
    String especialidade;
    String telefone;
    String rg;
    String cpf;

    public Profissional(String var1, String var2, String var3, String var4,String var5, String var6){
        this.id_profissional = var1;
        this.nome = var2;
        this.especialidade = var3;
        this.telefone = var4;
        this.rg = var5;
        this.cpf = var6;
    }

    public String getId(){
        return this.id_profissional;
    }    
    public String getNome() {
        return this.nome;
    }
    public String getEspecialidade() {
        return this.especialidade;
    }
    public String getTelefone() {
        return this.telefone;
    }
    public String getRg() {
        return this.rg;
    }
    public String getCpf(){
        return this.cpf;
    }
    }