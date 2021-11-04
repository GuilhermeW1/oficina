/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contoller;

import database.Conexao;
import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Guilherme
 */
public class Preencher {
    
    public void preencher(JTable jtbUsuarios, String sql, int identificacao, int numeroColunas ) {

        Conexao.openConnection();

        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector(); //receber os dados do banco
        
        /*
        */
        int contador = numeroColunas;
        
        switch(identificacao) {
            case 0:
                cabecalhos.add("Id");
                cabecalhos.add("Placa");
                cabecalhos.add("Data de entrada");
                //cabecalhos.add("concluido");
                break;
            case 1:
                cabecalhos.add("Proprietario");
                cabecalhos.add("Placa Veiculo");
                cabecalhos.add("Cor do Veiculo");
                
                break;
            case 2:
                cabecalhos.add("Id");
                cabecalhos.add("Descrição serviço");
                cabecalhos.add("Valor do serviço");
                        
                
        }
        
        //cabecalhos.add("Exc");
        

        ResultSet result = null;

        try {

            String wSql = sql;

            result = Conexao.stmt.executeQuery(wSql);

            Vector<Object> linha;
           
            while (result.next()) {
                linha = new Vector<Object>();
                
                for(int i =1 ; i<= contador;i++){
                    linha.add(result.getString(i));
                }
                //linha.add(result.getString(1));
                //linha.add(result.getString(2));
                //linha.add(result.getString(3));
                

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
        
        //=========================================================================
        /* 
            redimensiona as colunas de uma tabela não e necessario mas
            **pode fazer uma coluna ficar mais larga sem ela ira alocar de forma
            padrao o tamnaho das colunas
        */
        
        /*
        TableColumn column = null;
        for (int i = 0; i <= 1; i++) {
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
        ============================================================================
        */
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
