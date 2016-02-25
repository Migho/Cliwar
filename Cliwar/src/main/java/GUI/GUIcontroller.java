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

public class GUIcontroller extends JPanel implements ActionListener {
    
    private JFrame frame;
    private Timer t = new Timer(20, this);
    private GUIbackground background = new GUIbackground();
    private GUIcards cards;
    private GUIhands hands;
    private GUIstats stats;
    //private Controller controller;
    
    public GUIcontroller(Controller controller) {
        //this.controller = controller;
        cards = new GUIcards(controller.getTable());
        hands = new GUIhands(controller.getButtonController());
        stats = new GUIstats(controller.getGameboard().getPlayer(1), controller.getGameboard().getPlayer(2));
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        background.paintComponent(g);
        hands.paintComponent(g);
        cards.paintComponent(g);
        stats.paintComponent(g);
        t.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    
}
