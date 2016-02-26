package gui;

import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import system.Player;

public class Gstats extends JPanel {

    private Player player1, player2;

    /**
     * Tämä luokka huolehtii pelaajien statsien piirrosta.
     * @param player1   Pelaajaolio 1
     * @param player2   Pelaajaolio 2.
     */
    
    public Gstats(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Font font = new Font("Verdana", Font.BOLD, 20);
        g.setFont(font);
        super.paintComponent(g);
        int i[];

        i = player1.getStats();
        g.drawString("HP: " + i[0] + "/30", 20, 20);
        g.drawString("ARMOR: " + i[1], 20, 40);
        g.drawString("MAGIC RESISTANCE: " + i[2], 20, 60);
        g.drawString("ENERGY: " + i[3] + "/" + i[4], 20, 80);

        i = player2.getStats();
        g.drawString("HP: " + i[0] + "/30", 532, 20);
        g.drawString("ARMOR: " + i[1], 532, 40);
        g.drawString("MAGIC RESISTANCE: " + i[2], 532, 60);
        g.drawString("ENERGY: " + i[3] + "/" + i[4], 532, 80);
    }
}
