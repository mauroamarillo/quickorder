/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.DataTypes.DataProducto;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Jean
 */
public class VerInfoProducto extends javax.swing.JInternalFrame {

    QuickOrder ventanaPrincipal;
    private PanelInfoProducto panelInfoProducto1;

    public VerInfoProducto(QuickOrder vp) throws SQLException {
        this.ventanaPrincipal = vp;
        initComponents();
        cargarProductos(new String());
        panelInfoProducto1 = new PanelInfoProducto(this);
        PanelContenedor.add(panelInfoProducto1);
        this.setLocation(220, 80);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
    }

    private void cargarProductos(String filtro) throws SQLException {

        HashMap OBJs = new HashMap();

        OBJs.putAll(ventanaPrincipal.CU.getCP().getDataIndividuales());
        OBJs.putAll(ventanaPrincipal.CU.getCP().getDataPromociones());

        Iterator it = OBJs.entrySet().iterator();
        DefaultListModel model = new DefaultListModel();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            DataProducto DP = (DataProducto) entry.getValue();
            String elemento = DP.getRestaurante() + "_" + DP.getNombre();
            if (filtro.isEmpty()) {
                model.addElement(elemento);
            } else if (elemento.contains(filtro)) {
                model.addElement(elemento);
            }
        }
        ListaClientes.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ListaClientes = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        PanelContenedor = new javax.swing.JPanel();

        setClosable(true);
        setTitle("Informacion Productos");
        setMaximumSize(new java.awt.Dimension(700, 470));
        setMinimumSize(new java.awt.Dimension(700, 470));
        setPreferredSize(new java.awt.Dimension(700, 470));
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

        ListaClientes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        ListaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListaClientes);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Seleccione Producto ");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        PanelContenedor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PanelContenedor.setMaximumSize(new java.awt.Dimension(450, 418));
        PanelContenedor.setMinimumSize(new java.awt.Dimension(450, 418));
        PanelContenedor.setPreferredSize(new java.awt.Dimension(450, 418));
        PanelContenedor.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(PanelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PanelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        ventanaPrincipal.setOperando(false);
        this.dispose();
    }//GEN-LAST:event_formInternalFrameClosing

    private void ListaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListaClientesMouseClicked
        JList list = (JList) evt.getSource();
        if (evt.getClickCount() == 2) {
            String Restaurante_Producto = (String) list.getSelectedValue();
            try {
                DataProducto DP = ventanaPrincipal.CU.getCP().BuscarDataXRestaurante_Producto(Restaurante_Producto);
                panelInfoProducto1.cargarInfo(DP, ventanaPrincipal.CU.getDataPedidosProducto(DP.getRestaurante(), DP.getNombre()));
            } catch (IOException ex) {
                Logger.getLogger(VerInfoProducto.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(VerInfoProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ListaClientesMouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        try {
            cargarProductos(jTextField1.getText());
        } catch (SQLException ex) {
            Logger.getLogger(VerInfoClientes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTextField1KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList ListaClientes;
    private javax.swing.JPanel PanelContenedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
