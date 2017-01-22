
package hearthstone.cards;

import hearthstone.Hero;
import java.util.Scanner;

public class ShatteredSunCleric extends Minions{
    
    int choice;
    Minions effectMinion;
    
    Scanner myKeyboard = new Scanner(System.in);

    
    public ShatteredSunCleric() {
        super(3, "Shattered Sun Cleric", "Battlecry: Give a friendly minion +1 attack and +1 defense");
        this.attack = 3;
        this.health = 2;
        this.attacksAvailable = 1;     
    }
    
    /**
     * 
     * @param currentPlayingHero
     * @param notCurrentPlayingHero 
     */
    
    public void effect(Hero currentPlayingHero, Hero notCurrentPlayingHero) {
        System.out.println("Which Minion would you like to give +1 attack and +1 defense to");

        for (int i = 0; i < currentPlayingHero.myField.cardsInBattlefield.length; i++) {
            if (currentPlayingHero.myField.cardsInBattlefield[i] != null) {
                System.out.println(1 + i + ". " + currentPlayingHero.myField.cardsInBattlefield[i]);
            }
        }
        choice = myKeyboard.nextInt();
        effectMinion = (Minions) currentPlayingHero.myField.cardsInBattlefield[choice - 1];
        effectMinion.setAttack(effectMinion.getAttack() + 1);
        effectMinion.setHealth(effectMinion.getHealth() + 1);
    }
}
