
package hearthstone.cards;

import hearthstone.Hero;
import java.util.Scanner;

public class Polymorph extends Spells {
    int choice;
    Minions effectMinion;
    Minions bufferEffectMinion;
    
    Scanner myKeyboard = new Scanner(System.in);
    
    public Polymorph() {
        super(4, "Polymorph", "Transform a Minion into a 1 attack 1 defense sheep");
        this.damage = true;
    }
    
    /**
     * 
     * @param currentPlayingHero
     * @param notCurrentPlayingHero 
     */
    
    public void effect(Hero currentPlayingHero, Hero notCurrentPlayingHero) {       
        
        System.out.println("Would you like to transform your Minion or your enemies Minion into a sheep\n1. My Minion\n2. Enemies Minion");
        choice = myKeyboard.nextInt();
        
        if(choice == 1) {
            System.out.println("Which Minion would you like to transform");
            
            for (int i = 0; i < currentPlayingHero.myField.cardsInBattlefield.length; i++) {
                if (currentPlayingHero.myField.cardsInBattlefield[i] != null) {
                    System.out.println(1 + i + ". " + currentPlayingHero.myField.cardsInBattlefield[i]);
                }
            }
            choice = myKeyboard.nextInt();
            effectMinion = new Sheep();
            currentPlayingHero.myField.cardsInBattlefield[choice - 1] = effectMinion;
        }
        
        if(choice == 2) {
            System.out.println("Which Minion would you like to transform");
            
            for (int i = 0; i < notCurrentPlayingHero.myField.cardsInBattlefield.length; i++) {
                if (notCurrentPlayingHero.myField.cardsInBattlefield[i] != null) {
                    System.out.println((1 + i) + ". " + notCurrentPlayingHero.myField.cardsInBattlefield[i]);
                }
            }
            choice = myKeyboard.nextInt();
            effectMinion = new Sheep();
            notCurrentPlayingHero.myField.cardsInBattlefield[choice - 1] = effectMinion;
        }
    }
    
}
