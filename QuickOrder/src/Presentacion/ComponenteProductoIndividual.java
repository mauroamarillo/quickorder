/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.DataTypes.DataIndividual;
import Logica.HerramientaImagenes;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Jean
 */
public class ComponenteProductoIndividual extends javax.swing.JPanel {

    /**
     * Creates new form ComponenteProducto
     */
    private DataIndividual P;
    private int cantidad = 1;
    
    private PanelProductos PP;
    
    public ComponenteProductoIndividual(DataIndividual I, PanelProductos PP) {
        this.P = I;
        this.PP = PP;
        initComponents();
        Nombre.setText(P.getNombre());
        Precio.setText("$"+String.valueOf(P.getPrecio()));
        IMG.setText("");
        IMG.setIcon(HerramientaImagenes.cargarYescalar(P.getImagen(), 78, 78));
    }
    
    public DataIndividual getProducto() {
        return P;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IMG = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        Precio = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setMaximumSize(new java.awt.Dimension(218, 82));
        setMinimumSize(new java.awt.Dimension(218, 82));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        IMG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IMG.setText("SIN IMAGEN");
        IMG.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        Nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Nombre.setText("Nombre");

        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("Precio: ");

        Precio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Precio.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(IMG, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Precio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(IMG, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Nombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label)
                    .addComponent(Precio))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        try {
            cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Cantidad"));
            this.setVisible(false);
            PP.agregarProductoaLista(this, P, cantidad);
            
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Cantidad invalida", "ENTRADA INCORRECTA", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IMG;
    private javax.swing.JLabel Nombre;
    private javax.swing.JLabel Precio;
    private javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables
}
