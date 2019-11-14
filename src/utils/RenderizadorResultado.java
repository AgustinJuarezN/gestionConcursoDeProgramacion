/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author ajuarez
 */
public class RenderizadorResultado implements ListCellRenderer {

    protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();

    public Component getListCellRendererComponent(JList list, Object value, int index,
    boolean isSelected, boolean cellHasFocus) {
        Color theBackground = null;
        String theText = null;

        JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);

        theText = (String) value;
        
        
        if (theText.contains("+")) {
            theBackground = Color.GREEN;
        }else if (theText.contains("-")) {
            theBackground = Color.YELLOW;
        }else {
            theBackground = Color.RED;
        }

        renderer.setText(theText);
        renderer.setBackground(theBackground);
        
        return renderer;
    }
}
