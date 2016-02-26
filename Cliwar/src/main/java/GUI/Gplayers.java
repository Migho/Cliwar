package GUI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Gplayers extends JPanel {
    private BufferedImage player1, player1x, player2, player2x;
    public Gplayers() {
        try {
            player1 = ImageIO.read(new File("src/main/java/graphics/Player1.png"));
            player1x = ImageIO.read(new File("src/main/java/graphics/Player1x.png"));
            player2 = ImageIO.read(new File("src/main/java/graphics/Player2.png"));
            player2x = ImageIO.read(new File("src/main/java/graphics/Player2x.png"));
        } catch (IOException ex) {
            System.out.println("Ei voitu latada taustaa!");
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(player1, 0, 80, null);
        g.drawImage(player2, 612, 80, null);
    }
}
