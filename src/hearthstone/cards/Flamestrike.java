
package hearthstone.cards;

import hearthstone.Hero;

public class Flamestrike extends Spells {
    Minions effectMinion;
    
    public Flamestrike() {
        super(7, "Flamestrike", "Deal 4 damage to all enemy Minions");
        this.damage = true;
    }
    
    /**
     *
     * @param currentPlayingHero
     * @param notCurrentPlayingHero 
     */
    
    public void effect(Hero currentPlayingHero, Hero notCurrentPlayingHero) {                
        for (int i = 0; i < notCurrentPlayingHero.myField.cardsInBattlefield.length; i++) {               
            if (notCurrentPlayingHero.myField.cardsInBattlefield[i] != null) {
                effectMinion = (Minions)notCurrentPlayingHero.myField.cardsInBattlefield[i];
                effectMinion.setHealth(effectMinion.getHealth()-4);
                notCurrentPlayingHero.myField.checkAndDeleteMinion(notCurrentPlayingHero, currentPlayingHero);
            }
        }
        notCurrentPlayingHero.myField.checkAndDeleteMinion(notCurrentPlayingHero, currentPlayingHero);
    }        
}
