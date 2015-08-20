/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.DataTypes;

import Logica.Estado;
import Logica.Pedido;
import Logica.ProdPedido;
import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Jean
 */
public class DataPedido {

    private final int numero;
    private final Date fecha;
    private final Estado estado;
    private final HashMap prodPedidos;
    private final DataCliente cliente;
    private final DataRestaurante restaurante;

    public DataPedido(int numero, Date fecha, Estado estado, HashMap prodPedidos, DataCliente cliente, DataRestaurante restaurante) {
        this.numero = numero;
        this.fecha = fecha;
        this.estado = estado;
        this.prodPedidos = prodPedidos;
        this.cliente = cliente;
        this.restaurante = restaurante;
    }

    public DataPedido(Pedido P) {
        this.numero = P.getNumero();
        this.fecha = P.getFecha();
        this.estado = P.getEstado();
        this.cliente = new DataCliente(P.getCliente());
        this.restaurante = new DataRestaurante(P.getRestaurante());
        /*por cada objeto producto de pedido se  crea un datatype*/
        Iterator it = P.getProdPedidos().entrySet().iterator();
        this.prodPedidos = new HashMap();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            ProdPedido p = (ProdPedido) entry.getValue();
            prodPedidos.put(p.getProducto().getNombre(), new DataProdPedido(p));
        }

    }

    public int getNumero() {
        return numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public HashMap getProdPedidos() {
        return prodPedidos;
    }

    public DataCliente getCliente() {
        return cliente;
    }

    public DataRestaurante getRestaurante() {
        return restaurante;
    }

}
