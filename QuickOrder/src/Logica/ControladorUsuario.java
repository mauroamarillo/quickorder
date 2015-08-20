package Logica;

import Datos.CategoriaD;
import Datos.PedidoD;
import Datos.UsuarioD;
import Logica.DataTypes.DataCliente;
import Logica.DataTypes.DataPedido;
import Logica.DataTypes.DataProdPedido;
import Logica.DataTypes.DataRestaurante;
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
    private final PedidoD PedidoDatos;

    /*acceso a datos de productos*/
    private final ControladorProductos CP;
    /*Datos de usuarios, categorias guardados en el sistema*/
    private HashMap Clientes = new HashMap();
    private HashMap Restaurantes = new HashMap();
    private HashMap Categorias = new HashMap();

    public ControladorUsuario() throws SQLException, ClassNotFoundException {

        this.UsuarioDatos = new UsuarioD();
        this.CategoriaDatos = new CategoriaD();
        this.PedidoDatos = new PedidoD();

        this.Restaurantes = retornarRestaurantes();
        this.Clientes = retornarClientes();
        this.Categorias = consultarCategorias();
        this.CP = new ControladorProductos(this);

    }

    public HashMap getDataClientes() {
        HashMap resultado = new HashMap();
        Iterator it = Clientes.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Cliente C = (Cliente) entry.getValue();
            resultado.put(C.getNickname(), C.getDataType());
        }
        return resultado;
    }

    public HashMap getDataRestaurantes() {
        HashMap resultado = new HashMap();
        Iterator it = Restaurantes.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Restaurante R = (Restaurante) entry.getValue();
            resultado.put(R.getNickname(), R.getDataType());
        }
        return resultado;
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

    public HashMap consultarRestaurantesPorCategoria(String nomCategoria) {
        Categoria categoria = new Categoria(nomCategoria);
        HashMap res = new HashMap();
        Iterator it = Restaurantes.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Restaurante R = ((Restaurante) entry.getValue());
            if (R.getCategorias().containsKey(categoria.getNombre())) {
                res.put(R.getNickname(), new DataRestaurante(R));
            }
        }
        return res;
    }

    public void insertarCliente(String nick, String email, String dir, String nombre, String apellido, Date fecha, File img) throws SQLException, Exception {
        Cliente C;
        if (img != null) {
            C = new Cliente(nick, nombre, email, dir, apellido, fecha, img.getPath(), new HashMap());
        } else {
            C = new Cliente(nick, nombre, email, dir, apellido, fecha, "sin_imagen", new HashMap());
        }
        validarDatosC(C);
        UsuarioDatos.agregarCliente(C.getNickname(), C.getNombre(), C.getEmail(), C.getDireccion(), C.getApellido(), C.getFechaNac(), C.getImagen());
        if (img != null) {
            File destino = new File("C:\\imagenes\\" + nick + ".jpg");
            HerramientaArchivos.copiarArchivo(img, destino);
        }
    }

    public void insertarRestaurante(String nick, String email, String dir, String nombre, HashMap IMGs, int cat[]) throws SQLException, Exception {
        Restaurante R = new Restaurante(nick, nombre, email, dir, null, null, null, null);
        validarDatosR(R, cat);
        UsuarioDatos.agregarRestaurante(nick, nombre, email, dir);
        for (int x = 0; x < cat.length; x++) {
            UsuarioDatos.agregarCategoriaARestaurante(nick, x);
        }
        Iterator it = IMGs.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String path = (String) entry.getValue();
            UsuarioDatos.agregarImgRestaurante(nick, path);
        }
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
        Iterator it = resultado.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Cliente C = ((Cliente) entry.getValue());
            C.setImagen(retornarIMGCliente(C.getNickname()));
        }
        return resultado;
    }

    private String retornarIMGCliente(String nick) throws SQLException {
        return UsuarioDatos.obtenerIMGCliente(nick);

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
            resultado.put(index, rs.getString("imagen"));
            index++;
        }
        return resultado;
    }

    public HashMap retornarCategoriasRestaurantes(String nick) throws SQLException {
        HashMap resultado = new HashMap();
        java.sql.ResultSet rs = CategoriaDatos.listarCatsRestaurante(nick);
        while (rs.next()) {
            String C =rs.getString("nombre");
            resultado.put(C , C);
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
                res.put(R.getNickname(), R.getDataType());
            }
        }
        return res;
    }

    /*
     MECANISMO DE BUSQUEDA:
     Primero vemos si el usuario que buscamos esta entre los datos que 
     el sistema ya tiene y si no lo encontramos, buscamos en la base de datos
     */
    public DataRestaurante buscarRestaurante(String nickname) throws SQLException {
        if ((Restaurante) Restaurantes.get(nickname) == null) {
            Restaurantes = this.retornarRestaurantes();
        }
        Restaurante R = (Restaurante) Restaurantes.get(nickname);
        if (R == null) {
            return null;
        }
        return new DataRestaurante(R);
    }

    public DataCliente buscarCliente(String nickname) throws SQLException {
        if ((Cliente) Clientes.get(nickname) == null) {
            Clientes = this.retornarRestaurantes();
        }
        Cliente C = (Cliente) Clientes.get(nickname);
        if (C == null) {
            return null;
        }
        return new DataCliente(C);
    }

    public Restaurante _buscarRestaurante(String nickname) throws SQLException {
        if ((Restaurante) Restaurantes.get(nickname) == null) {
            Restaurantes = this.retornarRestaurantes();
        }
        return (Restaurante) Restaurantes.get(nickname);
    }

    public Cliente _buscarCliente(String nickname) throws SQLException {
        if ((Cliente) Clientes.get(nickname) == null) {
            Clientes = this.retornarRestaurantes();
        }
        return (Cliente) Clientes.get(nickname);
    }

    /*-- PEDIDOS --*/
    private void validarPedido(Pedido P) throws Exception {
        if (P.getCliente() == null) {
            throw new Exception("Cliente invalido");
        }
        if (P.getRestaurante() == null) {
            throw new Exception("Restaurante invalido");
        }
        if (P.getProdPedidos() == null) {
            throw new Exception("Error al generar pedido");
        }
        if (P.getProdPedidos().size() < 1) {
            throw new Exception("No se agregaron Productos al pedido");
        }
    }

    public void insertarPedido(Date fecha, Estado estado, String cliente, String restaurante, HashMap dataProdPedidos) throws SQLException, Exception {
        Pedido P = new Pedido(0, fecha, estado, this._buscarCliente(cliente), this._buscarRestaurante(restaurante), dataProdPedidos);
        validarPedido(P);
        int numero = (PedidoDatos.agregarPedido(fecha, estado.ordinal(), cliente, restaurante));
        Iterator it = P.getProdPedidos().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            DataProdPedido DPP = (DataProdPedido) entry.getValue();
            PedidoDatos.agregarLineaDePedido(numero, DPP.getProducto().getRestaurante(), DPP.getProducto().getNombre(), DPP.getCantidad());
        }
    }

}
