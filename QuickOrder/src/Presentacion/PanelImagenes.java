package Presentacion;

import java.awt.Dimension;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JPanel;

public class PanelImagenes extends JPanel {

    RegistroRestaurante RR;

    public PanelImagenes(RegistroRestaurante RR) {
        this.RR = RR;
        setPreferredSize(new Dimension(170, 500));
    }

    private int pos = 1;
    //Nos sirve para almacenar a los objetos creados
    private final Map IMGs = new HashMap();

    public void AgregarImagen(int index, String nombre, String Pach_Img) {
        pos++;
        int x = pos * 100;
        this.setPreferredSize(new Dimension(170, x));
        ComponenteImagen CI = new ComponenteImagen(index, nombre, Pach_Img, this);
        this.add(CI);
        this.validate();
        this.IMGs.put("key_" + index, CI);
    }

    public HashMap GuardarColeccion(String nickRestaurant) {
        Iterator it = IMGs.entrySet().iterator();
        HashMap r = new HashMap();
        int x = 1;
        while (it.hasNext()) {
            String path = "C:\\imagenes\\" + nickRestaurant + "\\";
            new File(path).mkdirs();
            Map.Entry entry = (Map.Entry) it.next();
            ComponenteImagen CI = ((ComponenteImagen) entry.getValue());
            r.put(x, CI.GuardarImagen(path, x + ".jpg"));
            x++;
        }
        return r;
    }

    public void borrarImagen(int key) {
        pos--;
        IMGs.remove("key_" + key);
    }
}
