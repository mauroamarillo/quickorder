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
    private HashMap prodPromo;
    
    
    public Promocion(String nombre, String descripcion, String imagen, boolean activa, float descuento, Restaurante restaurante, HashMap subProductos){
        super(nombre,descripcion,imagen,restaurante);
        this.activa = activa;
        this.descuento = descuento;
        this.prodPromo = subProductos;
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
        return prodPromo;
    }

    public void setProdPromos(HashMap prodPromos) {
        this.prodPromo = prodPromos;
    }
}
