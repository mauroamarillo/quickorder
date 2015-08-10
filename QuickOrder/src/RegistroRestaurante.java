
import java.awt.Dimension;
import java.io.File;
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
    File foto[] = null;

    public RegistroRestaurante(QuickOrder vp) {

        ventanaPrincipal = vp;
        initComponents();

        disponerCategorias();
        Scroll_Categorias.setViewportView(PC);
        Scroll_Categorias.setPreferredSize(new Dimension(192, 233));

        this.setLocation(200, 50);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addInternalFrameListener(this);
        this.setVisible(true);
    }

    private void disponerCategorias() {
        /*aca en vez de un bucle con 20 numeros se recorren las categorias obtenidas de la base de datos
         La X seria para el ID de categoria y donde dice categoria va el nombre*/
        int x,y = 10;

        for (x = 0; x < y; x++) {
            PC.AgregarCategoria(x, "Categoria " + x);
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

        jFileChooser1.setFileFilter(new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif"));

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

        Label_Nickname.setText("Nickname:");

        Label_Nombre.setText("Nombre:");

        Label_Email.setText("Email:");

        Label_Direccion.setText("Dirección:");

        Label_Titulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Label_Titulo.setText("- Ingresar datos del restaurante -");
        Label_Titulo.setAutoscrolls(true);

        Label_Imagenes.setText("Imagenes: ");

        Label_Categorias.setText("Categorias: ");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Label_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 280, Short.MAX_VALUE))
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
                                    .addComponent(Label_Email)
                                    .addComponent(Label_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Label_Categorias)
                                    .addComponent(Scroll_Categorias, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Text_Nickname, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                    .addComponent(Text_Nombre)
                                    .addComponent(Text_Email)
                                    .addComponent(Text_Direccion)
                                    .addComponent(Scroll_Imagenes)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Label_Imagenes)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(76, 76, 76))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(Label_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Text_Nickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Nickname))
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
                    .addComponent(Label_Imagenes, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Scroll_Imagenes)
                    .addComponent(Scroll_Categorias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Registrar)
                    .addComponent(Button_Cancelar))
                .addGap(51, 51, 51))
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
        //registrar
        JOptionPane.showMessageDialog(this, "- ERROR -", "Error", JOptionPane.ERROR_MESSAGE);
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
    private javax.swing.JLabel Label_Categorias;
    private javax.swing.JLabel Label_Direccion;
    private javax.swing.JLabel Label_Email;
    private javax.swing.JLabel Label_Imagenes;
    private javax.swing.JLabel Label_Nickname;
    private javax.swing.JLabel Label_Nombre;
    private javax.swing.JLabel Label_Titulo;
    private javax.swing.JScrollPane Scroll_Categorias;
    private javax.swing.JScrollPane Scroll_Imagenes;
    private javax.swing.JTextField Text_Direccion;
    private javax.swing.JTextField Text_Email;
    private javax.swing.JTextField Text_Nickname;
    private javax.swing.JTextField Text_Nombre;
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
