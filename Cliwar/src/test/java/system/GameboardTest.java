/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mcrintah
 */
public class GameboardTest {
    Gameboard gameboard;
    
    @Before
    public void setUp() {
        gameboard = new Gameboard();
    }
    
    @Test
    public void PalauttaaInfonOikein() {
        assertTrue(gameboard.getPlayerInfo(0) == null);
        assertTrue(gameboard.getPlayerInfo(1) != null);
        assertTrue(gameboard.getPlayerInfo(2) != null);
        assertTrue(gameboard.getPlayerInfo(3) == null);
    }
    
    @Test
    public void KortinAktivointiToimii() {
        int[] a = gameboard.getPlayerInfo(1);
        int[] b = gameboard.getPlayerInfo(2);
        int i=1;
        while(!gameboard.activateCard(i, 1)) i++;
        assertTrue(!gameboard.getPlayerInfo(1).equals(a) || !gameboard.getPlayerInfo(2).equals(b));
    }
    
    @Test
    public void OlemattomallePelaajalleEiVoiAktivoidaKorttia() {
        assertFalse(gameboard.activateCard(1, 0));
        assertFalse(gameboard.activateCard(1, 3));
    }
}
