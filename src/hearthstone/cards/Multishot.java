
package hearthstone.cards;

import hearthstone.Hero;
import java.util.Random;
import java.util.Scanner;

public class Multishot extends Spells {
    int choice;
    int randomCard;
    Minions effectMinion;
    
    Scanner myKeyboard = new Scanner(System.in);
    Random RNG = new Random();
    
    public Multishot() {
        super(4, "Multi-Shot", "Deal 3 damage to a Minion and the Hero");
    }
    
    /**
     * 
     * @param currentPlayingHero
     * @param notCurrentPlayingHero 
     */
    
    public void effect(Hero currentPlayingHero, Hero notCurrentPlayingHero) {       
        
        System.out.println("Would you like to deal 3 damage to your Minion and Hero or your enemies Minion and Hero\n1. My Minion and Hero\n2. Enemies Minion and Hero");
        choice = myKeyboard.nextInt();
        
        if(notCurrentPlayingHero.myField.cardsInBattlefield.length != 0) {
            if(choice == 1) {
                randomCard = RNG.nextInt(currentPlayingHero.myField.cardsInBattlefield.length);

                effectMinion = (Minions)currentPlayingHero.myField.cardsInBattlefield[randomCard];
                effectMinion.setHealth(effectMinion.getHealth()-3);
                currentPlayingHero.setHealth(currentPlayingHero.getHealth()-3);
                currentPlayingHero.myField.checkAndDeleteMinion(currentPlayingHero, notCurrentPlayingHero);
            }

            if(choice == 2) {
                randomCard = RNG.nextInt(notCurrentPlayingHero.myField.cardsInBattlefield.length);

                effectMinion = (Minions)notCurrentPlayingHero.myField.cardsInBattlefield[randomCard];
                effectMinion.setHealth(effectMinion.getHealth()-3);
                notCurrentPlayingHero.setHealth(notCurrentPlayingHero.getHealth()-3);
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
