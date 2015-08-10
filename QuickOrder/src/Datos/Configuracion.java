/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author usuario
 */

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Configuracion {
    private Connection conexion;
    
    public Connection getConexion(){
        return conexion;
    }
    
    public void conectarBD(){
        String url = "jdbc:postgresql://localhost:5433/quickorderDB";
        String usuario = "postgres";
        String contrasenia = "1234";
        
        if (conexion != null)
            return;
        
        try{
            Class.forName("org.postgresql.Driver");
            
            conexion = DriverManager.getConnection(url,usuario,contrasenia);
            //JOptionPane.showMessageDialog(null, ":)");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: No se ha podido conectar a la base de datos"+e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
}
