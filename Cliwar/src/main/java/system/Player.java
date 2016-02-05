package system;

public class Player {
    int hp, armor, mResistance, energy, maxEnergy;
    final int maxHp=30;
    
    public Player() {
        hp=25;
        armor=1;
        mResistance=0;
        energy=0;
        maxEnergy=20;
    }
    
    public void dealDamage(int damageType, int damage) {
        if(damageType==1)
            if(armor<damage) hp-=damage-armor;
        if(damageType==2)
            if(mResistance<damage) hp-=damage-mResistance;
        if(damageType==3)
            hp-=damage;
        if(hp<=0)
            killPlayer();
    }
    
    public void addHp(int i) {
        hp+=i;
        if(hp>maxHp) hp=maxHp;
    }
    
    public void changeArmor(int i) {
        armor+=i;
    }
    
    public void changeMagicResistance(int i) {
        mResistance+=i;
    }
    
    public boolean changeEnergy(int i) {
        energy+=i;
        if(energy<0) {
            energy-=i;
            return false;
        }
        if(energy>maxEnergy) energy=maxEnergy;
        return true;
    }
    
    private void killPlayer() {
        //not yet implemented
    }
    
    public int[] getStats() {
        int[] a = {hp, armor, mResistance, energy, maxEnergy};
        return a;
    }
    
    
    
}
