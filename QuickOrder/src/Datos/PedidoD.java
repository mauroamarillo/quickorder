/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Logica.Cliente;
import Logica.Estado;
import Logica.Pedido;
import Logica.ProdPedido;
import Logica.Restaurante;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PedidoD {

    private final Estructura es = new Estructura();
    private final Statement st;

    public PedidoD() throws SQLException, ClassNotFoundException {
        this.st = es.generarSt();
    }

    public int agregarPedido(Pedido P) throws SQLException {
        String query = "INSERT INTO pedidos(fecha,estado,cliente,restaurante)"
                + " VALUES('" + P.getFecha() + "','" + P.getEstado().ordinal()+ "','" + P.getCliente().getNickname() + "','"+P.getRestaurante().getNickname()+"') RETURNING numero";
        ResultSet rs = st.executeQuery(query);
        rs.next();
        return rs.getInt("numero");
    }

    public void agregarLineaDePedido(int numero,ProdPedido PP) throws SQLException {
        String query = "INSERT INTO pedidos_producto(pedido,restaurante,producto,cantidad)"
                + " VALUES(" + numero + ",'" +PP.getProducto().getRestaurante().getNickname() + "','" + PP.getProducto().getNombre()+ "'," + PP.getCantidad()+ ")";
        st.execute(query);
    }
}
