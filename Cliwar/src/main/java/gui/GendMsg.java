package gui;

import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import system.Controller;

public class GendMsg extends JPanel {

    private Controller controller;
    
    /**
     * Tämä luokka piirtää lopetustekstin kun peli päättyy.
     * @param controller    controller-luokka, jolta tämä luokka saa tiedon kun
     *                      peli on päättynyt.
     */
    public GendMsg(Controller controller) {
        this.controller = controller;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        if (controller.getPelinTilanne() != 0) {
            Font font = new Font("Verdana", Font.BOLD, 70);
            g.setFont(font);
            super.paintComponent(g);
            g.drawString("THE END", 340, 220);
            font = new Font("Verdana", Font.BOLD, 40);

            g.setFont(font);
            if (controller.getPelinTilanne() == 1) {
                g.drawString("Player 1 wins!", 350, 260);
            }
            if (controller.getPelinTilanne() == 2) {
                g.drawString("Player 2 wins!", 350, 260);
            }
            if (controller.getPelinTilanne() == 3) {
                g.drawString("TIE!", 467, 260);
            }
            font = new Font("Verdana", Font.BOLD, 30);
            g.setFont(font);
            g.drawString("Please restart the game to play again", 195, 290);
        }
    }

}
