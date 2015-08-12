/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Logica.Cliente;
import Logica.Restaurante;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UsuarioD {

    private final Estructura es = new Estructura();
    private final Statement st = es.generarSt();

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

    public void agregarCliente(Cliente C) throws SQLException {
        /*Registro al Usuario como cliente*/
        String Usuario = "INSERT INTO usuarios(nickname,nombre,email,direccion) "
                + " VALUES('" + C.getNickname() + "','" + C.getNombre() + "','" + C.getEmail() + "','" + C.getDireccion() + "');";
        String Cliente = "INSERT INTO clientes(\"nicknameC\",\"apellido\",\"fechaN\") "
                + " VALUES('" + C.getNickname() + "','" + C.getApellido() + "','" + C.getFechaNac() + "');";
        st.execute(Usuario);
        st.execute(Cliente);
        /*Si no se le asigno una imagen retorno*/
        if (C.getImagen().equals("sin_imagen")) {
            return;
        }
        /*si hay imagen guarda la ruta y la asocia con el cliente*/
        String Imagen = "INSERT INTO imagenes (path)"
                + "VALUES('" + C.getImagen() + "') RETURNING \"idImg\"";
        ResultSet rs = st.executeQuery(Imagen);
        rs.next();
        Imagen = " INSERT INTO clientes_imagenes(cliente,imagen)"
                + " VALUES('" + C.getNickname() + "','" + rs.getString("idImg") + "')";
        st.execute(Imagen);
    }

    public int agregarRestaurante(Restaurante R, HashMap IMGs, int cat[]) throws SQLException {
        /*Guardo los datos del restaurante*/
        String Usuario = "INSERT INTO usuarios(nickname,nombre,email,direccion) "
                + " VALUES('" + R.getNickname() + "','" + R.getNombre() + "','" + R.getEmail() + "','" + R.getDireccion() + "');";
        String Restaurante = "INSERT INTO restaurantes(\"nicknameR\") "
                + " VALUES('" + R.getNickname() + "');";
        st.execute(Usuario);
        st.execute(Restaurante);
        /*Guardo las imagenes y las asocio con el restaurante*/
        Iterator it = IMGs.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String path = ((String) entry.getValue());
            String Imagen = "INSERT INTO imagenes (path)"
                    + "VALUES('" + path + "') RETURNING \"idImg\";";
            ResultSet rs = st.executeQuery(Imagen);
            rs.next();
            Imagen = " INSERT INTO restaurantes_imagenes(restaurante,imagen)"
                    + " VALUES('" + R.getNickname() + "','" + rs.getString("idImg") + "');";
            st.execute(Imagen);
        }
        /*Asocio el restaurante con sus categorias*/
        for (int x = 0; x < cat.length; x++) {
            String categoria = "INSERT INTO restaurantes_categorias(restaurante,categoria) "
                    + "VALUES('" + R.getNickname() + "','" + cat[x] + "');";
            st.execute(categoria);
        }
        return 0;
    }

    public ResultSet listarRestaurantes() throws SQLException {
        String query = " SELECT * "
                + " FROM usuarios u, restaurantes r"
                + " WHERE u.nickname = r.\"nicknameR\";";
        return st.executeQuery(query);
    }

    public ResultSet listarIMGsRestaurante(String nick) throws SQLException {
        String query = "SELECT \"idImg\", path "
                + " FROM imagenes , restaurantes_imagenes"
                + " WHERE \"idImg\" = imagen"
                + " AND restaurante = '" + nick + "';";
        return st.executeQuery(query);
    }

}
