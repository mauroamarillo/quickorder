package Presentacion;

import java.awt.Dimension;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JPanel;

public class PanelImagenes extends JPanel {

    public PanelImagenes() {
        setPreferredSize(new Dimension(170, 500));
    }

    private int pos = 1;
    //Nos sirve para almacenar a los objetos creados
    private final Map nota = new HashMap();

    public void AgregarImagen(int index, String nombre, String Pach_Img) {
        pos++;
        int x = pos * 100;
        setSize(new Dimension(170, x));
        ComponenteImagen CI = new ComponenteImagen(index, nombre, Pach_Img, this);
        this.add(CI);
        this.validate();
        this.nota.put("key_" + index, CI);

    }

    public void GuardarColeccion(String nickRestaurant) {
        String pach = "C:\\imagenes\\" + nickRestaurant+"\\";
        new File(pach).mkdirs();
        Iterator it = nota.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            ComponenteImagen CI = ((ComponenteImagen) entry.getValue());
            CI.GuardarImagen(pach);
        }
    }
    public void borrarImagen(int key){
       nota.remove("key_" + key);
    }
    /*
     // este codigo lo dejo porque se ve como se hace la iteracion y puede servir para devolver todos las imagenes
     public void BorrarImagen(java.awt.event.ActionEvent e) {
     //se obtiene el comando ejecutado
     String comando = e.getActionCommand();
     //se recorre el MAP
     Iterator it = nota.entrySet().iterator();
     while (it.hasNext()) {
     Map.Entry entry = (Map.Entry) it.next();
     //se obtiene el KEY -> identificador unico
     String itm = entry.getKey().toString();
     //si comando de componente es igual a comando pulsado
     if (itm.equals(comando)) {
     //se recupera el contenido del JTextfield
     ComponenteImagen CI = ((ComponenteImagen) entry.getValue());
     this.remove(CI);
     }
     }
     }*/
}
