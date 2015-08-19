package Datos;

import Logica.Individual;
import Logica.ProdPromo;
import Logica.Producto;
import Logica.Promocion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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

    private void agregarImagenProducto(Producto P) throws SQLException {
        String query = " INSERT INTO productos_imagenes(restaurante,producto,imagen)"
                + " VALUES('" + P.getRestaurante().getNickname() + "','" + P.getNombre() + "','" + P.getImagen() + "')";
        st.execute(query);
    }

    private void agregarProducto(Producto P) throws SQLException {
        String query = " INSERT INTO productos(restaurante,nombre,descripcion) "
                + " VALUES ('" + P.getRestaurante().getNickname() + "','" + P.getNombre() + "','" + P.getDescripcion() + "');";
        st.execute(query);
        agregarImagenProducto(P);
    }

    public void agregarIndividual(Individual I) throws SQLException {
        agregarProducto(I);
        String query = " INSERT INTO individuales(restaurante,nombre,precio) "
                + " VALUES ('" + I.getRestaurante().getNickname() + "','" + I.getNombre() + "'," + I.getPrecio() + ");";
        st.execute(query);
    }

    public ResultSet listarIndividuales() throws SQLException {
        String query = " SELECT p.restaurante, p.nombre, i.precio, p.descripcion "
                + " FROM productos p, individuales i"
                + " WHERE p.restaurante = i.restaurante"
                + " AND p.nombre = i.nombre";
        return st.executeQuery(query);
    }

    public void agregarPromocion(Promocion P) throws SQLException {
        agregarProducto(P);
        String activa = "false";
        if (P.getActiva()) {
            activa = "true";
        }
        String query = " INSERT INTO promociones(restaurante,nombre,activa,descuento) "
                + " VALUES ('" + P.getRestaurante().getNickname() + "','" + P.getNombre() + "'," + activa + "," + P.getDescuento() + ");";
        st.execute(query);
        Iterator it = P.getProdPromos().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            ProdPromo I = ((ProdPromo) entry.getValue());
            vincularPromocionProducto(P, I);
        }
    }

    public void vincularPromocionProducto(Promocion Promo, ProdPromo Prod) throws SQLException {
        String query = " INSERT INTO productos_promociones(restaurante,nombrepromo,nombreprod,cantidad) "
                + " VALUES ('" + Promo.getRestaurante().getNickname() + "','" + Promo.getNombre() + "','" + Prod.getIndividual().getNombre() + "'," + Prod.getCantidad() + ");";
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
                + " FROM productos p,individuales i,productos_promociones pp "
                + " WHERE p.restaurante = i.restaurante"
                + " AND p.nombre = i.nombre"
                + " AND i.restaurante = pp.restaurante"
                + " AND i.nombre = pp.nombreprod"
                + " AND pp.restaurante = '" + restaurante + "'"
                + " AND pp.nombrepromo = '" + nombre + "'";
        return st.executeQuery(query);
    }

    public String obtenerIMGdeProducto(Producto P) throws SQLException {
        String query = "SELECT imagen"
                + " FROM productos_imagenes p"
                + " WHERE p.restaurante = '" + P.getRestaurante().getNickname() + "'"
                + " AND p.producto = '" + P.getNombre() + "';";
        ResultSet rs = st.executeQuery(query);
        rs.next();
        return rs.getString("imagen");
    }
}
