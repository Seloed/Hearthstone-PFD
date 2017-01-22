
package hearthstone.cards;

import hearthstone.Hero;
import java.util.Scanner;

public class Consecration extends Spells {
    int choice;
    Minions effectMinion;
    
    Scanner myKeyboard = new Scanner(System.in);
    
    public Consecration() {
        super(4, "Consecration", "Deal 2 damage to all Minions");
    }
    
    /**
     * 
     * @param currentPlayingHero
     * @param notCurrentPlayingHero 
     */
    
    public void effect(Hero currentPlayingHero, Hero notCurrentPlayingHero) {       
        if(notCurrentPlayingHero.myField.cardsInBattlefield.length != 0) {
            System.out.println("Would you like to deal 2 damage to your Minions or your enemies Minions\n1. My Minions\n2. Enemies Minions");
            choice = myKeyboard.nextInt();

            if(choice == 1) {
                for (int i = 0; i < currentPlayingHero.myField.cardsInBattlefield.length; i++) {               
                    if (currentPlayingHero.myField.cardsInBattlefield[i] != null) {
                        effectMinion = (Minions)currentPlayingHero.myField.cardsInBattlefield[i];
                        effectMinion.setHealth(effectMinion.getHealth()-2);
                        currentPlayingHero.myField.checkAndDeleteMinion(currentPlayingHero, notCurrentPlayingHero);
                    }
                }
                currentPlayingHero.setHealth(currentPlayingHero.getHealth()-2);
            }

            if(choice == 2) {           
                for (int i = 0; i < notCurrentPlayingHero.myField.cardsInBattlefield.length; i++) {
                    if (notCurrentPlayingHero.myField.cardsInBattlefield[i] != null) {
                        effectMinion = (Minions)notCurrentPlayingHero.myField.cardsInBattlefield[i];
                        effectMinion.setHealth(effectMinion.getHealth()-2);
                        notCurrentPlayingHero.myField.checkAndDeleteMinion(notCurrentPlayingHero, currentPlayingHero);
                    }
                }
            }
            notCurrentPlayingHero.setHealth(notCurrentPlayingHero.getHealth()-2);
        } else {
            System.out.println("Would you like to deal 2 damage to your Hero or your enemies Hero\n1. My Hero\n2. Enemies Hero");
            choice = myKeyboard.nextInt();

            if(choice == 1) {               
                currentPlayingHero.setHealth(currentPlayingHero.getHealth()-2);
            }

            if(choice == 2) {
                notCurrentPlayingHero.setHealth(notCurrentPlayingHero.getHealth()-2);              
            }
        }    
    }       
}
