package system;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

/**
 * Luokka pitää kirjaa korttipinosta ja palauttaa 
 */

/*
 * Korttien asetustiedosto noudattaa seuraavaa kaavaa:
 * 1. rivi: eri korttien määrä
 * Loput rivit: riveittäin tietyn kortin määrä.
 */

public class Deck {
    private int korttienmaara=0;
    private int kortit[];
    private Random random = new Random();
    
    public Deck(int i) {
       if(i==1) {
            if(!DeckConstruct(new File("src/main/java/settings/Deck1.txt")))
                throw new Error();
        } else if(i==2) {
            if(!DeckConstruct(new File("src/main/java/settings/Deck2.txt")))
                throw new Error();
        } else {
            throw new Error();
        }
    }
    
    public Deck(File tiedosto) {
        if(!DeckConstruct(tiedosto))
            throw new Error();
    }
    
    private boolean DeckConstruct(File tiedosto) {
        String rivi;
        Scanner lukija = null;
        try {
            lukija = new Scanner(tiedosto);
        } catch (Exception e) {
            System.out.println("Tiedoston lukeminen epäonnistui. Virhe: " + e.getMessage());
            return false;
        }
        
        if(!lukija.hasNextLine()) {
            System.out.println("Tiedosto on tyhjä!");
            return false;
        }
        kortit = new int[Integer.parseInt(lukija.nextLine())];
        int i=0;
        while (lukija.hasNextLine()) {
            kortit[i] = Integer.parseInt(lukija.nextLine());
            korttienmaara+=kortit[i];
            i++;
        }
        //System.out.println("Tiedoston luku onnistui");
        return true;
    }
    
    public int annaKortti() {
        if(korttienmaara == 0) return -1;
        int j;
        int i = random.nextInt(korttienmaara);
        for(j=0; i>=0; j++) {
            i-=kortit[j];
        }
        j--;
        kortit[j]--;
        korttienmaara--;
        return j;
    }
    
    public void lisaaKortti(int i) {
        kortit[i]++;
        korttienmaara++;
    }
    
}
