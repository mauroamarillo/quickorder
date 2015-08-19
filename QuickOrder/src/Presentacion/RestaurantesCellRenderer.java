package Presentacion;

import Logica.Restaurante;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
/**/



class RestaurantesCellRenderer implements TreeCellRenderer {

    DefaultTreeCellRenderer defaultRenderer = new DefaultTreeCellRenderer();

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value,
            boolean selected, boolean expanded, boolean leaf, int row,
            boolean hasFocus) {
        Restaurante R;
        Component returnValue = null;
        if ((value != null) && (value instanceof DefaultMutableTreeNode)) {
            Object userObject = ((DefaultMutableTreeNode) value).getUserObject();
            if (userObject instanceof Restaurante) {
                returnValue = defaultRenderer.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
                R = (Restaurante) userObject;
                JLabel label = (JLabel) returnValue;
                label.setIcon(new ImageIcon(getClass().getResource("/img/icoRes.png")));
                label.setText(R.getNickname());
            }
        }
        if (returnValue == null) {
            returnValue = defaultRenderer.getTreeCellRendererComponent(tree,
                    value, selected, expanded, leaf, row, hasFocus);
            /*CAMBIO EL ICOMO DE LOS NODOS QUE NO SON RESTAURANTES (RAIZ Y CATGORIAS)*/
            JLabel label = (JLabel) returnValue;
            label.setIcon(new ImageIcon(getClass().getResource("/img/folder.png")));
        }
        return returnValue;
    }
}
