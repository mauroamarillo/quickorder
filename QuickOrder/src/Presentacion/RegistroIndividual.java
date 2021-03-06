/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.DataTypes.DataRestaurante;
import Logica.HerramientaImagenes;
import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Jean
 */
public class RegistroIndividual extends javax.swing.JInternalFrame {

    QuickOrder ventanaPrincipal;
    File foto;

    public RegistroIndividual(QuickOrder vp) throws SQLException {
        this.ventanaPrincipal = vp;
        initComponents();
        cargarRestaurantes();
        //ESTE CAMPO SOLO PUEDE SER NUMERICO

        //  this.setLocation(220, 80);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
        Text_Nombre.requestFocus();
    }

    private void cargarRestaurantes() throws SQLException {
        HashMap OBJs = ventanaPrincipal.CU.getDataRestaurantes();
        Iterator it = OBJs.entrySet().iterator();
        DefaultListModel model = new DefaultListModel();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            DataRestaurante R = ((DataRestaurante) entry.getValue());
            model.addElement(R.getNickname() + " - " + R.getNombre());
        }
        jList2.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        Text_Nombre = new javax.swing.JTextField();
        Text_Descripcion = new javax.swing.JTextField();
        Text_Precio = new javax.swing.JTextField();
        Text_Filtro = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Label_Img = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Button_Aceptar = new javax.swing.JButton();
        Button_Cancelar = new javax.swing.JButton();

        jFileChooser1.setFileFilter(new FileNameExtensionFilter("Imagenes jpg ", "jpg"));
        jFileChooser1.setCurrentDirectory(new java.io.File("C:\\Users\\Jean\\Pictures"));

        setClosable(true);
        setTitle("Registro Producto Individual");
        setMaximumSize(new java.awt.Dimension(600, 340));
        setMinimumSize(new java.awt.Dimension(600, 340));
        setPreferredSize(new java.awt.Dimension(600, 340));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        Text_Precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Text_PrecioKeyTyped(evt);
            }
        });

        Text_Filtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_FiltroActionPerformed(evt);
            }
        });
        Text_Filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Text_FiltroKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Text_FiltroKeyTyped(evt);
            }
        });

        jList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jList2);

        jLabel1.setText("Nombre*: ");

        jLabel2.setText("Descripcion*:");

        jLabel3.setText("Precio*:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Restaurante*: ");

        Label_Img.setBackground(new java.awt.Color(45, 245, 245));
        Label_Img.setFont(new java.awt.Font("High Tower Text", 0, 24)); // NOI18N
        Label_Img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Img.setText("Seleccionar Imagen");
        Label_Img.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Label_Img.setMaximumSize(new java.awt.Dimension(190, 190));
        Label_Img.setMinimumSize(new java.awt.Dimension(190, 190));
        Label_Img.setPreferredSize(new java.awt.Dimension(190, 190));
        Label_Img.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_ImgMouseClicked(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Filtrar Restaurante: ");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Seleccionar");

        Button_Aceptar.setText("Aceptar");
        Button_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_AceptarActionPerformed(evt);
            }
        });

        Button_Cancelar.setText("Cancelar");
        Button_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(51, 51, 51))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(26, 26, 26)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(40, 40, 40)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Text_Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Text_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Button_Aceptar)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Text_Filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Label_Img, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_Cancelar))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Text_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Text_Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Text_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Text_Filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Label_Img, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Aceptar)
                    .addComponent(Button_Cancelar))
                .addGap(28, 28, 28))
        );

        Text_Nombre.requestFocus();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Text_FiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_FiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_FiltroActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        ventanaPrincipal.setOperando(false);
        this.dispose();
    }//GEN-LAST:event_formInternalFrameClosing

    private void Button_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_CancelarActionPerformed
        ventanaPrincipal.setOperando(false);
        this.dispose();
    }//GEN-LAST:event_Button_CancelarActionPerformed

    private void Button_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_AceptarActionPerformed
        try {
            ventanaPrincipal.CU.getCP().insertarIndividual(Text_Nombre.getText(), Text_Descripcion.getText(), Text_Precio.getText(), foto, (String) jList2.getSelectedValue());
            JOptionPane.showMessageDialog(null, "Producto Ingresado", "Exito!", JOptionPane.DEFAULT_OPTION);
            ventanaPrincipal.setOperando(false);
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(RegistroIndividual.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Button_AceptarActionPerformed

    private void Label_ImgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_ImgMouseClicked
        int option = jFileChooser1.showOpenDialog(this);
        if (APPROVE_OPTION == option) {
            foto = jFileChooser1.getSelectedFile();
            Label_Img.setText("");
            Label_Img.setIcon(HerramientaImagenes.cargarYescalar(foto.getPath(), 190, 190));
        }
    }//GEN-LAST:event_Label_ImgMouseClicked

    private void Text_FiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Text_FiltroKeyTyped

    }//GEN-LAST:event_Text_FiltroKeyTyped

    private void Text_FiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Text_FiltroKeyReleased
        HashMap OBJs = ventanaPrincipal.CU.filtrarRestaurantes(Text_Filtro.getText());
        Iterator it = OBJs.entrySet().iterator();
        DefaultListModel model = new DefaultListModel();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            DataRestaurante R = ((DataRestaurante) entry.getValue());
            model.addElement(R.getNickname() + " - " + R.getNombre());
        }
        jList2.setModel(model);
    }//GEN-LAST:event_Text_FiltroKeyReleased

    private void Text_PrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Text_PrecioKeyTyped
        char car = evt.getKeyChar();
        String desc = Text_Precio.getText();
        if (Character.isDigit(car) || Character.compare(car, '.') == 0) {
            if (desc.contains(".") && Character.compare(car, '.') == 0) {
                evt.consume();
            }
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_Text_PrecioKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Aceptar;
    private javax.swing.JButton Button_Cancelar;
    private javax.swing.JLabel Label_Img;
    private javax.swing.JTextField Text_Descripcion;
    private javax.swing.JTextField Text_Filtro;
    private javax.swing.JTextField Text_Nombre;
    private javax.swing.JTextField Text_Precio;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList jList2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
