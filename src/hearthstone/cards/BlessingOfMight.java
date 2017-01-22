package hearthstone.cards;

import hearthstone.Hero;
import java.util.Scanner;

public class BlessingOfMight extends Spells {
    int choice;
    Minions effectMinion;
    
    Scanner myKeyboard = new Scanner(System.in);

    public BlessingOfMight() {
        super(1, "Blessing of Might", "Give a Minion +3 attack");
    }
    
    /**
     * 
     * @param currentPlayingHero
     * @param notCurrentPlayingHero 
     */
    
    public void effect(Hero currentPlayingHero, Hero notCurrentPlayingHero) {       
        
        System.out.println("Would you like to give +3 attack to your Minion or your enemies Minion\n1. My Minion\n2. Enemies Minion");
        choice = myKeyboard.nextInt();
        
        if(choice == 1) {
            System.out.println("Which Minion would you like to give +3 attack to");
            
            for (int i = 0; i < currentPlayingHero.myField.cardsInBattlefield.length; i++) {
                if (currentPlayingHero.myField.cardsInBattlefield[i] != null) {
                    System.out.println(1 + i + ". " + currentPlayingHero.myField.cardsInBattlefield[i]);
                }
            }    
            choice = myKeyboard.nextInt();
            effectMinion = (Minions)currentPlayingHero.myField.cardsInBattlefield[choice - 1];
            effectMinion.setAttack(effectMinion.getAttack()+3);
        }
        
        if(choice == 2) {
            System.out.println("Which Minion would you like to give +3 attack to");
            
            for (int i = 0; i < notCurrentPlayingHero.myField.cardsInBattlefield.length; i++) {
                if (notCurrentPlayingHero.myField.cardsInBattlefield[i] != null) {
                    System.out.println((1 + i) + ". " + notCurrentPlayingHero.myField.cardsInBattlefield[i]);
                }
            }    
            choice = myKeyboard.nextInt();
            effectMinion = (Minions)notCurrentPlayingHero.myField.cardsInBattlefield[choice - 1];
            effectMinion.setAttack(effectMinion.getAttack()+3);
        }
    }
}
