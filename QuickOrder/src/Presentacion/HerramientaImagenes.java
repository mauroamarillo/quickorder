/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Jean
 */
public abstract class HerramientaImagenes {

    public static ImageIcon obtenerImagenEscalada(String path, int w, int h) {
        Image img = new ImageIcon(path).getImage();
        Image newImg;
        newImg = img.getScaledInstance(w, h, java.awt.Image.SCALE_AREA_AVERAGING);
        return new ImageIcon(newImg);
    }

    public static ImageIcon escalarIcono(ImageIcon ico, int w, int h) {
        Image img = ico.getImage();
        Image newImg;
        newImg = img.getScaledInstance(w, h, java.awt.Image.SCALE_FAST);
        return new ImageIcon(newImg);
    }

    /**
     *
     * @param path
     * @return
     */
    public static ImageIcon cargarImagen(String path) {
        try {
            byte[] btDataFile = Base64.getDecoder().decode(path.split(",")[1]);
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(btDataFile));
            return new ImageIcon(image);
        } catch (IOException ex) {
            Logger.getLogger(HerramientaImagenes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ImageIcon cargarYescalar(String path, int w, int h) {
        return escalarIcono(cargarImagen(path), w, h);
    }
}