/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contoller;

import javax.swing.JTable;

/**
 *
 * @author guilherme.w1
 */
public class VeiculoController {
    
    public void popular(JTable jTable){
        String sql = " select p.nome, v.placa, v.cor\n " +
                     " from veiculo v, proprietario p, veiculo_proprietario vp\n " +
                     " where vp.id_veiculo = v.id_veiculo\n " +
                     " and vp.id_proprietario = p.id_proprietario ";
        Preencher preencher = new  Preencher();
        preencher.preencher(jTable, sql, 1, 3);
    }
    
    
    
}
