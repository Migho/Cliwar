package system;

import gui.Gcontroller;
import gui.Gstarter;
import java.awt.EventQueue;

public class Launcher {
    
    /**
     * Tämä luokka käynnistää koko sovelluksen toiminnan.
     * @param args  Ohjelman parametrit, joita ei huomioida :).
     */
    public static void main(String[] args) {
        Controller controller = new Controller();
        Gstarter guistarter = new Gstarter(controller);

    }
}
