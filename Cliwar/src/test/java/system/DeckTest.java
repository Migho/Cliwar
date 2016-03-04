package system;

import system.Deck;
import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DeckTest {
    
    Deck deck;
  
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
        deck = new Deck(1);
        int i = deck.annaKortti();
        assertTrue(i>=0);
    }
    
    @Test
    public void kortitLoppuvatJoskus() {
        deck = new Deck(1);
        int korttienMaara = deck.getKorttienMaara();
        for(int j=0; j<korttienMaara; j++) {
            int i = deck.annaKortti();
            assertTrue(i>=0);
        }
        int i = deck.annaKortti();
        assertTrue(i==-1);
    }
    
    @Test
    public void korttienLisaysToimii() {
        deck = new Deck(1);
        while(deck.annaKortti() != -1) //Tyhjätään deck.
            deck.annaKortti();
        deck.lisaaKortti(1);
        int i = deck.annaKortti();
        assertTrue("kortin lisäys lisäsi kortin " + i + " vaikka piti lisätä 1.", i==1);
    }
    
}
