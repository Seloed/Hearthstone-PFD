package hearthstone;

import hearthstone.cards.Cards;
import hearthstone.cards.Minions;
import hearthstone.cards.Spells;

public class Battlefield {

    public Cards cardsInBattlefield[] = new Cards[0];
    int didISwap;
    int count = 0;

    public Battlefield() {
        cardsInBattlefield = new Cards[0];  // The array needs to start with 0.  Otherwise, "cardsInBattlefield[].length" won't work.
    }

    /**
     * 
     * @param playingCardObject 
     */
    
    public void putHandCardIntoBattlefield(Cards playingCardObject) {
        if(playingCardObject instanceof Minions) {
            if (cardsInBattlefield.length == 0) {// Do not use = null, better use length = 0. Only use = null when actullay looking into the variable. 
                Minions attackVariable;
                attackVariable = (Minions)playingCardObject;
                attackVariable.setAttacksAvailable(1);
                
                this.cardsInBattlefield = new Cards[1];
                this.cardsInBattlefield[0] = playingCardObject;                
            } else if (!(cardsInBattlefield[0] == null) && !(count >= 7)) {
                count++;
                Cards newCardsInBattlefield[] = new Cards[cardsInBattlefield.length + 1];
                
                Minions attackVariable;
                attackVariable = (Minions)playingCardObject;
                attackVariable.setAttacksAvailable(1);

                System.arraycopy(cardsInBattlefield, 0, newCardsInBattlefield, 0, cardsInBattlefield.length);
                cardsInBattlefield = newCardsInBattlefield;
                for (int i = 0; i < cardsInBattlefield.length; i++) {//starts at 0 so it can iterate through the battlefield until it finds an empty box to place the card value in
                    if (cardsInBattlefield[i] == null) {
                        cardsInBattlefield[i] = playingCardObject;
                    }
                }
            }
        } else if (playingCardObject instanceof Spells) {
            if (cardsInBattlefield.length == 0) {// Do not use = null, better use length = 0. Only use = null when actullay looking into the variable.          
                this.cardsInBattlefield = new Cards[1];
                this.cardsInBattlefield[0] = playingCardObject;
            } else if (!(cardsInBattlefield[0] == null) && !(count >= 7)) {
                count++;
                Cards newCardsInBattlefield[] = new Cards[cardsInBattlefield.length + 1];

                System.arraycopy(cardsInBattlefield, 0, newCardsInBattlefield, 0, cardsInBattlefield.length);
                cardsInBattlefield = newCardsInBattlefield;
                for (int i = 0; i < cardsInBattlefield.length; i++) {//starts at 0 so it can iterate through the battlefield until it finds an empty box to place the card value in
                    if (cardsInBattlefield[0] == null) {
                        cardsInBattlefield[0] = playingCardObject;
                    }
                }
            }
        }    
    }

    public void activateEffect() {
        if (cardsInBattlefield != null) {
            for (int i = 0; i < cardsInBattlefield.length; i++) {

            }
        }
    }

    public void checkAndDeleteMinion(Hero p1Hero, Hero p2Hero) {
        //This function checks if any minions on the battlefield is dead
        //If so, deletes that minion and moves everyone down

        //Check each minion to see if they are "dead" 
        boolean swap1 = true;
        if(cardsInBattlefield.length == 0) {
            Cards newCardsInBattlefield[] = new Cards[1];
            Cards buffer;
            Cards cardsInBattlefieldObject = cardsInBattlefield[0];
            
            do {
                for (int i = 0; i < cardsInBattlefield.length + 1; i++) {
                    System.out.println("We made it here");
                    if(cardsInBattlefieldObject instanceof Spells) {
                        cardsInBattlefieldObject = (Spells)cardsInBattlefield[i];
                    }
                    if (cardsInBattlefieldObject == null) {//This runs if the 
                        swap1 = true;
                    } else {
                        cardsInBattlefield[i] = null;//Delete
                        for (int j = 1; j < cardsInBattlefield.length; j++) {
                            if (cardsInBattlefield[j - 1] == null && cardsInBattlefield[j] != null) {
                                if ((cardsInBattlefield[j - 1] == null) && (cardsInBattlefield[j] != null)) {
                                    buffer = cardsInBattlefield[j - 1];
                                    cardsInBattlefield[j - 1] = cardsInBattlefield[j];
                                    cardsInBattlefield[j] = buffer;
                                }
                            }
                        }
                    }
                    swap1 = false;
                }
                for (int i = 0; i < cardsInBattlefield.length; i++) {
                    if (cardsInBattlefield[i] == null) {
                        System.arraycopy(cardsInBattlefield, 0, newCardsInBattlefield, 0, cardsInBattlefield.length - 1);
                        cardsInBattlefield = newCardsInBattlefield;
                    }
                }
            } while (swap1 == true);
        } else {
            Cards newCardsInBattlefield[] = new Cards[cardsInBattlefield.length - 1];
            Cards buffer;
            
            do {
                for (int i = 0; i < cardsInBattlefield.length; i++) {
                    Minions cardsInBattlefieldObject = (Minions) cardsInBattlefield[i];//Downcasting cardsInBattlefield to Minions objects
                    if (cardsInBattlefieldObject == null) {//This runs if the 
                        swap1 = true;
                    } else if (cardsInBattlefieldObject.getHealth() <= 0) {
                        cardsInBattlefield[i] = null;//Delete
                        for (int j = 1; j < cardsInBattlefield.length; j++) {
                            if (cardsInBattlefield[j - 1] == null && cardsInBattlefield[j] != null) {
                                if ((cardsInBattlefield[j - 1] == null) && (cardsInBattlefield[j] != null)) {
                                    buffer = cardsInBattlefield[j - 1];
                                    cardsInBattlefield[j - 1] = cardsInBattlefield[j];
                                    cardsInBattlefield[j] = buffer;
                                }
                            }
                        }
                    }
                    swap1 = false;
                }
                for (int i = 0; i < cardsInBattlefield.length; i++) {
                    if (cardsInBattlefield[i] == null) {
                        System.arraycopy(cardsInBattlefield, 0, newCardsInBattlefield, 0, cardsInBattlefield.length - 1);
                        cardsInBattlefield = newCardsInBattlefield;
                    }
                }
            } while (swap1 == true);
        }          
    }
}
