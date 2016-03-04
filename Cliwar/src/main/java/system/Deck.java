package system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Korttien asetustiedosto noudattaa seuraavaa kaavaa:
 * 1. rivi: eri korttien määrä
 * Loput rivit: riveittäin tietyn kortin määrä.
 */
public class Deck {

    private int korttienMaara = 0;
    private int kortit[];
    private Random random = new Random();

    /**
     * Luokka pitää kirjaa korttipinosta ja antaa kortteja pinosta.
     *
     * @param i Pelaaja jonka korttipino halutaan ladata; 1=pelaaja1, 2=pelaaja2
     */
    public Deck(int i) {
        ClassLoader classLoader = getClass().getClassLoader();
        if (i == 1) {
            if (!deckConstruct(getClass().getResourceAsStream("/settings/Deck1.txt"))) {
                throw new Error();
            }
        } else if (i == 2) {
            if (!deckConstruct(getClass().getResourceAsStream("/settings/Deck2.txt"))) {
                throw new Error();
            }
        } else {
            throw new Error();
        }
    }

    /**
     * Metodi, joka lataa halutun tiedoston ja lataa asetukset.
     *
     * @param tiedosto Tiedosto jota käsitellään
     * @return
     */
    private boolean deckConstruct(InputStream in) {
        BufferedReader input = null;
        Scanner lukija;
        try {
            input = new BufferedReader(new InputStreamReader(in));
            kortit = new int[Integer.parseInt(input.readLine())];
            String rivi;
            for (int i = 0; (rivi = input.readLine()) != null; i++) {
                kortit[i] = Integer.parseInt(rivi);
                korttienMaara += kortit[i];
                //System.out.println("korttityyppi lisää: " + i + "/" + kortit.length + ", " + kortit[i] + "kpl");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException ex) {
                    Logger.getLogger(CardDatabase.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Anna pakasta seuraava kortti.
     *
     * @return Palauttaa pakasta kortin.
     */
    public int annaKortti() {
        if (korttienMaara == 0) {
            return -1;
        }
        int j;
        int i = random.nextInt(korttienMaara);
        for (j = 0; i >= 0; j++) {
            i -= kortit[j];
        }
        j--;
        kortit[j]--;
        korttienMaara--;
        return j;
    }

    /**
     * Lisää pakkaan kortti.
     *
     * @param i Kortin ID joka lisätään.
     */
    public void lisaaKortti(int i) {
        kortit[i]++;
        korttienMaara++;
    }

    public int getKorttienMaara() {
        return korttienMaara;
    }
    
    /**
     * Metodi palauttaa erilaisten korttien määrän.
     * @return  Eri korttien määrä
     */
    public int getEriKorttienMaara() {
        return kortit.length;
    }

}
