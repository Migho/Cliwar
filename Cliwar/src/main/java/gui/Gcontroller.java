package gui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import system.Controller;

public class Gcontroller extends JPanel implements ActionListener {

    private JFrame frame;
    private Timer t = new Timer(20, this);
    private Gbackground background = new Gbackground();
    private Gcards cards;
    private Ghands hands;
    private Gstats stats;
    private Gplayers players;
    
    /**
     * Tämä luokka huolehtii kaikkien komponenttien piirrosta tiettyjen aikojen
     * välein.
     * @param controller Controller-olio, jonka avulla pelin kannalta oleelliset
     * tiedot saadaan noudettua.
     */
    
    public Gcontroller(Controller controller) {
        cards = new Gcards(controller.getTable());
        hands = new Ghands(controller.getButtonController());
        stats = new Gstats(controller.getGameboard().getPlayer(1), controller.getGameboard().getPlayer(2));
        players = new Gplayers();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        background.paintComponent(g);
        hands.paintComponent(g);
        cards.paintComponent(g);
        stats.paintComponent(g);
        players.paintComponent(g);
        t.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

}
