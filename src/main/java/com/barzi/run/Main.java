/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.barzi.run;

/**
 *
 * @author Jalal.Hussain
 */
import com.barzi.design.ShadeOptionsPanel;
import com.barzi.design.ShadowSelector;

import javax.swing.*;

public class Main {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run()
            {
                ShadeOptionsPanel shadeOptions = new ShadeOptionsPanel();
                ShadowSelector shadowSelector = new ShadowSelector(shadeOptions);
                //ComponentSource componentSource = new ComponentSource(shadeOptions);
                JFrame f = new JFrame("Rounded Concept Demo with Shadows");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.add(shadowSelector, "North");
                f.add(shadeOptions);
                //f.add(componentSource, "South");
                f.setSize(300, 200);
                f.setLocation(150, 150);
                f.setVisible(true);
            }
        });
    }
    
    private Main() {
    }
}

