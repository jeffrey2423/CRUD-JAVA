/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author STH_1F_GCA_PC16
 */
//usamos herencia de clases para no tener que usar objetos
public class ConsultasProducto extends Conexion{
    
    public boolean registrar(Producto producto){
        PreparedStatement ps = null;
        Connection conn = getConexion();
        
        String query = "INSERT INTO producto (codigo, nombre, precio, cantidad) VALUES(?,?,?,?)";
        
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getCantidad());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }finally{
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }   
    }
    
    public boolean modificar(Producto producto){
        PreparedStatement ps = null;
        Connection conn = getConexion();
        
        String query = "UPDATE producto SET codigo=?, nombre=?, precio=?, cantidad=? WHERE id=?";
        
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getCantidad());
            ps.setInt(4, producto.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }finally{
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }   
    }
    
    public boolean eliminar(Producto producto){
        PreparedStatement ps = null;
        Connection conn = getConexion();
        
        String query = "DELETE FROM producto WHERE id=?";
        
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, producto.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }finally{
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }   
    }
    
    public boolean buscar (Producto producto){
        PreparedStatement ps = null;
        //variable para el resultrado de la consulta
        ResultSet rs = null;
        Connection conn = getConexion();
        
        String query = "SELECT * FROM producto WHERE codigo=?";
        
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, producto.getCodigo());
            //aqui guardamos el resultado
            rs = ps.executeQuery();
            
            if (rs.next()) {
                
                producto.setId(Integer.parseInt(rs.getString("id")));
                producto.setCodigo(rs.getString("codigo"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(Double.parseDouble(rs.getString("precio")));
                producto.setCantidad(Integer.parseInt(rs.getString("cantidad")));
                return true;
            }
            
            return false;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }finally{
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }   
    }
    
    
}
