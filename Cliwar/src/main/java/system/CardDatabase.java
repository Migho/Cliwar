package system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/* 
 * Korttien asetustiedosto noudattaa seuraavaa kaavaa:
 * 1. rivi skipataan
 * 2. rivi: eri korttien määrä
 * loput rivit: card_id, energy_cost, p-dmg_emeny, p-dmg_self, m-dmg_emeny,
 *  m-dmg_self, pure-dmg_emeny, pure-dmg_self, armor-mod_emeny, armor-mod_self,
 *  mResistance-mod_emeny, mResistance-mod_self, energy%_emeny, energy%_self.
 * Eli yhteensä ID + 13 eri lukua/rivi välilyönnein eriteltynä
 */
public class CardDatabase {

    private int[][] kortit;
    final private int asetustenMaara = 13;
    private int korttienMaara = 0;

    /**
     * Tämän luokan tehtävä on latada asetustiedostosta eri korttien efektit ja
     * palauttaa niitä.
     */
    public CardDatabase() {
        InputStream in = getClass().getResourceAsStream("/settings/CardDatabase.txt");
        if (!cardDatabaseConstruct(in)) {
            throw new Error();
        }
    }

    /**
     * Metodi lataa parametrina annetun tiedoston sisällön.
     *
     * @param tiedosto Tiedosto joka halutaan ladata
     * @return Palauttaa false, mikäli epäonnistuu
     */
    private boolean cardDatabaseConstruct(InputStream in) {
        BufferedReader input = null;
        Scanner lukija;
        try {
            input = new BufferedReader(new InputStreamReader(in));
            int i;
            input.readLine();
            korttienMaara = Integer.parseInt(input.readLine());
            kortit = new int[korttienMaara][asetustenMaara];
            String rivi;
            while ((rivi = input.readLine()) != null) {
                lukija = new Scanner(rivi);
                i = lukija.nextInt();
                for (int j = 0; j < asetustenMaara; j++) {
                    kortit[i][j] = lukija.nextInt();
                }
            }
        } catch (IOException | NumberFormatException e) {
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
     * Palauttaa halutun kortin tiedot.
     *
     * @param cardId Sen kortin ID, jonka speksit halutaan.
     * @return Palauttaa kortin tiedot int[] -taulukkona
     */
    public int[] getCardInfo(int cardId) {
        return kortit[cardId];
    }

    public int getKorttienMaara() {
        return korttienMaara;
    }

}
