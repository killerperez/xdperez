/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Emmanuel Pérez
 */
public class ProbarConexion {
    public static void main (String[] args){
        try{
            Conexion conexion = new Conexion();
        JOptionPane.showMessageDialog(null, "Conexión exitosa");
        }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
