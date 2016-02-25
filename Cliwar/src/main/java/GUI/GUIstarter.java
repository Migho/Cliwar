/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JFrame;
import system.Controller;

/**
 *
 * @author mcrintah
 */
public class GUIstarter {
    
    JFrame f;
    GUIcontroller guicontroller;
    
    public GUIstarter(Controller controller) {
        f = new JFrame();
        guicontroller = new GUIcontroller(controller);
        f.add(guicontroller);
        f.setVisible(true);
        f.setSize(1024, 720);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Cliwar");
        f.addKeyListener(controller.getButtonController().getKeyboardListener());
    }
    
}
