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
public class Restaurante extends Usuario {
    private HashMap categorias;
    private HashMap individuales;
    private HashMap promociones;
    private HashMap imagenes;

    public HashMap getImagenes() {
        return imagenes;
    }
 
    public Restaurante(String nickname, String nombre, String email, String direccion, HashMap categorias, HashMap individuales, HashMap promociones, HashMap imagenes){
        super(nickname,nombre,email,direccion);
        this.categorias = categorias;
        this.individuales = individuales;
        this.promociones = promociones;
        this.imagenes = imagenes;
    }

   
    
    public HashMap getCategorias(){
        return categorias;
    }
    
    public HashMap getIndividuales(){
        return individuales;
    }
    
    public HashMap getPromociones(){
        return promociones;
    }
    
    public void setCategorias(HashMap categorias){
        this.categorias = categorias;
    }
    
    public void setIndividuales(HashMap individuales){
        this.individuales = individuales;
    }
    
    public void setPromociones(HashMap promociones){
        this.promociones = promociones;
    }
    
    public void setImagenes(HashMap imagenes){
        this.imagenes = imagenes;
    }
    
}
