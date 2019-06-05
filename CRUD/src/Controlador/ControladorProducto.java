/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasProducto;
import Modelo.Producto;
import Vista.VistaProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author STH_1F_GCA_PC16
 */
public class ControladorProducto implements ActionListener{
    
    private Producto modelo;
    private ConsultasProducto modeloConsultas;
    private VistaProducto vista;
    

    public ControladorProducto(Producto modelo, ConsultasProducto modeloConsultas, VistaProducto vista) {
        this.modelo = modelo;
        this.modeloConsultas = modeloConsultas;
        this.vista = vista;
        this.vista.btnBuscar.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        this.vista.btnGuardar.addActionListener(this);
    }
    
    public void iniciar(){
        vista.setTitle("Productos");
        vista.setLocationRelativeTo(null);
        vista.jTextFieldId.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            modelo.setCodigo(vista.jTextFieldCodigo.getText());
            modelo.setNombre(vista.jTextFieldCodigo.getText());
            modelo.setPrecio(Double.parseDouble(vista.jTextFieldCodigo.getText()));
            modelo.setCantidad(Integer.parseInt(vista.jTextFieldCodigo.getText()));
            
            if (modeloConsultas.registrar(modelo)){
                JOptionPane.showMessageDialog(null, "Registro guardado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al registar");
            }
        }
        if (e.getSource() == vista.btnModificar) {
            modelo.setId(Integer.parseInt(vista.jTextFieldId.getText()));
            modelo.setCodigo(vista.jTextFieldCodigo.getText());
            modelo.setNombre(vista.jTextFieldCodigo.getText());
            modelo.setPrecio(Double.parseDouble(vista.jTextFieldCodigo.getText()));
            modelo.setCantidad(Integer.parseInt(vista.jTextFieldCodigo.getText()));
            
            if (modeloConsultas.modificar(modelo)){
                JOptionPane.showMessageDialog(null, "Registro modificado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al modificar");
            }
        }
        if (e.getSource() == vista.btnEliminar) {
            modelo.setId(Integer.parseInt(vista.jTextFieldId.getText()));
            
            if (modeloConsultas.eliminar(modelo)){
                JOptionPane.showMessageDialog(null, "Registro eliminado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al eliminar");
            }
        }
        if (e.getSource() == vista.btnBuscar) {
            modelo.setCodigo(vista.jTextFieldCodigo.getText());
            
            if (modeloConsultas.buscar(modelo)){
                
                vista.jTextFieldId.setText(String.valueOf(modelo.getId()));
                vista.jTextFieldCodigo.setText(String.valueOf(modelo.getCodigo()));
                vista.jTextFieldNombre.setText(String.valueOf(modelo.getNombre()));
                vista.jTextFieldPrecio.setText(String.valueOf(modelo.getPrecio()));
                vista.jTextFieldCantidad.setText(String.valueOf(modelo.getCantidad()));

            }else{
                JOptionPane.showMessageDialog(null, "no se encontro el resultado");
            }
        }
        if (e.getSource() == vista.btnLimpiar) {
            limpiar();
        }
        
    }
    
    public void limpiar(){
        vista.jTextFieldCantidad.setText("");
        vista.jTextFieldCodigo.setText("");
        vista.jTextFieldId.setText("");
        vista.jTextFieldNombre.setText("");
        vista.jTextFieldPrecio.setText("");
    }
    
    

   
}
