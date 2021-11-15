/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contoller;

import database.Conexao;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.Veiculo;
import tools.CaixaDeDialogo;
/**
 *
 * @author guilherme.w1
 */
public class VeiculoController {
    
    /*
    public void popular(JTable jTable){
        String sql = " select p.nome, v.placa, v.cor\n " +
                     " from veiculo v, proprietario p, veiculo_proprietario vp\n " +
                     " where vp.id_veiculo = v.id_veiculo\n " +
                     " and vp.id_proprietario = p.id_proprietario ";
        Preencher preencher = new  Preencher();
        preencher.preencher(jTable, sql, 1, 3);
    }
    */
    
    public void preencher(JTable jtbUsuarios) {

        Conexao.openConnection();

        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector(); //receber os dados do banco

        cabecalhos.add("Proprietario");
        cabecalhos.add("Placa");
        cabecalhos.add("Cor");

        ResultSet result = null;
        StringBuilder wSql = new StringBuilder();
        try {

            wSql.append(" select p.nome, v.placa, v.cor ");
            wSql.append(" from veiculo v, proprietario p, veiculo_proprietario vp ");
            wSql.append(" where vp.id_veiculo = v.id_veiculo ");
            wSql.append(" and vp.id_proprietario = p.id_proprietario ");

            result = Conexao.stmt.executeQuery(wSql.toString());

            Vector<Object> linha;
            while (result.next()) {
                linha = new Vector<Object>();
               // for(int i =1; i <= contado)

                linha.add(result.getString(1));
                linha.add(result.getString(2));
                linha.add(result.getString(3));
                

                dadosTabela.add(linha);
            }

        } catch (SQLException e) {
            System.out.println("problemas para popular tabela..." +e);
            System.out.println(e);
        }

        jtbUsuarios.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            // permite seleção de apenas uma linha da tabela
        });

        // permite seleção de apenas uma linha da tabela
        jtbUsuarios.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i <= 2; i++) {
            column
                    = jtbUsuarios.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(60);
                    break;
                case 1:
                    column.setPreferredWidth(200);
                    break;
                case 3:
                    column.setPreferredWidth(10);
                    break;
            }
        }

        //função para deixar a tabela zebrada
        jtbUsuarios.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);
                if (row % 2 == 0) {
                    setBackground(Color.LIGHT_GRAY);
                } else {
                    setBackground(Color.WHITE);
                }

                return this;
            }
        });
        //return (true);
    }
    
    /*
    public boolean incluir(Veiculo objeto){
        try{
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        StringBuilder sql = new StringBuilder();
        
        sql.append(" insert into veiculo values (default, ?, ?)");
        
        stmt = con.prepareStatement(sql.toString());
        stmt.setString(1, objeto.getPlaca());
        stmt.setString(2, objeto.getCor());
        
        stmt.executeUpdate();
        return true;
        }catch(SQLException e){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro incluir veiculo "+ e);
            return false;
        }
        
    } 
    */
    
    public boolean inserir(Veiculo objeto) throws SQLException{
        Connection con = Conexao.getConnection();
        try{
           // con.setAutoCommit(false);
            
            PreparedStatement stmt = null;
            //insercao na tabela veiculos
            StringBuilder sql = new StringBuilder();
            sql.append(" insert into veiculo values (default, ?, ?)");
            stmt = con.prepareStatement(sql.toString());
            stmt.setString(1, objeto.getPlaca());
            stmt.setString(2, objeto.getCor());
            stmt.executeUpdate();
            //insercao na tabela veiculo prop
           
            /*
            if(veicPropController.inserir(id_Proprietario, con)){
                System.out.println("relacao adicionada com sucesso ");
            }
            */
            
            
            
            
           // con.commit();
            return true;
        }catch(SQLException e){
            //con.rollback();
            CaixaDeDialogo.obterinstancia().exibirMensagem("erro "+e.getMessage());
            return false;
        }
        
        
    }
    
    
}
