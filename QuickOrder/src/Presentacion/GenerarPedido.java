/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

/**
 *
 * @author usuario
 */
public class GenerarPedido extends javax.swing.JInternalFrame {

    /**
     * Creates new form GenerarPedido
     */
    
    private QuickOrder ventanaPrincipal;
    
    public GenerarPedido() {
        initComponents();
    }
    
    public GenerarPedido(QuickOrder vp){
        this.ventanaPrincipal = vp;
        initComponents();
        
        this.setLocation(200,50);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
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

        TabbedPane_Pedido = new javax.swing.JTabbedPane();
        Panel_Cliente = new javax.swing.JPanel();
        Panel_Categoria = new javax.swing.JPanel();
        Panel_Restaurante = new javax.swing.JPanel();
        Panel_Productos = new javax.swing.JPanel();
        Panel_Confirmar = new javax.swing.JPanel();

        setClosable(true);
        setTitle("Generar Pedido");

        javax.swing.GroupLayout Panel_ClienteLayout = new javax.swing.GroupLayout(Panel_Cliente);
        Panel_Cliente.setLayout(Panel_ClienteLayout);
        Panel_ClienteLayout.setHorizontalGroup(
            Panel_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 622, Short.MAX_VALUE)
        );
        Panel_ClienteLayout.setVerticalGroup(
            Panel_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 413, Short.MAX_VALUE)
        );

        TabbedPane_Pedido.addTab("Cliente", Panel_Cliente);

        javax.swing.GroupLayout Panel_CategoriaLayout = new javax.swing.GroupLayout(Panel_Categoria);
        Panel_Categoria.setLayout(Panel_CategoriaLayout);
        Panel_CategoriaLayout.setHorizontalGroup(
            Panel_CategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 622, Short.MAX_VALUE)
        );
        Panel_CategoriaLayout.setVerticalGroup(
            Panel_CategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 413, Short.MAX_VALUE)
        );

        TabbedPane_Pedido.addTab("Categoría", Panel_Categoria);

        javax.swing.GroupLayout Panel_RestauranteLayout = new javax.swing.GroupLayout(Panel_Restaurante);
        Panel_Restaurante.setLayout(Panel_RestauranteLayout);
        Panel_RestauranteLayout.setHorizontalGroup(
            Panel_RestauranteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 622, Short.MAX_VALUE)
        );
        Panel_RestauranteLayout.setVerticalGroup(
            Panel_RestauranteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 413, Short.MAX_VALUE)
        );

        TabbedPane_Pedido.addTab("Restaurantes", Panel_Restaurante);

        javax.swing.GroupLayout Panel_ProductosLayout = new javax.swing.GroupLayout(Panel_Productos);
        Panel_Productos.setLayout(Panel_ProductosLayout);
        Panel_ProductosLayout.setHorizontalGroup(
            Panel_ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 622, Short.MAX_VALUE)
        );
        Panel_ProductosLayout.setVerticalGroup(
            Panel_ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 413, Short.MAX_VALUE)
        );

        TabbedPane_Pedido.addTab("Prodcutos", Panel_Productos);

        javax.swing.GroupLayout Panel_ConfirmarLayout = new javax.swing.GroupLayout(Panel_Confirmar);
        Panel_Confirmar.setLayout(Panel_ConfirmarLayout);
        Panel_ConfirmarLayout.setHorizontalGroup(
            Panel_ConfirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 622, Short.MAX_VALUE)
        );
        Panel_ConfirmarLayout.setVerticalGroup(
            Panel_ConfirmarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 413, Short.MAX_VALUE)
        );

        TabbedPane_Pedido.addTab("Confirmar pedido", Panel_Confirmar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPane_Pedido)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPane_Pedido)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_Categoria;
    private javax.swing.JPanel Panel_Cliente;
    private javax.swing.JPanel Panel_Confirmar;
    private javax.swing.JPanel Panel_Productos;
    private javax.swing.JPanel Panel_Restaurante;
    private javax.swing.JTabbedPane TabbedPane_Pedido;
    // End of variables declaration//GEN-END:variables
}
