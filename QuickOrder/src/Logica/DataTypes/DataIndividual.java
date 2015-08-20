/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.DataTypes;

import Logica.Individual;

/**
 *
 * @author Jean
 */
public class DataIndividual {

    private final String nombre;
    private final String descripcion;
    private final float precio;
    private final String imagen;
    private final String restaurante;

    public DataIndividual(String nombre, String descripcion, float precio, String imagen, String restaurante) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
        this.restaurante = restaurante;
    }

    public DataIndividual(Individual I) {
        this.nombre = I.getNombre();
        this.descripcion = I.getDescripcion();
        this.precio = I.getPrecio();
        this.imagen = I.getImagen();
        this.restaurante = I.getRestaurante().getNickname();
    }
}
