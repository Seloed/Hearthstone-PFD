
package hearthstone.cards;

import hearthstone.Hero;

public class MirrorImage extends Spells {
    Minions effectMinion;
    
    public MirrorImage() {
        super(1, "Mirror Image", "Summons a minion with 0 attack 2 defense and taunt effect");
    }
    
    /**
     * 
     * @param currentPlayingHero
     * @param notCurrentPlayingHero 
     */
    
    public void effect(Hero currentPlayingHero, Hero notCurrentPlayingHero) {       
        effectMinion = new MirrorImageMinion();
        currentPlayingHero.myField.putHandCardIntoBattlefield(effectMinion);       
    }   
}
