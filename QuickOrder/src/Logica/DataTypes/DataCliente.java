/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.DataTypes;

import Logica.Cliente;
import java.sql.Date;
import java.util.HashMap;

/**
 *
 * @author Jean
 */
public class DataCliente {

    private final String nickname;
    private final String nombre;
    private final String email;
    private final String direccion;

    private final String apellido;
    private final Date fechaNac;
    private final String imagen;
    private final HashMap pedidos;

    public DataCliente(String nickname, String nombre, String email, String direccion, String apellido, Date fechaNac, String imagen, HashMap pedidos) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.imagen = imagen;
        this.pedidos = pedidos;
    }

    public DataCliente(Cliente C) {
        this.nickname = C.getNickname();
        this.nombre = C.getNombre();
        this.email = C.getEmail();
        this.direccion = C.getDireccion();
        this.apellido = C.getApellido();
        this.fechaNac = C.getFechaNac();
        this.imagen = C.getImagen();
        this.pedidos = C.getPedidos();
    }

}
