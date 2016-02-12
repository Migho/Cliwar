package system;

/**
 * Luokka huolehtii pelipöydän korttikokonaisuudesta.
 */
public class Table {
    
    private Deck deck1;
    private Deck deck2;
    private int kortit[];
    private CardUpdater cardUpdater;
    
    public Table() {
        deck1 = new Deck(1);
        deck2 = new Deck(2);
        kortit = new int[6];
        for(int i=0; i<3; i++)
            kortit[i]=deck1.annaKortti();
        for(int i=3; i<6; i++)
            kortit[i]=deck2.annaKortti();
        cardUpdater = new CardUpdater(this);
    }
    
    /**
     * Käynnistää korttien päivittäjän.
     */
    public void startActivity() {
        cardUpdater.start();
    }
    
    /**
     * Pysäyttää korttien päivittäjän.
     */
    public void stopActivity() {
        cardUpdater.stopRunning();
    }
    
    /**
     * Metodi palauttaa pöydän kaikki kortit taulukkona
     * @return      integer-taulukko joka sisältää kaikki kortit.
     */
    public int[] getKortit() {
        return kortit;
    }
    
    /**
     * Metodi palauttaa pöydältä halutun kortin.
     * tilalle uuden.
     * @param kortti    Monesko kortti halutaan palauttaa
     * @return          Palauttaa kortin
     */
    public int getKortti(int kortti) {
        return kortit[kortti];
    }
    
    /**
     * Metodi päivittää pöydältä halutun kortin.
     * @param i         Monesko kortti halutaan päivittää
     * @return          Palauttaa false, jos päivitys epäonnistuu
     */
    public boolean updateKortti(int i) {
        int kortti;
        if(i >=0 && i <=2) {
            kortti = deck1.annaKortti();
            if(kortti==-1) return false;
            deck1.lisaaKortti(kortit[i]);
            kortit[i] = kortti;
        } else if(i >=3 && i <=5) {
            kortti = deck2.annaKortti();
            if(kortti==-1) return false;
            deck2.lisaaKortti(kortit[i]);
            kortit[i] = kortti;
        } else return false;
        cardUpdater.delayCardUpdate(i);
        return true;
    }
}
