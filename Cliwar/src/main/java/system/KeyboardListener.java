package system;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/**
 * Tämän luokan tehtävä on huolehtia näppäinpainelluksiin reagoimisesta.
 */
public class KeyboardListener implements KeyListener {
    ButtonController buttonController;
    
    public KeyboardListener(ButtonController buttonController) {
        this.buttonController = buttonController;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        if('a' == e.getKeyChar()) buttonController.siirraKattaVasemmalle(1);
        if('s' == e.getKeyChar()) buttonController.otaKortti(1);
        if('d' == e.getKeyChar()) buttonController.siirraKattaOikealle(1);

        if('b' == e.getKeyChar()) buttonController.siirraKattaVasemmalle(2);
        if('n' == e.getKeyChar()) buttonController.otaKortti(2);
        if('m' == e.getKeyChar()) buttonController.siirraKattaOikealle(2);
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
