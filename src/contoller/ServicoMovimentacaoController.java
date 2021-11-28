/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contoller;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tools.CaixaDeDialogo;
import model.ServicoMovimentacao;

/**
 *
 * @author Guilherme
 */
public class ServicoMovimentacaoController {
    
    public boolean inserir(ServicoMovimentacao objeto){
        
        try{
        
        Connection con =  Conexao.getConnection();
            
            
        int indiceMovimentacao = buscarUltimoIdice();
        PreparedStatement stmt = null;
        
        
        
        StringBuilder sql = new StringBuilder();
        sql.append("insert into servico_movimentacao values(default, ?, ?)");
        
        stmt = con.prepareStatement(sql.toString());
        stmt.setInt(1, objeto.getId_movimentacao());
        stmt.setInt(2, objeto.getId_servico());
        
        stmt.executeUpdate();
        return true;
        
        }catch(SQLException e){
            System.out.println(" erro "+e.getSQLState());
            System.out.println("erro 2 " +e.getLocalizedMessage());
            System.out.println(" erro 3" +e.getMessage());
            return false;
        }
        
    }
    
    public int buscarUltimoIdice(){
        try{
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = null;  
            ResultSet rs = null;
            
            String sql = "select max(id_movimentacao) as maximo from movimentacoes";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            String numero = "";
            while(rs.next()){
               
                 numero = rs.getString(1);
                
                }
            
            
            
            int contador = Integer.parseInt(numero);
            System.out.println("int "+numero);
           
           
                
            
            return contador;
            
        }catch(SQLException e){
            CaixaDeDialogo.obterinstancia().exibirMensagem("erro buscar "+e.getMessage());
            return -1;        
        }
    }
    
    
}
