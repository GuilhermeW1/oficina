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
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
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
    
    
    public void preencher(JTable jtbUsuarios) {

        Conexao.openConnection();

        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector(); //receber os dados do banco

        cabecalhos.add("Nome");
        cabecalhos.add("Placa");
        cabecalhos.add("TP pessoa");

        ResultSet result = null;
        StringBuilder wSql = new StringBuilder();
        try {

            wSql.append(" select p.nome, p.codigo, p.tppessoa ");
            wSql.append(" from proprietario p ");
           

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
                    column.setPreferredWidth(150);
                    break;
                case 1:
                    column.setPreferredWidth(100);
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
