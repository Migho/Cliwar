
package gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import system.Table;

public class Gcards extends JPanel {
    
    private BufferedImage[] korttikuvat;
    private int korttienMaara;
    private Table table;

    /**
     * Tämä luokka piirtää kortit ikkunaan.
     * @param table     Table, josta korttien tiedot otetaan.
     */
    
    public Gcards(Table table) {
        this.table = table;
        korttienMaara = table.getEriKorttienMaara();
        korttikuvat = new BufferedImage[korttienMaara];
        for (int i = 0; i < korttienMaara; i++) {
            try {
                korttikuvat[i] = ImageIO.read(getClass().getResourceAsStream("/graphics/" + i + ".jpg"));
            } catch (IOException ex) {
                System.out.println("Virhe lukiessa kortille " + i + " grafiikkaa!");
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int[] i = table.getKortit();
        g.drawImage(korttikuvat[i[0]], 14, 450, null);
        g.drawImage(korttikuvat[i[1]], 184, 450, null);
        g.drawImage(korttikuvat[i[2]], 354, 450, null);
        g.drawImage(korttikuvat[i[3]], 520, 450, null);
        g.drawImage(korttikuvat[i[4]], 690, 450, null);
        g.drawImage(korttikuvat[i[5]], 860, 450, null);
    }
}
