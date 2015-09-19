/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.DataTypes.DataCliente;
import Logica.DataTypes.DataProdPedido;
import Logica.DataTypes.DataProducto;
import Logica.DataTypes.DataPromocion;
import Logica.DataTypes.DataRestaurante;
import Logica.Estado;
import java.awt.Frame;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;

/**
 *
 * @author Jean
 */
public class RegistroPedido extends javax.swing.JInternalFrame {

    QuickOrder ventanaPrincipal;
    PanelProductos PP;

    /*nodos Para el arbol*/
    DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Categorias");
    DefaultMutableTreeNode nodoCategoria;
    DefaultMutableTreeNode nodoRestaurante;
    /*categorias para el arbol*/
    HashMap Categorias;
    /*modelo para la tabla*/
    DefaultTableModel modeloTabla;
    /*Lista de los productos con los DataProdPedido*/
    HashMap LineasPedido;
    String restaurante;

    public RegistroPedido(QuickOrder vp) throws SQLException, ClassNotFoundException {
        this.ventanaPrincipal = vp;
        initComponents();
        modeloTabla = new DefaultTableModel();
        this.Categorias = ventanaPrincipal.CU.getCategorias();  // guardo una lista de STRINGs con las categorias del sistema
        ScrollProductos.setViewportView(new JPanel());          // al scroll de productos lo dejo con un panel en blanco
        LineasPedido = new HashMap();                           // inicio las lineas de pedido 
        cargarArbol();              // lleno el arbol
        cargarClientes();           // cargo los clientes
        limpiarTabla();             // dejo la tabla sin registros
        ArbolRestaurantes.setEnabled(false);        // el arbol no esta activo hasta que se elige un cliente
        TablaSubProductos.setModel(modeloTabla);    //seteo el modelo de la tabla
        this.setLocation(200, 50);
        this.show();
    }

