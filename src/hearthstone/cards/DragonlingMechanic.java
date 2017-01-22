
package hearthstone.cards;

import hearthstone.Hero;

public class DragonlingMechanic extends Minions{
    
    public DragonlingMechanic() {
        super(4, "Dragonling Mechanic", "Summon a 2 attack 1 defense Mechanical Dragonling");
        
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
        System.out.println("\nYour Dragonling Mechanic summoned a Mechanical Dragonling");
        Cards MechanicalDragonling = new hearthstone.cards.MechanicalDragonling();
        currentPlayingHero.myField.putHandCardIntoBattlefield(MechanicalDragonling);
    }    
    
}
