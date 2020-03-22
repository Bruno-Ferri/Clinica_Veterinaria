/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes_back;

/**
 *
 * @author Admin
 */
public class Exame {
    private String nome_cliente;
    private String cpf_cliente;

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }
    private String nome_animal;
    private String especie;
    private String suspeita;
    private boolean tratamento;
    private String tipo_ratamento;
    private String categoria_exame;
    private String tipo_exame;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getNome_animal() {
        return nome_animal;
    }

    public void setNome_animal(String nome_animal) {
        this.nome_animal = nome_animal;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getSuspeita() {
        return suspeita;
    }

    public void setSuspeita(String suspeita) {
        this.suspeita = suspeita;
    }

    public boolean isTratamento() {
        return tratamento;
    }

    public void setTratamento(boolean tratamento) {
        this.tratamento = tratamento;
    }

    public String getTipo_ratamento() {
        return tipo_ratamento;
    }

    public void setTipo_ratamento(String tipo_ratamento) {
        this.tipo_ratamento = tipo_ratamento;
    }

    public String getCategoria_exame() {
        return categoria_exame;
    }

    public void setCategoria_exame(String categoria_exame) {
        this.categoria_exame = categoria_exame;
    }

    public String getTipo_exame() {
        return tipo_exame;
    }

    public void setTipo_exame(String tipo_exame) {
        this.tipo_exame = tipo_exame;
    }
    
    
}
