/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author guiaw
 */
public class User {
    
    private int id_usuarios;
    private String nome;
    private String login;
    private String senha;    
    
    public int getId_usuarios(){
        return id_usuarios;
    }
    
    public void setId_usuarios(int id_usuarios){
        this.id_usuarios = id_usuarios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
