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
public class Movimentacoes {
    
    private int id_movimentacoes;
    private String dt_entrada;
    private boolean encerrados;
    private String dt_entrega;
    private int id_veiculo;

    public int getId_movimentacoes() {
        return id_movimentacoes;
    }

    public void setId_movimentacoes(int id_movimentacoes) {
        this.id_movimentacoes = id_movimentacoes;
    }

    public String getDt_entrada() {
        return dt_entrada;
    }

    public void setDt_entrada(String dt_entrada) {
        this.dt_entrada = dt_entrada;
    }

    public boolean isEncerrados() {
        return encerrados;
    }

    public void setEncerrados(boolean encerrados) {
        this.encerrados = encerrados;
    }

    public String getDt_entrega() {
        return dt_entrega;
    }

    public void setDt_entrega(String dt_entrega) {
        this.dt_entrega = dt_entrega;
    }

    public int getId_veiculo() {
        return id_veiculo;
    }

    public void setId_veiculo(int id_veiculo) {
        this.id_veiculo = id_veiculo;
    }
    
    
    
}
