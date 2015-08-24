/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.ControladorUsuario;
import Logica.DataTypes.DataCliente;
import Logica.DataTypes.DataIndividual;
import Logica.DataTypes.DataPedido;
import Logica.DataTypes.DataProdPedido;
import Logica.DataTypes.DataProdPromo;
import Logica.DataTypes.DataProducto;
import Logica.DataTypes.DataPromocion;
import Logica.HerramientaImagenes;
import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jean
 */
public class PanelInfoProducto extends javax.swing.JPanel {

    /**
     * Creates new form PanelInfoCliente
     */
    DefaultTableModel modeloTablaProductos;
    DefaultTableModel modeloTablaPedidos;
    ControladorUsuario CU;
    String restaurante;

    public PanelInfoProducto(VerInfoProducto vip) {
        initComponents();
        modeloTablaProductos = (DefaultTableModel) TablaIndividuales.getModel();
        modeloTablaPedidos = (DefaultTableModel) TablaPedidos.getModel();
        TablaIndividuales.setModel(modeloTablaProductos);
        TablaPedidos.setModel(modeloTablaPedidos);
        limpiarTablaProductos();
        limpiarTablaPedidos();
        panelEnBlanco();
    }

    public void setCU(ControladorUsuario CU) {
        this.CU = CU;
    }

    public void panelEnBlanco() {
        for (Component child : ((Container) this).getComponents()) {
            child.setVisible(false);
        }
    }

    public void panelComun() {
        for (Component child : ((Container) this).getComponents()) {
            child.setVisible(true);
        }
    }

    public void cargarInfo(DataProducto DP, HashMap DPed) throws IOException, SQLException {
        if (DP == null) {
            panelEnBlanco();
            return;
        } else {
            panelComun();
        }

        Label_Nombre.setText(DP.getNombre());
        Label_Descripcion.setText(DP.getDescripcion());
        Label_IMG.setText("");
        String precio = String.valueOf(DP.getPrecio());
        Label_Precio.setText(precio);
        Label_IMG.setIcon(HerramientaImagenes.cargarYescalar(DP.getImagen(), 125, 125));
        restaurante = DP.getRestaurante();
        limpiarTablaPedidos();
        cargarTablaPedidos(DPed);
        if (DP instanceof DataIndividual) {
            Label_Tipo.setText("Producto Individual");
            jLabel3.setVisible(false);
            jLabel4.setVisible(false);
            Label_Activa.setVisible(false);
            jScrollPane1.setVisible(false);
            limpiarTablaProductos();
        } else {
            Label_Tipo.setText("Producto Promocional");
            DataPromocion DPr = (DataPromocion) DP;
            if (DPr.isActivo()) {
                Label_Activa.setText("SI");
            } else {
                Label_Activa.setText("NO");
            }
            jLabel3.setVisible(true);
            jLabel4.setVisible(true);
            Label_Activa.setVisible(true);
            jScrollPane1.setVisible(true);
            limpiarTablaProductos();
            cargarTablaProductos(DPr.getDataProdPromo());
        }
    }

    public void cargarTablaProductos(HashMap dataSubProductos) {
        Iterator it = dataSubProductos.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            DataProdPromo DP = (DataProdPromo) entry.getValue();
            modeloTablaProductos.addRow(new Object[]{DP.getIndividual().getNombre(), DP.getCantidad()});
        }
    }

    public void cargarTablaPedidos(HashMap dataPedidos) {
        Iterator it = dataPedidos.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            DataPedido DP = (DataPedido) entry.getValue();
            modeloTablaPedidos.addRow(new Object[]{DP.getCliente(), DP.getFecha(), DP.getPrecio()});
        }
    }

    private void limpiarTablaProductos() {
        modeloTablaProductos = (DefaultTableModel) TablaIndividuales.getModel();
        while (modeloTablaProductos.getRowCount() > 0) {
            modeloTablaProductos.removeRow(0);
        }
    }

    private void limpiarTablaPedidos() {
        modeloTablaPedidos = (DefaultTableModel) TablaPedidos.getModel();
        while (modeloTablaPedidos.getRowCount() > 0) {
            modeloTablaPedidos.removeRow(0);
        }
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Label_IMG = new javax.swing.JLabel();
        Label_Nombre = new javax.swing.JLabel();
        Label_Tipo = new javax.swing.JLabel();
        Label_Descripcion = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaIndividuales = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        Label_Activa = new javax.swing.JLabel();
        Label_Precio = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaPedidos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(450, 418));
        setMinimumSize(new java.awt.Dimension(450, 418));

        jLabel1.setText("Tipo:");

        jLabel2.setText("Descripcion:");

        jLabel3.setText("SubProductos:");

        Label_IMG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_IMG.setText("SIN IMAGEN");
        Label_IMG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Label_IMG.setMaximumSize(new java.awt.Dimension(130, 130));
        Label_IMG.setMinimumSize(new java.awt.Dimension(130, 130));
        Label_IMG.setPreferredSize(new java.awt.Dimension(130, 130));

        Label_Nombre.setFont(new java.awt.Font("Cambria Math", 0, 24)); // NOI18N
        Label_Nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Nombre.setText("Nombre Producto");

        Label_Tipo.setText("   ");

        Label_Descripcion.setEditable(false);
        Label_Descripcion.setBackground(new java.awt.Color(240, 240, 240));
        Label_Descripcion.setColumns(20);
        Label_Descripcion.setRows(5);
        Label_Descripcion.setMaximumSize(new java.awt.Dimension(230, 39));
        Label_Descripcion.setMinimumSize(new java.awt.Dimension(230, 39));
        Label_Descripcion.setPreferredSize(new java.awt.Dimension(230, 39));
        Label_Descripcion.setSelectedTextColor(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        Label_Descripcion.setSelectionColor(java.awt.Color.lightGray);

        TablaIndividuales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaIndividuales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaIndividualesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaIndividuales);
        if (TablaIndividuales.getColumnModel().getColumnCount() > 0) {
            TablaIndividuales.getColumnModel().getColumn(0).setResizable(false);
            TablaIndividuales.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel4.setText("Activa: ");

        Label_Activa.setText(" ");

        Label_Precio.setText(" ");

        jLabel5.setText("Precio: ");

        TablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Cliente", "Fecha", "Monto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaPedidosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TablaPedidos);
        if (TablaPedidos.getColumnModel().getColumnCount() > 0) {
            TablaPedidos.getColumnModel().getColumn(0).setResizable(false);
            TablaPedidos.getColumnModel().getColumn(1).setResizable(false);
            TablaPedidos.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel6.setText("Pedidos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Label_Activa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Label_Precio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Label_Tipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Label_Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(Label_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Label_IMG, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(Label_IMG, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Label_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Label_Tipo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Label_Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(Label_Precio))
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Label_Activa))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TablaIndividualesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaIndividualesMouseClicked

    }//GEN-LAST:event_TablaIndividualesMouseClicked

    private void TablaPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaPedidosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TablaPedidosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label_Activa;
    private javax.swing.JTextArea Label_Descripcion;
    private javax.swing.JLabel Label_IMG;
    private javax.swing.JLabel Label_Nombre;
    private javax.swing.JLabel Label_Precio;
    private javax.swing.JLabel Label_Tipo;
    private javax.swing.JTable TablaIndividuales;
    private javax.swing.JTable TablaPedidos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
