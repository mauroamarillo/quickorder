/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.DataTypes;

import Logica.Restaurante;
import java.util.HashMap;

/**
 *
 * @author Jean
 */
public class DataRestaurante {

    private final String nickname;
    private final String nombre;
    private final String email;
    private final String direccion;

    private final HashMap categorias;
    private final HashMap individuales;
    private final HashMap promociones;
    private final HashMap imagenes;

    public DataRestaurante(String nickname, String nombre, String email, String direccion, HashMap categorias, HashMap individuales, HashMap promociones, HashMap imagenes) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.categorias = categorias;
        this.individuales = individuales;
        this.promociones = promociones;
        this.imagenes = imagenes;
    }

    public DataRestaurante(Restaurante R) {
        this.nickname = R.getNickname();
        this.nombre = R.getNombre();
        this.email = R.getEmail();
        this.direccion = R.getDireccion();
        this.categorias = R.getCategorias();
        this.individuales = R.getIndividuales();
        this.promociones = R.getPromociones();
        this.imagenes = R.getImagenes();
    }

}
