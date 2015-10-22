/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Jean
 */
public final class PanelInfoResIMG extends javax.swing.JPanel {

    /**
     * Creates new form PanelInfoResIMG
     */
    public PanelInfoResIMG() {
        setPreferredSize(new java.awt.Dimension(0, 0));
        initComponents();
    }

    public void cargar(List<Object> imgs) {
        Iterator it = imgs.iterator();
        int x = 0;
        while (it.hasNext()) {
            String path = (String) it.next();
            miniaturaIMG m = new miniaturaIMG();
            m.cargarIMGs(path);
            this.add(m);
            this.validate();
            x++;
        }
        if (x % 2 == 0) {
            setPreferredSize(new java.awt.Dimension(300, ((x * 150) / 2) + x * 3));
        } else {
            setPreferredSize(new java.awt.Dimension(300, (((x + 1) * 150) / 2) + x * 4));
        }
    }

    private void initComponents() {
        setPreferredSize(new java.awt.Dimension(300, 0));
    }
}
