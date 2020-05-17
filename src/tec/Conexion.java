/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas Emmanuel Pérez
 */
public class Conexion {
    Connection con = null;
    
     public Connection GetConnectionGoogleCloud()
    {
        try
        {
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Class.forName("com.microsoft.sqlserver.jdbc.Driver");
            String url = "jdbc:sqlserver://35.247.245.143:1433;database=SistemaTec;user=lucas;password=154014707";
        
            con= DriverManager.getConnection(url);
            
        }
        catch(ClassNotFoundException ex)
        {
            //JOptionPane.showMessageDialog(null, ex, "Error1 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            con=null;
        }
        catch(SQLException ex)
        {
            //JOptionPane.showMessageDialog(null, ex, "Error2 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.getMessage());
            con=null;
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            //JOptionPane.showMessageDialog(null, ex, "Error3 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            con=null;
        }
        finally
        {
            return con;
        }
    }
     
    public static void main(String[] args) throws SQLException{

        try {
            Conexion con = new Conexion();
            Connection connection = con.GetConnectionGoogleCloud();
            PreparedStatement ps = connection.prepareStatement("select * from tblUsuarios");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("Usuario: " + rs.getObject("usuario"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
