package Presentacion;

import Logica.FileController;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
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
public class RegistroCliente extends javax.swing.JInternalFrame implements InternalFrameListener {

    /**
     * Creates new form NewJInternalFrame
     */
    QuickOrder ventanaPrincipal;
    File foto = null;

    public RegistroCliente(QuickOrder vp) {

        ventanaPrincipal = vp;
        initComponents();

        this.setLocation(200, 50);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addInternalFrameListener(this);
        this.setVisible(true);
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
        Text_Apellido = new javax.swing.JTextField();
        Text_Email = new javax.swing.JTextField();
        Text_Direccion = new javax.swing.JTextField();
        Label_Nickname = new javax.swing.JLabel();
        Label_Nombre = new javax.swing.JLabel();
        Label_Apellido = new javax.swing.JLabel();
        Label_Email = new javax.swing.JLabel();
        Label_Direccion = new javax.swing.JLabel();
        Spinner_D = new javax.swing.JSpinner();
        Spinner_M = new javax.swing.JSpinner();
        Spinner_A = new javax.swing.JSpinner();
        Label_Fecha = new javax.swing.JLabel();
        Label_Fecha_D = new javax.swing.JLabel();
        Label_Fecha_M = new javax.swing.JLabel();
        Label_Fecha_A = new javax.swing.JLabel();
        Label_resultadoImg = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Button_Registrar = new javax.swing.JButton();
        Button_Cancelar = new javax.swing.JButton();

        jFileChooser1.setFileFilter(new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif"));

        setClosable(true);
        setForeground(java.awt.Color.cyan);
        setTitle("Registro Cliente");
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

        Text_Apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_ApellidoActionPerformed(evt);
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

        Label_Nickname.setText("Nickname:");

        Label_Nombre.setText("Nombre:");

        Label_Apellido.setText("Apellido:");

        Label_Email.setText("Email:");

        Label_Direccion.setText("Dirección:");

        Spinner_D.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        Spinner_M.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        Spinner_A.setModel(new javax.swing.SpinnerNumberModel(1900, 1900, 2015, 1));

        Label_Fecha.setText("Fecha de Nacimiento:");

        Label_Fecha_D.setText("D");

        Label_Fecha_M.setText("M");

        Label_Fecha_A.setText("A");

        Label_resultadoImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/perfil.jpg"))); // NOI18N
        Label_resultadoImg.setName(""); // NOI18N
        Label_resultadoImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_resultadoImgMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("- Ingresar datos del cliente -");
        jLabel1.setAutoscrolls(true);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(Label_resultadoImg)
                        .addGap(100, 100, 100))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Button_Registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Button_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Label_Nickname)
                                    .addComponent(Label_Nombre)
                                    .addComponent(Label_Apellido)
                                    .addComponent(Label_Email)
                                    .addComponent(Label_Fecha)
                                    .addComponent(Label_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Spinner_D, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Label_Fecha_D, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Spinner_M, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Label_Fecha_M)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Spinner_A, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Label_Fecha_A))
                                    .addComponent(Text_Nickname)
                                    .addComponent(Text_Nombre)
                                    .addComponent(Text_Apellido)
                                    .addComponent(Text_Email)
                                    .addComponent(Text_Direccion))))
                        .addGap(76, 76, 76))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_resultadoImg)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Text_Nickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Nickname))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Text_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Nombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Text_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Apellido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_Email)
                    .addComponent(Text_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Text_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Direccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Spinner_D, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Spinner_M, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Spinner_A, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Fecha_D)
                    .addComponent(Label_Fecha_M)
                    .addComponent(Label_Fecha_A)
                    .addComponent(Label_Fecha))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Registrar)
                    .addComponent(Button_Cancelar))
                .addGap(168, 168, 168))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Text_NicknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_NicknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_NicknameActionPerformed

    private void Text_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_NombreActionPerformed

    private void Text_ApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_ApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_ApellidoActionPerformed

    private void Text_EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_EmailActionPerformed

    private void Text_DireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_DireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_DireccionActionPerformed

    private void Label_resultadoImgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_resultadoImgMouseClicked
        int option = jFileChooser1.showOpenDialog(this);
        if (APPROVE_OPTION == option) {
            foto = jFileChooser1.getSelectedFile();
            String fil = jFileChooser1.getSelectedFile().getPath();
            //ImageIcon icon = new ImageIcon(fil);
            Image img = new ImageIcon(fil).getImage();
            Image newImg;
            newImg = img.getScaledInstance(150, 150, java.awt.Image.SCALE_FAST);
            ImageIcon ico = new ImageIcon(newImg);
            Label_resultadoImg.setIcon(ico);
        }
    }//GEN-LAST:event_Label_resultadoImgMouseClicked

    private void Button_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_RegistrarActionPerformed
        //registrar
        /*No estoy seguro si esto va aca pero esta como para mostrar como usar la funcion copiarArchivo de la clase FileController */
        if (Text_Nickname.getText().compareTo("") != 0 && foto != null) {
            File directorio = new File("C:\\imagenes\\" + Text_Nickname.getText() + ".jpg");
            try {
                FileController.copiarArchivo(foto, directorio);
            } catch (IOException ex) {
                Logger.getLogger(RegistroCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "- no se culple la condicion -", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_Button_RegistrarActionPerformed


    private void Button_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_CancelarActionPerformed
        ventanaPrincipal.setOperando(false);
        this.dispose();
    }//GEN-LAST:event_Button_CancelarActionPerformed

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
        ventanaPrincipal.setOperando(false);
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Cancelar;
    private javax.swing.JButton Button_Registrar;
    private javax.swing.JLabel Label_Apellido;
    private javax.swing.JLabel Label_Direccion;
    private javax.swing.JLabel Label_Email;
    private javax.swing.JLabel Label_Fecha;
    private javax.swing.JLabel Label_Fecha_A;
    private javax.swing.JLabel Label_Fecha_D;
    private javax.swing.JLabel Label_Fecha_M;
    private javax.swing.JLabel Label_Nickname;
    private javax.swing.JLabel Label_Nombre;
    private javax.swing.JLabel Label_resultadoImg;
    private javax.swing.JSpinner Spinner_A;
    private javax.swing.JSpinner Spinner_D;
    private javax.swing.JSpinner Spinner_M;
    private javax.swing.JTextField Text_Apellido;
    private javax.swing.JTextField Text_Direccion;
    private javax.swing.JTextField Text_Email;
    private javax.swing.JTextField Text_Nickname;
    private javax.swing.JTextField Text_Nombre;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
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