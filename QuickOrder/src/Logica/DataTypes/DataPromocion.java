/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.DataTypes;

import Logica.Promocion;

/**
 *
 * @author Jean
 */
public class DataPromocion {

    private final String nombre;
    private final String descripcion;
    private final float precio;
    private final String imagen;
    private final String restaurante;
    private final float descuento;
    private final boolean activo;

    public DataPromocion(String nombre, String descripcion, float precio, String imagen, String restaurante, float descuento, boolean activo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
        this.restaurante = restaurante;
        this.descuento = descuento;
        this.activo = activo;
    }

    public DataPromocion(Promocion P) {
        this.nombre = P.getNombre();
        this.descripcion = P.getDescripcion();
        this.precio = P.getPrecio();
        this.imagen = P.getImagen();
        this.restaurante = P.getRestaurante().getNickname();
        this.descuento = P.getDescuento();
        this.activo = P.getActiva();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public String getImagen() {
        return imagen;
    }

    public String getRestaurante() {
        return restaurante;
    }

    public float getDescuento() {
        return descuento;
    }

    public boolean isActivo() {
        return activo;
    }
    
}
