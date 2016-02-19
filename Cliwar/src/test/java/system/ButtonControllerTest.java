package system;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ButtonControllerTest extends Controller{
    ButtonController buttonController;
    boolean a, b;
    
    @Before
    public void setUp() {
        buttonController = new ButtonController(this);
    }
    
    @Test
    public void siirraKattaVasemmalleToimii() {
        int i = buttonController.getKadet()[0];
        buttonController.siirraKattaVasemmalle(1);
        assertTrue(i == buttonController.getKadet()[0]+1);
        i = buttonController.getKadet()[1];
        buttonController.siirraKattaVasemmalle(2);
        assertTrue(i == buttonController.getKadet()[1]+1);
    }
    
    @Test
    public void siirraKattaOikealleToimii() {
        int i = buttonController.getKadet()[0];
        buttonController.siirraKattaOikealle(1);
        assertTrue(i == buttonController.getKadet()[0]-1);
        i = buttonController.getKadet()[1];
        buttonController.siirraKattaOikealle(2);
        assertTrue(i == buttonController.getKadet()[1]-1);
    }
    
    @Test
    public void olemattomanKadenSiirtaminenEiTeeMitaan() {
        int[] i = buttonController.getKadet();
        buttonController.siirraKattaVasemmalle(0);
        buttonController.siirraKattaVasemmalle(3);
        assertTrue(i[0] == (buttonController.getKadet()[0]));
        assertTrue(i[1] == (buttonController.getKadet()[1]));
    }
    
    @Test
    public void otaKorttiKutsuuControlleria() {
        a=false;
        b=false;
        buttonController.otaKortti(1);
        buttonController.otaKortti(2);
        assertTrue(a);
        assertTrue(b);
    }
    
    @Override
    public boolean nostaKortti(int kasi, int pelaaja) {
        if(pelaaja==1) a=true;
        if(pelaaja==2) b=true;
        return true;
    }
    
}
