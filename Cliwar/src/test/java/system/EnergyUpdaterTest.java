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
        energyUpdater.start();
    }

    @Test
    public void EnergiaaTuleeLisaa() throws InterruptedException {
        int i=player1.getStats()[3];
        int j=player2.getStats()[3];
        Thread.sleep(2100);
        assertTrue(i<player1.getStats()[3] || player1.getStats()[3] == player1.getStats()[4]);
        assertTrue(i<player2.getStats()[3] || player2.getStats()[3] == player2.getStats()[4]);
    }
    
    @Test
    public void EnergiaaEiTuleLisaaJosStopRunning() throws InterruptedException {
        energyUpdater.stopRunning();
        int i=player1.getStats()[3];
        int j=player2.getStats()[3];
        Thread.sleep(2100);
        assertTrue(i==player1.getStats()[3]);
        assertTrue(j==player2.getStats()[3]);
    }
    
    @Test
    public void EnergiaaTuleeTodellaHitaastiLisaaJosTuotantoAlhainen() throws InterruptedException {
        energyUpdater.muutaEnergianTuotantoa(player1, -99);
        energyUpdater.muutaEnergianTuotantoa(player2, -99);
        int i=player1.getStats()[3];
        int j=player2.getStats()[3];
        Thread.sleep(3000);
        assertTrue("Energiaa oli tullut " + (player1.getStats()[3]-i) + " lisää", i+1>=player1.getStats()[3]);
        assertTrue("Energiaa oli tullut " + (player2.getStats()[3]-j) + " lisää", j+1>=player2.getStats()[3]);
    }
    
    @Test
    public void EnergiaaTuleeSairaanNopeestiLisaaJosTuotantoKorkea() throws InterruptedException {
        energyUpdater.muutaEnergianTuotantoa(player1, 99);
        energyUpdater.muutaEnergianTuotantoa(player2, 99);
        Thread.sleep(1000);
        assertTrue(player1.getStats()[3]==player1.getStats()[4]);
        assertTrue(player2.getStats()[3]==player2.getStats()[4]);
    }
    
    
}
