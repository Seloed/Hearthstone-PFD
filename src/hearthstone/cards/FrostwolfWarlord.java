
package hearthstone.cards;

import hearthstone.Hero;
import java.util.Scanner;

public class FrostwolfWarlord extends Minions{
    
    int choice;
    Minions effectMinion;
    Scanner myKeyboard = new Scanner(System.in);
    
    public FrostwolfWarlord() {
        super(5, "Frostwolf Warlord", "Gain 1 attack and 1 defense for each friendly minion on the Battlefield");
        
        this.attack = 4;
        this.health = 4;
        this.attacksAvailable = 1;
        
    }
    
    /**
     * 
     * @param currentPlayingHero
     * @param notCurrentPlayingHero 
     */
    
    public void effect(Hero currentPlayingHero, Hero notCurrentPlayingHero) {
        
        System.out.println("Your other minions have +1 attack and +1 defense");      

        for (int i = 0; i < currentPlayingHero.myField.cardsInBattlefield.length; i++) {
            if (currentPlayingHero.myField.cardsInBattlefield[i] != null) {
                effectMinion = (Minions) currentPlayingHero.myField.cardsInBattlefield[i];
                effectMinion.setAttack(effectMinion.getAttack() + 1);
                effectMinion.setHealth(effectMinion.getHealth() + 1);
            }
        }
    }
    
}
