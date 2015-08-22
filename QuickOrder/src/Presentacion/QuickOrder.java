package Presentacion;

import Logica.ControladorUsuario;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import javax.swing.UnsupportedLookAndFeelException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jean
 */
public class QuickOrder extends javax.swing.JFrame {

    private boolean operando = false;
    ControladorUsuario CU;
    /*
     codigo para ver si anda bien esto
     */

    public QuickOrder() throws SQLException, ClassNotFoundException {
        try {
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "!ERROR¡", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(QuickOrder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "!ERROR¡", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(QuickOrder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "!ERROR¡", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(QuickOrder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "!ERROR¡", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(QuickOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.CU = new ControladorUsuario();
        initComponents();
       // setContentPane(new FondoVentanaPrincipal("/img/back.png"));
        setLocationRelativeTo(null);

    }

    public void setOperando(boolean o) {
        operando = o;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        Registros = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        Menu_RCliente = new javax.swing.JMenuItem();
        Menu_RRestaurante = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        Menu_RIndividual = new javax.swing.JMenuItem();
        Menu_RPromocion = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        Infirmacion = new javax.swing.JMenu();
        Menu_Info_Rest = new javax.swing.JMenuItem();
        Menu_Info_Cliente = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quick Order");
        setBackground(new java.awt.Color(204, 255, 255));
        setMinimumSize(new java.awt.Dimension(1200, 700));

        Registros.setText("Registros");
        Registros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrosActionPerformed(evt);
            }
        });

        jMenu4.setText("Registrar Usuario");

        Menu_RCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        Menu_RCliente.setText("Cliente");
        Menu_RCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_RClienteActionPerformed(evt);
            }
        });
        jMenu4.add(Menu_RCliente);

