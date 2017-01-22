
package hearthstone.cards;

import hearthstone.Hero;
import java.util.Random;
import java.util.Scanner;

public class ArcaneMissiles extends Spells {
    int choice;
    int randomCard;
    Minions effectMinion;
    
    Scanner myKeyboard = new Scanner(System.in);
    Random RNG = new Random();
    
    public ArcaneMissiles() {
        super(1, "Arcane Missiles", "Deal 3 damage randomly split among all enemies");  
    }
    
    /**
     * 
     * @param currentPlayingHero
     * @param notCurrentPlayingHero 
     */
    
    public void effect(Hero currentPlayingHero, Hero notCurrentPlayingHero) {       
        
        System.out.println("Would you like to deal 3 damage split among Enemies to your Minion and Hero or your enemies Minion and Hero\n1. My Minion and Hero\n2. Enemies Minion and Hero");
        choice = myKeyboard.nextInt();
        
        if(choice == 1) {
            for(int i=0; i<3; i++) {
                randomCard = RNG.nextInt(currentPlayingHero.myField.cardsInBattlefield.length + 1);
                
                if(currentPlayingHero.myField.cardsInBattlefield.length == 0) { 
                    currentPlayingHero.setHealth(currentPlayingHero.getHealth()-1);
                } else if(currentPlayingHero.myField.cardsInBattlefield.length != 0){
                    if(randomCard == currentPlayingHero.myField.cardsInBattlefield.length + 1) {
                        currentPlayingHero.setHealth(currentPlayingHero.getHealth()-1);
                    } else {
                        if(randomCard != 0) {
                            effectMinion = (Minions)currentPlayingHero.myField.cardsInBattlefield[randomCard - 1];
                            effectMinion.setHealth(effectMinion.getHealth()-1);
                            currentPlayingHero.myField.checkAndDeleteMinion(currentPlayingHero, notCurrentPlayingHero);
                        } else {
                            effectMinion = (Minions)currentPlayingHero.myField.cardsInBattlefield[0];
                            effectMinion.setHealth(effectMinion.getHealth()-1);
                            currentPlayingHero.myField.checkAndDeleteMinion(currentPlayingHero, notCurrentPlayingHero);
                        }    
                    }         
                }    
            }
        }    
        
        if(choice == 2) {
            for(int i=0; i<3; i++) {
                randomCard = RNG.nextInt(notCurrentPlayingHero.myField.cardsInBattlefield.length + 1);
                
                if(notCurrentPlayingHero.myField.cardsInBattlefield.length == 0) { 
                    notCurrentPlayingHero.setHealth(notCurrentPlayingHero.getHealth()-1);
                } else if(notCurrentPlayingHero.myField.cardsInBattlefield.length != 0) {
                    if(randomCard == notCurrentPlayingHero.myField.cardsInBattlefield.length + 1) { 
                        notCurrentPlayingHero.setHealth(notCurrentPlayingHero.getHealth()-1);
                    } else {
                        if(randomCard != 0) {
                            effectMinion = (Minions)notCurrentPlayingHero.myField.cardsInBattlefield[randomCard - 1];
                            effectMinion.setHealth(effectMinion.getHealth()-1);
                            notCurrentPlayingHero.myField.checkAndDeleteMinion(notCurrentPlayingHero, currentPlayingHero);
                        } else {
                            effectMinion = (Minions)notCurrentPlayingHero.myField.cardsInBattlefield[0];
                            effectMinion.setHealth(effectMinion.getHealth()-1);
                            notCurrentPlayingHero.myField.checkAndDeleteMinion(notCurrentPlayingHero, currentPlayingHero);
                        }    
                    }                
                }    
            }
        } 
    }    
}
