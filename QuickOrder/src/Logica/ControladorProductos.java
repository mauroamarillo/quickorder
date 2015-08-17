/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.ProductosD;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Jean
 */
public final class ControladorProductos {

    private final ControladorUsuario CU;

    private ProductosD PD;

    private HashMap individuales;
    private HashMap promociones;

    public HashMap getPromociones() {
        return promociones;
    }

    public HashMap getIndividuales() {
        return individuales;
    }

    public ControladorProductos(ControladorUsuario C) throws SQLException, ClassNotFoundException {
        this.CU = C;
        this.PD = new ProductosD();
        this.individuales = retornarIndividuales();
        this.promociones = retornarPromociones();
        asignarProductosDePromocion();

    }

    private void guardarIMG(Producto P, File img) throws IOException {
        if (img != null) {
            new File("C:\\imagenes\\" + P.getRestaurante().getNickname() + "\\productos\\").mkdirs();
            File destino = new File("C:\\imagenes\\" + P.getRestaurante().getNickname() + "\\productos\\" + P.getNombre() + ".jpg");
            FileController.copiarArchivo(img, destino);
        }
    }

    public void insertarIndividual(String nombre, String descripcion, String precio, File img, Restaurante restaurante) throws Exception, ParseException {
        float pre = Float.parseFloat(precio);
        Individual P;
        if (restaurante == null) {
            throw new Exception("Asignar Restaurante");
        }
        if (img != null) {
            P = new Individual(nombre, descripcion, pre, "C:\\imagenes\\" + restaurante.getNickname() + "\\productos\\" + nombre + ".jpg", restaurante);
        } else {
            P = new Individual(nombre, descripcion, pre, "sin_imagen", restaurante);
        }
        validarProducto(P);
        PD.agregarIndividual(P);
        guardarIMG(P, img);
        this.individuales = retornarIndividuales();
    }

    public void validarProducto(Producto P) throws Exception {
        if (P.getNombre().isEmpty()) {
            throw new Exception("Asignar Nombre");
        }
        if (P.getDescripcion().isEmpty()) {
            throw new Exception("Asignar Descripcion");
        }
        if (P.getRestaurante() == null) {
            throw new Exception("Asignar Restaurante");
        }
    }

    public HashMap retornarIndividuales() throws SQLException {
        HashMap resultado = new HashMap();
        java.sql.ResultSet rs = PD.listarIndividuales();
        while (rs.next()) {
            Restaurante R = CU.buscarRestaurante(rs.getString("restaurante"));
            Individual I = new Individual(rs.getString("nombre"), rs.getString("descripcion"), rs.getFloat("precio"), "sin imagen", R);
            R.getIndividuales().put(I.getRestaurante().getNickname() + "_" + I.getNombre(), I);
            resultado.put(I.getRestaurante().getNickname() + "_" + I.getNombre(), I);

        }
        Iterator it = resultado.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Individual I = ((Individual) entry.getValue());
            if (PD.obtenerIMGdeProducto(I) != null) {
                I.setImagen(PD.obtenerIMGdeProducto(I));
            }
        }
        return resultado;
    }

    public HashMap buscarProductosI(Restaurante R) {
        HashMap resultado = new HashMap();
        Iterator it = individuales.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Individual I = ((Individual) entry.getValue());
            if (I.getRestaurante().getNombre().equals(R.getNombre())) {
                resultado.put(I.getRestaurante().getNickname() + "_" + I.getNombre(), I);
            }
        }
        return resultado;
    }

    public Individual buscarIndividual(String nombre, String restaurante) {
        return (Individual) individuales.get(restaurante + "_" + nombre);
    }

    public void insertarPromocion(String nombre, String descripcion, File img, boolean activa, float descuento, Restaurante restaurante, HashMap subProductos) throws SQLException, Exception {
        Promocion P;//= new Promocion(nombre, descripcion, img, activa, descuento, restaurante, subProductos);
        if (restaurante == null) {
            throw new Exception("Asignar Restaurante");
        }
        if (img != null) {
            P = new Promocion(nombre, descripcion, "C:\\imagenes\\" + restaurante.getNickname() + "\\productos\\" + nombre + ".jpg", activa, descuento, restaurante, subProductos);
        } else {
            P = new Promocion(nombre, descripcion, "sin_imagen", activa, descuento, restaurante, subProductos);
        }
        validarProducto(P);
        PD.agregarPromocion(P);
        guardarIMG(P, img);
        this.promociones = retornarPromociones();
        asignarProductosDePromocion();
    }

    public HashMap retornarPromociones() throws SQLException {
        HashMap resultado = new HashMap();
        java.sql.ResultSet rs = PD.listarPromociones();
        while (rs.next()) {
            Restaurante R = CU.buscarRestaurante(rs.getString("restaurante"));
            Promocion P = new Promocion(rs.getString("nombre"), rs.getString("descripcion"), "sin imagen", rs.getBoolean("activa"), rs.getFloat("descuento"), R, null);
            R.getPromociones().put(P.getRestaurante().getNickname() + "_" + P.getNombre(), P);
            resultado.put(P.getRestaurante().getNickname() + "_" + P.getNombre(), P);
        }
        Iterator it = resultado.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Promocion P = ((Promocion) entry.getValue());
            if (PD.obtenerIMGdeProducto(P) != null) {
                P.setImagen(PD.obtenerIMGdeProducto(P));
            }
        }
        return resultado;
    }

    public void asignarProductosDePromocion() throws SQLException {
        Iterator it = promociones.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Promocion P = ((Promocion) entry.getValue());
            java.sql.ResultSet rs = PD.listarProductosDePromocion(P.getRestaurante().getNickname(), P.getNombre());
            HashMap productosDePromo = new HashMap();
            while (rs.next()) {
                ProdPromo PP = new ProdPromo(rs.getInt("cantidad"), buscarIndividual(rs.getString("nombre"), rs.getString("restaurante")));
                productosDePromo.put(PP.getIndividual().getRestaurante().getNickname() + "_" + PP.getIndividual().getNombre(), PP);
            }
            P.setProdPromos(productosDePromo);
        }
    }

}
