package contoller;

import database.Conexao;
import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Vector;

/**
 *
 * @author jonasdhein
 */
public class RelatorioController {
        
    public ResultSet buscarRelatorio(String wSelect)
    {
        ResultSet rs = null;
        try {
            Conexao.openConnection();
            
            String wSql = "";
            wSql = wSelect;

            try{
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(wSql);
            }

            catch (SQLException ex )
            {
                System.out.println("ERRO de SQL: " + ex.getMessage());
                return rs;
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return rs;
        }
        
        System.out.println ("Executou buscar com sucesso");
        return rs;
    }
    
    
    
}
