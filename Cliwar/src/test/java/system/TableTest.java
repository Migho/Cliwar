package system;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import system.Table;
import java.util.Arrays;


public class TableTest {
    
    Table table;
    
    @Before
    public void setUp() {
        table = new Table();
    }
    
    @Test
    public void AntaaKortin() {
        for(int i=0; i<6; i++) {
            int kortti = table.getKortti(i);
            assertTrue(kortti>=0);
        }
    }
    
    @Test
    public void AntaaKortit() {
        int[] kortit = table.getKortit();
        for(int j=0; j<kortit.length; j++)
            assertTrue("Kortti " + j + " oli " + kortit[j], kortit[j]>=0);
    }
    
    @Test
    public void KortitEivatLopu() {
        for(int i=0; i<200; i++)
            AntaaKortin();
    }
    
    @Test
    public void EiVoiPaivittaaEpapatevaaKorttia() {
        assertFalse(table.updateKortti(-1));
        assertFalse(table.updateKortti(6));
    }
    
    @Test
    public void KorttienPaivitysOnnistuu() {
        int[] kortit1 = table.getKortit().clone();
        for(int i=0; i<6; i++)
            assertTrue("Kortin vaihto epäonnistui. ", table.updateKortti(i));
        int[] kortit2 = table.getKortit();
        assertFalse("Kortit eivät vaihtuneet", Arrays.equals(kortit1, kortit2));
    }
}