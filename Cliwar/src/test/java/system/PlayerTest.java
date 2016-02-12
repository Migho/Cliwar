package system;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {
    
    Player player;
    
    @Before
    public void setUp() {
        player = new Player();
    }
    
    @Test
    public void dealDamageToimii() {
        int playerHp=player.getStats()[0];
        player.dealDamage(1, 5);
        assertTrue(playerHp>player.getStats()[0]);
        playerHp=player.getStats()[0];
        player.dealDamage(2, 5);
        assertTrue(playerHp>player.getStats()[0]);
        playerHp=player.getStats()[0];
        player.dealDamage(3, 5);
        assertTrue(playerHp>player.getStats()[0]);
    }
    
    @Test
    public void statsienLisäysToimii() {
        int i=player.getStats()[0];
        player.addHp(1);
        assertTrue(i<player.getStats()[0]);
        i=player.getStats()[1];
        player.changeArmor(1);
        assertTrue(i<player.getStats()[1]);
        i=player.getStats()[1];
        player.changeArmor(-1);
        assertTrue(i>player.getStats()[1]);
        i=player.getStats()[2];
        player.changeMagicResistance(1);
        assertTrue(i<player.getStats()[2]);
        i=player.getStats()[2];
        player.changeMagicResistance(-1);
        assertTrue(i>player.getStats()[2]);
        i=player.getStats()[3];
        assertTrue(player.changeEnergy(1));
        assertTrue(i<player.getStats()[3]);
        i=player.getStats()[3];
        assertTrue(player.changeEnergy(-1));
        assertTrue(i>player.getStats()[3]);
    }
    
    @Test
    public void hpEivoiNoustaRajattomasti() {
        player.addHp(999);
        int i=player.getStats()[0];
        player.addHp(1);
        assertTrue(i==player.getStats()[0]);
    }
    
    @Test
    public void energiaEiVoiNoustaRajattomasti() {
        player.changeEnergy(999);
        int i=player.getStats()[3];
        player.changeEnergy(1);
        assertTrue(i==player.getStats()[3]);
    }
    
    @Test
    public void energiaEiLaskeJosSitäEiOleTarpeeksi() {
        int i=player.getStats()[3];
        assertFalse(player.changeEnergy(-999));
        assertTrue(i==player.getStats()[3]);
    }
    
}
