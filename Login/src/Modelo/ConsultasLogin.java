/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;

/**
 *
 * @author STH_1F_MCA_PC27
 */
public class ConsultasLogin {
        // Instancias la clase que hemos creado anteriormente
    private Conexion SQL = new Conexion();
    // Llamas al método que tiene la clase y te devuelve una conexión
    private Connection conn = SQL.conectarMySQL();
    // Query que usarás para hacer lo que necesites
    private String sSQL =   "";
    
    // Query
    sSQL =  "INSERT INTO USERS (first_name, last_name) VALUES (?, ?)";
    // PreparedStatement
    PreparedStatement pstm = conn.prepareStatement(sSQL);
    
}
