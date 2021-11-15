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
import model.Veiculo;
import tools.CaixaDeDialogo;
import model.VeiculoProprietario;
        
/**
 *
 * @author Guilherme.w1
 */
public class VeiculoProprietarioController {
    /*
    public boolean inserir(VeiculoProprietario objeto){
        
        try{
        String sql ="insert into  veiculo_proprietario values default, ?, ? ";
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
            
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, objeto.getId_proprietario());
            stmt.setInt(2, objeto.getId_veiculo());
                    
        
            stmt.executeQuery();
            return true;
            
        }catch(SQLException e){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro inserir propVeiculo "+e);
            return false;
        }
        
        
    }
    */
    public boolean inserir(int i){
        
        try{
        
        Connection con =  Conexao.getConnection();
            
            
        int indiceVeiculo = buscarUltimoIdice();
        PreparedStatement stmt = null;
        
        
        
        StringBuilder sql = new StringBuilder();
        sql.append("insert into veiculo_proprietario values(default, ?, ?)");
        
        stmt = con.prepareStatement(sql.toString());
        stmt.setInt(1, indiceVeiculo);
        stmt.setInt(2, i);
        
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
            
            String sql = "select max(id_veiculo) as maximo from veiculo";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            System.out.println(""+rs.toString());
            int algo = Integer.parseInt( rs.toString());
            System.out.println(""+algo);
            
            int contador = 0;
           /*while (rs.next()) {
                if(rs.last()){
                    rs.getRow();
                    int cont = rs.getInt(1);
                    System.out.println(""+cont);
                }
                
            }*/ 
           
                
            
            return contador;
            
        }catch(SQLException e){
            CaixaDeDialogo.obterinstancia().exibirMensagem("erro buscar "+e.getMessage());
            return -1;        
        }
    }
    
    
    
    public boolean transaction(Veiculo v, int id_Proprietario){
        Connection con = Conexao.getConnection();
        try{
        
        con.setAutoCommit(false);
        
        
        
        
        
        return true;
        }catch(SQLException e){
            System.out.println("erro "+e.getMessage());
            try{
                
            con.rollback();
            
            }catch(SQLException es){
                System.out.println("erro rolbak "+e.getMessage());
                return false;
            }
            
            return false;
        }    
    }
}
