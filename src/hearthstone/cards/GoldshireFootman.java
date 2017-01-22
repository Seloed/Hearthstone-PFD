
package hearthstone.cards;

import hearthstone.Hero;

public class GoldshireFootman extends Minions{
    Minions effectMinion;
    
    public GoldshireFootman() {
        super(1, "Goldshire Footman", "Taunt");
        
        this.attack = 1;
        this.health = 2;
        this.attacksAvailable = 1;
        this.taunt = true;        
    }
     
    /**
     * 
     * @param currentPlayingHero
     * @param notCurrentPlayingHero 
     */
    
    public void effect(Hero currentPlayingHero, Hero notCurrentPlayingHero) {
     
    }   
}
