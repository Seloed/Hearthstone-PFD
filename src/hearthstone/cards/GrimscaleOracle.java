package hearthstone.cards;

import hearthstone.Hero;
import java.util.Scanner;

public class GrimscaleOracle extends Minions {
    int choice;
    Minions effectMinion;
    
    Scanner myKeyboard = new Scanner(System.in);

    public GrimscaleOracle() {
        super(1, "Grimscale Oracle", "All other murlocks have +1 attack");

        this.attack = 1;
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
        for (int i = 0; i < currentPlayingHero.myField.cardsInBattlefield.length; i++) {
            effectMinion = (Minions) currentPlayingHero.myField.cardsInBattlefield[i];
            if (effectMinion.getMurloc() == true) {
                effectMinion.setAttack(effectMinion.getAttack() + 1);
            } else {
                System.out.println("You don't have a murlocs exist on the Battlefield.");
            }
        }
    }
}
