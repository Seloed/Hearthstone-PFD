
package hearthstone.cards;

import hearthstone.Hero;
import java.util.Scanner;

public class Huffer extends Minions{
    int choice;
    Minions effectMinion;
    
    Scanner myKeyboard = new Scanner(System.in);
    
    public Huffer() {
        super(3, "Huffer", "Charge");
        
        this.attack = 4;
        this.health = 2;
        this.attacksAvailable = 1;
        this.beast = true;
    }
    
    /**
     * 
     * @param currentPlayingHero
     * @param notCurrentPlayingHero 
     */
    
    public void effect(Hero currentPlayingHero, Hero notCurrentPlayingHero) {
        if(notCurrentPlayingHero.myField.cardsInBattlefield.length != 0) {
            System.out.println("Would you like to deal 4 damage to your Minion or Hero or your enemies Minion or Hero\n1. My Minion\n2. Enemies Minion\n3. My Hero\n4. Enemies Hero");
            choice = myKeyboard.nextInt();

            if(choice == 1) {
                System.out.println("Which Minion would you like to deal 4 damage to");

                for (int i = 0; i < currentPlayingHero.myField.cardsInBattlefield.length; i++) {
                    if (currentPlayingHero.myField.cardsInBattlefield[i] != null) {
                        System.out.println(1 + i + ". " + currentPlayingHero.myField.cardsInBattlefield[i]);
                    }
                }
                choice = myKeyboard.nextInt();
                effectMinion = (Minions)currentPlayingHero.myField.cardsInBattlefield[choice - 1];
                effectMinion.setHealth(effectMinion.getHealth()-4);
                currentPlayingHero.myField.checkAndDeleteMinion(currentPlayingHero, notCurrentPlayingHero);
            }

            if(choice == 2) {
                System.out.println("Which Minion would you like to deal 4 damage to");

                for (int i = 0; i < notCurrentPlayingHero.myField.cardsInBattlefield.length; i++) {
                    if (notCurrentPlayingHero.myField.cardsInBattlefield[i] != null) {
                        System.out.println((1 + i) + ". " + notCurrentPlayingHero.myField.cardsInBattlefield[i]);
                    }
                }
                choice = myKeyboard.nextInt();
                effectMinion = (Minions)notCurrentPlayingHero.myField.cardsInBattlefield[choice - 1];
                effectMinion.setHealth(effectMinion.getHealth()-4);
                notCurrentPlayingHero.myField.checkAndDeleteMinion(notCurrentPlayingHero, currentPlayingHero);
            }

            if(choice == 3) {
                currentPlayingHero.setHealth(currentPlayingHero.getHealth()-4);
            }

            if(choice == 4) {
                notCurrentPlayingHero.setHealth(notCurrentPlayingHero.getHealth()-4);
            }
        } else {
            System.out.println("Would you like to deal 4 damage to your Hero or your enemies Hero\n1. My Hero\n2. Enemies Hero");
            choice = myKeyboard.nextInt();

            if(choice == 1) {               
                currentPlayingHero.setHealth(currentPlayingHero.getHealth()-4);
            }

            if(choice == 2) {
                notCurrentPlayingHero.setHealth(notCurrentPlayingHero.getHealth()-4);              
            }
        }    
    }    
}
