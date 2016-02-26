package system;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

/*
 * Korttien asetustiedosto noudattaa seuraavaa kaavaa:
 * 1. rivi: eri korttien määrä
 * Loput rivit: riveittäin tietyn kortin määrä.
 */
public class Deck {

    private int korttienmaara = 0;
    private int kortit[];
    private Random random = new Random();

    /**
     * Luokka pitää kirjaa korttipinosta ja antaa kortteja pinosta.
     * @param i     Pelaaja jonka korttipino halutaan ladata;
     * 1=pelaaja1, 2=pelaaja2
     */
    
    public Deck(int i) {
        ClassLoader classLoader = getClass().getClassLoader();
        if (i == 1) {
            if (!deckConstruct(new File(classLoader.getResource("settings/Deck1.txt").getFile()))) {
                throw new Error();
            }
        } else if (i == 2) {
            if (!deckConstruct(new File(classLoader.getResource("settings/Deck2.txt").getFile()))) {
                throw new Error();
            }
        } else {
            throw new Error();
        }
    }
    
    /**
     * Luokka pitää kirjaa korttipinosta ja antaa kortteja pinosta.
     * @param tiedosto      Tiedosto, jossa on asetukset pakalle.
     */
    
    public Deck(File tiedosto) {
        if (!deckConstruct(tiedosto)) {
            throw new Error();
        }
    }
    
    /**
     * Metodi, joka lataa halutun tiedoston ja lataa asetukset.
     * @param tiedosto      Tiedosto jota käsitellään
     * @return 
     */
    
    private boolean deckConstruct(File tiedosto) {
        String rivi;
        Scanner lukija = null;
        try {
            lukija = new Scanner(tiedosto);
        } catch (Exception e) {
            System.out.println("Tiedoston lukeminen epäonnistui. Virhe: " + e.getMessage());
            return false;
        }

        if (!lukija.hasNextLine()) {
            System.out.println("Tiedosto on tyhjä!");
            return false;
        }
        kortit = new int[Integer.parseInt(lukija.nextLine())];
        int i = 0;
        while (lukija.hasNextLine()) {
            kortit[i] = Integer.parseInt(lukija.nextLine());
            korttienmaara += kortit[i];
            i++;
        }
        //System.out.println("Tiedoston luku onnistui");
        return true;
    }

    /**
     * Anna pakasta seuraava kortti.
     * @return  Palauttaa pakasta kortin.
     */
    
    public int annaKortti() {
        if (korttienmaara == 0) {
            return -1;
        }
        int j;
        int i = random.nextInt(korttienmaara);
        for (j = 0; i >= 0; j++) {
            i -= kortit[j];
        }
        j--;
        kortit[j]--;
        korttienmaara--;
        return j;
    }
    
    /**
     * Lisää pakkaan kortti.
     * @param i     Kortin ID joka lisätään.
     */
    public void lisaaKortti(int i) {
        kortit[i]++;
        korttienmaara++;
    }

}
