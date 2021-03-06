package Presentacion;

import java.awt.Dimension;
import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jean
 */
public class RegistroRestaurante extends javax.swing.JInternalFrame implements InternalFrameListener {

    /**
     * Creates new form NewJInternalFrame
     */
    QuickOrder ventanaPrincipal;
    private PanelCategorias PC = new PanelCategorias();
    private PanelImagenes PI = new PanelImagenes(this);
    File foto[] = null;
    int idCat[];

    public RegistroRestaurante(QuickOrder vp) throws ClassNotFoundException {

        ventanaPrincipal = vp;
        initComponents();

        disponerCategorias();

        Scroll_Categorias.setViewportView(PC);
        Scroll_Categorias.setPreferredSize(new Dimension(192, 233));
        Scroll_Imagenes.setViewportView(PI);
        Scroll_Imagenes.setPreferredSize(new Dimension(245, 233));
        this.setLocation(200, 50);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addInternalFrameListener(this);
        this.setVisible(true);
    }

    private void disponerCategorias() throws ClassNotFoundException {
        /*pido las categorias al ControladorUsuario*/
        HashMap categorias;
        try {
            categorias = ventanaPrincipal.CU.consultarCategorias();
            Iterator it = categorias.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                PC.AgregarCategoria(((int) entry.getKey()), ((String) entry.getValue()));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(RegistroRestaurante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public javax.swing.JTextField getTTT() {
        return Text_Nickname;
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
        Text_Nickname = new javax.swing.JTextField();
        Text_Nombre = new javax.swing.JTextField();
        Text_Email = new javax.swing.JTextField();
        Text_Direccion = new javax.swing.JTextField();
        Label_Nickname = new javax.swing.JLabel();
        Label_Nombre = new javax.swing.JLabel();
        Label_Email = new javax.swing.JLabel();
        Label_Direccion = new javax.swing.JLabel();
        Label_Titulo = new javax.swing.JLabel();
        Label_Imagenes = new javax.swing.JLabel();
        Label_Categorias = new javax.swing.JLabel();
        Button_Registrar = new javax.swing.JButton();
        Button_Cancelar = new javax.swing.JButton();
        Scroll_Categorias = new javax.swing.JScrollPane();
        Scroll_Imagenes = new javax.swing.JScrollPane();
        jButton1 = new javax.swing.JButton();
        Button_NCategoria = new javax.swing.JButton();
        Label_Nickname1 = new javax.swing.JLabel();
        Text_Pass = new javax.swing.JTextField();

        jFileChooser1.setCurrentDirectory(new java.io.File("C:\\Users\\Jean\\Pictures"));
        jFileChooser1.setFileFilter(new FileNameExtensionFilter("JPG Images", "jpg"));

        setClosable(true);
        setForeground(java.awt.Color.cyan);
        setTitle("Registro Restaurante");
        setMaximumSize(new java.awt.Dimension(600, 600));
        setMinimumSize(new java.awt.Dimension(600, 600));
        setNormalBounds(new java.awt.Rectangle(0, 0, 600, 0));
        setPreferredSize(new java.awt.Dimension(600, 600));

        Text_Nickname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_NicknameActionPerformed(evt);
            }
        });

        Text_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_NombreActionPerformed(evt);
            }
        });

        Text_Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_EmailActionPerformed(evt);
            }
        });

        Text_Direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_DireccionActionPerformed(evt);
            }
        });

        Label_Nickname.setText("Nickname*:");

        Label_Nombre.setText("Nombre*:");

        Label_Email.setText("Email*:");

        Label_Direccion.setText("Dirección*:");

        Label_Titulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Label_Titulo.setText("- Ingresar datos del restaurante -");
        Label_Titulo.setAutoscrolls(true);

        Label_Imagenes.setText("Imagenes: ");

        Label_Categorias.setText("Categorias* (al menos 1): ");

        Button_Registrar.setText("Registrar");
        Button_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_RegistrarActionPerformed(evt);
            }
        });

        Button_Cancelar.setText("Cancelar");
        Button_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_CancelarActionPerformed(evt);
            }
        });

        Scroll_Categorias.setMaximumSize(new java.awt.Dimension(192, 233));
        Scroll_Categorias.setMinimumSize(new java.awt.Dimension(192, 233));
        Scroll_Categorias.setPreferredSize(new java.awt.Dimension(192, 233));

        Scroll_Imagenes.setMaximumSize(new java.awt.Dimension(245, 233));
        Scroll_Imagenes.setMinimumSize(new java.awt.Dimension(245, 233));
        Scroll_Imagenes.setPreferredSize(new java.awt.Dimension(245, 233));

        jButton1.setText("Agregar Imagen");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Button_NCategoria.setText("Nueva categoria");
        Button_NCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_NCategoriaActionPerformed(evt);
            }
        });

        Label_Nickname1.setText("Contraseña*:");

        Text_Pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_PassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Label_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Button_Registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Button_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Label_Nickname)
                                        .addComponent(Label_Nombre)
                                        .addComponent(Label_Email)
                                        .addComponent(Label_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Label_Categorias)
                                        .addComponent(Scroll_Categorias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Button_NCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(Label_Nickname1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Text_Pass)
                                    .addComponent(Text_Nickname)
                                    .addComponent(Text_Nombre)
                                    .addComponent(Text_Email)
                                    .addComponent(Text_Direccion)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(Label_Imagenes)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton1))
                                            .addComponent(Scroll_Imagenes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(76, 76, 76))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(Label_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Text_Nickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Nickname))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Text_Pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Nickname1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Text_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Nombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_Email)
                    .addComponent(Text_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_Direccion)
                    .addComponent(Text_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_Categorias, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Imagenes, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Scroll_Imagenes, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Scroll_Categorias, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Button_NCategoria)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Registrar)
                    .addComponent(Button_Cancelar))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Text_NicknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_NicknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_NicknameActionPerformed

    private void Text_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_NombreActionPerformed

    private void Text_EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_EmailActionPerformed

    private void Text_DireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_DireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_DireccionActionPerformed

    private void Button_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_RegistrarActionPerformed
        idCat = PC.getCategorias();
        HashMap IMGs = PI.GuardarColeccion(Text_Nickname.getText());
        try {
            ventanaPrincipal.CU.insertarRestaurante(
                    Text_Nickname.getText(),
                    Text_Email.getText(),
                    Text_Direccion.getText(),
                    Text_Nombre.getText(),
                    IMGs,
                    idCat,
                    Text_Pass.getText());
            JOptionPane.showMessageDialog(this, "Restaurante registrado", "- EXITO -", JOptionPane.DEFAULT_OPTION);
            ventanaPrincipal.setOperando(false);
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(RegistroRestaurante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Button_RegistrarActionPerformed


    private void Button_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_CancelarActionPerformed
        ventanaPrincipal.setOperando(false);
        this.dispose();
    }//GEN-LAST:event_Button_CancelarActionPerformed
    private int cantImg = 0;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int option = jFileChooser1.showOpenDialog(this);
        if (APPROVE_OPTION == option) {
            cantImg++;
            String path = jFileChooser1.getSelectedFile().getPath();
            PI.AgregarImagen(cantImg, path);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Button_NCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_NCategoriaActionPerformed
        try {
            ventanaPrincipal.CU.insertarCategoria(JOptionPane.showInputDialog("Ingrese el nombre de la categoria:"));
            PC.reset();
            disponerCategorias();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(QuickOrder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistroRestaurante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Button_NCategoriaActionPerformed

    private void Text_PassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_PassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_PassActionPerformed

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
        ventanaPrincipal.setOperando(false);
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Cancelar;
    private javax.swing.JButton Button_NCategoria;
    private javax.swing.JButton Button_Registrar;
    private javax.swing.JLabel Label_Categorias;
    private javax.swing.JLabel Label_Direccion;
    private javax.swing.JLabel Label_Email;
    private javax.swing.JLabel Label_Imagenes;
    private javax.swing.JLabel Label_Nickname;
    private javax.swing.JLabel Label_Nickname1;
    private javax.swing.JLabel Label_Nombre;
    private javax.swing.JLabel Label_Titulo;
    private javax.swing.JScrollPane Scroll_Categorias;
    private javax.swing.JScrollPane Scroll_Imagenes;
    private javax.swing.JTextField Text_Direccion;
    private javax.swing.JTextField Text_Email;
    private javax.swing.JTextField Text_Nickname;
    private javax.swing.JTextField Text_Nombre;
    private javax.swing.JTextField Text_Pass;
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
