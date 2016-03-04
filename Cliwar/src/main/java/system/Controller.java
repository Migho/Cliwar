package system;

public class Controller {

    private Gameboard gameboard;
    private Table table;
    private ButtonController buttonController;

    /**
     * Luokka on koko sovelluslogiikan pääydin, joka yhdistää sen eri osat
     * toisiinsa.
     */
    public Controller() {
        gameboard = new Gameboard(this);
        table = new Table();
        buttonController = new ButtonController(this);
        table.startActivity();
        gameboard.startActivity();
    }

    /**
     * Nostaa pelialueelta kortin ja pelaa sen.
     *
     * @param kortti Monesko kortti pöydällä halutaan pelata.
     * @param pelaaja Kumpi pelaaja pelaa kortin
     * @return Palauttaa false jos korttia ei voitu pelata.
     */
    public boolean nostaKortti(int kortti, int pelaaja) {
        if (gameboard.activateCard(table.getKortti(kortti), pelaaja)) {
            table.updateKortti(kortti);
            return true;
        }
        return false;
    }

    public Table getTable() {
        return table;
    }

    public ButtonController getButtonController() {
        return buttonController;
    }

    public Gameboard getGameboard() {
        return gameboard;
    }

    /**
     * Metodi palauttaa pelin tilanteen, aka onko peli jo päättynyt.
     * @return  Palauttaa tilanteen. 0=peli on käynnissä, 1=pelaaja 1 voitti,
     * 2=pelaaja 2 voitti, 3=peli päättyi tasapeliin
     */
    public int getPelinTilanne() {
        if (gameboard.getPlayerInfo(1)[0] <= 0 && gameboard.getPlayerInfo(2)[0] <= 0) {
            return 3;
        }
        if (gameboard.getPlayerInfo(2)[0] <= 0) {
            return 1;
        }
        if (gameboard.getPlayerInfo(1)[0] <= 0) {
            return 2;
        }
        return 0;
    }

    /**
     * Metodi lopettaa pelin kulun.
     */
    public void lopetaPeli() {
        table.stopActivity();
        buttonController.stopListening();

    }

}
