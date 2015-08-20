/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PedidoD {

    private final Estructura es = new Estructura();
    private final Statement st;

    public PedidoD() throws SQLException, ClassNotFoundException {
        this.st = es.generarSt();
    }

    public int agregarPedido(Date fecha, int estado, String cliente, String restaurante) throws SQLException {
        String query = "INSERT INTO pedidos(fecha,estado,cliente,restaurante)"
                + " VALUES('" + fecha + "','" + estado + "','" + cliente + "','" + restaurante + "') RETURNING numero";
        ResultSet rs = st.executeQuery(query);
        rs.next();
        return rs.getInt("numero");
    }

    public void agregarLineaDePedido(int numero, String restaurante, String producto, int cantidad) throws SQLException {
        String query = "INSERT INTO pedidos_producto(pedido,restaurante,producto,cantidad)"
                + " VALUES(" + numero + ",'" + restaurante + "','" + producto + "'," + cantidad + ")";
        st.execute(query);
    }
}
