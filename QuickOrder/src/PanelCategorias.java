
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;

public class PanelCategorias extends JPanel {

    public PanelCategorias(){
       setPreferredSize(new Dimension(170, 0));
    }
    
    private int pos = 1;
    //Nos sirve para almacenar a los objetos creados
    private final Map nota = new HashMap();

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
}
