package system;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EnergyUpdater extends Thread {

    private volatile boolean keepRunning = true;
    private long sleep = 50, energy1updateInterval, energy2updateInterval;
    private long[] energies = new long[2];
    private long time = 0;
    private Player player1, player2;

    EnergyUpdater(Player player1, Player player2) {
        energy1updateInterval = 1500;
        energy2updateInterval = 1500;
        energies[0] = time;
        energies[1] = time;
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public void run() {
        while (keepRunning) {
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException ex) {
                Logger.getLogger(CardUpdater.class.getName()).log(Level.SEVERE, null, ex);
            }
            time += sleep;
            if (energies[0] <= time) {
                player1.changeEnergy(1);
                energies[0] = time + energy1updateInterval;
            }
            if (energies[1] <= time) {
                player2.changeEnergy(1);
                energies[1] = time + energy2updateInterval;
            }
        }
    }

    /**
     * Metodi muuttaa parametrina annetun pelaajan energiantuottotahtia.
     *
     * @param player Pelaaja jonka energiantuottoa halutaan muuttaa
     * @param maara Määrä paljonko sitä muutetaan prosentteina.
     */
    public void muutaEnergianTuotantoa(Player player, int maara) {
        double desimaalina = (100 - (double) maara) / 100;
        if (player == player1) {
            energy1updateInterval = (long) (energy1updateInterval * desimaalina + 0.5);
        } else if (player == player2) {
            energy2updateInterval = (long) (energy2updateInterval * desimaalina + 0.5);
        }
    }

    /**
     * Lopettaa energian päivittämisen.
     */
    public void stopRunning() {
        keepRunning = false;
    }
}
