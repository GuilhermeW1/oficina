/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contoller;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author guiaw
 */
public class UserController {
    
    public boolean login(String user, String pass){
        try{
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;
            
            
            String sql = "select from usuarios where login = ? and senha = md5(md5(encode(?::bytea, 'base64')))"; 
            stmt = con.prepareStatement(sql);
            stmt.setString(1, user);
            stmt.setString(2, pass);
            
            rs = stmt.executeQuery();
            
            return rs.next();
                    
        }catch(SQLException e){
            System.out.println("ERROR SQL AT: "+e.getMessage());
            return false;
        }catch(Exception e){
            System.out.println("ERROR AT: "+e.getMessage());
            return false;
        }
    }
    
}
