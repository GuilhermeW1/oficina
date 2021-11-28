/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import contoller.MovimentacoesController;
import contoller.ServicoMovimentacaoController;
import contoller.ServicosController;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Movimentacoes;
import model.ServicoMovimentacao;
import tools.CaixaDeDialogo;
import tools.Combos;

/**
 *
 * @author Guilherme
 */
public class TelaAdicionar extends javax.swing.JFrame {

    /**
     * Creates new form TelaAdicionar
     */
    ServicosController serController;
    Combos comboProprietario, comboVeiculo, comboServico;
    
    public TelaAdicionar() {
        initComponents();
        
        atualizarTabelaProp();
        
        atualizarTabelaVeiculo(0);
        
        serController = new ServicosController();
        serController.preencher(jtbAdicionarServico);
       
        atualizarTabelaServicos();
        
    }
    
    public void atualizarTabelaProp(){
        try{
            comboProprietario = new Combos(jcbCliente_TelaAdicionar);
            comboProprietario.PreencheCombo("select id_proprietario, nome from proprietario", "Proprietario..");
            
        }catch(Exception e){
            CaixaDeDialogo.obterinstancia().exibirMensagem("erro atualizar tabela "+e);
        }
    }
    
    public void atualizarTabelaVeiculo(int prop ){
        try{
            
            String sql = " select v.id_veiculo, v.placa  " +
                     " from veiculo v, proprietario p, veiculo_proprietario vp " +
                     " where vp.id_veiculo = v.id_veiculo " +
                     " and vp.id_proprietario = p.id_proprietario " +
                     " and p.id_proprietario =  "+prop;
            
            comboVeiculo = new Combos(jcbVeiculo_TelaAdicionar);
            comboVeiculo.PreencheCombo(sql, "Placa..");
            
        }catch(Exception e){
            CaixaDeDialogo.obterinstancia().exibirMensagem("erro atualizar tabela "+e);
        }
        
    }
    
