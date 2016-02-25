/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import system.Table;

public class Gcards extends JPanel {
    private BufferedImage[] korttikuvat;
    private int korttienMaara=3;
    private Table table;
    
    public Gcards(Table table) {
        this.table = table;
        korttikuvat = new BufferedImage[korttienMaara];
        for(int i=0; i<korttienMaara; i++) {
            try {
                korttikuvat[i] = ImageIO.read(new File("src/main/java/graphics/" + i + ".jpg"));
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