        Menu_RRestaurante.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        Menu_RRestaurante.setText("Restaurante");
        Menu_RRestaurante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_RRestauranteActionPerformed(evt);
            }
        });
        jMenu4.add(Menu_RRestaurante);

        Registros.add(jMenu4);

        jMenu5.setText("Registrar Producto");

        Menu_RIndividual.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        Menu_RIndividual.setText("Individual");
        Menu_RIndividual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_RIndividualActionPerformed(evt);
            }
        });
        jMenu5.add(Menu_RIndividual);

        Menu_RPromocion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        Menu_RPromocion.setText("Promocion");
        Menu_RPromocion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_RPromocionActionPerformed(evt);
            }
        });
        jMenu5.add(Menu_RPromocion);

        Registros.add(jMenu5);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Generar Pedido");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        Registros.add(jMenuItem4);

        jMenuBar1.add(Registros);

        Infirmacion.setText("Información");

        Menu_Info_Rest.setText("Restaurantes");
        Menu_Info_Rest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_Info_RestActionPerformed(evt);
            }
        });
        Infirmacion.add(Menu_Info_Rest);

        Menu_Info_Cliente.setText("Clientes");
        Menu_Info_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_Info_ClienteActionPerformed(evt);
            }
        });
        Infirmacion.add(Menu_Info_Cliente);

        jMenuItem1.setText("Productos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Infirmacion.add(jMenuItem1);

        jMenuItem2.setText("Pedidos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        Infirmacion.add(jMenuItem2);

        jMenuBar1.add(Infirmacion);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 679, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Menu_RClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_RClienteActionPerformed
        if (!operando) {
            RegistroCliente registroCliente = new RegistroCliente(this);
            this.add(registroCliente, BorderLayout.CENTER);
            Dimension desktopSize = this.getContentPane().getSize();
            Dimension FrameSize = registroCliente.getSize();
            registroCliente.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            try {
                registroCliente.setSelected(true);
                operando = true;
            } catch (PropertyVetoException ex) {
                Logger.getLogger(QuickOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_Menu_RClienteActionPerformed

    private void Menu_RRestauranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_RRestauranteActionPerformed
        if (!operando) {
            RegistroRestaurante registroRestaurante = new RegistroRestaurante(this);
            this.add(registroRestaurante, BorderLayout.CENTER);
            Dimension desktopSize = this.getContentPane().getSize();
            Dimension FrameSize = registroRestaurante.getSize();
            registroRestaurante.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);

            try {
                registroRestaurante.setSelected(true);
                operando = true;
            } catch (PropertyVetoException ex) {
                Logger.getLogger(QuickOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_Menu_RRestauranteActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        if (!operando) {
            try {
                RegistroPedido registroPedido = new RegistroPedido(this);
                this.add(registroPedido, BorderLayout.CENTER);
                Dimension desktopSize = this.getContentPane().getSize();
                Dimension FrameSize = registroPedido.getSize();
                registroPedido.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
                registroPedido.setSelected(true);
                operando = true;
            } catch (PropertyVetoException ex) {
                Logger.getLogger(QuickOrder.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(QuickOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void Menu_RIndividualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_RIndividualActionPerformed
        if (!operando) {
            RegistroIndividual registroIndividual = null;
            try {
                registroIndividual = new RegistroIndividual(this);
                this.getContentPane().add(registroIndividual, BorderLayout.CENTER);
                registroIndividual.setSelected(true);
                Dimension desktopSize = this.getContentPane().getSize();
                Dimension FrameSize = registroIndividual.getSize();
                registroIndividual.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
                operando = true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "!ERROR¡", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(QuickOrder.class.getName()).log(Level.SEVERE, null, ex);
            } catch (PropertyVetoException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "!ERROR¡", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(QuickOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_Menu_RIndividualActionPerformed

    private void RegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrosActionPerformed
        if (!operando) {
            try {
                RegistroPedido RP = new RegistroPedido(this);
                this.add(RP, BorderLayout.CENTER);
                Dimension desktopSize = this.getContentPane().getSize();
                Dimension FrameSize = RP.getSize();
                RP.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
                RP.setSelected(true);
                operando = true;
            } catch (PropertyVetoException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "!ERROR¡", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(QuickOrder.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(QuickOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_RegistrosActionPerformed

    private void Menu_RPromocionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_RPromocionActionPerformed
        if (!operando) {
            RegistroPromocion registroPromocion = new RegistroPromocion(this);
            this.add(registroPromocion, BorderLayout.CENTER);
            Dimension desktopSize = this.getContentPane().getSize();
            Dimension FrameSize = registroPromocion.getSize();
            registroPromocion.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);

            try {
                registroPromocion.setSelected(true);
                operando = true;
            } catch (PropertyVetoException ex) {
                Logger.getLogger(QuickOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_Menu_RPromocionActionPerformed

    private void Menu_Info_RestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_Info_RestActionPerformed
        if (!operando) {
            try {
                VerInfoRestaurantes vir = new VerInfoRestaurantes(this);
                this.add(vir, BorderLayout.CENTER);
                Dimension desktopSize = this.getContentPane().getSize();
                Dimension FrameSize = vir.getSize();
                vir.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
                vir.setSelected(true);
                operando = true;
            } catch (PropertyVetoException ex) {
                Logger.getLogger(QuickOrder.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(QuickOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_Menu_Info_RestActionPerformed

    private void Menu_Info_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_Info_ClienteActionPerformed
        if (!operando) {
            try {
                VerInfoClientes vic = new VerInfoClientes(this);
                this.add(vic, BorderLayout.CENTER);
                Dimension desktopSize = this.getContentPane().getSize();
                Dimension FrameSize = vic.getSize();
                vic.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
                vic.setSelected(true);
                operando = true;
            } catch (PropertyVetoException ex) {
                Logger.getLogger(QuickOrder.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(QuickOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_Menu_Info_ClienteActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (!operando) {
            try {
                VerInfoProducto vip = new VerInfoProducto(this);
                this.add(vip, BorderLayout.CENTER);
                Dimension desktopSize = this.getContentPane().getSize();
                Dimension FrameSize = vip.getSize();
                vip.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
                vip.setSelected(true);
                operando = true;
            } catch (PropertyVetoException ex) {
                Logger.getLogger(QuickOrder.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(QuickOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (!operando) {
            try {
                VerInfoPedido vip = new VerInfoPedido(this);
                this.add(vip, BorderLayout.CENTER);
                Dimension desktopSize = this.getContentPane().getSize();
                Dimension FrameSize = vip.getSize();
                vip.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
                vip.setSelected(true);
                operando = true;
            } catch (PropertyVetoException ex) {
                Logger.getLogger(QuickOrder.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(QuickOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuickOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuickOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuickOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuickOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new QuickOrder().setVisible(true);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "!ERROR¡", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(QuickOrder.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "!ERROR¡", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(QuickOrder.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Infirmacion;
    private javax.swing.JMenuItem Menu_Info_Cliente;
    private javax.swing.JMenuItem Menu_Info_Rest;
    private javax.swing.JMenuItem Menu_RCliente;
    private javax.swing.JMenuItem Menu_RIndividual;
    private javax.swing.JMenuItem Menu_RPromocion;
    private javax.swing.JMenuItem Menu_RRestaurante;
    private javax.swing.JMenu Registros;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    // End of variables declaration//GEN-END:variables
}
