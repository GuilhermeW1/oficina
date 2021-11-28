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
    
    public static Date stringToDate(String data){
        try{
        String dataCerta = new SimpleDateFormat("yyyy-MM-dd").format(data);
       
        Date dataFormatada = new SimpleDateFormat("dd-MM-yyyy").parse(dataCerta);
        
        return dataFormatada;
        }catch(Exception e){
            System.out.println("erro conversao de datas" +e);
            return null;
        }
    }
    
    //recebe um date e o converte para string 
    public static String dateToString(Date data){
        String dataCerta = new SimpleDateFormat("yyyy-MM-dd").format(data);
        
        return dataCerta;
        
    }
    
    /*
        Recebe uma string de data (dd/mm/yyyy ) e retorna ela com a formatacao padrao
        do banco de dados (yyyy/mm/dd)
    */
    public static String formatPadraoBanco(String data2){
        try{
        String data = data2.replace(" ", "");
        Date dataFormatada = new SimpleDateFormat("dd/MM/yyyy").parse(data);
        System.out.println(""+dataFormatada);
       
        String dataCerta = new SimpleDateFormat("yyyy-MM-dd").format(dataFormatada);
        return dataCerta;
        }catch(Exception e){
            System.out.println("erro data"+e);
            return null;
        }
    }
    
    /*
    recebe um tipo string e o retorna como tipo DATE SQL
    */
    public static java.sql.Date stringTodataSql(String data){
        java.sql.Date dat = java.sql.Date.valueOf(data);
        return dat;
        
    }
    
    /*
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
    */
    
    /*retorna a data de hoje com padrao de banco de dados (yyyy/mm/dd) em formato string*/
    public static java.sql.Date dataHojeToDateSQL(){
        try{
        Date date = new Date();
        
        String dataCerta = new SimpleDateFormat("yyyy-MM-dd").format(date);
            System.out.println(""+dataCerta);
        //Date dataFormatada = new SimpleDateFormat("dd-MM-yyyy").parse(dataCerta);
        java.sql.Date data = stringTodataSql(dataCerta);
            System.out.println(""+data);
        
        return data;
        }catch(Exception e){
            System.out.println("erro converso de data "+e);
            return null;
        }
    }
}
