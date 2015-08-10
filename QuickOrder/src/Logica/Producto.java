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
public abstract class Producto implements ICollectible{
    protected String nombre;
    protected String descripcion;
    protected float precio;
    protected Imagen imagen;
    
    public Producto(String nombre, String descripcion, float precio, Imagen imagen){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public float getPrecio(){
        return precio;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    public void setPrecio(float precio){
        this.precio = precio;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }
}
