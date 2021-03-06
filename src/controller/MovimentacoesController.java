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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.Movimentacoes;
import tools.CaixaDeDialogo;

/**
 *
 * @author guilherme.w1
 */
public class MovimentacoesController {
    
    
    public void preencher(JTable jtbUsuarios, String tipo) {

        Conexao.openConnection();
        

        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector(); //receber os dados do banco

        cabecalhos.add("Id");
        cabecalhos.add("Placa");
        cabecalhos.add("Data de entrada");
        if(tipo.equals("p")){
            cabecalhos.add("Concluido");
        }else{
            cabecalhos.add("Dt Entrega");
        }
        
                   

        ResultSet result = null;
        StringBuilder wSql = new StringBuilder();
        try {
            
            //tipo ira receber a string mandada ao chamar o metodo
            //com isso ele ira redirecionar para pendentes ou encerradas de acordo com 
            //o botao clicado
            
            if(tipo.equals("p")){
            
            wSql.append( " select m.id_movimentacao, v.placa ,  to_char(m.dt_entrada, 'dd / mm / yyyy'), m.encerrados " );
            wSql.append( " from movimentacoes m , veiculo v " );
            wSql.append( " where m.id_veiculo= v.id_veiculo ");
            wSql.append( " and encerrados = false; ");
        //preencher.preencher(jtbDefault, wSql, 0, 3 );     
        }else if(tipo.equals("e")){
            
            wSql.append( " select m.id_movimentacao, v.placa ,  to_char(m.dt_entrada, 'dd / mm / yyyy'), " );
            wSql.append( " m.encerrados, to_char(m.dt_entrega, 'dd / mm / yyyy') ");
            wSql.append( " from movimentacoes m , veiculo v " );
            wSql.append( " where m.id_veiculo= v.id_veiculo ");
            wSql.append( " and encerrados = true; ");
            //preencher.preencher(jtbDefault, wSql, 0, 3 );  
        }

            result = Conexao.stmt.executeQuery(wSql.toString());

            Vector<Object> linha;
            while (result.next()) {
                linha = new Vector<Object>();
               // for(int i =1; i <= contado)

                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                linha.add(result.getString(3));
                if(tipo.equals("p")){
                 linha.add("X");
                }else if (tipo.equals("e")){
                    linha.add(result.getString(5));
                }

                dadosTabela.add(linha);
            }

        } catch (SQLException e) {
            System.out.println("problemas para popular tabela..." +e);
            System.out.println(e);
        }

        jtbUsuarios.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {
            /*
            public Class getColumnClass(int column){ 
                if(column == 3 ){ 
                    return  Icon.class; 
                }
            } 
            */
                        
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            // permite sele????o de apenas uma linha da tabela
        });

        // permite sele????o de apenas uma linha da tabela
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

        //fun????o para deixar a tabela zebrada
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
    
    public boolean buscar(int id){
        try{
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            String sql = "select id_movimentacao from movimentacoes where id_movimentacao = "+id;
            
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            if(rs.next()){
                return true;
            }else{
                return false;
            }
            
        }catch(Exception e){
            System.out.println("erro "+e.getMessage());
            return false;
        }
        
    }
    
    public boolean marcarComoConcluido(int id){
        Movimentacoes objMov;
        
        try{
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = null;
            
            StringBuilder sql = new StringBuilder();
            
            if(buscar(id)){
                java.sql.Date data = tools.Datas.dataHojeToDateSQL();
                
                sql.append("update movimentacoes set encerrados = 'true', ");
                sql.append(" dt_entrega = '"+data+"'");
                sql.append(" where id_movimentacao ="+id);
                
                
                stmt = con.prepareStatement(sql.toString());
                
                
                stmt.executeUpdate();
                return true;
            
            }else{
                return false;
            }
            
        }catch(Exception e){
            System.out.println("erro marcar como conlcuido"+e.getMessage());
            return false;
        }
        
        
    }
  
    
    public boolean inserir(Movimentacoes objeto){
        try{
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = null;
            
            
            
            StringBuilder sql = new StringBuilder();
            
            sql.append("insert into movimentacoes values(default, ?,?,?, ?)");
            System.out.println("data "+objeto.getDt_entrada());
            
            java.sql.Date data = tools.Datas.stringTodataSql(objeto.getDt_entrada());
            System.out.println("data "+data);

            
            stmt = con.prepareStatement(sql.toString());
            stmt.setDate(1, data);
            stmt.setDate(2, null);
            stmt.setInt(3, objeto.getId_veiculo());
            stmt.setBoolean(4, objeto.isEncerrados());
            
            stmt.executeUpdate();
            
            return true;
            
        }catch(SQLException e){ 
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro incluir movimentacao"+e.getMessage());
            return false;
        }
        
        
    }
}   

