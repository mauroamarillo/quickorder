/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.DataTypes;

import Logica.ProdPromo;
import Logica.Promocion;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Jean
 */
public class DataPromocion extends DataProducto {

    private final String nombre;
    private final String descripcion;
    private final float precio;
    private final String imagen;
    private final String restaurante;
    private final float descuento;
    private final boolean activo;
    private final HashMap dataProdPromo;

    public DataPromocion(String nombre, String descripcion, float precio, String imagen, String restaurante, float descuento, boolean activo, HashMap dataProdPromo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
        this.restaurante = restaurante;
        this.descuento = descuento;
        this.activo = activo;
        this.dataProdPromo = dataProdPromo;
    }

    public DataPromocion(Promocion P) {
        this.nombre = P.getNombre();
        this.descripcion = P.getDescripcion();
        this.precio = P.getPrecio();
        this.imagen = P.getImagen();
        this.restaurante = P.getRestaurante().getNickname();
        this.descuento = P.getDescuento();
        this.activo = P.getActiva();
        /*convierto cada linea objeto ProdudctodePromocion en un datatype*/
        Iterator it = P.getProdPromos().entrySet().iterator();
        dataProdPromo = new HashMap();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            ProdPromo pp = (ProdPromo) entry.getValue();
            dataProdPromo.put(pp.getIndividual().getRestaurante().getNickname()+"_"+pp.getIndividual().getNombre(), new DataProdPromo(pp));
        }
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
