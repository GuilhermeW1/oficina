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
    
    
    public static String stringFormataData(String data){
        try{
        String data1 = data.replace("/", "-");
        Date dataFormatada = new SimpleDateFormat("dd-MM-yyyy").parse(data1);
        String dataCerta = new SimpleDateFormat("yyyy-MM-dd").format(dataFormatada);
        return dataCerta;
        }catch(Exception e){
            System.out.println("erro data "+e);
            return null;
        }
    }
    
    
    public static Date stringDataBanco(String data) {
        try{
        
        String data1 = stringFormataData(data);
        
        java.sql.Date date = java.sql.Date.valueOf(data1);
        return date;
        }catch(Exception e){
            System.out.println("erro datas "+e);
            return null;
        }
    }
    
}
