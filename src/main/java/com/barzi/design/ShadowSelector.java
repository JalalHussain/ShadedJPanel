/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barzi.design;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 *
 * @author Jalal.Hussain
 */
public class ShadowSelector extends JPanel {
    
    private static final long serialVersionUID = 1L;
    private ShadeOptionsPanel soPanel;
    private String[] directions = {"northeast", "northwest", "southwest", "southeast"};
    
    public ShadowSelector(ShadeOptionsPanel sop) {
        soPanel = sop;
        
        final SpinnerListModel model = new SpinnerListModel(directions);
        model.setValue(directions[3]);
        JSpinner spinner = new JSpinner(model);
        spinner.setPreferredSize(new Dimension(90, spinner.getPreferredSize().height));
        spinner.addChangeListener(new ChangeListener() {
            
            @Override
            public void stateChanged(ChangeEvent e) {
                String value = (String) model.getValue();
                soPanel.shadowVertex = model.getList().indexOf(value);
                soPanel.repaint();
            }
        });
        add(new JLabel("shadow vertex", JLabel.RIGHT));
        add(spinner);
    }
}