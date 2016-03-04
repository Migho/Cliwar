package system;

public class Player {

    private int hp, armor, mResistance, energy, maxEnergy;
    private final int maxHp = 30;

    /**
     * Luokka pitää kirjaa pelaajan statistiikasta.
     */
    public Player() {
        hp = 30;
        armor = 1;
        mResistance = 0;
        energy = 10;
        maxEnergy = 20;
    }

    /**
     * Metodi tekee vahinkoa pelaajalle.
     *
     * @param damageType    1=physical, 2=magical, 3=pure
     * @param damage        Aiheutettavan vahingon määrä
     * @return palauttaa true jos pelaaja kuolee vammoihin
     */
    public boolean dealDamage(int damageType, int damage) {
        if (damageType == 1) {
            if (armor < damage) {
                hp -= damage - armor;
            }
        }
        if (damageType == 2) {
            if (mResistance < damage) {
                hp -= damage - mResistance;
            }
        }
        if (damageType == 3) {
            hp -= damage;
        }
        if (hp <= 0) {
            return true;
        }
        return false;
    }

    /**
     * Lisää HP-arvoa (tai vähentää, mutta vahingon tekemiseen on tarkoitus
     * käyttää dealDamage -metodia).
     *
     * @param i Halutun muutoksen määrä
     */
    public void addHp(int i) {
        hp += i;
        if (hp > maxHp) {
            hp = maxHp;
        }
    }

    /**
     * Muuttaa pelaajan armorin määrää, eli lisää tai vähentää.
     *
     * @param i Halutun muutoksen määrä
     */
    public void changeArmor(int i) {
        armor += i;
    }

    /**
     * Muuttaa pelaajan magic resistancea, eli lisää tai vähentää.
     *
     * @param i Halutun muutoksen määrä
     */
    public void changeMagicResistance(int i) {
        mResistance += i;
    }

    /**
     * Muuttaa pelaajan energian määrää, muttei koskaan negatiiviseksi.
     *
     * @param i Halutun muutoksen määrä
     * @return Palauttaa false jos energia menisi operaation jälkeen
     * negatiiviseksi.
     */
    public boolean changeEnergy(int i) {
        energy += i;
        if (energy < 0) {
            energy -= i;
            return false;
        }
        if (energy > maxEnergy) {
            energy = maxEnergy;
        }
        return true;
    }

    /**
     * Metodi palauttaa tämän pelaajan statistiikat.
     * @return Palauttaa taulun, jossa on pelaajan statistiikat.
     */
    public int[] getStats() {
        int[] a = {hp, armor, mResistance, energy, maxEnergy};
        return a;
    }

}
