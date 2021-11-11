/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contoller;
import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
