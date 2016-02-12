package system;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CardDatabaseTest {
    
    CardDatabase cardDatabase;
    
    @Before
    public void setUp() {
        //Samalla testaa tiedoston lukemisen; heittää errorin jos epäonnistuu
        cardDatabase = new CardDatabase();
    }
    
    @Test
    public void korttejaOnLadattu() {
        assertTrue(cardDatabase.getKorttienMaara()>0);
    }
    
    @Test
    public void kaikissaKorteissaOnJotainOminaisuuksia() {
        for(int j=0; j<cardDatabase.getKorttienMaara(); j++) {
            int[] a = cardDatabase.getCardInfo(j);
            int b=0;
            for(int i=0; i<13; i++) {
                b+=a[i];
            }
            assertTrue(b>0);
        }
    }
    
}