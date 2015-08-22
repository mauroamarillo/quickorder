package Presentacion;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class FondoVentanaPrincipal extends JPanel {

    private Image imagen;

    public FondoVentanaPrincipal(String nombreImagen) {
        imagen = new ImageIcon(getClass().getResource(nombreImagen)).getImage();
    }

    @Override
    public void paint(Graphics g) {
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
        } else {
            setOpaque(true);
        }
        super.paint(g);
    }
}