    public void atualizarTabelaServicos(){
        try{
        comboServico = new Combos(jcbServico_TelaAdicionar);
        comboServico.PreencheCombo("select id_servico, ds_servico from servicos", "Servico..");
    }catch(Exception e){
            CaixaDeDialogo.obterinstancia().exibirMensagem("erro atualizar tabela "+e);
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jcbServico_TelaAdicionar = new javax.swing.JComboBox<>();
        jcbCliente_TelaAdicionar = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcbVeiculo_TelaAdicionar = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbAdicionarServico = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        dtAdicionar = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jcbServico_TelaAdicionar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbServico_TelaAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbServico_TelaAdicionarActionPerformed(evt);
            }
        });

        jcbCliente_TelaAdicionar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbCliente_TelaAdicionar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbCliente_TelaAdicionarItemStateChanged(evt);
            }
        });
        jcbCliente_TelaAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCliente_TelaAdicionarActionPerformed(evt);
            }
        });

        jLabel2.setText("Serviço");

        jLabel3.setText("Cliente");

        jcbVeiculo_TelaAdicionar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbVeiculo_TelaAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbVeiculo_TelaAdicionarActionPerformed(evt);
            }
        });

        jLabel4.setText("Veiculo");

        jtbAdicionarServico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtbAdicionarServico);

        jLabel5.setText("Valor");

        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Adicionar/Salvar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        try {
            dtAdicionar.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter(" ## / ## / ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dtAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtAdicionarActionPerformed(evt);
            }
        });

        jLabel6.setText("Data de Entrada");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbCliente_TelaAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(86, 86, 86)
                                        .addComponent(jLabel4))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(79, 79, 79)
                                        .addComponent(jcbVeiculo_TelaAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(79, 79, 79)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(dtAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(141, 141, 141)
                                        .addComponent(jButton2))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(67, 67, 67)
                                        .addComponent(jLabel5))))
                            .addComponent(jcbServico_TelaAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbCliente_TelaAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addGap(20, 20, 20)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbVeiculo_TelaAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jcbServico_TelaAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbServico_TelaAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbServico_TelaAdicionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbServico_TelaAdicionarActionPerformed

    private void jcbCliente_TelaAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCliente_TelaAdicionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbCliente_TelaAdicionarActionPerformed
    
    //preenche o o combo cliente e proprietario
    private void jcbCliente_TelaAdicionarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCliente_TelaAdicionarItemStateChanged
        try{
            if(jcbCliente_TelaAdicionar.getSelectedIndex() > 0){
                Combos c = (Combos) jcbCliente_TelaAdicionar.getSelectedItem();
                int prop = Integer.parseInt(c.getCodigo());
                atualizarTabelaVeiculo(prop);
            }
    
        }catch(Exception e){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao buscar clientes: " + e.getMessage());
        }
    }//GEN-LAST:event_jcbCliente_TelaAdicionarItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void dtAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtAdicionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dtAdicionarActionPerformed

    private void jcbVeiculo_TelaAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbVeiculo_TelaAdicionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbVeiculo_TelaAdicionarActionPerformed

    //botao de salvar e adicionar movimentacoes
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        boolean validacao = validarDados();
        
        if(validacao){
            Movimentacoes objMov = new Movimentacoes();
            objMov = guardarDados();
            
            MovimentacoesController movController = new MovimentacoesController();
            if(movController.inserir(objMov)){
                
                ServicoMovimentacaoController serMovController = new ServicoMovimentacaoController();
                ServicoMovimentacao serObj = new ServicoMovimentacao();
                
                serObj = guardarDadosRel();
                
                serMovController.inserir(serObj);
                
                CaixaDeDialogo.obterinstancia().exibirMensagem("Movimentacao adicionada com sucesso");
                
                TelaMovimetacoes tela = new TelaMovimetacoes();
                
                tela.atualizarTabela("p");
                
                
            }else{
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao adicionar movimentacao");

            }
            
            
            
        }
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed
    private void limparTela(){
        
        
        
        
    }
    private Movimentacoes guardarDados(){
        try{
        Movimentacoes obj = new Movimentacoes();
        
        Combos c = (Combos) jcbVeiculo_TelaAdicionar.getSelectedItem();
        int veiculo = Integer.parseInt(c.getCodigo());
        
        /*
        Date dataFormatada = new SimpleDateFormat("dd/MM/yyyy").parse(dtAdicionar.getText().trim);
        System.out.println(""+dataFormatada);
       
        String dataCerta = new SimpleDateFormat("yyyy-MM-dd").format(dataFormatada);
        */
        
        String dataCerta = tools.Datas.formatPadraoBanco(dtAdicionar.getText().trim());
            
        
        obj.setDt_entrada(dataCerta);
        obj.setDt_entrega(null);
        obj.setId_veiculo(veiculo);
        obj.setEncerrados(false);
        
        return obj;
        }catch(Exception e){
            System.out.println("erro " +e.getMessage());
            return null;
        }
        
    }
    
    private ServicoMovimentacao guardarDadosRel(){
        
        ServicoMovimentacao serMovObj = new ServicoMovimentacao();
        ServicoMovimentacaoController serMController = new ServicoMovimentacaoController();
        
        int index = serMController.buscarUltimoIdice();
        int linha = jtbAdicionarServico.getSelectedRow();
        
        String codigo = jtbAdicionarServico.getModel().getValueAt(linha, 0).toString();
        int servico = Integer.parseInt(codigo);
        
        serMovObj.setId_servico(servico);
        serMovObj.setId_movimentacao(index);
        
        return serMovObj;
    }
    
    private boolean validarDados(){
        try{
        Combos c = (Combos) jcbCliente_TelaAdicionar.getSelectedItem();
        //Combos c1 = (Combos) jcbServico_TelaAdicionar.getSelectedItem();
        Combos c2 = (Combos) jcbVeiculo_TelaAdicionar.getSelectedItem();
        
        int linha = jtbAdicionarServico.getSelectedRow();
        String codigo = jtbAdicionarServico.getModel().getValueAt(linha, 0).toString();
        
         if(c.equals("") ){
            
             CaixaDeDialogo.obterinstancia().exibirMensagem("CLIENTE nao selecionado");
             return false;
     
         }
         if(c2.equals("")){
             CaixaDeDialogo.obterinstancia().exibirMensagem("VEICULO nao selecionado");
               return false;

         }
         if(codigo.equals("")){
             CaixaDeDialogo.obterinstancia().exibirMensagem("SERVICO nao selecionado");
            return false;

             
         }
         return true;
        }catch(Exception e){
            System.out.println("erro validar dados" +e.getMessage());
            return false;
        }
        
        
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAdicionar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JFormattedTextField dtAdicionar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbCliente_TelaAdicionar;
    private javax.swing.JComboBox<String> jcbServico_TelaAdicionar;
    private javax.swing.JComboBox<String> jcbVeiculo_TelaAdicionar;
    private javax.swing.JTable jtbAdicionarServico;
    // End of variables declaration//GEN-END:variables
}
