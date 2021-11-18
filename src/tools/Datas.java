/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Guilherme.w1
 */
public class Datas {
    
    public Date coverterStringData(String data){
        try{
           
        String DateN = data.replaceAll("-", "/");
        
        Date dataFormatada = new SimpleDateFormat("dd/MM/yyyy").parse(data);
        return dataFormatada;
        
        }catch(Exception e){
            System.out.println(""+e);
            return null;
        }
        
    }
    
    public String converterDateString(){
        
    }
    
    /*
    Date dataFormatada = new SimpleDateFormat("dd/MM/yyyy").parse(txtDtParto.getText());
    
    String dataCerta = new SimpleDateFormat("yyyy-MM-dd").format(dataFormatada);
    */
    
}
