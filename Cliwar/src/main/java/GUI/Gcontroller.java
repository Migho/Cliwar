package GUI;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import system.Controller;

public class Gcontroller extends JPanel implements ActionListener {
    
    private JFrame frame;
    private Timer t = new Timer(20, this);
    private Gbackground background = new Gbackground();
    private Gcards cards;
    private Ghands hands;
    private Gstats stats;
    private Gplayers players;
    //private Controller controller;
    
    public Gcontroller(Controller controller) {
        //this.controller = controller;
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
