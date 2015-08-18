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
    /*acceso a capa logica*/
    private final CategoriaD CategoriaDatos;
    private final UsuarioD UsuarioDatos;
    /*acceso a datos de productos*/
    private final ControladorProductos CP;
    /*Datos de usuarios, categorias guardados en el sistema*/
    private HashMap Clientes = new HashMap();
    private HashMap Restaurantes = new HashMap();
    private HashMap Categorias = new HashMap();

    public ControladorUsuario() throws SQLException, ClassNotFoundException {
        
        this.UsuarioDatos = new UsuarioD();
        this.CategoriaDatos = new CategoriaD();
        
        this.Restaurantes = retornarRestaurantes();
        this.Clientes = retornarClientes();
        
        this.Categorias = consultarCategorias();
        this.CP = new ControladorProductos(this);

    }

    public ControladorProductos getCP() {
        return CP;
    }

    public HashMap getClientes() {
        return Clientes;
    }

    public HashMap getRestaurantes() {
        return Restaurantes;
    }

    public HashMap getCategorias() {
        return Categorias;
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

    public HashMap consultarRestaurantesPorCategoria(Categoria categoria) {
        HashMap res = new HashMap();
        Iterator it = Restaurantes.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Restaurante R = ((Restaurante) entry.getValue());
            if (R.getCategorias().containsKey(categoria.getNombre())) {
                res.put(R.getNickname(), R);
            }
        }
        return res;
    }

    public Restaurante buscarRestaurantePorNick_Nombre(String n_n) {
        Iterator it = Restaurantes.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Restaurante R = ((Restaurante) entry.getValue());
            if ((R.getNickname() + " - " + R.getNombre()).equals(n_n)) {
                return R;
            }
        }
        return null;
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
    /*FALTA COMPLETAR ESTO!!!!!!!!!!!!!!!!!!*/

    public HashMap retornarClientes() throws SQLException {
        HashMap resultado = new HashMap();
        java.sql.ResultSet rs = UsuarioDatos.listarClientes();
        while (rs.next()) {
            Cliente C = new Cliente(rs.getString("nickname"), rs.getString("nombre"), rs.getString("email"), rs.getString("direccion"), rs.getString("apellido"), rs.getDate("fechaN"), "sin_imagen", null);
            resultado.put(C.getNickname(), C);
        }
        /* Iterator it = resultado.entrySet().iterator();
         while (it.hasNext()) {
         Map.Entry entry = (Map.Entry) it.next();
         Restaurante R = ((Restaurante) entry.getValue());
         R.setImagenes(retornarIMGsRestaurantes(R.getNickname()));
         }
         it = resultado.entrySet().iterator();
         while (it.hasNext()) {
         Map.Entry entry = (Map.Entry) it.next();
         Restaurante R = ((Restaurante) entry.getValue());
         R.setCategorias(retornarCategoriasRestaurantes(R.getNickname()));
         }*/
        return resultado;

    }

    public HashMap retornarRestaurantes() throws SQLException {
        HashMap resultado = new HashMap();
        java.sql.ResultSet rs = UsuarioDatos.listarRestaurantes();
        while (rs.next()) {
            Restaurante R = new Restaurante(rs.getString("nickname"), rs.getString("nombre"), rs.getString("email"), rs.getString("direccion"), new HashMap(), new HashMap(), new HashMap(), new HashMap());
            resultado.put(R.getNickname(), R);
        }
        Iterator it = resultado.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Restaurante R = ((Restaurante) entry.getValue());
            R.setImagenes(retornarIMGsRestaurantes(R.getNickname()));
        }
        it = resultado.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Restaurante R = ((Restaurante) entry.getValue());
            R.setCategorias(retornarCategoriasRestaurantes(R.getNickname()));
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

    /*
     MECANISMO DE BUSQUEDA:
     Primero vemos si el usuario que buscamos esta entre los datos que 
     el sistema ya tiene y si no lo encontramos, buscamos en la base de datos
     */
    public Restaurante buscarRestaurante(String nickname) throws SQLException {
        if ((Restaurante) Restaurantes.get(nickname) == null) {
            Restaurantes = this.retornarRestaurantes();
        }
        return (Restaurante) Restaurantes.get(nickname);
    }

    public Cliente buscarCliente(String nickname) throws SQLException {
        if ((Cliente) Clientes.get(nickname) == null) {
            Clientes = this.retornarRestaurantes();
        }
        return (Cliente) Clientes.get(nickname);
    }

}
