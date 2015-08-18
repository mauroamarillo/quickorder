package Presentacion;

import Logica.Individual;
import Logica.Producto;
import Logica.Promocion;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelProductos extends JPanel {

    private final Map individuales = new HashMap();
    private final Map promociones = new HashMap();
    int cant = 0;
    private RegistroPedido RP;
    
    public PanelProductos(RegistroPedido RP) {
        this.RP = RP;
        setPreferredSize(new Dimension(170, 163));
    }

    public void iniciarPanel(HashMap listaIndividual, HashMap listaPromocion) {
        this.removeAll();
        individuales.clear();
        promociones.clear();

        Iterator it = listaIndividual.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Individual P = (Individual) entry.getValue();
            AgregarProductoIndividual(P);
        }
        it = listaPromocion.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Promocion P = (Promocion) entry.getValue();
            AgregarProductoPromocion(P);
        }
    }

    public void AgregarProductoIndividual(Individual I) {
        cant++;
        int x = cant * 52;
        this.setPreferredSize(new Dimension(170, x));
        ComponenteProductoIndividual CP = new ComponenteProductoIndividual(I,this);
        this.add(CP);
        this.validate();
        this.individuales.put(I.getNombre(), CP);
    }

    public void AgregarProductoPromocion(Promocion P) {
        cant++;
        int x = cant * 52;
        this.setPreferredSize(new Dimension(170, x));
        ComponenteProductoPromocion CP = new ComponenteProductoPromocion(P,this);
        this.add(CP);
        this.validate();
        this.promociones.put(P.getNombre() + cant, CP);
    }
    /*Agrega producto individual a la tabla*/
    public void agregarProductoIaLista(ComponenteProductoIndividual CPI, int cantidad){
       RP.agregarProductoIndividualTabla(CPI.getProducto(), cantidad);
       this.remove(CPI);
       this.individuales.remove(CPI.getProducto().getNombre());
       this.validate();
    }
    /*Agrega producto promocion a la tabla*/
    public void agregarProductoPaLista(ComponenteProductoPromocion CPP, int cantidad){
       RP.agregarProductoPromocionTabla(CPP.getProducto(), cantidad);
       this.remove(CPP);
       this.individuales.remove(CPP.getProducto().getNombre());
       this.validate();
    }
    
    
    
}
