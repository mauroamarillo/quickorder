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
public class Restaurante extends Usuario {
    private Lista categorias;
    private Lista individuales;
    private Lista promociones;
    private Lista imagenes;

 
    public Restaurante(String nickname, String nombre, String email, String direccion, Lista categorias, Lista individuales, Lista promociones, Lista imagenes){
        super(nickname,nombre,email,direccion);
        this.categorias = categorias;
        this.individuales = individuales;
        this.promociones = promociones;
        this.imagenes = imagenes;
    }

   
    
    public Lista getCategorias(){
        return categorias;
    }
    
    public Lista getIndividuales(){
        return individuales;
    }
    
    public Lista getPromociones(){
        return promociones;
    }
    
    public void setCategorias(Lista categorias){
        this.categorias = categorias;
    }
    
    public void setIndividuales(Lista individuales){
        this.individuales = individuales;
    }
    
    public void setPromociones(Lista promociones){
        this.promociones = promociones;
    }
    
    public void setImagenes(Lista imagenes){
        this.imagenes = imagenes;
    }
    
}
