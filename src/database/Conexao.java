/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author guiaw
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
    
    //Link for the driver
    private final static String DRIVER = "org.postgresql.Driver";
    //Link for the url of database
    private final static String URL = "jdbc:postgresql://localhost:5432/oficina";// pode ser bancao na univates ta salvo como oficina
    //user and password how givs acess to the database
    private final static String USER = "postgres";
    private final static String PASS = "postgres";
    
    public static Connection con;
    public static Statement stmt;
    
    public static void openConnection(){
        try{
            Connection con = getConnection();
            stmt = con.createStatement();
            System.out.println("Connection has ben sussesfulelkfsn");
            
        }catch(SQLException e){
            System.out.println(" ERROR AT openConection(): " + e.getMessage());
        }
    }
    
    public static Connection getConnection() {
        try{
            Class.forName(DRIVER);
            
            return DriverManager.getConnection(URL, USER, PASS);
            
        }catch(SQLException  | ClassNotFoundException e){
            System.out.println("ERRO AT getConnection() " +e.getMessage());
            return null;
        }
    }
    
    public static void closeConnection(Connection con){
        try{
            if(con != null){
                con.close();
            }
        }catch(SQLException ex){
            System.out.println("ERROR AT closeConnection1");
            
        }
            
    }
        public static void closeConnection(Connection con, PreparedStatement stmt){
        try{
            closeConnection(con);
            if(stmt != null){
                stmt.close();
            }
        }catch(SQLException ex){
            System.out.println("ERROR AT closeConnection2");
            
        }
            
    }
        public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){    
        try{
             closeConnection(con, stmt);
            if(rs != null){
                rs.close();
            }
        }catch(SQLException ex){
            System.out.println("ERROR AT closeConnection3 "+ ex.getMessage());
            
        }
            
    }
    
}
