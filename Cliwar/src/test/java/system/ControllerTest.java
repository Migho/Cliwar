package system;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ControllerTest {
    
    Controller c;
    
    public ControllerTest() {
    }
    
    @Before
    public void setUp() {
        c = new Controller();
    }
    
    @Test
    public void palautuksetToimivat() {
        assertTrue(c.getButtonController() != null);
        assertTrue(c.getGameboard() != null);
        assertTrue(c.getTable() != null);
    }
    
    @Test
    public void pelaaja1voittaaJosPelaaja2kuolee() {
        assertTrue(c.getPelinTilanne() == 0);
        c.getGameboard().getPlayer(2).dealDamage(3, 1000);
        assertTrue(c.getPelinTilanne() == 1);
    }
    
    @Test
    public void pelaaja2voittaaJosPelaaja1kuolee() {
        assertTrue(c.getPelinTilanne() == 0);
        c.getGameboard().getPlayer(1).dealDamage(3, 1000);
        assertTrue(c.getPelinTilanne() == 2);
    }
    
    @Test
    public void tuleeTasapeliJosMolemmatOvatKuolleet() {
        assertTrue(c.getPelinTilanne() == 0);
        c.getGameboard().getPlayer(1).dealDamage(3, 1000);
        c.getGameboard().getPlayer(2).dealDamage(3, 1000);
        assertTrue(c.getPelinTilanne() == 3);
    }
    
}
