/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import system.Table;

/**
 *
 * @author migho
 */
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
    
}
