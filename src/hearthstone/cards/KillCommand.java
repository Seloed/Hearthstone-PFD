
package hearthstone.cards;

import hearthstone.Hero;
import java.util.Scanner;

public class KillCommand extends Spells {
    int choice;
    int restriction = 0;
    Minions effectMinion;
    
    Scanner myKeyboard = new Scanner(System.in);
    
    public KillCommand() {
        super(3, "Kill Command", "Deal 3 damage to a Minion or Hero and 5 damage if you have a beast");
    }
    
    /**
     * 
     * @param currentPlayingHero
     * @param notCurrentPlayingHero 
     */
    
    public void effect(Hero currentPlayingHero, Hero notCurrentPlayingHero) {  
        if(currentPlayingHero.myField.cardsInBattlefield.length != 0) {
            for(int i=0; i<currentPlayingHero.myField.cardsInBattlefield.length; i++) {
                effectMinion = (Minions)currentPlayingHero.myField.cardsInBattlefield[i];
                if(effectMinion.getBeast() != true && restriction != 1) {
                    restriction = 1;

                    System.out.println("Would you like to deal 3 damage to your Minion or Hero or your enemies Minion or Hero\n1. My Minion\n2. Enemies Minion\n3. My Hero\n4. Enemies Hero");
                    choice = myKeyboard.nextInt();

                    if(choice == 1) {
                        System.out.println("Which Minion would you like to deal 3 damage to");

                        for (i = 0; i < currentPlayingHero.myField.cardsInBattlefield.length; i++) {
                            if (currentPlayingHero.myField.cardsInBattlefield[i] != null) {
                                System.out.println(1 + i + ". " + currentPlayingHero.myField.cardsInBattlefield[i]);
                            }
                        }
                        choice = myKeyboard.nextInt();
                        effectMinion = (Minions)currentPlayingHero.myField.cardsInBattlefield[choice - 1];
                        effectMinion.setHealth(effectMinion.getHealth()-3);
                        currentPlayingHero.myField.checkAndDeleteMinion(currentPlayingHero, notCurrentPlayingHero);
                    }

                    if(choice == 2) {
                        System.out.println("Which Minion would you like to deal 3 damage to");

                        for (i = 0; i < notCurrentPlayingHero.myField.cardsInBattlefield.length; i++) {
                            if (notCurrentPlayingHero.myField.cardsInBattlefield[i] != null) {
                                System.out.println((1 + i) + ". " + notCurrentPlayingHero.myField.cardsInBattlefield[i]);
                            }
                        }
                        choice = myKeyboard.nextInt();
                        effectMinion = (Minions)notCurrentPlayingHero.myField.cardsInBattlefield[choice - 1];
                        effectMinion.setHealth(effectMinion.getHealth()-3);
                        notCurrentPlayingHero.myField.checkAndDeleteMinion(notCurrentPlayingHero, currentPlayingHero);
                    }

                    if(choice == 3) {
                        currentPlayingHero.setHealth(currentPlayingHero.getHealth()-3);
                    }

                    if(choice == 4) {
                        notCurrentPlayingHero.setHealth(notCurrentPlayingHero.getHealth()-3);
                    }
                } 
                if(effectMinion.getBeast() == true && restriction != 1) {
                    restriction = 1;

                    System.out.println("Would you like to deal 5 damage to your Minion or Hero or your enemies Minion or Hero\n1. My Minion\n2. Enemies Minion\n3. My Hero\n4. Enemies Hero");
                    choice = myKeyboard.nextInt();

                    if(choice == 1) {
                        System.out.println("Which Minion would you like to deal 5 damage to");

                        for (i = 0; i < currentPlayingHero.myField.cardsInBattlefield.length; i++) {
                            if (currentPlayingHero.myField.cardsInBattlefield[i] != null) {
                                System.out.println(1 + i + ". " + currentPlayingHero.myField.cardsInBattlefield[i]);
                            }
                        }
                        choice = myKeyboard.nextInt();
                        effectMinion = (Minions)currentPlayingHero.myField.cardsInBattlefield[choice - 1];
                        effectMinion.setHealth(effectMinion.getHealth()-5);
                        currentPlayingHero.myField.checkAndDeleteMinion(currentPlayingHero, notCurrentPlayingHero);
                    }

                    if(choice == 2) {
                        System.out.println("Which Minion would you like to deal 5 damage to");

                        for (i = 0; i < notCurrentPlayingHero.myField.cardsInBattlefield.length; i++) {
                            if (notCurrentPlayingHero.myField.cardsInBattlefield[i] != null) {
                                System.out.println((1 + i) + ". " + notCurrentPlayingHero.myField.cardsInBattlefield[i]);
                            }
                        }
                        choice = myKeyboard.nextInt();
                        effectMinion = (Minions)notCurrentPlayingHero.myField.cardsInBattlefield[choice - 1];
                        effectMinion.setHealth(effectMinion.getHealth()-5);
                        notCurrentPlayingHero.myField.checkAndDeleteMinion(notCurrentPlayingHero, currentPlayingHero);
                    }

                    if(choice == 3) {
                        currentPlayingHero.setHealth(currentPlayingHero.getHealth()-5);
                    }

                    if(choice == 4) {
                        notCurrentPlayingHero.setHealth(notCurrentPlayingHero.getHealth()-5);
                    }
                }
            }
            if((currentPlayingHero.myField.cardsInBattlefield.length == 0) && (notCurrentPlayingHero.myField.cardsInBattlefield.length == 0)) {
                System.out.println("Would you like to deal 3 damage to your Hero or your enemies Hero\n1. My Hero\n2. Enemies Hero");
                choice = myKeyboard.nextInt();

                if(choice == 1) {
                    currentPlayingHero.setHealth(currentPlayingHero.getHealth()-3);
                }

                if(choice == 2) {
                    notCurrentPlayingHero.setHealth(notCurrentPlayingHero.getHealth()-3);
                }        
            }
        }    
    }   
}

