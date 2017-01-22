
package hearthstone.cards;

import hearthstone.Hero;
import java.util.Random;
import java.util.Scanner;

public class AnimalCompanion extends Spells {
    int choice;
    int randomCard;
    Minions effectMinion;
    
    Random RNG = new Random();
    Scanner myKeyboard = new Scanner(System.in);
    
    public AnimalCompanion() {
        super(3, "Animal Companion", "Summon a random beast companion");
    }
    
    /**
     * 
     * @param currentPlayingHero
     * @param notCurrentPlayingHero 
     */
    
    public void effect(Hero currentPlayingHero, Hero notCurrentPlayingHero) {       
        
        System.out.println("Would you like to summon a beast companion for you or your enemy\n1. Me\n2. My Enemy");
        choice = myKeyboard.nextInt();
        
        if(choice == 1) {
            randomCard = RNG.nextInt(3);
            
            if(randomCard == 0) {
                Minions effectMinion = new Misha();
                currentPlayingHero.myField.putHandCardIntoBattlefield(effectMinion);
            }
            
            if(randomCard == 1) {
                Minions effectMinion = new Leokk();
                currentPlayingHero.myField.putHandCardIntoBattlefield(effectMinion);
            }
            
            if(randomCard == 2) {
                Minions effectMinion = new Huffer();
                currentPlayingHero.myField.putHandCardIntoBattlefield(effectMinion);
            }
        }
        
        if(choice == 2) {
            randomCard = RNG.nextInt(3);
            
            if(randomCard == 0) {
                Minions effectMinion = new Misha();
                notCurrentPlayingHero.myField.putHandCardIntoBattlefield(effectMinion);
            }
            
            if(randomCard == 1) {
                Minions effectMinion = new Leokk();
                notCurrentPlayingHero.myField.putHandCardIntoBattlefield(effectMinion);
            }
            
            if(randomCard == 2) {
                Minions effectMinion = new Huffer();
                notCurrentPlayingHero.myField.putHandCardIntoBattlefield(effectMinion);
            }
        }
    }
    
}
