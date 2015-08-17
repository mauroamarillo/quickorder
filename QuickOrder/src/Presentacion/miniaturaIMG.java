/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.awt.Frame;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jean
 */
public final class miniaturaIMG extends JPanel {

    /**
     * Creates new form miniaturaIMG
     */
    String Path;

    public miniaturaIMG() {

        initComponents();
        // cargarIMGs();
    }

    public void cargarIMGs(String x) {

        Path = x;
        Image img = new ImageIcon(Path).getImage();
        Image newImg;
        newImg = img.getScaledInstance(150, 150, java.awt.Image.SCALE_FAST);
        ImageIcon ico = new ImageIcon(newImg);
        jLabel1.setIcon(ico);
        this.validate();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(150, 150));
        setMinimumSize(new java.awt.Dimension(150, 150));
        setPreferredSize(new java.awt.Dimension(150, 150));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.setMaximumSize(new java.awt.Dimension(150, 150));
        jLabel1.setMinimumSize(new java.awt.Dimension(150, 150));
        jLabel1.setPreferredSize(new java.awt.Dimension(150, 150));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        java.awt.Dimension D = new java.awt.Dimension(800, 600);
        Image img = new ImageIcon(Path).getImage();
        Image newImg;
        newImg = img.getScaledInstance(D.width, D.height, java.awt.Image.SCALE_AREA_AVERAGING);
        ImageIcon ico = new ImageIcon(newImg);
        JLabel I = new JLabel();
        I.setIcon(ico);
        JDialog d = new JDialog(new Frame(), true);
        d.setLocationByPlatform(true);
        d.setMaximumSize(D);
        d.setMinimumSize(D);
        // d.setPreferredSize(new java.awt.Dimension(479, 306));
        d.add(I);
        d.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
