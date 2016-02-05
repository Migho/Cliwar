package system;


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
    
    public void startActivity() {
        cardUpdater.start();
    }
    
    public void stopActivity() {
        cardUpdater.stopRunning();
    }
    
    public int[] getKortit() {
        return kortit;
    }
    
    public int getKortti(int i) {
        return kortit[i];
    }
    
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
