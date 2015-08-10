package Presentacion;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import javax.swing.JPanel;

public class PanelCategorias extends JPanel {

    public PanelCategorias() {
        setPreferredSize(new Dimension(170, 0));
    }

    private int pos = 1;
    //Nos sirve para almacenar a los objetos creados
    private final Map nota = new HashMap();
    //private int idCat[] = null;
 
    public void AgregarCategoria(int index, String nombre) {
        //instancia nueva a componente
        int x = pos * 26;
        setPreferredSize(new Dimension(170, x));
        ComponenteCategoria CC = new ComponenteCategoria(index, nombre);
        this.add(CC);//se añade al jpanel
        this.validate();
        //se añade al MAP
        this.nota.put("key_" + index, CC);
        //se incrementa contador de componentes
        pos++;
    }
    /*obtener las categorias seleccionadas*/
    public int[] getCategorias() {
        int x = 0, y = 0;
        Iterator it = nota.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            ComponenteCategoria CC = ((ComponenteCategoria) entry.getValue());
            if (CC.getValor().isSelected()) {
               x++;
            }
        }
        int[] idCat = new int[x];
        it = nota.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            ComponenteCategoria CC = ((ComponenteCategoria) entry.getValue());
            if (CC.getValor().isSelected()) {
              idCat[y] = CC.getIndex();
              y++;
            }
        }
        return idCat;
    }
}
