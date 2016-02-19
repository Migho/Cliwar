package system;

import java.io.File;
import java.util.Scanner;

/**
 * Luokka lataa asetustiedostosta eri korttien ominaisuudet ja pitää niistä kirjaa.
 */

/* 
 * Korttien asetustiedosto noudattaa seuraavaa kaavaa:
 * 1. rivi skipataan
 * 2. rivi: eri korttien määrä
 * loput rivit: card_id, energy_cost, p-dmg_emeny, p-dmg_self, m-dmg_emeny,
 *  m-dmg_self, pure-dmg_emeny, pure-dmg_self, armor-mod_emeny, armor-mod_self,
 *  mResistance-mod_emeny, mResistance-mod_self, energy/s_emeny, energy/s_self.
 * Eli yhteensä ID + 13 eri lukua/rivi välilyönnein eriteltynä
*/

public class CardDatabase {
    
    private int[][] kortit;
    final private int asetustenMaara=13;
    private int korttienMaara=0;
    
    public CardDatabase() {
        if(!CardDatabaseConstruct(new File("src/main/java/settings/CardDatabase.txt")))
            throw new Error();
    }
    
    public CardDatabase(File tiedosto) {
        if(!CardDatabaseConstruct(tiedosto))
            throw new Error();
    }
    
    private boolean CardDatabaseConstruct(File tiedosto)  {
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
        lukija.nextLine();
        korttienMaara = Integer.parseInt(lukija.nextLine());
        kortit = new int[korttienMaara][asetustenMaara];
        int i;
        while (lukija.hasNextLine()) {
            i = lukija.nextInt();
            for(int j=0; j<asetustenMaara; j++) {
                kortit[i][j] = lukija.nextInt();
            }
            lukija.nextLine();
        }
        //System.out.println("Tiedoston luku onnistui");
        return true;
    }
    
    public int[] getCardInfo(int cardId) {
        return kortit[cardId];
    }
    
    public int getKorttienMaara() {
        return korttienMaara;
    }
    
}