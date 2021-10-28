/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author guilherme.w1
 */
public class Proprietario {
    
    private int id_proprietario;
    private String nome;
    private String codigo;
    private String tppessoa;

    public int getId_proprietario() {
        return id_proprietario;
    }

    public void setId_proprietario(int id_proprietario) {
        this.id_proprietario = id_proprietario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTppessoa() {
        return tppessoa;
    }

    public void setTppessoa(String tppessoa) {
        this.tppessoa = tppessoa;
    }
    
    
    
}
