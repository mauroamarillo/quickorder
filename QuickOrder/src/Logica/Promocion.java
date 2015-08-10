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
public class Promocion extends Producto {
    private boolean activa;
    private float descuento;
    private Lista prodPromos;
    
    public Promocion(String nombre, String descripcion, float precio, Imagen imagen, boolean activa, float descuento){
        super(nombre,descripcion,precio,imagen);
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

    public Lista getProdPromos() {
        return prodPromos;
    }

    public void setProdPromos(Lista prodPromos) {
        this.prodPromos = prodPromos;
    }
}
