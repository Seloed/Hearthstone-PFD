
package hearthstone.cards;

import hearthstone.Hero;
import java.util.Scanner;

public class HuntersMark extends Spells {
    int choice;
    Minions effectMinion;

    Scanner myKeyboard = new Scanner(System.in);
    
    public HuntersMark() {
        super(1, "Hunters Mark", "Change a Minions defense to 1");
        this.damage = true;
    } 
    
    /**
     * 
     * @param currentPlayingHero
     * @param notCurrentPlayingHero 
     */
    
    public void effect(Hero currentPlayingHero, Hero notCurrentPlayingHero) {       
        
        System.out.println("Would you like to change a Minions defense to 1 for your Minion or your enemies Minion\n1. My Minion\n2. Enemies Minion");
        choice = myKeyboard.nextInt();
        
        if(choice == 1) {
            System.out.println("Which Minion would you like to change their defense to 1");
            
            for (int i = 0; i < currentPlayingHero.myField.cardsInBattlefield.length; i++) {
                if (currentPlayingHero.myField.cardsInBattlefield[i] != null) {
                    System.out.println(1 + i + ". " + currentPlayingHero.myField.cardsInBattlefield[i]);
                }
            }
            choice = myKeyboard.nextInt();
            effectMinion = (Minions)currentPlayingHero.myField.cardsInBattlefield[choice - 1];
            effectMinion.setHealth(1);
        }
        
        if(choice == 2) {
            System.out.println("Which Minion would you like to change their defense to 1");
            
            for (int i = 0; i < notCurrentPlayingHero.myField.cardsInBattlefield.length; i++) {
                if (notCurrentPlayingHero.myField.cardsInBattlefield[i] != null) {
                    System.out.println((1 + i) + ". " + notCurrentPlayingHero.myField.cardsInBattlefield[i]);
                }
            }
            choice = myKeyboard.nextInt();
            effectMinion = (Minions)notCurrentPlayingHero.myField.cardsInBattlefield[choice - 1];
            effectMinion.setHealth(1);
        }
    }
}
