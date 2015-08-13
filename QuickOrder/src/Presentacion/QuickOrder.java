package Presentacion;

import Logica.ControladorProductos;
import Logica.ControladorUsuario;
import java.awt.BorderLayout;
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
    ControladorProductos CP;
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
        this.CP = new ControladorProductos(CU);
        initComponents();
        setResizable(false);
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
        jMenu1 = new javax.swing.JMenu();
        Registros = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        Menu_RCliente = new javax.swing.JMenuItem();
        Menu_RRestaurante = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        Menu_RIndividual = new javax.swing.JMenuItem();
        Menu_RPromocion = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quick Order");
        setMinimumSize(new java.awt.Dimension(1200, 700));

        jMenu1.setText("Inicio");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenu1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenu1KeyPressed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        Registros.setText("Registros");
        Registros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrosActionPerformed(evt);
            }
        });

        jMenu4.setText("Registrar Usuario");

        Menu_RCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        Menu_RCliente.setText("Registrar Cliente");
        Menu_RCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_RClienteActionPerformed(evt);
            }
        });
        jMenu4.add(Menu_RCliente);

        Menu_RRestaurante.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        Menu_RRestaurante.setText("Registrar Restaurante");
        Menu_RRestaurante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_RRestauranteActionPerformed(evt);
            }
        });
        jMenu4.add(Menu_RRestaurante);

        Registros.add(jMenu4);

        jMenu5.setText("Registrar Producto");

        Menu_RIndividual.setText("Individual");
        Menu_RIndividual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_RIndividualActionPerformed(evt);
            }
        });
        jMenu5.add(Menu_RIndividual);

        Menu_RPromocion.setText("Promocion");
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

        jMenu3.setText("Información");
        jMenuBar1.add(jMenu3);

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
            try {
                registroRestaurante.setSelected(true);
                operando = true;
            } catch (PropertyVetoException ex) {
                Logger.getLogger(QuickOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_Menu_RRestauranteActionPerformed

    private void jMenu1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu1KeyPressed

    }//GEN-LAST:event_jMenu1KeyPressed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void Menu_RIndividualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_RIndividualActionPerformed
        if (!operando) {
            RegistroIndividual registroIndividual = new RegistroIndividual(this);
            this.add(registroIndividual, BorderLayout.CENTER);
            try {
                registroIndividual.setSelected(true);
                operando = true;
            } catch (PropertyVetoException ex) {
                Logger.getLogger(QuickOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_Menu_RIndividualActionPerformed

    private void RegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrosActionPerformed
        if (!operando) {
            GenerarPedido genPedido = new GenerarPedido(this);
            this.add(genPedido, BorderLayout.CENTER);
            try {
                genPedido.setSelected(true);
                operando = true;
            } catch (PropertyVetoException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "!ERROR¡", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(QuickOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_RegistrosActionPerformed

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
    private javax.swing.JMenuItem Menu_RCliente;
    private javax.swing.JMenuItem Menu_RIndividual;
    private javax.swing.JMenuItem Menu_RPromocion;
    private javax.swing.JMenuItem Menu_RRestaurante;
    private javax.swing.JMenu Registros;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    // End of variables declaration//GEN-END:variables
}
