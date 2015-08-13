/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Logica.Individual;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jean
 */
public class ProductosD {

    private final Estructura es = new Estructura();
    private final Statement st;

    public ProductosD() throws SQLException, ClassNotFoundException {
        this.st = es.generarSt();
    }

    public boolean productoRegistrado(String nombre, String restaurante) throws SQLException {
        String query = " SELECT * "
                + " FROM productos "
                + " WHERE nombre = '" + nombre + "' "
                + " AND restaurante ='" + restaurante + "';";
        ResultSet rs = st.executeQuery(query);
        return rs.next();
    }

    public void agregarIndividual(Individual I) throws SQLException {
        String query = " INSERT INTO productos(restaurante,nombre,descripcion) "
                + " VALUES ('" + I.getRestaurante().getNickname() + "','" + I.getNombre() + "','" + I.getDescripcion() + "');";
        st.execute(query);

        query = " INSERT INTO individuales(restaurante,nombre,precio) "
                + " VALUES ('" + I.getRestaurante().getNickname() + "','" + I.getNombre() + "'," + I.getPrecio() + ");";
        st.execute(query);
    }
}
