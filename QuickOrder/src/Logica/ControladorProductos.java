/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.ProductosD;
import Logica.DataTypes.DataIndividual;
import Logica.DataTypes.DataPromocion;
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

    private final ProductosD PD;

    private HashMap individuales;
    private HashMap promociones;

    public ControladorProductos(ControladorUsuario C) throws SQLException, ClassNotFoundException {
        this.CU = C;
        this.PD = new ProductosD();
        this.individuales = retornarIndividuales();
        this.promociones = retornarPromociones();
        asignarProductosDePromocion();

    }

    public HashMap getDataPromociones() {
        HashMap DataPromociones = new HashMap();
        Iterator it = promociones.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Promocion P = (Promocion) entry.getValue();
            DataPromociones.put(P.getRestaurante() + "_" + P.getNombre(), new DataPromocion(P));
        }
        return DataPromociones;
    }

    public HashMap getDataIndividuales() {
        HashMap DataIndividuales = new HashMap();
        Iterator it = individuales.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Individual I = (Individual) entry.getValue();
            DataIndividuales.put(I.getRestaurante() + "_" + I.getNombre(), new DataIndividual(I));
        }
        return DataIndividuales;
    }

    public HashMap getPromociones() {
        return promociones;
    }

    public HashMap getIndividuales() {
        return individuales;
    }

    private void guardarIMG(Producto P, File img) throws IOException {
        if (img != null) {
            new File("C:\\imagenes\\" + P.getRestaurante().getNickname() + "\\productos\\").mkdirs();
            File destino = new File("C:\\imagenes\\" + P.getRestaurante().getNickname() + "\\productos\\" + P.getNombre() + ".jpg");
            FileController.copiarArchivo(img, destino);
        }
    }

    public void insertarIndividual(String nombre, String descripcion, String precio, File img, String restaurante) throws Exception, ParseException {
        float pre = Float.parseFloat(precio);
        Individual P;
        if (img != null) {
            P = new Individual(nombre, descripcion, pre, "C:\\imagenes\\" + restaurante + "\\productos\\" + nombre + ".jpg", CU._buscarRestaurante(restaurante));
        } else {
            P = new Individual(nombre, descripcion, pre, "sin_imagen", CU._buscarRestaurante(restaurante));
        }
        validarProducto(P);
        PD.agregarIndividual(P.getRestaurante().getNickname(), P.getNombre(), P.getPrecio(), P.getDescripcion(), P.getImagen());
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
            Restaurante R = CU._buscarRestaurante(rs.getString("restaurante"));
            Individual I = new Individual(rs.getString("nombre"), rs.getString("descripcion"), rs.getFloat("precio"), "sin imagen", R);
            R.getIndividuales().put(I.getRestaurante().getNickname() + "_" + I.getNombre(), I);
            resultado.put(I.getRestaurante().getNickname() + "_" + I.getNombre(), I);

        }
        Iterator it = resultado.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Individual I = ((Individual) entry.getValue());
            if (PD.obtenerIMGdeProducto(I.getRestaurante().getNombre(), I.getNombre()) != null) {
                I.setImagen(PD.obtenerIMGdeProducto(I.getRestaurante().getNombre(), I.getNombre()));
            }
        }
        return resultado;
    }
    /* Buscar todos los productos del restaurante 'R' */

    public HashMap buscarProductos(String R) {
        HashMap resultado = buscarProductosI(R);
        resultado.putAll(buscarProductosP(R));
        return resultado;
    }

    public HashMap buscarProductosI(String R) {
        HashMap resultado = new HashMap();
        Iterator it = individuales.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Individual I = ((Individual) entry.getValue());
            if (I.getRestaurante().getNombre().equals(R)) {
                resultado.put(I.getRestaurante().getNickname() + "_" + I.getNombre(), new DataIndividual(I));
            }
        }
        return resultado;
    }

    public HashMap buscarProductosP(String R) {
        HashMap resultado = new HashMap();
        Iterator it = promociones.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Promocion P = ((Promocion) entry.getValue());
            if (P.getRestaurante().getNombre().equals(R)) {
                resultado.put(P.getRestaurante().getNickname() + "_" + P.getNombre(), new DataPromocion(P));
            }
        }
        return resultado;
    }

    public Individual buscarIndividual(String nombre, String restaurante) {
        return (Individual) individuales.get(restaurante + "_" + nombre);
    }

    public DataIndividual buscarDataIndividual(String nombre, String restaurante) {
        return new DataIndividual((Individual) individuales.get(restaurante + "_" + nombre));
    }
    /* NOMBRE, DESCRIPCION,IMAGEN,ACTIVADESCUENTO,*/

    public void insertarPromocion(String nombre, String descripcion, File img, boolean activa, float descuento, String restaurante, HashMap subProductos) throws SQLException, Exception {
        Promocion P;
        if (restaurante == null) {
            throw new Exception("Asignar Restaurante");
        }
        if (img != null) {
            P = new Promocion(nombre, descripcion, "C:\\imagenes\\" + CU._buscarRestaurante(restaurante).getNickname() + "\\productos\\" + nombre + ".jpg", activa, descuento, CU._buscarRestaurante(restaurante), null);
        } else {
            P = new Promocion(nombre, descripcion, "sin_imagen", activa, descuento, CU._buscarRestaurante(restaurante), null);
        }
        validarProducto(P);
        PD.agregarPromocion(P.getRestaurante().getNombre(), P.getNombre(), P.getDescuento(), P.getDescripcion(), P.getImagen(), P.getActiva());
        Iterator it = subProductos.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            ProdPromo pp = (ProdPromo) entry.getValue();
            PD.vincularPromocionProducto(pp.getIndividual().getRestaurante().getNickname(), P.getNombre(), pp.getIndividual().getNombre(), pp.getCantidad());
        }
        guardarIMG(P, img);
        this.promociones = retornarPromociones();
        asignarProductosDePromocion();
    }

    public HashMap retornarPromociones() throws SQLException {
        HashMap resultado = new HashMap();
        java.sql.ResultSet rs = PD.listarPromociones();
        while (rs.next()) {
            Restaurante R = CU._buscarRestaurante(rs.getString("restaurante"));
            Promocion P = new Promocion(rs.getString("nombre"), rs.getString("descripcion"), "sin imagen", rs.getBoolean("activa"), rs.getFloat("descuento"), R, null);
            R.getPromociones().put(P.getRestaurante().getNickname() + "_" + P.getNombre(), P);
            resultado.put(P.getRestaurante().getNickname() + "_" + P.getNombre(), P);
        }
        Iterator it = resultado.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Promocion P = ((Promocion) entry.getValue());
            if (PD.obtenerIMGdeProducto(P.getRestaurante().getNickname(), P.getNombre()) != null) {
                P.setImagen(PD.obtenerIMGdeProducto(P.getRestaurante().getNickname(), P.getNombre()));
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
