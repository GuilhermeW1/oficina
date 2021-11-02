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
import javax.swing.JTable;
import tools.CaixaDeDialogo;
import model.Servicos;

/**
 *
 * @author guilherme.w1
 */
public class ServicosController {
    
    public void popular(JTable jbTable){
        String sql =  "select id_servico, ds_servico, vlr_serivico from servicos ";
        Preencher preencher = new Preencher();
        preencher.preencher(jbTable, sql, 2, 3);
        
        
    }
    public boolean incluir(Servicos objeto){
        try{
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = null;
            
            String sql = "insert into servicos values(default, ?, ?)";
            
            stmt = con.prepareStatement(sql);
            stmt.setString(1, objeto.getDs_servico());
            stmt.setDouble(2, objeto.getVlr_servico());
            
            stmt.executeUpdate();
            
            return true;
            
        }catch(Exception e){
            CaixaDeDialogo.obterinstancia().exibirMensagem("erro ao incluir "+e);
            return false;
        }
    }
    
    
    
    public Servicos buscar(String cod){
        Servicos objServicos = null;
        try{
             Connection conn = Conexao.getConnection();
             PreparedStatement stmt = null;
             ResultSet rs =  null;
             
             String sql = "select * from servicos where id_servico = ?";
             
            stmt =  conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(cod));
            
            rs = stmt.executeQuery();
            if(rs.next()){
                objServicos = new Servicos();
                objServicos.setId_servico(rs.getInt("id_servico"));
                objServicos.setDs_servico(rs.getString("ds_servico"));
                objServicos.setVlr_servico(rs.getDouble("vlr_serivico"));
            }
            
        }catch(SQLException | NumberFormatException e){
            CaixaDeDialogo.obterinstancia().exibirMensagem("erros servicos controller buscar " + e);
            return null;
        }
        return objServicos;
    }
}
