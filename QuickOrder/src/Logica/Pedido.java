/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author usuario
 */
import java.sql.Date;
import java.util.HashMap;

public class Pedido {

    private int numero;
    private Date fecha;
    private Estado estado;
    private HashMap prodPedidos;
    private Cliente cliente;

    private Restaurante restaurante;

    public Pedido(int numero, Date fecha, Estado estado, Cliente cliente, Restaurante restaurante, HashMap prodPedidos) {
        this.numero = numero;
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.fecha = fecha;
        this.estado = estado;
        this.prodPedidos = prodPedidos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getPrecio() {
        return 0;
    }


    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public HashMap getProdPedidos() {
        return prodPedidos;
    }

    public void setProdPedidos(HashMap prodPedidos) {
        this.prodPedidos = prodPedidos;
    }

}
