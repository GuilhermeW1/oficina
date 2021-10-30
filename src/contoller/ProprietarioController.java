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
import model.Proprietario;
import tools.CaixaDeDialogo;

/**
 *
 * @author guilherme.w1
 */
public class ProprietarioController {
    
    public boolean incluir(Proprietario objeto){
        try{
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = null;
            
            if(existe(objeto) == true){
                return false;
            }else {
                String sql = "insert into proprietario values(default, ?,?,?) ";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, objeto.getNome());
                stmt.setString(2, objeto.getCodigo());
                stmt.setString(3, objeto.getTppessoa().toUpperCase());
                
                stmt.executeUpdate();
                return true;
                        
            }
            
        }catch(SQLException e){
            CaixaDeDialogo.obterinstancia().exibirMensagem("ERRO INCLUIR PROPRIETARIO "+e.getMessage());
            return false;
        }
        
    }
    
    private boolean existe(Proprietario objeto){
       try{
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = " select from proprietario where codigo = ?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, objeto.getCodigo());
        rs = stmt.executeQuery();
        if(rs.next()){
            return true;
        }else{
        return false;
        }
       }catch(SQLException e){
           CaixaDeDialogo.obterinstancia().exibirMensagem("ERRO SQL EXISTE " +e.getMessage());
           return false;
       }
       
    }   
    
}
