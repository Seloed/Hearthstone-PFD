
package hearthstone.cards;

import hearthstone.Hero;

public class ArcaneIntellect extends Spells {
    
    public ArcaneIntellect() {
        super(3, "Arcane Intellect", "Draw 2 cards");
    }
    
    /**
     * 
     * @param currentPlayingHero
     * @param notCurrentPlayingHero 
     */
    
    public void effect(Hero currentPlayingHero, Hero notCurrentPlayingHero) {   
        for(int i=0; i<2; i++) {
            currentPlayingHero.drawACard();
            currentPlayingHero.myDeck.getListOfCards();
        }
    }   
}
