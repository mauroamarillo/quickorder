package Logica;

import Datos.CategoriaD;
import Datos.UsuarioD;
import java.io.File;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class ControladorUsuario {

    private final CategoriaD CategoriaDatos;
    private final UsuarioD UsuarioDatos;
    private HashMap Restaurantes = new HashMap();

    public ControladorUsuario() throws SQLException, ClassNotFoundException {
        this.UsuarioDatos = new UsuarioD();
        this.CategoriaDatos = new CategoriaD();
        this.Restaurantes = retornarRestaurantes();
    }

    public HashMap getRestaurantes() {
        return Restaurantes;
    }

    public HashMap consultarCategorias() throws SQLException {
        HashMap resultado = new HashMap();
        java.sql.ResultSet rs;
        rs = CategoriaDatos.consultarCategorias();
        while (rs.next()) {
            resultado.put(rs.getInt("idCat"), rs.getString("nombre"));
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
        if (img != null) {
            File destino = new File("C:\\imagenes\\" + nick + ".jpg");
            FileController.copiarArchivo(img, destino);
        }
    }
    public void insertarRestaurante(String nick, String email, String dir, String nombre, HashMap IMGs, int cat[]) throws SQLException, Exception {
        Restaurante R = new Restaurante(nick, nombre, email, dir, null, null, null, null);
        validarDatosR(R, cat);
        UsuarioDatos.agregarRestaurante(R, IMGs, cat);
        this.Restaurantes = retornarRestaurantes();
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

    public HashMap retornarRestaurantes() throws SQLException {
        HashMap resultado = new HashMap();
        java.sql.ResultSet rs = UsuarioDatos.listarRestaurantes();
        while (rs.next()) {
            Restaurante R = new Restaurante(rs.getString("nickname"), rs.getString("nombre"), rs.getString("email"), rs.getString("direccion"), null, null, null, null);
            resultado.put(R.getNickname(), R);
        }
        Iterator it = resultado.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Restaurante R = ((Restaurante) entry.getValue());
            R.setImagenes(retornarIMGsRestaurantes(R.nickname));
        }
        it = resultado.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Restaurante R = ((Restaurante) entry.getValue());
            R.setCategorias(retornarCategoriasRestaurantes(R.nickname));
        }
        return resultado;
    }

    public HashMap retornarIMGsRestaurantes(String nick) throws SQLException {
        HashMap resultado = new HashMap();
        java.sql.ResultSet rs = UsuarioDatos.listarIMGsRestaurante(nick);
        int index = 1;
        while (rs.next()) {
            Imagen I = new Imagen(rs.getString("path"));
            resultado.put(index, I);
            index++;
        }
        return resultado;
    }

    public HashMap retornarCategoriasRestaurantes(String nick) throws SQLException {
        HashMap resultado = new HashMap();
        java.sql.ResultSet rs = CategoriaDatos.listarCatsRestaurante(nick);
        while (rs.next()) {
            Categoria C = new Categoria(rs.getString("nombre"));
            resultado.put(C.getNombre(), C);
        }
        return resultado;
    }

    public HashMap filtrarRestaurantes(String filtro) {
        HashMap res = new HashMap();
        Iterator it = Restaurantes.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Restaurante R = ((Restaurante) entry.getValue());
            if (R.getNickname().contains(filtro)) {
                res.put(R.getNickname(), R);
            }
        }
        return res;
    }
    public Restaurante buscarRestaurante(String nickname){
        return (Restaurante) Restaurantes.get(nickname);
    }

}
