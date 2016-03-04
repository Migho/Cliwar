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


public class GameboardTest extends Controller {
    Gameboard gameboard;
    
    @Before
    public void setUp() {
        gameboard = new Gameboard(this);
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
        int[] a = gameboard.getPlayer(1).getStats();
        int[] b = gameboard.getPlayer(2).getStats();
        int i=1;
        while(!gameboard.activateCard(i, 1) && i < 3) i++;
        assertTrue(!gameboard.getPlayer(1).getStats().equals(a) || !gameboard.getPlayer(2).getStats().equals(b));
    }
    
    @Test
    public void OlemattomallePelaajalleEiVoiAktivoidaKorttia() {
        assertFalse(gameboard.activateCard(1, 0));
        assertFalse(gameboard.activateCard(1, 3));
    }
    
    public void PalauttaaFalseJosEnergiaKuluuLopultaLoppuun() {
        for(int i=0; i<100; i++) gameboard.activateCard(1, 1);
        assertFalse(gameboard.activateCard(1, 1));
    }
}
