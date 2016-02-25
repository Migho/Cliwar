package GUI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Gbackground extends JPanel {
    private BufferedImage image;
    
    public Gbackground() {
        try {
            image = ImageIO.read(new File("src/main/java/graphics/Background.jpg"));
        } catch (IOException ex) {
            System.out.println("Ei voitu latada taustaa!");
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }
    
}
