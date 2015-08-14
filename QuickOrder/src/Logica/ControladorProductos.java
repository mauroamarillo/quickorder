/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.ProductosD;
import java.io.File;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Jean
 */
public final class ControladorProductos {

    private final ControladorUsuario CU;
    private final ProductosD PD;
    private final HashMap individuales;

    public HashMap getIndividuales() {
        return individuales;
    }

    public ControladorProductos(ControladorUsuario CU) throws SQLException, ClassNotFoundException {
        this.CU = CU;
        this.PD = new ProductosD();
        this.individuales = retornarIndividuales();

    }

    public void insertarIndividual(String nombre, String descripcion, String precio, File img, Restaurante restaurante) throws Exception, ParseException {
        float pre = Float.parseFloat(precio);
        Individual P;
        if (img != null) {
            P = new Individual(nombre, descripcion, pre, img.getPath(), restaurante);
        } else {
            P = new Individual(nombre, descripcion, pre, "sin_imagen", restaurante);
        }
        validarProducto(P);
        PD.agregarIndividual(P);
        if (img != null) {
            new File("C:\\imagenes\\" + P.getRestaurante().getNickname() + "\\productos\\").mkdirs();
            File destino = new File("C:\\imagenes\\" + P.getRestaurante().getNickname() + "\\productos\\" + nombre + ".jpg");
            FileController.copiarArchivo(img, destino);
        }
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
            Individual I = new Individual(rs.getString("nombre"), rs.getString("descripcion"), rs.getFloat("precio"), "sin imagen", CU.buscarRestaurante(rs.getString("restaurante")));
            resultado.put(I.getRestaurante().getNickname() + "_" + I.getNombre(), I);
        }
        /* Iterator it = resultado.entrySet().iterator();
         while (it.hasNext()) {
         Map.Entry entry = (Map.Entry) it.next();
         Restaurante R = ((Restaurante) entry.getValue());
         R.setImagenes(retornarIMGsRestaurantes(R.nickname));
         }*/
        return resultado;
    }

    public HashMap buscarProductos(Restaurante R) {
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

    public void insertarPromocion(String nombre, String descripcion, String imagen, boolean activa, float descuento, Restaurante restaurante, HashMap subProductos) throws SQLException, Exception {
        // JOptionPane.showMessageDialog(null, nombre);
        Promocion P = new Promocion(nombre, descripcion, imagen, activa, descuento, restaurante, subProductos);
        validarProducto(P);
        PD.agregarPromocion(P);
    }

}
