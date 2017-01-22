package hearthstone;

import hearthstone.cards.Cards;
import hearthstone.cards.Minions;
import java.util.Scanner;

public class Mage extends Hero {

    public Mage(String heroName) {
        super(heroName);
    }

    @Override

    
    public int getHealth() {
        return health;
    }

    public void heroPower(Hero notCurrentPlayingHero, Hero currentPlayingHero, int cost) {
        cost = 2;
        Scanner keyboard = new Scanner(System.in);
        int option;
        int count;
        
        Minions targetArray[];
        targetArray = new Minions[14];
        

        System.out.println("Target?");
        System.out.println("1. Your own face");
        System.out.println("2. Opponent face");
        count = 3;
        
        for (int i = 0; i < currentPlayingHero.myField.cardsInBattlefield.length; i++) {

            if (currentPlayingHero.myField.cardsInBattlefield[i] != null) {
                System.out.println(count + ". Your " + currentPlayingHero.myField.cardsInBattlefield[i]);
                
                targetArray[count] = (Minions) currentPlayingHero.myField.cardsInBattlefield[i];
                
                count++;
            }
        }

        for (int i = 0; i < notCurrentPlayingHero.myField.cardsInBattlefield.length; i++) {
            if (notCurrentPlayingHero.myField.cardsInBattlefield[i] != null) {
                System.out.println((count + i) + ". Opponent's " + notCurrentPlayingHero.myField.cardsInBattlefield[i]);
                
                targetArray[count+i] = (Minions) notCurrentPlayingHero.myField.cardsInBattlefield[i];
            }
        }

        option = keyboard.nextInt();

        if (option == 1) {
            currentPlayingHero.health = currentPlayingHero.health - 1;
        }
        
        else if (option == 2) {
            notCurrentPlayingHero.health = notCurrentPlayingHero.health - 1;
        }
        
        for (int i =3;i<14;i++){
            if (option == i){
                targetArray[i].health = targetArray[i].health - 1;
                notCurrentPlayingHero.myField.checkAndDeleteMinion(notCurrentPlayingHero, currentPlayingHero);
            }
            
        }
      
    }
}
