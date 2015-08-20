package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jean
 */
public class ProductosD {

    private final Estructura es = new Estructura();
    private final Statement st;

    public ProductosD() throws SQLException, ClassNotFoundException {
        this.st = es.generarSt();
    }

    public boolean productoRegistrado(String nombre, String restaurante) throws SQLException {
        String query = " SELECT * "
                + " FROM productos "
                + " WHERE nombre = '" + nombre + "' "
                + " AND restaurante ='" + restaurante + "';";
        ResultSet rs = st.executeQuery(query);
        return rs.next();
    }

    private void agregarImagenProducto(String restaurante, String producto, String imagen) throws SQLException {
        String query = " INSERT INTO productos_imagenes(restaurante,producto,imagen)"
                + " VALUES('" + restaurante + "','" + producto + "','" + imagen + "')";
        st.execute(query);
    }

    private void agregarProducto(String restaurante, String producto, String descripcion, String imagen) throws SQLException {
        String query = " INSERT INTO productos(restaurante,nombre,descripcion) "
                + " VALUES ('" + restaurante + "','" + producto + "','" + descripcion + "');";
        st.execute(query);
        agregarImagenProducto(restaurante, producto, imagen);
    }

    public void agregarIndividual(String restaurante, String producto, float precio, String descripcion, String imagen) throws SQLException {
        agregarProducto(restaurante, producto, descripcion, imagen);
        String query = " INSERT INTO individuales(restaurante,nombre,precio) "
                + " VALUES ('" + restaurante + "','" + producto + "'," + precio + ");";
        st.execute(query);
    }

    public ResultSet listarIndividuales() throws SQLException {
        String query = " SELECT p.restaurante, p.nombre, i.precio, p.descripcion "
                + " FROM productos p, individuales i"
                + " WHERE p.restaurante = i.restaurante"
                + " AND p.nombre = i.nombre";
        return st.executeQuery(query);
    }

    public void agregarPromocion(String restaurante, String producto, float descuento, String descripcion, String imagen, boolean act) throws SQLException {
        agregarProducto(restaurante, producto, descripcion, imagen);
        String activa = "false";
        if (act) {
            activa = "true";
        }
        String query = " INSERT INTO promociones(restaurante,nombre,activa,descuento) "
                + " VALUES ('" + restaurante + "','" + producto + "'," + activa + "," + descuento + ");";
        st.execute(query);
    }

    public void vincularPromocionProducto(String restaurante, String nombrePromo, String nombreProd, int cantidad) throws SQLException {
        String query = " INSERT INTO productos_promociones(restaurante,nombrepromo,nombreprod,cantidad) "
                + " VALUES ('" + restaurante + "','" + nombrePromo + "','" + nombreProd + "'," + cantidad + ");";
        st.execute(query);
    }

    public ResultSet listarPromociones() throws SQLException {
        String query = " SELECT p.restaurante, p.nombre, p.descripcion, pp.descuento, pp.activa "
                + " FROM productos p,promociones pp"
                + " WHERE p.restaurante = pp.restaurante"
                + " AND p.nombre = pp.nombre";
        return st.executeQuery(query);
    }

    public ResultSet listarProductosDePromocion(String restaurante, String nombre) throws SQLException {
        String query = " SELECT p.restaurante, p.nombre, p.descripcion, i.precio, pp.cantidad"
                + " FROM productos p,individuales i,promociones_productos pp "
                + " WHERE p.restaurante = i.restaurante"
                + " AND p.nombre = i.nombre"
                + " AND i.restaurante = pp.restaurante"
                + " AND i.nombre = pp.nombreprod"
                + " AND pp.restaurante = '" + restaurante + "'"
                + " AND pp.nombrepromo = '" + nombre + "'";
        return st.executeQuery(query);
    }

    public String obtenerIMGdeProducto(String restaurante, String nombre) throws SQLException {
        String query = "SELECT imagen"
                + " FROM productos_imagenes p"
                + " WHERE p.restaurante = '" + restaurante + "'"
                + " AND p.producto = '" + nombre + "';";
        ResultSet rs = st.executeQuery(query);
        if (rs.next()) {
            return rs.getString("imagen");
        }
        return "sin_imagen";
    }
}
