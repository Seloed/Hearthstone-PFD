
package hearthstone.cards;

import hearthstone.Hero;
import java.util.Scanner;

public class StarvingBuzzard extends Minions{
    Minions effectMinion;
    
    public StarvingBuzzard() {
        super(5, "Starving Buzzard", "Battlecry: Draw a card for each frienly beast");
        
        this.attack = 3;
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
        for(int i=0; i<currentPlayingHero.myField.cardsInBattlefield.length; i++) {
            effectMinion = (Minions)currentPlayingHero.myField.cardsInBattlefield[i];
            if(effectMinion.getBeast() == true) {
                currentPlayingHero.drawACard();
            }
        }        
    }               
}
