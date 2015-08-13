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
import javax.swing.JOptionPane;

/**
 *
 * @author Jean
 */
public class ControladorProductos {

    private final ControladorUsuario CU;
    private final ProductosD PD;

    public ControladorProductos(ControladorUsuario CU) throws SQLException, ClassNotFoundException {
        this.CU = CU;
        PD = new ProductosD();
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

    public void validarProducto(Individual P) throws Exception {
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
}
