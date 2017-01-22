
package hearthstone.cards;

import hearthstone.Hero;
import java.util.Scanner;

public class WaterElemental extends Minions{
    int choice;
    Minions effectMinion;
    
    Scanner myKeyboard = new Scanner(System.in);
 
    public WaterElemental() {
        super(4, "Water Elemental", "Battlecry: Freezes an enemy Minion");
        
        this.attack = 3;
        this.health = 6;
        this.attacksAvailable = 1;   
        this.damage = true;
    }
    
    public void effect(Hero currentPlayingHero, Hero notCurrentPlayingHero) {  
        System.out.println("Would you like to freeze your Minion or your enemies Minion\n1. My Minion\n2. Enemies Minion");
        choice = myKeyboard.nextInt();

        if(choice == 1) {
            System.out.println("Which Minion would you like to freeze"); 

            for (int i = 0; i < currentPlayingHero.myField.cardsInBattlefield.length; i++) {
                if (currentPlayingHero.myField.cardsInBattlefield[i] != null) {
                    System.out.println(1 + i + ". " + currentPlayingHero.myField.cardsInBattlefield[i]);
                }
            }
            choice = myKeyboard.nextInt();
            Minions attackVariable;
            attackVariable = (Minions)currentPlayingHero.myField.cardsInBattlefield[choice - 1];
            attackVariable.setAttacksAvailable(1);//Freezes the Enemy
        }

        if(choice == 2) {
            System.out.println("Which Minion would you like to freeze");

            for (int i = 0; i < notCurrentPlayingHero.myField.cardsInBattlefield.length; i++) {
                if (notCurrentPlayingHero.myField.cardsInBattlefield[i] != null) {
                    System.out.println((1 + i) + ". " + notCurrentPlayingHero.myField.cardsInBattlefield[i]);
                }
            }
            choice = myKeyboard.nextInt();
            Minions attackVariable;
            attackVariable = (Minions)notCurrentPlayingHero.myField.cardsInBattlefield[choice - 1];
            attackVariable.setAttacksAvailable(1);//Freezes the Enemy
        }
    }  
}
