/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 182110084
 */
public class Cliente {
    private int idCliente;
    private String nome;
    private String endereco;
    private int telefone;

public Cliente() {
    }

    public Cliente(int idCliente, String nome, String endereco, int telefone) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        
    }

    public int getidCliente() {
        return idCliente;
    }

    public void setidCliente(int idCliente ) {
        this.idCliente = idCliente;
    }

    public String getnome() {
        return nome;
    }

    public void setnome(String marca) {
        this.nome = nome;
    }

    public String getendereco() {
        return endereco;
    }

    public void setendereco(String endereco) {
        this.endereco = endereco;
    }

    public int gettelefone() {
        return telefone;
    }

    public void settelefone(int telefone) {
        this.telefone = telefone;
    }
}

    