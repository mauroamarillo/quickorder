/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.Restaurante;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;

/**
 *
 * @author Jean
 */
class RestaurantesCellRenderer implements TreeCellRenderer {

    JLabel NombreRestaurante;
    private final JPanel renderer;
    DefaultTreeCellRenderer defaultRenderer = new DefaultTreeCellRenderer();

    public RestaurantesCellRenderer() {
        renderer = new JPanel(new GridLayout(0, 1));
        NombreRestaurante = new JLabel(" ");
        renderer.add(NombreRestaurante);
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value,
            boolean selected, boolean expanded, boolean leaf, int row,
            boolean hasFocus) {
        Restaurante R;
        Component returnValue = null;
        if ((value != null) && (value instanceof DefaultMutableTreeNode)) {
            Object userObject = ((DefaultMutableTreeNode) value).getUserObject();
            if (userObject instanceof Restaurante) {
                R = (Restaurante) userObject;
                NombreRestaurante.setText(R.getNombre());
                if (selected) {
                    renderer.setBackground(defaultRenderer.getBackgroundSelectionColor());
                } else {
                    renderer.setBackground(defaultRenderer.getBackgroundNonSelectionColor());
                }
                renderer.setEnabled(tree.isEnabled());
                returnValue = renderer;
            }
        }
        if (returnValue == null) {
            returnValue = defaultRenderer.getTreeCellRendererComponent(tree,
                    value, selected, expanded, leaf, row, hasFocus);
        }
        return returnValue;
    }
}
