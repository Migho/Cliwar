package system;

public class ButtonController {

    private int hand1, hand2;
    private final Controller controller;
    private KeyboardListener keyboardListener;
    private boolean cont;

    /**
     * Tämä luokka kontrolloi pelaajan "käsiä" ja reagoi luokan keyboardListener
     * -käskyihin.
     *
     * @param controller Kontrolleri, jonka kanssa tämä luokka kommunikoi
     */
    public ButtonController(Controller controller) {
        hand1 = 1;
        hand2 = 4;
        this.controller = controller;
        this.keyboardListener = new KeyboardListener(this);
        cont = true;
    }

    /**
     * Siirtää parametrina annetun pelaajan kättä vasemmalle.
     *
     * @param pelaaja 1=ensimmäinen pelaaja, 2=toinen pelaaja
     */
    public void siirraKattaVasemmalle(int pelaaja) {
        if (cont) {
            if (pelaaja == 1) {
                if (hand1 <= 0) {
                    hand1 = 5;
                } else {
                    hand1--;
                }
            } else if (pelaaja == 2) {
                if (hand2 <= 0) {
                    hand2 = 5;
                } else {
                    hand2--;
                }
            }
        }
    }

    /**
     * Siirtää parametrina annetun pelaajan kättä oikealle.
     *
     * @param pelaaja 1=ensimmäinen pelaaja, 2=toinen pelaaja
     */
    public void siirraKattaOikealle(int pelaaja) {
        if (cont) {
            if (pelaaja == 1) {
                if (hand1 >= 5) {
                    hand1 = 0;
                } else {
                    hand1++;
                }
            } else if (pelaaja == 2) {
                if (hand2 >= 5) {
                    hand2 = 0;
                } else {
                    hand2++;
                }
            }
        }
    }

    /**
     * Ottaa kortin.
     *
     * @param pelaaja 1=ensimmäinen pelaaja, 2=toinen pelaaja
     */
    public void otaKortti(int pelaaja) {
        if (cont) {
            if (pelaaja == 1) {
                controller.nostaKortti(hand1, pelaaja);
            }
            if (pelaaja == 2) {
                controller.nostaKortti(hand2, pelaaja);
            }
        }
    }

    /**
     * Palauttaa virtuaalikäsien paikat.
     *
     * @return int[] -taulukko, josta [0]=pelaaja1 ja [1]=pelaaja2
     */
    public int[] getKadet() {
        int[] kadet = {hand1, hand2};
        return kadet;
    }

    public KeyboardListener getKeyboardListener() {
        return keyboardListener;
    }
    
    /**
     * Metodin suorituksen jälkeen käyttäjän toimintoihin ei enää reagoida.
     */
    public void stopListening() {
        cont = false;
    }

}
