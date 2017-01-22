
package hearthstone.cards;

import hearthstone.Hero;

public class TimberWolf extends Minions{   
    Minions effectMinion;
    
    public TimberWolf() {
        super(1, "Timber Wolf", "Battlecry: Your other beasts have +1 attack");
        
        this.attack = 1;
        this.health = 1;
        this.attacksAvailable = 1;
        this.beast = true;
    }   
    
    /**
     * 
     * @param currentPlayingHero
     * @param notCurrentPlayingHero 
     */
    
    public void effect(Hero currentPlayingHero, Hero notCurrentPlayingHero) {
        for (int i = 0; i < currentPlayingHero.myField.cardsInBattlefield.length; i++) {
            effectMinion = (Minions) currentPlayingHero.myField.cardsInBattlefield[i];
            if (effectMinion.getBeast() == true) {
                effectMinion.setAttack(effectMinion.getAttack() + 1);
                System.out.println("The beasts exist on the battle field just gained +1 attack");          
            }
        }
    }
}
