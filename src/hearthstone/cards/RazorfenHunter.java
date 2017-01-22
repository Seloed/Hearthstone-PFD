
package hearthstone.cards;

import hearthstone.Hero;

public class RazorfenHunter extends Minions{
    
    public RazorfenHunter() {
        super(3, "Razorfen Hunter", "Battlecry: Summon a 1 attack 1 defense Boar");
        
        this.attack = 2;
        this.health = 3;
        this.attacksAvailable = 1;        
    }
    
    /**
     * 
     * @param currentPlayingHero
     * @param notCurrentPlayingHero 
     */
    
    public void effect(Hero currentPlayingHero, Hero notCurrentPlayingHero) {
        System.out.println("\nYour RazorfenHunter summoned a Boar");
        Cards Boar = new hearthstone.cards.Boar();
        currentPlayingHero.myField.putHandCardIntoBattlefield(Boar);
    }     
}
