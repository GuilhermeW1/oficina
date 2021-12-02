/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Conexao;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import jxl.biff.drawing.CheckBox;
import tools.CaixaDeDialogo;
import model.Servicos;

/**
 *
 * @author guilherme.w1
 */
public class ServicosController {
    /*
    public void popular(JTable jbTable){
        String sql =  "select id_servico, ds_servico, vlr_serivico from servicos ";
        Preencher preencher = new Preencher();
        preencher.preencher(jbTable, sql, 2, 3);
        
        
    }
*/
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
    
    public boolean alterar(Servicos objeto){
        try{
        Connection con =  Conexao.getConnection();
        PreparedStatement stmt = null;
        
        StringBuilder sql = new StringBuilder();
        
        
        sql.append(" update servicos ");
        //sql.append(" set id_servico = ?, ");
        sql.append(" set ds_servico = ?, ");
        sql.append(" vlr_serivico = ? ");
        sql.append(" where id_servico = ? ");
        
        stmt = con.prepareStatement(sql.toString());
        //stmt.setInt(1, objeto.getId_servico());
        stmt.setString(1, objeto.getDs_servico());
        stmt.setDouble(2, objeto.getVlr_servico());
        stmt.setInt(3, objeto.getId_servico());
        
        stmt.executeUpdate();
        
        return true;
        }catch(SQLException e ){
            CaixaDeDialogo.obterinstancia().exibirMensagem("erro alterar servico: "+e);
            return false;
        }
        
        
        
        
    }
    public void preencher(JTable jtbUsuarios) {

        Conexao.openConnection();

        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector(); //receber os dados do banco

        cabecalhos.add("Id");
        cabecalhos.add("Descriçao ");
        cabecalhos.add("Valor");
        cabecalhos.add("Selecionar");
        
        try{
        ResultSet result = null;
        StringBuilder wSql = new StringBuilder();
        wSql.append(" select id_servico, ds_servico, vlr_serivico from servicos  ");

            result = Conexao.stmt.executeQuery(wSql.toString());

            Vector<Object> linha;
            while (result.next()) {
                linha = new Vector<Object>();
               // for(int i =1; i <= contado)

                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                linha.add(result.getDouble(3));
                linha.add(false);

                dadosTabela.add(linha);
            }

        } catch (SQLException e) {
            System.out.println("problemas para popular tabela..." +e);
            System.out.println(e);
        }

        jtbUsuarios.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {
            /*
            @Override
            public Class getColumnClass(int column){
                if(column == 3){
                    return Icon.class;
                }else {
                return null;
                }
            }
              */  
            @Override
            public Class getColumnClass(int column) {
                return getValueAt(1, column).getClass();
            }
            
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 3){
                    return true;
                }else{
                    return false;
                }
                
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
                case 2:
                    column.setPreferredWidth(150);
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
    
        
        
        
    
}
