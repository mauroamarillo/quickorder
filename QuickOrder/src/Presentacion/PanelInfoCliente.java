/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jean
 */
public class PanelInfoCliente extends javax.swing.JPanel implements Runnable {

    /**
     * Creates new form PanelInfoCliente
     */
    DefaultTableModel modeloTabla;
    List<Object> dataPedidos;
    private Thread thread;
    private String path;
    webservices.WSQuickOrder port;

    public PanelInfoCliente() {
        webservices.WSQuickOrder_Service service = new webservices.WSQuickOrder_Service();
        port = service.getWSQuickOrderPort();
        initComponents();
        modeloTabla = (DefaultTableModel) TablaPedidos.getModel();
        TablaPedidos.setModel(modeloTabla);
        limpiarTabla();
    }

    public void cargarInfo(webservices.DataCliente DC) throws IOException {
        Label_Nick.setText(DC.getNickname());
        Label_Apellido.setText(DC.getApellido());
        Label_Nombre.setText(DC.getNombre());
        Label_Email.setText(DC.getEmail());
        Label_Direccion.setText(DC.getDireccion());
        Label_FN.setText(DC.getFechaNac().toString());
        Label_IMG.setText("Cargando...");
        path = DC.getImagen();
        thread = new Thread(this, "cargar_img");
        thread.start();
        dataPedidos = port.clienteGetPedidos(DC.getNickname());
        limpiarTabla();
        cargarTablaPedidos();
    }

    public void cargarTablaPedidos() {
        Iterator it = dataPedidos.iterator();
        while (it.hasNext()) {
            webservices.DataPedido DP = (webservices.DataPedido) it.next();
            modeloTabla.addRow(new Object[]{DP.getRestaurante(), DP.getFecha().toString()});
        }
    }

    private void limpiarTabla() {
        modeloTabla = (DefaultTableModel) TablaPedidos.getModel();
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Label_IMG = new javax.swing.JLabel();
        Label_Nick = new javax.swing.JLabel();
        Label_Nombre = new javax.swing.JLabel();
        Label_Apellido = new javax.swing.JLabel();
        Label_Direccion = new javax.swing.JLabel();
        Label_Email = new javax.swing.JLabel();
        Label_FN = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPedidos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(450, 418));
        setMinimumSize(new java.awt.Dimension(450, 418));

        jLabel1.setText("Nombre:");

        jLabel2.setText("Apellido:");

        jLabel3.setText("Direccion:");

        jLabel4.setText("F. Nacimiento:");

        jLabel5.setText("Email:");

        Label_IMG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_IMG.setText("SIN IMAGEN");
        Label_IMG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Label_Nick.setFont(new java.awt.Font("Cambria Math", 0, 24)); // NOI18N
        Label_Nick.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Nick.setText("Nickname Cliente");

        Label_Nombre.setText("   ");

        Label_Apellido.setText("  ");

        Label_Direccion.setText("  ");

        Label_Email.setText("  ");

        Label_FN.setText("  ");

        TablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Restaurante", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaPedidos);
        if (TablaPedidos.getColumnModel().getColumnCount() > 0) {
            TablaPedidos.getColumnModel().getColumn(0).setResizable(false);
            TablaPedidos.getColumnModel().getColumn(1).setResizable(false);
            TablaPedidos.getColumnModel().getColumn(1).setPreferredWidth(10);
        }

        jLabel6.setText("Pedidos:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Label_Nick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(34, 34, 34)
                                .addComponent(Label_Nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Label_FN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(47, 47, 47)
                                .addComponent(Label_Email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(28, 28, 28)
                                .addComponent(Label_Direccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(34, 34, 34)
                                .addComponent(Label_Apellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Label_IMG, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Label_IMG, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Label_Nick, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Label_Nombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Label_Apellido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Label_Direccion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(Label_Email))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Label_FN))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label_Apellido;
    private javax.swing.JLabel Label_Direccion;
    private javax.swing.JLabel Label_Email;
    private javax.swing.JLabel Label_FN;
    private javax.swing.JLabel Label_IMG;
    private javax.swing.JLabel Label_Nick;
    private javax.swing.JLabel Label_Nombre;
    private javax.swing.JTable TablaPedidos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        Label_IMG.setIcon(null);
        Label_IMG.setIcon(HerramientaImagenes.cargarYescalar(path, 125, 125));
        Label_IMG.setText("");
    }
}
