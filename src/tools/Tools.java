/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

/**
 *
 * @author guiaw
 */
public class Tools {
    
    public static String convertCharArrayToString(char[] vetor){
        try{
            StringBuilder retorno = new StringBuilder();
            for(int i =0; i < vetor.length; i++){
                retorno.append(vetor[i]);
            }
            return retorno.toString();
            
        }catch(Exception e){
            System.out.println("ERROR AT convertCharToString" +e.getMessage());
            return "";
        }
    }
    
}
