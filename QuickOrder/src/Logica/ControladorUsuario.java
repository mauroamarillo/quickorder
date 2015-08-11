package Logica;

import Datos.CategoriaD;
import Datos.UsuarioD;
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

    public int insertarCliente(String nick, String email, String dir, String nombre, String apellido, Date fecha, String path) {
        Cliente C = new Cliente(nick, nombre, email, dir, apellido, fecha, path, new HashMap());
        if (!UsuarioDatos.nickOcupado(C.nickname)) {
            UsuarioDatos.agregarCliente(C);
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "- " + C.nickname + " Ocupado -", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

}
