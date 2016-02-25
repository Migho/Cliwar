package system;

/**
 * Luokka on koko sovelluslogiikan pääydin, joka yhdistää sen eri osat toisiinsa.
 */
public class Controller {
    private Gameboard gameboard;
    private Table table;
    private ButtonController buttonController;
    
    public Controller() {
        gameboard = new Gameboard();
        table = new Table();
        buttonController = new ButtonController(this);
        table.startActivity();
        gameboard.startActivity();
    }
    
    /**
     * Nostaa pelialueelta kortin ja pelaa sen.
     * @param kortti    Monesko kortti pöydällä halutaan pelata.
     * @param pelaaja   Kumpi pelaaja pelaa kortin
     * @return          Palauttaa false jos korttia ei voitu pelata.
     */
    public boolean nostaKortti(int kortti, int pelaaja) {
        if(gameboard.activateCard(table.getKortti(kortti), pelaaja)) {
            table.updateKortti(kortti);
            return true;
        } return false;
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
}
