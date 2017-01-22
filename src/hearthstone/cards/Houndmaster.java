
package hearthstone.cards;

import hearthstone.Hero;
import java.util.Scanner;

public class Houndmaster extends Minions{
    int choice;
    Minions effectMinion;
    
    Scanner myKeyboard = new Scanner(System.in);

    public Houndmaster() {
        super(4, "Houndmaster", "Battlecry: Give a friendly beast 2 attack, 2 defense and taunt");
        
        this.attack = 4;
        this.health = 3;
        this.attacksAvailable = 1;
        this.taunt = true;
    }
    
    /**
     * 
     * @param currentPlayingHero
     * @param notCurrentPlayingHero 
     */
     
    public void effect(Hero currentPlayingHero, Hero notCurrentPlayingHero) {
        System.out.println("Which minion would you like to give 2 attack, 2 defense and taunt to");
        choice = myKeyboard.nextInt();
        
         for (int i = 0; i < currentPlayingHero.myField.cardsInBattlefield.length; i++) {
            if ((currentPlayingHero.myField.cardsInBattlefield[i] != null) && (effectMinion.getBeast() == true) && (effectMinion.getTaunt() != true)) {
                System.out.println(1 + i + ". " + currentPlayingHero.myField.cardsInBattlefield[i]);
            }
            if (effectMinion.getBeast() == true && effectMinion.getTaunt() != true) {
                choice = myKeyboard.nextInt();
                effectMinion = (Minions)currentPlayingHero.myField.cardsInBattlefield[choice - 1];
                effectMinion.setAttack(effectMinion.getAttack() + 2);
                effectMinion.setHealth(effectMinion.getHealth() + 2);
                effectMinion.setTaunt(true);
            } else {
                System.out.println("You don't have beasts that exist on the Battlefield.");
            }
        }
    }
}
