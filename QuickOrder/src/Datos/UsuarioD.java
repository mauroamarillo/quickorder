/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Logica.Cliente;
import Logica.Restaurante;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UsuarioD {

    private final Estructura es = new Estructura();
    private final Statement st;

    public UsuarioD() throws SQLException, ClassNotFoundException {
        this.st = es.generarSt();
    }

    public boolean nickOcupado(String nick) throws SQLException {
        String query = "SELECT nickname FROM usuarios WHERE nickname = '" + nick + "';";
        ResultSet rs = st.executeQuery(query);
        return rs.next();
    }

    public boolean emailOcupado(String email) throws SQLException {
        String query = "SELECT email FROM usuarios WHERE email = '" + email + "';";
        ResultSet rs = st.executeQuery(query);
        return rs.next();
    }

    private void agregarUsuario(String nick, String nombre, String email, String direccion) throws SQLException {
        String Usuario = "INSERT INTO usuarios(nickname,nombre,email,direccion) "
                + " VALUES('" + nick + "','" + nombre + "','" + email + "','" + direccion + "');";
        st.execute(Usuario);
    }

    public void agregarCliente(String nick, String nombre, String email, String direccion, String apellido, Date fechaN, String imagen) throws SQLException {
        agregarUsuario(nick, nombre, email, direccion);
        /*Registro al Usuario como cliente*/
        String Cliente = "INSERT INTO clientes(\"nicknameC\",\"apellido\",\"fechaN\") "
                + " VALUES('" + nick + "','" + apellido + "','" + fechaN + "');";

        st.execute(Cliente);
        /*Si no se le asigno una imagen retorno*/
        if (imagen.equals("sin_imagen")) {
            return;
        }
        /*si hay imagen guarda la ruta y la asocia con el cliente*/
        String Img = " INSERT INTO clientes_imagenes(cliente,imagen)"
                + " VALUES('" + nick + "','" + imagen + "')";
        st.execute(Img);
    }

    public void agregarRestaurante(String nick, String nombre, String email, String direccion) throws SQLException {
        agregarUsuario(nick, nombre, email, direccion);
        String Restaurante = "INSERT INTO restaurantes(\"nicknameR\") "
                + " VALUES('" + nick + "');";
        st.execute(Restaurante);

    }

    public void agregarImgRestaurante(String nick, String path) throws SQLException {
        String Imagen = " INSERT INTO restaurantes_imagenes(restaurante,imagen)"
                + " VALUES('" + nick + "','" + path + "');";
        st.execute(Imagen);
    }

    public void agregarCategoriaARestaurante(String nick, int cat) throws SQLException {
        String categoria = "INSERT INTO restaurantes_categorias(restaurante,categoria) "
                + "VALUES('" + nick + "','" + cat + "');";
        st.execute(categoria);

    }

    public ResultSet listarRestaurantes() throws SQLException {
        String query = " SELECT * "
                + " FROM usuarios u, restaurantes r"
                + " WHERE u.nickname = r.\"nicknameR\";";
        return st.executeQuery(query);
    }

    public ResultSet listarIMGsRestaurante(String nick) throws SQLException {
        String query = "SELECT imagen "
                + " FROM restaurantes_imagenes"
                + " WHERE restaurante = '" + nick + "';";
        return st.executeQuery(query);
    }

    public ResultSet listarClientes() throws SQLException {
        String query = " SELECT * "
                + " FROM usuarios u, clientes c"
                + " WHERE u.nickname = c.\"nicknameC\";";
        return st.executeQuery(query);
    }
    public String obtenerIMGCliente(String nick){
        
    }
}
