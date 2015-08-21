package Presentacion;

import Logica.DataTypes.DataIndividual;
import Logica.DataTypes.DataProducto;
import Logica.DataTypes.DataPromocion;
import java.awt.Component;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JPanel;

public class PanelProductos extends JPanel {

    private final HashMap dataProductos = new HashMap();
    int cant = 0;
    private RegistroPedido RP;

    public PanelProductos(RegistroPedido RP) {
        this.RP = RP;
        setPreferredSize(new Dimension(170, 163));
    }

    public void iniciarPanel(HashMap listaDataProductos) {
        this.removeAll();
        dataProductos.clear();

        Iterator it = listaDataProductos.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (entry.getValue() instanceof DataIndividual) {
                DataIndividual DI = (DataIndividual) entry.getValue();
                AgregarProductoIndividual(DI);
            } else {
                DataPromocion DP = (DataPromocion) entry.getValue();
                AgregarProductoPromocion(DP);
            }
        }

    }

    public void reagregarProducto(Object P) {
        if (P instanceof DataIndividual) {
            DataIndividual DI = (DataIndividual) P;
            AgregarProductoIndividual(DI);
        } else {
            DataPromocion DP = (DataPromocion) P;
            AgregarProductoPromocion(DP);
        }
    }

    public void AgregarProductoIndividual(DataIndividual I) {
        cant++;
        int x = cant * 52;
        this.setPreferredSize(new Dimension(170, x));
        ComponenteProductoIndividual CP = new ComponenteProductoIndividual(I, this);
        this.add(CP);
        this.validate();
        this.dataProductos.put(I.getNombre(), CP);
    }

    public void AgregarProductoPromocion(DataPromocion P) {
        cant++;
        int x = cant * 52;
        this.setPreferredSize(new Dimension(170, x));
        ComponenteProductoPromocion CP = new ComponenteProductoPromocion(P, this);
        this.add(CP);
        this.validate();
        this.dataProductos.put(P.getNombre() + cant, CP);
    }
    /*Agrega producto a la tabla*/

    public void agregarProductoaLista(Component CP, DataProducto DP, int cantidad) {
        RP.agregarProductoTabla(DP, cantidad);
        this.remove(CP);
        this.dataProductos.remove(DP.getNombre());
        this.validate();
    }

}
