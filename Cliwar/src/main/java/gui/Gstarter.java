package gui;

import javax.swing.JFrame;
import system.Controller;



public class Gstarter {

    JFrame f;
    Gcontroller guicontroller;

    /**
     * Tämä luokka luo ikkunan ja käynnistää GUI-controllerin toiminnan.
     * @param controller  Controller-olio, jonka avulla pelin kannalta oleelliset
     * tiedot saadaan noudettua.
     */
    
    public Gstarter(Controller controller) {
        f = new JFrame();
        
        guicontroller = new Gcontroller(controller);
        f.add(guicontroller);
        f.setSize(1024, 720);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("SUPER EPIC DINO FIGHT SHOWDOWN");
        f.setResizable(false);
        f.addKeyListener(controller.getButtonController().getKeyboardListener());
        f.setVisible(true);
    }

}
