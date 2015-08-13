/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.HashMap;

/**
 *
 * @author usuario
 */
public class Promocion extends Producto {
    private boolean activa;
    private float descuento;
    private HashMap prodPromos;
    
    public Promocion(String nombre, String descripcion, float precio, String imagen, boolean activa, float descuento,Restaurante restaurante){
        super(nombre,descripcion,precio,imagen,restaurante);
        this.activa = activa;
        this.descuento = descuento;
    }

    
    public boolean getActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public HashMap getProdPromos() {
        return prodPromos;
    }

    public void setProdPromos(HashMap prodPromos) {
        this.prodPromos = prodPromos;
    }
}
