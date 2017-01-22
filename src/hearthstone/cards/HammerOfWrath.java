
package hearthstone.cards;

import hearthstone.Hero;
import java.util.Scanner;

public class HammerOfWrath extends Spells {
    int choice;
    Minions effectMinion;
    
    Scanner myKeyboard = new Scanner(System.in);
    
    public HammerOfWrath() {
        super(4, "Hammer of Wrath", "Deal 3 damage and draw a card");   
    }
    
    /**
     * 
     * @param currentPlayingHero
     * @param notCurrentPlayingHero 
     */
    
    public void effect(Hero currentPlayingHero, Hero notCurrentPlayingHero) {       
        
        currentPlayingHero.drawACard();
        if(notCurrentPlayingHero.myField.cardsInBattlefield.length != 0) {
            System.out.println("Would you like to deal 3 damage to your Minion or your enemies Minion\n1. My Minion\n2. Enemies Minion");
            choice = myKeyboard.nextInt();

            if(choice == 1) {
                System.out.println("Which Minion would you like to deal 3 damage to");

                for (int i = 0; i < currentPlayingHero.myField.cardsInBattlefield.length; i++) {
                    if (currentPlayingHero.myField.cardsInBattlefield[i] != null) {
                        System.out.println(1 + i + ". " + currentPlayingHero.myField.cardsInBattlefield[i]);
                    }
                }
                choice = myKeyboard.nextInt();
                effectMinion = (Minions)currentPlayingHero.myField.cardsInBattlefield[choice - 1];
                effectMinion.setHealth(effectMinion.getHealth()-3);
                currentPlayingHero.myField.checkAndDeleteMinion(currentPlayingHero, notCurrentPlayingHero);
            }

            if(choice == 2) {
                System.out.println("Which Minion would you like to deal 3 damage to");

                for (int i = 0; i < notCurrentPlayingHero.myField.cardsInBattlefield.length; i++) {
                    if (notCurrentPlayingHero.myField.cardsInBattlefield[i] != null) {
                        System.out.println((1 + i) + ". " + notCurrentPlayingHero.myField.cardsInBattlefield[i]);
                    }
                }
                choice = myKeyboard.nextInt();
                effectMinion = (Minions)notCurrentPlayingHero.myField.cardsInBattlefield[choice - 1];
                effectMinion.setHealth(effectMinion.getHealth()-3);
                notCurrentPlayingHero.myField.checkAndDeleteMinion(notCurrentPlayingHero, currentPlayingHero);
            }
        } else {
            System.out.println("Would you like to deal 3 damage to your Hero or your enemies Hero\n1. My Hero\n2. Enemies Hero");
            choice = myKeyboard.nextInt();

            if(choice == 1) {               
                currentPlayingHero.setHealth(currentPlayingHero.getHealth()-3);
            }

            if(choice == 2) {
                notCurrentPlayingHero.setHealth(notCurrentPlayingHero.getHealth()-3);              
            }
        }    
    }       
}
