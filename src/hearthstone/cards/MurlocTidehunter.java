
package hearthstone.cards;

import hearthstone.Hero;

public class MurlocTidehunter extends Minions{
    
    public MurlocTidehunter() {
        super(2, "Murloc Tidehunter", "Battlecry: Summon a 1 attack and 1 defense Murloc Scout");
        
        this.attack = 2;
        this.health = 1;
        this.attacksAvailable = 1;
        this.murloc = true;     
    }
    
    /**
     * 
     * @param currentPlayingHero
     * @param notCurrentPlayingHero 
     */
    
    public void effect(Hero currentPlayingHero, Hero notCurrentPlayingHero) {
        System.out.println("\nYour Murloc Tidehunter summoned a Murloc Scout");
        Cards MurlocScout = new hearthstone.cards.MurlocScout();
        currentPlayingHero.myField.putHandCardIntoBattlefield(MurlocScout);
    }       
}