    private void cargarArbol() {
        /*Guardo las categorias en la lista de categorias*/
        Iterator it = Categorias.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String nombreCategoria = (String) entry.getValue();
            nodoCategoria = new DefaultMutableTreeNode(nombreCategoria);    // creo un nodo con el nombreCategoria
            HashMap rest = ventanaPrincipal.CU.consultarRestaurantesPorCategoria(nombreCategoria);  // Obtengo los una lista de DATATYPEs de restaurantes 
            Iterator it2 = rest.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry entry2 = (Map.Entry) it2.next();
                DataRestaurante R = (DataRestaurante) entry2.getValue();
                nodoRestaurante = new DefaultMutableTreeNode(R);        // creo un nodo por cada datatype obtenido
                nodoRestaurante.setAllowsChildren(false);               // estos nodos no pueden tener nodos anidados, esto lo uso despues para saber cual nodo es de un restaurante y cual no
                nodoCategoria.add(nodoRestaurante);                     // agrego cada nodo restaurante al nodo de la categoria que encontre
            }
            raiz.add(nodoCategoria);                                    // agrego cada categoria al nodo raiz
        }
        DefaultTreeModel modelo = new DefaultTreeModel(raiz);           // creo un modelo para el arbol y le asigno el nodo raiz con todos sus hijos
        this.ArbolRestaurantes.setModel(modelo);                        // seteo al modelo al arbol
        TreeCellRenderer renderer = new RestaurantesCellRenderer();     // creo un TreeCellRenderer del tipo arbol (ver clase: RestaurantesCellRenderer)
        ArbolRestaurantes.setCellRenderer(renderer);                    // asigno el RestaurantesCellRenderer
    }

    private void cargarClientes() throws SQLException, ClassNotFoundException {
        DefaultListModel model = new DefaultListModel();
        HashMap clientes = ventanaPrincipal.CU.getDataClientes();

        Iterator it = clientes.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            DataCliente C = ((DataCliente) entry.getValue());
            model.addElement(C.getNickname());
        }
        ListaClientes.setModel(model);
    }

    public void agregarProductoTabla(DataProducto DP, int c) {
        LineasPedido.put(DP.getNombre(), new DataProdPedido(c, DP));
        String tipo = "Individual";
        if (DP instanceof DataPromocion) {
            tipo = "Promocion";
        }
        modeloTabla.addRow(new Object[]{DP.getNombre(), DP.getDescripcion(), tipo, DP.getPrecio(), c, (DP.getPrecio() * c)});
    }

    private void borrarLineaProducto() {
        int selectedRow = TablaSubProductos.getSelectedRow();
        if (selectedRow > -1) {
            DefaultTableModel tm = (DefaultTableModel) TablaSubProductos.getModel();
            String nom = String.valueOf(tm.getValueAt(TablaSubProductos.getSelectedRow(), 0));
            DataProdPedido DP = (DataProdPedido) LineasPedido.get(nom);
            PP.reagregarProducto(DP.getProducto());
            LineasPedido.remove(nom);
            modeloTabla.removeRow(selectedRow);
        }
    }

    private void limpiarTabla() {
        modeloTabla = (DefaultTableModel) TablaSubProductos.getModel();
        while (modeloTabla.getRowCount() > 0) {
            modeloTabla.removeRow(0);
        }
        LineasPedido.clear();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuTabla = new javax.swing.JPopupMenu();
        MenuTablaEliminar = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        ScrollClientes = new javax.swing.JScrollPane();
        ListaClientes = new javax.swing.JList();
        ScrollRestaurantes = new javax.swing.JScrollPane();
        ArbolRestaurantes = new javax.swing.JTree();
        ScrollProductos = new javax.swing.JScrollPane();
        ScrollTabla = new javax.swing.JScrollPane();
        TablaSubProductos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ButtonAceptar = new javax.swing.JButton();

        MenuTablaEliminar.setText("Quitar Linea");
        MenuTablaEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuTablaEliminarActionPerformed(evt);
            }
        });
        MenuTabla.add(MenuTablaEliminar);

        setClosable(true);
        setTitle("Registro Pedido");
        setMaximumSize(new java.awt.Dimension(860, 425));
        setMinimumSize(new java.awt.Dimension(860, 425));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(860, 425));
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

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Seleccione Cliente");
        jLabel1.setToolTipText("");

        ScrollClientes.setMaximumSize(new java.awt.Dimension(192, 163));
        ScrollClientes.setMinimumSize(new java.awt.Dimension(192, 163));
        ScrollClientes.setPreferredSize(new java.awt.Dimension(192, 163));

        ListaClientes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        ListaClientes.setMinimumSize(new java.awt.Dimension(192, 163));
        ListaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListaClientesMouseClicked(evt);
            }
        });
        ListaClientes.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListaClientesValueChanged(evt);
            }
        });
        ScrollClientes.setViewportView(ListaClientes);

        ScrollRestaurantes.setMaximumSize(new java.awt.Dimension(151, 163));
        ScrollRestaurantes.setMinimumSize(new java.awt.Dimension(151, 163));
        ScrollRestaurantes.setPreferredSize(new java.awt.Dimension(151, 163));

        ArbolRestaurantes.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                ArbolRestaurantesValueChanged(evt);
            }
        });
        ScrollRestaurantes.setViewportView(ArbolRestaurantes);

        ScrollProductos.setMaximumSize(new java.awt.Dimension(476, 163));
        ScrollProductos.setMinimumSize(new java.awt.Dimension(476, 163));
        ScrollProductos.setPreferredSize(new java.awt.Dimension(476, 163));

        TablaSubProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Descripcion", "Tipo", "Precio", "Cantidad", "Precio Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaSubProductos.setComponentPopupMenu(MenuTabla);
        TablaSubProductos.getTableHeader().setReorderingAllowed(false);
        ScrollTabla.setViewportView(TablaSubProductos);
        if (TablaSubProductos.getColumnModel().getColumnCount() > 0) {
            TablaSubProductos.getColumnModel().getColumn(0).setResizable(false);
            TablaSubProductos.getColumnModel().getColumn(0).setPreferredWidth(100);
            TablaSubProductos.getColumnModel().getColumn(1).setResizable(false);
            TablaSubProductos.getColumnModel().getColumn(1).setPreferredWidth(200);
            TablaSubProductos.getColumnModel().getColumn(2).setResizable(false);
            TablaSubProductos.getColumnModel().getColumn(2).setPreferredWidth(5);
            TablaSubProductos.getColumnModel().getColumn(3).setResizable(false);
            TablaSubProductos.getColumnModel().getColumn(3).setPreferredWidth(5);
            TablaSubProductos.getColumnModel().getColumn(4).setResizable(false);
            TablaSubProductos.getColumnModel().getColumn(4).setPreferredWidth(5);
            TablaSubProductos.getColumnModel().getColumn(5).setResizable(false);
            TablaSubProductos.getColumnModel().getColumn(5).setPreferredWidth(5);
        }

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Seleccione Restaurante");
        jLabel2.setToolTipText("");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Seleccione Productos");
        jLabel3.setToolTipText("");

        ButtonAceptar.setText("Aceptar");
        ButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollTabla)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ScrollClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ScrollRestaurantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ScrollProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ButtonAceptar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ScrollClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ScrollRestaurantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ScrollProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonAceptar)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        ventanaPrincipal.setOperando(false);
        this.dispose();
    }//GEN-LAST:event_formInternalFrameClosing

    private void ListaClientesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListaClientesValueChanged
        ArbolRestaurantes.setEnabled(true);
    }//GEN-LAST:event_ListaClientesValueChanged

    private void ArbolRestaurantesValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_ArbolRestaurantesValueChanged
        if (evt.getNewLeadSelectionPath() == null) {
            return;
        }
        DefaultMutableTreeNode x = (DefaultMutableTreeNode) evt.getNewLeadSelectionPath().getLastPathComponent();
        if (x.getAllowsChildren() == false) {
            DataRestaurante DR = (DataRestaurante) x.getUserObject();
            restaurante = DR.getNickname();
            PP = new PanelProductos(this);
            HashMap ListaDataProductos = new HashMap();
            ListaDataProductos.putAll(DR.getIndividuales());
            ListaDataProductos.putAll(DR.getPromociones());
            PP.iniciarPanel(ListaDataProductos);
            ScrollProductos.setViewportView(PP);
            limpiarTabla();
        }
    }//GEN-LAST:event_ArbolRestaurantesValueChanged

    private void ListaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListaClientesMouseClicked

    }//GEN-LAST:event_ListaClientesMouseClicked

    private void ButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAceptarActionPerformed
        try {
            String D, M, A;
            D = String.valueOf(Calendar.getInstance().get(Calendar.DATE));
            A = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
            M = getMes(Calendar.getInstance().get(Calendar.MONTH));
            int numero = ventanaPrincipal.CU.insertarPedido(D, M, A, Estado.preparacion, ListaClientes.getSelectedValue().toString(), restaurante, LineasPedido);
            //JOptionPane.showMessageDialog(this, "Pedido registrado", "- EXITO -", JOptionPane.DEFAULT_OPTION);
            PanelInfoPedido pip = new PanelInfoPedido(ventanaPrincipal.CU.getDataPedido(numero));
            JDialog JD = new JDialog(new Frame(), true);
            JD.setTitle("Datos del Pedido Resultante");
            JD.add(pip);
            JD.setLocationRelativeTo(this);
            JD.setResizable(false);
            JD.pack();
            JD.setVisible(true);
            ventanaPrincipal.setOperando(false);
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(RegistroPedido.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_ButtonAceptarActionPerformed
    private String getMes(int mesInt) throws Exception {
        String[] meses = {"enero", "febrero", "marzo", "abril", "mayo",
            "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
        for (int i = 0; i < meses.length; i++) {
            if (i == mesInt) {
                return meses[i];
            }
        }
        return "enero";
    }
    private void MenuTablaEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuTablaEliminarActionPerformed
        borrarLineaProducto();
    }//GEN-LAST:event_MenuTablaEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree ArbolRestaurantes;
    private javax.swing.JButton ButtonAceptar;
    private javax.swing.JList ListaClientes;
    private javax.swing.JPopupMenu MenuTabla;
    private javax.swing.JMenuItem MenuTablaEliminar;
    private javax.swing.JScrollPane ScrollClientes;
    private javax.swing.JScrollPane ScrollProductos;
    private javax.swing.JScrollPane ScrollRestaurantes;
    private javax.swing.JScrollPane ScrollTabla;
    private javax.swing.JTable TablaSubProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
