
package hearthstone.cards;

import hearthstone.Hero;

public class ManaCoin extends Spells {
    
     public ManaCoin() {
        super(0, "Mana Coin", "Gives +1 Mana");
        
        cost = 0;
    }
     
    public void effect (Hero currentPlayingHero, Hero notCurrentPlayingHero) {
        currentPlayingHero.setMana(currentPlayingHero.getMana() + 1);
    }
}
