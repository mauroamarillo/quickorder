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
public class Individual extends Producto {

    private float precio;

    public Individual(String nombre, String descripcion, float precio, String imagen, Restaurante restaurante) {
        super(nombre, descripcion, imagen, restaurante);
        this.precio = precio;
    }

}
