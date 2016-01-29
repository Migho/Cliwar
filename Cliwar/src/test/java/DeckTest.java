/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import system.Deck;
import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author migho
 */
public class DeckTest {
    
    Deck deck;
    
    @Before
    public void setUp() {
        deck = new Deck(new File("src/test/DeckSettingsTest.txt"));
    }

    @Test
    public void deck1asetustiedostonLukuToimii() {
        deck = new Deck(1);
    }
    
    @Test
    public void deck2asetustiedostonLukuToimii() {
        deck = new Deck(2);
    }
    
    @Test
    public void antaaKortin() {
        int i = deck.annaKortti();
        assertTrue(i>=0);
    }
    
    @Test
    public void kortitLoppuvatOikeaOppisesti() {
        for(int j=0; j<5; j++) {
            int i = deck.annaKortti();
            assertTrue(i>=0);
        }
        int i = deck.annaKortti();
        assertTrue(i==-1);
    }
    
    @Test
    public void korttienLisaysToimii() {
        while(deck.annaKortti() != -1) //Tyhjätään deck.
            deck.annaKortti();
        deck.lisaaKortti(2);
        int i = deck.annaKortti();
        assertTrue("kortin lisäys lisäsi kortin " + i + " vaikka piti lisätä 2.", i==2);
    }
    
}
