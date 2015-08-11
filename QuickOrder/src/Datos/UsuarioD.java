/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Logica.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioD {

    private final Estructura es = new Estructura();
    private final Statement st = es.generarSt();
    /*public ResultSet consultarDatosUsuario() throws SQLException {
     String seleccion = "SELECT * FROM categorias ";
     ResultSet rs = st.executeQuery(seleccion);
     return rs;
     }
     */

    public boolean nickOcupado(String nick) {
        String query = "SELECT nickname FROM usuarios WHERE nickname = '" + nick + "';";
        ResultSet rs = null;
        boolean res = true;
        try {
            rs = st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioD.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            res = rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public int agregarCliente(Cliente C) {

        String Usuario = "INSERT INTO usuarios(nickname,nombre,email,direccion) "
                + " VALUES('" + C.getNickname() + "','" + C.getNombre() + "','" + C.getEmail() + "','" + C.getDireccion() + "');";
        String Cliente = "INSERT INTO clientes(\"nicknameC\",\"apellido\",\"fechaN\") "
                + " VALUES('" + C.getNickname() + "','" + C.getApellido() + "','" + C.getFechaNac() + "');";
        String Imagen = "INSERT INTO imagenes (path)"
                + "VALUES('" + C.getImagen() + "') RETURNING \"idImg\"";

        try {
            st.execute(Usuario);
            st.execute(Cliente);
            ResultSet rs = st.executeQuery(Imagen);
            rs.next();
            Imagen = " INSERT INTO clientes_imagenes(cliente,imagen)"
                         + " VALUES('"+C.getNickname()+"','"+ rs.getString("idImg") +"')";
            st.execute(Imagen);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
