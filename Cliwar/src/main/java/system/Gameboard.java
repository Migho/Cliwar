package system;

/**
 * Luokka huolehtii korttien aktivoinnista aiheutuvista muutoksista.
 */
public class Gameboard {
    private final Player player1, player2;
    private final CardDatabase cardDatabase = new CardDatabase();
    private final EnergyUpdater energyUpdater;
    
    public Gameboard() {
        player1 = new Player();
        player2 = new Player();
        energyUpdater = new EnergyUpdater(player1, player2);
    }
    
    public void startActivity() {
        energyUpdater.start();
    }
    
    /**
     * Metodi aktivoi kortin, jonka ID vastaa syötteessä annettua lukua id.
     * 
     * @param id        Kortin ID, joka halutaan aktivoida peliin.
     * @param player    Pelaaja (yksi tai kaksi), joka kortin aktivoi.
     * @return          Palauttaa false, jos korttia ei voida pelata.
     */
    public boolean activateCard(int id, int player) {
        int[] info = cardDatabase.getCardInfo(id);
        Player pelaaja, vihu;
        if(player==1) {
            pelaaja = player1;
            vihu = player2;
        }
        else if(player==2) {
            pelaaja = player2;
            vihu = player1;
        }
        else return false;
        if(!pelaaja.changeEnergy(info[0])) return false;
        if(info[1] > 0) vihu.dealDamage(1, info[1]);
        if(info[2] > 0) pelaaja.dealDamage(1, info[2]);
        if(info[3] > 0) vihu.dealDamage(2, info[3]);
        if(info[4] > 0) pelaaja.dealDamage(2, info[4]);
        if(info[5] > 0) vihu.dealDamage(3, info[5]);
        if(info[6] > 0) pelaaja.dealDamage(3, info[6]);
        vihu.changeArmor(info[7]);
        pelaaja.changeArmor(info[8]);
        vihu.changeMagicResistance(info[9]);
        pelaaja.changeMagicResistance(info[10]);
        //puuttuu vielä energy/s!!!1
        
        return true;
    }
    
    /**
     * Palauttaa halutun pelaajan.
     * @param player    1=pelaaja1, 2=pelaaja2
     * @return          palauttaa valitun pelaajan.
     */
    public Player getPlayer(int player) {
        if(player==1) return player1;
        if(player==2) return player2;
        else return null;
    }
    
    /**
     * Palauttaa halutun pelaajan statistiikat.
     * @param player    1=pelaaja1, 2=pelaaja2
     * @return          palauttaa valitun pelaajan statistiikat taulussa.
     */
    public int[] getPlayerInfo(int player) {
        if(player==1) return player1.getStats();
        if(player==2) return player2.getStats();
        return null;
    }
}
