/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author Mauro
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CategoriaD {

    private Estructura es = new Estructura();
    private Statement st = es.generarSt();

    public ResultSet consultarCategorias() throws SQLException {
        String seleccion = "SELECT * FROM categorias ";
        ResultSet rs = st.executeQuery(seleccion);
        return rs;
    }

    public int insertCategoria(String nombre) throws SQLException {
        String insert = "INSERT INTO categorias(nombre) VALUES('" + nombre + "');";
        st.execute(insert);
        return 0;
    }

    public ResultSet listarCatsRestaurante(String nick) throws SQLException {
        String query = "SELECT c.nombre "
                + " FROM categorias c, restaurantes_categorias rc"
                + " WHERE c.\"idCat\" = rc.categoria"
                + " AND rc.restaurante = '" + nick + "';";
        return st.executeQuery(query);
    }
}
