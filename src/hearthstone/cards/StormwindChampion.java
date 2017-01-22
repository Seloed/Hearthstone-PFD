
package hearthstone.cards;

import hearthstone.Hero;
import java.util.Scanner;

public class StormwindChampion extends Minions{  
    int choice;
    Minions effectMinion;
    
    Scanner myKeyboard = new Scanner(System.in);
    
    public StormwindChampion() {
        super(7, "Stormwind Champion", "Battlecry: Your other minions have +1 attack and +1 defense");
        
        this.attack = 6;
        this.health = 6;
        this.attacksAvailable = 1;
    }
    
    /**
     * 
     * @param currentPlayingHero
     * @param notCurrentPlayingHero 
     */
    
    public void effect(Hero currentPlayingHero, Hero notCurrentPlayingHero) {
        System.out.println("Your other minions have +1 attack and +1 defense effect");      

        for (int i = 0; i < currentPlayingHero.myField.cardsInBattlefield.length; i++) {
            if (currentPlayingHero.myField.cardsInBattlefield[i] != null) {
                effectMinion = (Minions) currentPlayingHero.myField.cardsInBattlefield[i];
                effectMinion.setAttack(effectMinion.getAttack() + 1);
                effectMinion.setHealth(effectMinion.getHealth() + 1);
            }
        }
    }
}
