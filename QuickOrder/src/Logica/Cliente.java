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

import java.sql.Date;

public class Cliente extends Usuario {
    private String apellido;
    private Date fechaNac;
    private Imagen imagen;
    private Lista pedidos;
    
    public Cliente(String nickname, String nombre, String email, String direccion, String apellido, Date fechaNac, Imagen imagen, Lista pedidos){
        super(nickname,nombre,email,direccion);
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.imagen = imagen;
        this.pedidos = pedidos;
    }
    
    public String getApellido(){
        return apellido;
    }
    
    public Date getFechaNac(){
        return fechaNac;
    }
    
    public Imagen getImagen(){
        return imagen;
    }
    
    public Lista getPedidos(){
        return pedidos;
    }
    
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    
    public void setFechaNac(Date fechaNac){
        this.fechaNac = fechaNac;
    }
    
    public void setImagen(Imagen imagen){
        this.imagen = imagen;
    }
    
    public void setPedidos(Lista pedidos){
        this.pedidos = pedidos;
    }
    
}
