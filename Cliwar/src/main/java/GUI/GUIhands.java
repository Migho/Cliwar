package GUI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import system.ButtonController;
import system.Table;

public class GUIhands extends JPanel {
    private BufferedImage hand1, hand2;
    private ButtonController buttonController;
    
    public GUIhands(ButtonController buttonController) {
        this.buttonController = buttonController;
        try {
            hand1 = ImageIO.read(new File("src/main/java/graphics/Hand1.jpg"));
            hand2 = ImageIO.read(new File("src/main/java/graphics/Hand2.jpg"));
        } catch (IOException ex) {
            System.out.println("Virhe lukiessa käsi-implikaattoreille kuvia!");
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int[] i = buttonController.getKadet();
        if(i[0] < 3) { g.drawImage(hand1, 4 + i[0]*170, 440, null); }
        else { g.drawImage(hand1, 510 + (i[0]-3)*170, 440, null); }
        if(i[1] < 3) { g.drawImage(hand2, 4 + i[1]*170, 550, null); }
        else { g.drawImage(hand2, 510 + (i[1]-3)*170, 550, null); }
    }
}