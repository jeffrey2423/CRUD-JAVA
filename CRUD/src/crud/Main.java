/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import Controlador.ControladorProducto;
import Modelo.ConsultasProducto;
import Modelo.Producto;
import Vista.VistaProducto;

/**
 *
 * @author STH_1F_GCA_PC16
 */
public class Main {
    
    public static void main(String[] args) {
        Producto modelo = new Producto();
        ConsultasProducto modeloConsultas = new ConsultasProducto();
        VistaProducto vista = new VistaProducto();
        
        ControladorProducto controlador = new ControladorProducto(modelo, modeloConsultas, vista);
        controlador.iniciar();
        vista.setVisible(true);
    }
    
}
