/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author STH_1F_GCA_PC16
 */
public class Conexion {
    
   private final String bd = "tienda";
   private final String user = "root";
   private final String pass = "pass";        
   private final String url = "jdbc:mysql://localhost:3306/"+bd;
   private Connection conn = null; 
   
   public Connection getConexion(){
       try {
           //controlador para la conexion
           Class.forName("com.mysql.jdbc.Driver");
           conn = (Connection) DriverManager.getConnection(this.url, this.user, this.pass);
       } catch (SQLException e) {
           
           System.out.println(e);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
       }
       return conn;
   }
    
}
