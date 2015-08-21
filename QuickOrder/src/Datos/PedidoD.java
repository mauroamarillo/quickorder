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

    public ResultSet listarPedidos() throws SQLException {
        String query = " SELECT * "
                + " FROM pedidos";
        return st.executeQuery(query);
    }
     public ResultSet listarLineasDePedidos(int numero) throws SQLException {
        String query = " SELECT * "
                + " FROM pedidos_producto "
                + " WHERE pedido = "+numero;
        return st.executeQuery(query);
    }
    public ResultSet listarPedidosDeCliente(String nick) throws SQLException {
        String query = " SELECT * "
                + " FROM pedidos"
                + " WHERE cliente='" + nick + "'";
        return st.executeQuery(query);
    }
    public ResultSet listarLinasDePedidosDeCliente(String nick) throws SQLException {
        String query = " SELECT pp.pedido, pp.restaurante,pp.producto,pp.cantidad "
                + " FROM pedidos p, pedidos_producto pp"
                + " WHERE p.numero = pp.pedido"
                + " AND p.cliente='" + nick + "'";
        return st.executeQuery(query);
    }
    
}
