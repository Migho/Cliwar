package system;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Luokka päivittää automaattisesti luokan Table kortteja.
 */

public class CardUpdater extends Thread {
    
    private Table table;
    private volatile long cards[] = new long[6];
    private volatile boolean keepRunning=true;
    private final long sleep=100, updateInterval=3000;
    private long time=0;
    
    CardUpdater(Table table) {
        this.table = table;
        cards[0]=1000;
        cards[1]=2000;
        cards[2]=3000;
        cards[3]=1000;
        cards[4]=2000;
        cards[5]=3000;
    }
    
    @Override
    public void run() {
        while(keepRunning) {
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException ex) {
                Logger.getLogger(CardUpdater.class.getName()).log(Level.SEVERE, null, ex);
            }
            time+=sleep;
            for(int i=0; i<cards.length; i++) {
                if(cards[i]<=time) {
                    table.updateKortti(i);
                    cards[i]=time+updateInterval;
                }
            }
        }
    }
    
    public void delayCardUpdate(int i) {
        if(i<0 || i>=6) return;
        cards[i]=time+updateInterval;
    }
    
    public void stopRunning() {
        keepRunning=false;
    }
}
