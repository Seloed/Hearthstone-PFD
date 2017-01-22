
package hearthstone.cards;

import hearthstone.Hero;
import java.util.Scanner;

public class ArcaneExplosion extends Spells {
    int choice;
    Minions effectMinion;
    
    Scanner myKeyboard = new Scanner(System.in);
    
    public ArcaneExplosion() {
        super(2, "Arcane Explosion", "Deal 1 damage to all Minions");
        this.damage = true;
    }
    
    /**
     * 
     * @param currentPlayingHero
     * @param notCurrentPlayingHero 
     */
    
    public void effect(Hero currentPlayingHero, Hero notCurrentPlayingHero) {       
        
        System.out.println("Would you like to deal 1 damage to your Minions or your enemies Minions\n1. My Minions\n2. Enemies Minions");
        choice = myKeyboard.nextInt();
        
        if(choice == 1) {
            for (int i = 0; i < currentPlayingHero.myField.cardsInBattlefield.length; i++) {               
                if (currentPlayingHero.myField.cardsInBattlefield[i] != null) {
                    effectMinion = (Minions)currentPlayingHero.myField.cardsInBattlefield[i];
                    effectMinion.setHealth(effectMinion.getHealth()-1);
                    currentPlayingHero.myField.checkAndDeleteMinion(currentPlayingHero, notCurrentPlayingHero);
                }
            }
        }
        
        if(choice == 2) {           
            for (int i = 0; i < notCurrentPlayingHero.myField.cardsInBattlefield.length; i++) {
                if (notCurrentPlayingHero.myField.cardsInBattlefield[i] != null) {
                    effectMinion = (Minions)notCurrentPlayingHero.myField.cardsInBattlefield[i];
                    effectMinion.setHealth(effectMinion.getHealth()-1);
                    notCurrentPlayingHero.myField.checkAndDeleteMinion(notCurrentPlayingHero, currentPlayingHero);
                }
            }
        }
    }    
}
