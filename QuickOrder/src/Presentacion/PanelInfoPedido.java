package Presentacion;

import Logica.DataTypes.DataPedido;
import Logica.DataTypes.DataProdPedido;
import Logica.Estado;
import java.awt.Component;
import java.awt.Container;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PanelInfoPedido extends javax.swing.JPanel {

    DefaultTableModel modeloTabla;
    HashMap dataLineasProd;
    int pedido;
    VerInfoPedido VIP;

    public PanelInfoPedido(VerInfoPedido vip) {
        this.VIP = vip;
        initComponents();
        modeloTabla = (DefaultTableModel) TablaProd.getModel();
        TablaProd.setModel(modeloTabla);
        limpiarTabla();
        dataLineasProd = new HashMap();
        ocultarTodo();
    }

    public PanelInfoPedido(DataPedido DC) throws IOException {
        initComponents();
        modeloTabla = (DefaultTableModel) TablaProd.getModel();
        TablaProd.setModel(modeloTabla);
        limpiarTabla();
        dataLineasProd = new HashMap();
        cargarInfo(DC);
        ComboEstado.setEnabled(false);
        jButton1.setVisible(false);
        jButton2.setVisible(false);
    }

    public void ocultarTodo() {
        for (Component child : ((Container) this).getComponents()) {
            child.setVisible(false);
        }
    }

    public void verTodo() {
        for (Component child : ((Container) this).getComponents()) {
            child.setVisible(true);
        }
    }

    public void cargarInfo(DataPedido DC) throws IOException {
        pedido = DC.getNumero();
        Label_Cliente.setText(DC.getCliente());
        Label_Numero.setText("Pedido N°: " + String.valueOf(DC.getNumero()));
        Label_Costo.setText("$ " + String.valueOf(DC.getPrecio()));
        Label_Fecha.setText(DC.getFecha().toString());
        Label_Restaurante.setText(DC.getRestaurante());
        dataLineasProd = DC.getProdPedidos();
        ComboEstado.setSelectedItem(DC.getEstado());
        verTodo();
        if (DC.getEstado().equals(Estado.enviado) || DC.getEstado().equals(Estado.recibido)) {
            jButton1.setVisible(false);
        }
        limpiarTabla();
        cargarTablaPedidos();
    }

    public void cargarTablaPedidos() {
        Iterator it = dataLineasProd.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            DataProdPedido DP = (DataProdPedido) entry.getValue();
            modeloTabla.addRow(new Object[]{DP.getProducto().getNombre(), DP.getProducto().getPrecio(), DP.getCantidad(), (DP.getProducto().getPrecio() * DP.getCantidad())});
        }
    }

    private void limpiarTabla() {
        modeloTabla = (DefaultTableModel) TablaProd.getModel();
        while (modeloTabla.getRowCount() > 0) {
            modeloTabla.removeRow(0);
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Label_Numero = new javax.swing.JLabel();
        Label_Cliente = new javax.swing.JLabel();
        Label_Restaurante = new javax.swing.JLabel();
        Label_Fecha = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProd = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        ComboEstado = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        Label_Costo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(445, 304));
        setMinimumSize(new java.awt.Dimension(445, 304));
        setPreferredSize(new java.awt.Dimension(445, 304));

        jLabel2.setText("Cliente: ");

        jLabel3.setText("Resturante:");

        jLabel5.setText("Fecha");

        Label_Numero.setText("Pedido N°: X");

        Label_Cliente.setText("  ");

        Label_Restaurante.setText("  ");

        Label_Fecha.setText("  ");

        TablaProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Producto", "Costo", "Cantidad", "SubTotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaProd);
        if (TablaProd.getColumnModel().getColumnCount() > 0) {
            TablaProd.getColumnModel().getColumn(0).setResizable(false);
            TablaProd.getColumnModel().getColumn(1).setResizable(false);
            TablaProd.getColumnModel().getColumn(1).setPreferredWidth(10);
            TablaProd.getColumnModel().getColumn(2).setResizable(false);
            TablaProd.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel6.setText("Pedidos:");

        ComboEstado.setModel(new javax.swing.DefaultComboBoxModel(Estado.values() ));
        ComboEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboEstadoActionPerformed(evt);
            }
        });

        jButton1.setText("Cancelar Pedido");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Label_Costo.setText("  ");

        jLabel7.setText("Costo Total:");

        jButton2.setText("Cambiar Estado");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(34, 34, 34)
                                            .addComponent(Label_Cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel7)
                                                .addComponent(jLabel5))
                                            .addGap(16, 16, 16)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(Label_Fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(Label_Restaurante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(Label_Costo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addGap(34, 34, 34))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Label_Numero, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(238, 238, 238)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(ComboEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_Numero)
                    .addComponent(ComboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Label_Cliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Label_Restaurante)))
                    .addComponent(jButton2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(Label_Costo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(Label_Fecha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Seguro quiere de cancelar pedido? ", "Confirmar Cancelacion", dialogButton);
        if (dialogResult == 0) {
            try {
                this.VIP.ventanaPrincipal.CU.cancelarPedido(pedido);
                this.VIP.cargarPedidos(new String());
                ocultarTodo();
                JOptionPane.showMessageDialog(this, "Pedido Cancelado", "- EXITO -", JOptionPane.DEFAULT_OPTION);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "¡ERROR!", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(PanelInfoPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ComboEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboEstadoActionPerformed
        
    }//GEN-LAST:event_ComboEstadoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            this.VIP.ventanaPrincipal.CU.cambiarEstadoPedido(pedido, ((Estado) ComboEstado.getSelectedItem()).ordinal());
            JOptionPane.showMessageDialog(this, "Estado de Pedido Alterado \nPara ver cambios recargar panel", "- EXITO -", JOptionPane.DEFAULT_OPTION);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "¡ERROR!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(PanelInfoPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboEstado;
    private javax.swing.JLabel Label_Cliente;
    private javax.swing.JLabel Label_Costo;
    private javax.swing.JLabel Label_Fecha;
    private javax.swing.JLabel Label_Numero;
    private javax.swing.JLabel Label_Restaurante;
    private javax.swing.JTable TablaProd;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}