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

public class Pedido implements ICollectible{
    private int numero;
    private Date fecha;
    private float precio;
    private Estado estado;
    private Lista prodPedidos;
    
    public Pedido(int numero, Date fecha, float precio, Estado estado, Lista prodPedidos){
        this.numero = numero;
        this.fecha = fecha;
        this.precio = precio;
        this.estado = estado;
        this.prodPedidos = prodPedidos;
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
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Lista getProdPedidos() {
        return prodPedidos;
    }

    public void setProdPedidos(Lista prodPedidos) {
        this.prodPedidos = prodPedidos;
    }
    
    
}
