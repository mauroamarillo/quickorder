package Logica;

import Datos.CategoriaD;
import Datos.UsuarioD;
import java.io.File;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jean
 */
public class ControladorUsuario {

    CategoriaD categoriaDatos = new CategoriaD();
    UsuarioD UsuarioDatos = new UsuarioD();

    public ControladorUsuario() {
    }

    public HashMap consultarCategorias() {
        HashMap resultado = new HashMap();
        java.sql.ResultSet rs;
        try {
            rs = categoriaDatos.consultarCategorias();
            while (rs.next()) {
                resultado.put(rs.getInt("idCat"), rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public void insertarCliente(String nick, String email, String dir, String nombre, String apellido, Date fecha, File img) throws SQLException, Exception {
        Cliente C;
        if (img != null) {
            C = new Cliente(nick, nombre, email, dir, apellido, fecha, img.getPath(), new HashMap());
        } else {
            C = new Cliente(nick, nombre, email, dir, apellido, fecha, "sin_imagen", new HashMap());
        }
        validarDatosC(C);
        UsuarioDatos.agregarCliente(C);
    }

    public void insertarRestaurante(String nick, String email, String dir, String nombre, HashMap IMGs, int cat[]) throws SQLException, Exception {
        Restaurante R = new Restaurante(nick, nombre, email, dir, null, null, null, null);
        validarDatosR(R, cat);
        UsuarioDatos.agregarRestaurante(R, IMGs, cat);
    }

    private void validarDatosC(Cliente C) throws SQLException, Exception {

        if (C.getNickname().isEmpty()) {
            throw new Exception("Asignar Nickname");
        }
        if (C.getNombre().isEmpty()) {
            throw new Exception("Asignar Nombre");
        }
        if (C.getDireccion().isEmpty()) {
            throw new Exception("Asignar Direccion");
        }
        if (C.getApellido().isEmpty()) {
            throw new Exception("Asignar Apellido");
        }
        if (C.getEmail().isEmpty()) {
            throw new Exception("Asignar Email");
        }
        if (UsuarioDatos.nickOcupado(C.nickname)) {
            throw new Exception("Nickname Ocupado");
        }
        if (UsuarioDatos.emailOcupado(C.email)) {
            throw new Exception("Email Ocupado");
        }

    }

    private void validarDatosR(Restaurante R, int cat[]) throws SQLException, Exception {

        if (R.getNickname().isEmpty()) {
            throw new Exception("Asignar Nickname");
        }
        if (R.getNombre().isEmpty()) {
            throw new Exception("Asignar Nombre");
        }
        if (R.getDireccion().isEmpty()) {
            throw new Exception("Asignar Direccion");
        }
        if (R.getEmail().isEmpty()) {
            throw new Exception("Asignar Email");
        }
        if (cat.length < 1) {
            throw new Exception("Asignar al menos 1 Categoria");
        }
        if (UsuarioDatos.nickOcupado(R.nickname)) {
            throw new Exception("Nickname Ocupado");
        }
        if (UsuarioDatos.emailOcupado(R.email)) {
            throw new Exception("Email Ocupado");
        }

    }

}
