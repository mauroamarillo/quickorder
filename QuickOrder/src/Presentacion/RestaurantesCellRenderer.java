package Presentacion;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
/*
 天 CELLRENDERER QUE CAMBIA COMO SE VE EL ARBOL DE RESTAURANTES　天 　
 */

class RestaurantesCellRenderer implements TreeCellRenderer {

    DefaultTreeCellRenderer defaultRenderer = new DefaultTreeCellRenderer();    //<--- Renderer por defecto
    /*  Este metodo es que que se encarga de devolver cada componente del arbol
        Es un metodo de la interface TreeCellRenderer siempre hay que implementarlo
        
    */
    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        webservices.DataRestaurante R;  // aca se guarda el objeto, cuando el nodo sea de tipo restaurante
        Component returnValue = null;   // este es el componente que se va a devolver
        if ((value != null) && (value instanceof DefaultMutableTreeNode)) {         // Siempre y cuando el valor se valido
            Object userObject = ((DefaultMutableTreeNode) value).getUserObject();   // me quedo con el objeto del nodo
            if (userObject instanceof webservices.DataRestaurante) {                                // pregunto si es un restaurante
                returnValue = defaultRenderer.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus); // al componente que voy a devolver lo dejo como por defecto
                R = (webservices.DataRestaurante) userObject;                                           // guardo el objeto restaurante del nodo
                JLabel label = (JLabel) returnValue;                                    // tomo el componente de retorno y lo casteo como label
                label.setIcon(new ImageIcon(getClass().getResource("/img/icoRes.png")));// le asigno un icono de restaurante
                label.setText(R.getNombre());                                         // y le seteo el texto con el Nick del restaurante
            }
        }
        if (returnValue == null) {
            returnValue = defaultRenderer.getTreeCellRendererComponent(tree,value, selected, expanded, leaf, row, hasFocus);// al componente que voy a devolver lo dejo como por defecto
            JLabel label = (JLabel) returnValue;                                        // tomo el componente de retorno y lo casteo como label
            label.setIcon(new ImageIcon(getClass().getResource("/img/folder.png")));    // le asigno un icono de carpeta
        }
        return returnValue; // retorno el camponente modifocado
    }
}
