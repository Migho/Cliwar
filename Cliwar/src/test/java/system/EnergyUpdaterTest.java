package system;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class EnergyUpdaterTest {
    
    private EnergyUpdater energyUpdater;
    private Player player1, player2;
    
    @Before
    public void setUp() {
        player1 = new Player();
        player2 = new Player();
        energyUpdater = new EnergyUpdater(player1, player2);
        
    }

    @Test
    public void EnergiaaTuleeLisaa() throws InterruptedException {
        energyUpdater.start();
        int i=player1.getStats()[3];
        Thread.sleep(2100);
        assertTrue(i<player1.getStats()[3] || player1.getStats()[3] == player1.getStats()[4]);
    }
}
