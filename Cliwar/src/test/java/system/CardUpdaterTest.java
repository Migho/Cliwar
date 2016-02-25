package system;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * Tämä testi testaa CardUpdater -luokan toimivuuden ja yhteistyön table -luokan
 * kanssa. Testi vaatii ajan kulumista, joten testien läpiveto kestää ~16s
*/

public class CardUpdaterTest {
    /*
    Table table;
    
    @Before
    public void setUp() {
        table = new Table();
    }
    
    @Test
    public void cardUpdaterPaivittaa() throws InterruptedException {
        int[] kortit1 = table.getKortit().clone();
        table.startActivity();
        Thread.sleep(3500);
        int[] kortit2 = table.getKortit();
        assertFalse("Kortit eivät vaihtuneet", Arrays.equals(kortit1, kortit2));
        table.stopActivity();
        Thread.sleep(200);
    }
    
    @Test
    public void cardUpdaterPaivittaaOikeassaTahdissa() throws InterruptedException {
        int[] kortit = table.getKortit().clone();
        table.startActivity();
        Thread.sleep(500);
        int fails=0;
        for(int i=0; i<3; i++) {
            Thread.sleep(1000);
            if(kortit[i]==table.getKortti(i)) fails++;
            if(kortit[i+3]==table.getKortti(i+3)) fails++;
        }
        assertTrue("(Yli) puolet korteista eivät vaihtuneet", fails<=3);
        table.stopActivity();
        Thread.sleep(200);
    }
    
    @Test
    public void cardUpdaterEiPaivitaJosNostetaanKortti() throws InterruptedException {
        table.startActivity();
        table.updateKortti(0);
        int kortti = table.getKortti(0);
        Thread.sleep(2500);
        assertTrue(kortti==table.getKortti(0));
        table.stopActivity();
        Thread.sleep(200);
    }
    
    @Test
    public void cardUpdaterLopettaaToimintansaKaskettaessa() throws InterruptedException {
        table.startActivity();
        Thread.sleep(1500);
        table.stopActivity();
        int[] kortit1 = table.getKortit().clone();
        Thread.sleep(4000);
        int[] kortit2 = table.getKortit();
        assertTrue("Kortit vaihtuivat", Arrays.equals(kortit1, kortit2));
        table.stopActivity(); 
        Thread.sleep(200);
    }
    */
}
