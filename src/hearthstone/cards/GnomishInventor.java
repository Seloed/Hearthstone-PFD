
package hearthstone.cards;

import hearthstone.Hero;

public class GnomishInventor extends Minions{
    
    public GnomishInventor() {
        super(4, "Gnomish Inventor", "Battlecry: Draw a Card");
        
        this.attack = 2;
        this.health = 4;
        this.attacksAvailable = 1;       
    }
    
    /**
     * 
     * @param currentPlayingHero
     * @param notCurrentPlayingHero 
     */
    
    public void effect(Hero currentPlayingHero, Hero notCurrentPlayingHero) {
        System.out.println("\nBattlecry: Draw a card ");
        currentPlayingHero.drawACard();
    }
    
}
