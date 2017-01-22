
package hearthstone.cards;

import hearthstone.Hero;
import java.util.Scanner;

public class Leokk extends Minions{
    int choice;
    Minions effectMinion;
    
    Scanner myKeyboard = new Scanner(System.in);
    
    public Leokk() {
        super(3, "Leokk", "Battlecry: Other friendly minions have +1 attack ");
        
        this.attack = 4;
        this.health = 4;
        this.attacksAvailable = 1;
        this.beast = true;
        //Token
        //Battlecry: Other friendly minions have +1 Attack. 
    }
    
    /**
     * 
     * @param currentPlayingHero
     * @param notCurrentPlayingHero 
     */
    
    public void effect(Hero currentPlayingHero, Hero notCurrentPlayingHero) {

        System.out.println("Your friendly minions have +1 attack ");

        for (int i = 0; i < currentPlayingHero.myField.cardsInBattlefield.length; i++) {
            if (currentPlayingHero.myField.cardsInBattlefield[i] != null) {
                effectMinion = (Minions) currentPlayingHero.myField.cardsInBattlefield[i];
                effectMinion.setAttack(effectMinion.getAttack() + 1);
            }
        }
    }
    
}
