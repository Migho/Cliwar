package system;

public class Gameboard {

    private final Player player1, player2;
    private final CardDatabase cardDatabase = new CardDatabase();
    private final EnergyUpdater energyUpdater;
    private final Controller controller;

    /**
     * Luokka huolehtii korttien aktivoinnista aiheutuvista muutoksista.
     *
     * @param controller Kontrolleri, jolle luokka viestii pelin päättymisen
     */
    public Gameboard(Controller controller) {
        this.controller = controller;
        player1 = new Player();
        player2 = new Player();
        energyUpdater = new EnergyUpdater(player1, player2);
    }

    /**
     * Aloita energian automaattinen regeneroituminen.
     */
    public void startActivity() {
        energyUpdater.start();
    }

    /**
     * Metodi aktivoi kortin, jonka ID vastaa syötteessä annettua lukua id.
     *
     * @param id Kortin ID, joka halutaan aktivoida peliin.
     * @param player Pelaaja (yksi tai kaksi), joka kortin aktivoi.
     * @return Palauttaa false, jos korttia ei voida pelata.
     */
    public boolean activateCard(int id, int player) {
        int[] info = cardDatabase.getCardInfo(id);
        Player pelaaja, vihu;
        if (player == 1) {
            pelaaja = player1;
            vihu = player2;
        } else if (player == 2) {
            pelaaja = player2;
            vihu = player1;
        } else {
            return false;
        }
        if (!pelaaja.changeEnergy(info[0])) {
            return false;
        }

        for (int i = 2; i <= 6; i = i + 2) {
            if (info[i - 1] != 0) {
                if (vihu.dealDamage(i / 2, info[i - 1])) {
                    lopetaPeli();
                }
            }
            if (info[i] != 0) {
                if (pelaaja.dealDamage(i / 2, info[i])) {
                    lopetaPeli();
                }
            }
        }

        vihu.changeArmor(info[7]);
        pelaaja.changeArmor(info[8]);
        vihu.changeMagicResistance(info[9]);
        pelaaja.changeMagicResistance(info[10]);
        energyUpdater.muutaEnergianTuotantoa(vihu, info[11]);
        energyUpdater.muutaEnergianTuotantoa(pelaaja, info[12]);

        return true;
    }

    /**
     * Palauttaa halutun pelaajan.
     *
     * @param player 1=pelaaja1, 2=pelaaja2
     * @return palauttaa valitun pelaajan.
     */
    public Player getPlayer(int player) {
        if (player == 1) {
            return player1;
        }
        if (player == 2) {
            return player2;
        } else {
            return null;
        }
    }

    /**
     * Palauttaa halutun pelaajan statistiikat.
     *
     * @param player 1=pelaaja1, 2=pelaaja2
     * @return palauttaa valitun pelaajan statistiikat taulussa.
     */
    public int[] getPlayerInfo(int player) {
        if (player == 1) {
            return player1.getStats();
        }
        if (player == 2) {
            return player2.getStats();
        }
        return null;
    }

    private void lopetaPeli() {
        energyUpdater.stopRunning();
        controller.lopetaPeli();
    }
}
