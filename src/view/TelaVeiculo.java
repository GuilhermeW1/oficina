/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import contoller.VeiculoController;
import java.sql.SQLException;
import model.Veiculo;
import model.VeiculoProprietario;
import tools.CaixaDeDialogo;
import tools.Combos;
import contoller.VeiculoProprietarioController;

/**
 *
 * @author guilherme.w1
 */
public class TelaVeiculo extends javax.swing.JFrame {

    /**
     * Creates new form TelaVeiculo
     */
    Combos comboProprietario;
    VeiculoController veiculoController;
    Veiculo objVeiculo;
    
    VeiculoProprietario objVeiculoProp;
    VeiculoProprietarioController veiculoPropController;
    
    public TelaVeiculo() {
        
        initComponents();
        
        atualizarTabela();
        
        
        
    }
    
    public void atualizarTabela(){
        veiculoController = new VeiculoController();
        veiculoController.preencher(jTable_TelaVeiculos);
        
        comboProprietario = new Combos(jC_Proprietraio_TelaVeiculo);
        try{
            comboProprietario.PreencheCombo("select id_proprietario, nome from proprietario", "Proprietario");
        }catch(SQLException e){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao preencher CB_TV"+e);
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

        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtPlaca_TelaVeiculo = new javax.swing.JTextField();
        txtCor_TelaVeiculo = new javax.swing.JTextField();
        jC_Proprietraio_TelaVeiculo = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_TelaVeiculos = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Proprietario");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Placa");

        jButton1.setText("Adicionar veiculo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Cor");

        jC_Proprietraio_TelaVeiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton2.setText("Buscar Veiculo");

        jButton4.setText("Adicionar Proprietaios");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("X");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jC_Proprietraio_TelaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtPlaca_TelaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtCor_TelaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPlaca_TelaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2)
                            .addComponent(txtCor_TelaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jButton1)
                            .addComponent(jButton5)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addComponent(jC_Proprietraio_TelaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTable_TelaVeiculos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_TelaVeiculos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //botao adicionar veiculo
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        boolean validacao = validarDados();
        
        
        
        if(validacao){
            objVeiculo = new Veiculo();
            objVeiculo = guardarDados();
            
            int id_Proprietario = guardarIdProp();
            
            veiculoController = new VeiculoController();
            
            
            try{
            
                if(veiculoController.inserir(objVeiculo)){
                   veiculoPropController = new VeiculoProprietarioController();
                   
                   if(veiculoPropController.inserir(id_Proprietario)){
                       CaixaDeDialogo.obterinstancia().exibirMensagem("Adicionado com sucesso");
                               
                   }
            }
            }catch(SQLException e){
                CaixaDeDialogo.obterinstancia().exibirMensagem("erro "+e.getMessage());
            }
            
        }
       
        /*
        if(validacao){
            //recebe dados da tela para inserir no veiculo
            objVeiculo = guardarDados();
            //recebe dados da tela e do veiculo para inserir na relacao entre eles
            objVeiculoProp = guardarDadosRel();
           
            veiculoController = new VeiculoController();
            veiculoPropController = new VeiculoProprietarioController();
            
            
            
            //veiculoProp = guardarDadosA();
            
            if(veiculoController.incluir(objVeiculo)){
                if(veiculoPropController.inserir(objVeiculoProp)){
                    System.out.println("Relacao feita com sucesso ");
                }
               CaixaDeDialogo.obterinstancia().exibirMensagem("Veiculo adicionado com sucesso");
               
                
            }
            
            
            
        }
        */
        
    }//GEN-LAST:event_jButton1ActionPerformed
    /*
    private VeiculoProprietario guardarDadosRel(){
        objVeiculoProp = new VeiculoProprietario();
        
        //nestas duas linhas instancio um objeto veiculo para poder obter o id do veiculo
        //e fazer a relacao dos dois na tabela veiculo_prop
        objVeiculo = new Veiculo();
        objVeiculo = guardarDados();
        
        //vai pegar o id do proprietario selecionado na combo box
        Combos c = (Combos) jC_Proprietraio_TelaVeiculo.getSelectedItem();
        int id_proprietario = Integer.parseInt(c.getCodigo());
        
        
        objVeiculoProp.setId_proprietario(id_proprietario);
        System.out.println(" "+id_proprietario);
        
        objVeiculoProp.setId_veiculo(objVeiculo.getId_veiculo());
        
        System.out.println(""+objVeiculo.getId_veiculo() );
        return objVeiculoProp;
        
    }
    
    */
    public int guardarIdProp(){
        Combos c = (Combos) jC_Proprietraio_TelaVeiculo.getSelectedItem();
        int id_proprietario = Integer.parseInt(c.getCodigo());
        
        return id_proprietario;
    }
    public boolean validarDados(){
        if(txtCor_TelaVeiculo.equals("")){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Cor do veiculo nula");
            return false;
        }
        if(txtPlaca_TelaVeiculo.equals("")){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Placa do veiculo nula");
            return false;
        }  
        return true;
       
        
    }
    
    /*
    private VeiculoProprietario guardarDadosA(){
        VeiculoProprietario veiculoProp = new VeiculoProprietario();
        
        //veiculoProp.setId_veiculo();
        //veiculoProp.setId_proprietario();
        return null;
    }
    */
    
    private Veiculo guardarDados(){
        
        Veiculo veiculo = new Veiculo();
        veiculo.setCor(txtCor_TelaVeiculo.getText());
        veiculo.setPlaca(txtPlaca_TelaVeiculo.getText());

        
        return veiculo;
    }
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        TelaProprietario tela = new TelaProprietario();
        tela.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed
    
    //botao que fecha a janela
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaVeiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jC_Proprietraio_TelaVeiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_TelaVeiculos;
    private javax.swing.JTextField txtCor_TelaVeiculo;
    private javax.swing.JTextField txtPlaca_TelaVeiculo;
    // End of variables declaration//GEN-END:variables
}
