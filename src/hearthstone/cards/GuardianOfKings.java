
package hearthstone.cards;

import hearthstone.Hero;

public class GuardianOfKings extends Minions{
    
    public GuardianOfKings() {
        super(7, "Guardian of Kings", "Battlecry: Restore 6 health to your Hero");
        
        this.attack = 5;
        this.health = 6;
        this.attacksAvailable = 1;
    }
    
    /**
     * 
     * @param currentPlayingHero
     * @param notCurrentPlayingHero 
     */
    
    public void effect(Hero currentPlayingHero, Hero notCurrentPlayingHero) {
        System.out.println("\nBattlecry: Restore 6 health ");
        currentPlayingHero.setHealth(currentPlayingHero.getHealth()+6);
        
        if(currentPlayingHero.getHealth() >= 30) {
            currentPlayingHero.setHealth(30);
        }       
    }   
}
