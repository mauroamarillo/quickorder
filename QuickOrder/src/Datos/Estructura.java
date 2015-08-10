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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Estructura {
    private Statement st;
    
    public Statement generarSt(){
        Configuracion config = new Configuracion();
        config.conectarBD();
        
        try{
            st = config.getConexion().createStatement();
            return st;
        }
        catch(Exception e){
            return null;
        }
    }
    public ResultSet consultarCategorias() throws SQLException{
        String seleccion = "SELECT * ";
        seleccion +="FROM categorias ";     
        ResultSet rs = st.executeQuery(seleccion);
        return rs;
    }
    
}