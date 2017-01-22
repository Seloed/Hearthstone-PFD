package hearthstone;

import hearthstone.cards.Cards;
import hearthstone.cards.Minions;
import hearthstone.cards.Spells;
import java.util.Random;
import java.util.Scanner;

public class Game {

    public Game() {
    }

    /**
     * 
     * @param player1
     * @param player2
     * @param p1Hero
     * @param p2Hero
     * @param RNG 
     */
    
    public void startGame(String player1, String player2, Hero p1Hero, Hero p2Hero, Random RNG) {
        int endTurn = 0;
        int playingCard;
        int playerDecision;
        int buffer[];
        int heroPower = 1;

        Scanner myKeyboard = new Scanner(System.in);

        System.out.println("\n" + player1 + " is a " + p1Hero.name);//How you would call the players name and the players class
        System.out.println(player2 + " is a " + p2Hero.name);//How you would call the players name and the players class

        System.out.println("\nGame Start! \n");

        int coinFlip = RNG.nextInt(2);
        if (coinFlip == 0) {
            System.out.println(player1 + " has won the coin flip and is going first");
            for (int i = 0; i < 3; i++) {
                p1Hero.drawACard();//Both heroes draw cards
                p2Hero.drawACard();
            }
            
            p2Hero.drawManaCoin();

            p1Hero.mana = 1;
            p1Hero.turnCount = 1;
            p1Hero.heroPower = 1;
            p2Hero.mana = 1;
            p2Hero.turnCount = 1;
            p2Hero.heroPower = 1;

            p1Hero.player1sTurn = 1;//For switch player's turn
            p2Hero.player2sTurn = 0;
        }

        if (coinFlip == 1) {
            System.out.println(player2 + " has won the coin flip and is going first");
            for (int i = 0; i < 3; i++) {
                p1Hero.drawACard();//Both heroes draw cards
                p2Hero.drawACard();
            }
            
            p1Hero.drawManaCoin();

            p1Hero.mana = 1;
            p1Hero.turnCount = 1;
            p1Hero.heroPower = 1;
            p2Hero.mana = 1;
            p2Hero.turnCount = 1;
            p2Hero.heroPower = 1;

            p1Hero.player1sTurn = 0;//For switch player's turn
            p2Hero.player2sTurn = 1;
        }

        do {
            while (endTurn != 1) {
                //Player 1
                if ((p1Hero.player1sTurn == 1) && (p2Hero.player2sTurn == 0)) {
                    p1Hero.restriction = 0;
                    Hero currentPlayingHero = p1Hero;
                    Hero notCurrentPlayingHero = p2Hero;

                    if (p1Hero.restrictionTwo == 0) {
                        p1Hero.currentMana = p1Hero.mana;
                        p1Hero.restrictionTwo = 1;
                    }

                    System.out.println("\n" + player1 + " the " + p1Hero.name + " has cards in their hand: ");
                    for (int i = 0; i < p1Hero.myHand.cardsInHand.length; i++) {
                        System.out.println((i + 1) + ". " + p1Hero.myHand.cardsInHand[i]);
                    }

                    System.out.println("\n1.Play a Card\n2.Attack\n3.Check Status\n4.End Turn");

                    if ((p1Hero.heroPower == 1)) {
                        System.out.println("5.Hero Power");
                    }

                    playerDecision = myKeyboard.nextInt();

                    if (playerDecision == 1) {
                        buffer = new int[20];

                        System.out.println("These are the cards you are able to play");
                        System.out.println("IF THE OPPONENT DOES NOT HAVE CARDS IN THE BATTLEFIELD, ATTACKING EFFECTS WILL NOT TAKE PLACE");
                        System.out.println("\n" + player1 + " the " + p1Hero.name + " can play these cards: ");
                        for (int i = 0; i < p1Hero.myHand.cardsInHand.length; i++) {
                            if (p1Hero.myHand.cardsInHand[i].cost <= p1Hero.currentMana) {
                                p1Hero.restriction = 1;
                                System.out.println((i + 1) + ". " + p1Hero.myHand.cardsInHand[i]);
                                buffer[i] = i + 1;//If you enter 1 it will play because the first card has a value of 0 and the playingcard (user input) of 1 gets turned into 0 which means that the if statement is fulfilled and it can activate
                            }
                        }

                        if (p1Hero.restriction == 1) {
                            playingCard = myKeyboard.nextInt();//Player choice

                            for (int i = 0; i < p1Hero.myHand.cardsInHand.length; i++) {
                                if (buffer[i] == playingCard && p1Hero.restriction != 2) {
                                    p1Hero.restriction = 2;
                                    Cards playingCardObject;//Create a playingCard object
                                    Minions effectMinion;
                                    Spells effectSpell;
                                    
                                    playingCard = playingCard - 1;//-1 Because arrays starts from 0
                                    playingCardObject = p1Hero.myHand.cardsInHand[playingCard];//Turn playingCard to a object (Becaus playingCard was just a number that player input)

                                    p1Hero.currentMana = p1Hero.currentMana - p1Hero.myHand.cardsInHand[playingCard].cost;
                                    if(playingCardObject instanceof Spells) {
                                        effectSpell = (Spells)playingCardObject;
                                        
                                        if((p2Hero.myField.cardsInBattlefield.length == 0) && (effectSpell.getDamage() != true)) {
                                            playingCardObject.effect(currentPlayingHero, notCurrentPlayingHero);//This is the automatic effect and how it gets called when the card goes to the battlefield         
                                        }   
                                        if((p1Hero.myField.cardsInBattlefield.length != 0) && (p2Hero.myField.cardsInBattlefield.length != 0)) {
                                            playingCardObject.effect(currentPlayingHero, notCurrentPlayingHero);//This is the automatic effect and how it gets called when the card goes to the battlefield   
                                        }
                                        
                                        p1Hero.myHand.cardsInHand[playingCard] = null;//Delete the card that player just played
                                        p1Hero.myHand.deleteHandCards(playingCard);  
                                    } else if (playingCardObject instanceof Minions) {
                                        effectMinion = (Minions)playingCardObject;
                                        
                                        p1Hero.myField.putHandCardIntoBattlefield(playingCardObject);//Put playingCard object into battle field
                                        p1Hero.myHand.cardsInHand[playingCard] = null;//Delete the card that player just played
                                        p1Hero.myHand.deleteHandCards(playingCard);
                                        
                                        if((p2Hero.myField.cardsInBattlefield.length == 0) && (effectMinion.getDamage() != true)) {
                                            playingCardObject.effect(currentPlayingHero, notCurrentPlayingHero);//This is the automatic effect and how it gets called when the card goes to the battlefield         
                                        }  
                                        if((p1Hero.myField.cardsInBattlefield.length != 0) && (p2Hero.myField.cardsInBattlefield.length != 0)) {
                                            playingCardObject.effect(currentPlayingHero, notCurrentPlayingHero);//This is the automatic effect and how it gets called when the card goes to the battlefield   
                                        }
                                    }       
                                    //Print out Battle field
                                    this.printBattleField(player1, player2, p1Hero, p2Hero, currentPlayingHero, notCurrentPlayingHero);
                                }
                            }
                        }
                    }
                    if ((playerDecision == 2) && (p1Hero.myField.cardsInBattlefield == null) && (p2Hero.myField.cardsInBattlefield == null)) {
                        System.out.println("No minions in the Battlefield");
                    } else if (playerDecision == 2) {//Attack
                        this.minionsAttack(player1, player2, p1Hero, p2Hero, currentPlayingHero, notCurrentPlayingHero);
                    }

                    if (playerDecision == 3) {//Check status
                        this.checkStatus("\n" + player1, player2, currentPlayingHero, notCurrentPlayingHero, p1Hero, p2Hero);
                    }

                    if (playerDecision == 4) {//End turn
                        p1Hero.restrictionTwo = 0;
                        this.endTurn(p1Hero, p2Hero, currentPlayingHero, notCurrentPlayingHero, heroPower);
                    }

                    if ((playerDecision == 5) && (p1Hero.heroPower == 1) && (p1Hero.getCost() <= p1Hero.currentMana)) {
                        p1Hero.heroPower(p2Hero, p1Hero, 2);
                        p1Hero.currentMana = p1Hero.currentMana - p1Hero.getCost();
                        p1Hero.heroPower = 0;
                    }
                    if ((playerDecision == 5) && (p1Hero.getCost() > p1Hero.currentMana) && (p1Hero.heroPower == 1)) {
                        System.out.println("\nYou don't have enough mana to use your Hero Power\n");
                    } else if ((playerDecision == 5) && (heroPower == 0)) {
                        System.out.print("\nYou can't use your Hero Power twice a turn\n");
                    }
                }

                //Player two
                if ((p1Hero.player1sTurn == 0) && (p2Hero.player2sTurn == 1)) {
                    p2Hero.restriction = 0;
                    Hero currentPlayingHero = p2Hero;
                    Hero notCurrentPlayingHero = p1Hero;

                    if (p2Hero.restrictionTwo == 0) {
                        p2Hero.currentMana = p2Hero.mana;
                        p2Hero.restrictionTwo = 1;
                    }

                    //currentPlayingHero.drawACard();
                    System.out.println("\n" + player2 + " the " + p2Hero.name + " has cards hand: ");
                    for (int i = 0; i < p2Hero.myHand.cardsInHand.length; i++) {
                        System.out.println((i + 1) + ". " + p2Hero.myHand.cardsInHand[i]);
                    }

                    System.out.println("\n1.Play a Card\n2.Attack\n3.Check Status\n4.End Turn");

                    if ((p2Hero.heroPower == 1)) {
                        System.out.println("5.Hero Power");
                    }

                    playerDecision = myKeyboard.nextInt();

                    if (playerDecision == 1) {
                        buffer = new int[20];

                        System.out.println("These are the cards you are able to play");
                        System.out.println("IF THE OPPONENT DOES NOT HAVE CARDS IN THE BATTLEFIELD, ATTACKING EFFECTS WILL NOT TAKE PLACE");
                        System.out.println("\n" + player2 + " the " + p2Hero.name + " can play these cards: ");
                        for (int i = 0; i < p2Hero.myHand.cardsInHand.length; i++) {
                            if (p2Hero.myHand.cardsInHand[i].cost <= p2Hero.currentMana) {
                                p2Hero.restriction = 1;
                                System.out.println((i + 1) + ". " + p2Hero.myHand.cardsInHand[i]);
                                buffer[i] = i + 1;
                            }
                        }

                        if (p2Hero.restriction == 1) {
                            playingCard = myKeyboard.nextInt();//Player choice

                            for (int i = 0; i < p2Hero.myHand.cardsInHand.length; i++) {
                                if (buffer[i] == playingCard && p2Hero.restriction != 2) {
                                    p2Hero.restriction = 2;
                                    Cards playingCardObject;//Create a playingCard object
                                    Minions effectMinion;
                                    Spells effectSpell;
                                    
                                    playingCard = playingCard - 1;//-1 Because arrays starts from 0
                                    playingCardObject = p2Hero.myHand.cardsInHand[playingCard];//Turn playingCard to a object (Becaus playingCard was just a number that player input)
                                    
                                    p2Hero.currentMana = p2Hero.currentMana - p2Hero.myHand.cardsInHand[playingCard].cost;                         
                                    
                                    if (playingCardObject instanceof Spells) {
                                        effectSpell = (Spells)playingCardObject;
                                        
                                        if((p1Hero.myField.cardsInBattlefield.length == 0) && (effectSpell.getDamage() != true)) {
                                            playingCardObject.effect(currentPlayingHero, notCurrentPlayingHero);//This is the automatic effect and how it gets called when the card goes to the battlefield         
                                        }   
                                        if((p1Hero.myField.cardsInBattlefield.length != 0) && (p2Hero.myField.cardsInBattlefield.length != 0)) {
                                            playingCardObject.effect(currentPlayingHero, notCurrentPlayingHero);//This is the automatic effect and how it gets called when the card goes to the battlefield   
                                        }
                                        
                                        p2Hero.myHand.cardsInHand[playingCard] = null;//Delete the card that player just played
                                        p2Hero.myHand.deleteHandCards(playingCard);
                                    } else if (playingCardObject instanceof Minions) {
                                        effectMinion = (Minions)playingCardObject;
                                        
                                        p2Hero.myField.putHandCardIntoBattlefield(playingCardObject);//Put playingCard object into battle field
                                        p2Hero.myHand.cardsInHand[playingCard] = null;//Delete the card that player just played
                                        p2Hero.myHand.deleteHandCards(playingCard);
                                        
                                        if((p1Hero.myField.cardsInBattlefield.length == 0) && (effectMinion.getDamage() != true)) {
                                            playingCardObject.effect(currentPlayingHero, notCurrentPlayingHero);//This is the automatic effect and how it gets called when the card goes to the battlefield        
                                        }
                                        if((p1Hero.myField.cardsInBattlefield.length != 0) && (p2Hero.myField.cardsInBattlefield.length != 0)) {
                                            playingCardObject.effect(currentPlayingHero, notCurrentPlayingHero);//This is the automatic effect and how it gets called when the card goes to the battlefield   
                                        }
                                    }                               
                                    //Print out Battle field
                                    this.printBattleField(player1, player2, p1Hero, p2Hero, currentPlayingHero, notCurrentPlayingHero);
                                }
                            }
                        }
                    }

                    if ((playerDecision == 2) && (p1Hero.myField.cardsInBattlefield.length == 0) && (p2Hero.myField.cardsInBattlefield.length == 0)) {
                        System.out.println("No minions in the Battlefield");
                    } else if (playerDecision == 2) {//Attack
                        this.minionsAttack(player1, player2, p1Hero, p2Hero, currentPlayingHero, notCurrentPlayingHero);
                    }

                    if (playerDecision == 3) {//Check status
                        this.checkStatus("\n" + player2, player1, currentPlayingHero, notCurrentPlayingHero, p2Hero, p1Hero);
                    }

                    if (playerDecision == 4) {//End turn
                        p2Hero.restrictionTwo = 0;
                        this.endTurn(p1Hero, p2Hero, currentPlayingHero, notCurrentPlayingHero, heroPower);
                    }

                    if ((playerDecision == 5) && (p2Hero.heroPower == 1) && (p2Hero.getCost() <= p2Hero.currentMana)) {
                        p2Hero.heroPower(p1Hero, p2Hero, 2);
                        p2Hero.currentMana = p2Hero.currentMana - p2Hero.getCost();
                        p2Hero.heroPower = 0;
                    }

                    if ((playerDecision == 5) && (p2Hero.getCost() > p2Hero.currentMana) && (p2Hero.heroPower == 1)) {
                        System.out.println("\nYou don't have enough mana to use your Hero Power\n");
                    } else if ((playerDecision == 3) && (heroPower == 0)) {
                        System.out.print("\nYou can't use your Hero Power twice a turn\n");
                    }
                }

                if (p1Hero.health <= 0) {
                    //P1 dies
                    System.out.println("\n" + player2 + " the " + p2Hero.name + " Win !");
                    endTurn = 1;
                }

                if (p2Hero.health <= 0) {
                    //P2 dies
                    System.out.println("\n" + player1 + " the " + p1Hero.name + " Win !");
                    endTurn = 1;
                }
            }
        } while ((p1Hero.health > 0) && (p2Hero.health > 0));

        System.out.println("\n END ");
        
    }

    public void minionsAttack(String player1, String player2, Hero p1Hero, Hero p2Hero, Hero currentPlayingHero, Hero notCurrentPlayingHero) {
        int chooseMinion;
        int minionWantToAttack;
        int newHealthForChooseMinion;
        int newHealthForMinionWantToAttack;
        int userInput;
        int[] buffer;
        Minions tauntChecker;

        Scanner myKeyboard = new Scanner(System.in);
        //Print out Battle field
        this.printBattleField(player1, player2, p1Hero, p2Hero, currentPlayingHero, notCurrentPlayingHero);       
        
        if(notCurrentPlayingHero.myField.cardsInBattlefield != null) {
            for(int i=0; i<notCurrentPlayingHero.myField.cardsInBattlefield.length; i++) {//Taunt
                tauntChecker = (Minions)notCurrentPlayingHero.myField.cardsInBattlefield[i];
                if(tauntChecker.getTaunt() == true) {
                    notCurrentPlayingHero.attackRestriction = 1;
                }
            }    
            buffer = new int[notCurrentPlayingHero.myHand.cardsInHand.length];
                       
            if(notCurrentPlayingHero.attackRestriction == 1) {
                System.out.println(currentPlayingHero.name + ", which Minion would you like to choose for attack? ");
                chooseMinion = myKeyboard.nextInt();
                for(int i=0; i<notCurrentPlayingHero.myField.cardsInBattlefield.length; i++) {//Taunt
                    tauntChecker = (Minions)notCurrentPlayingHero.myField.cardsInBattlefield[i];
                    if(tauntChecker.getTaunt() == true) {
                        notCurrentPlayingHero.count++;
                        if(notCurrentPlayingHero.count > 1) {
                            System.out.println("\nOr");
                        }
                        System.out.println("\n\n---------------------------------------------------");
                        System.out.println("MINION YOU CAN ATTACK");
                        notCurrentPlayingHero.attackRestriction = 1;
                        System.out.println(1 + i + ". " + notCurrentPlayingHero.myField.cardsInBattlefield[i]);
                        buffer[i] = i + 1;
                        System.out.println("---------------------------------------------------");
                    }  
                }    
                System.out.println("Which Minion belonging to " + notCurrentPlayingHero.name + " would you like to attack? ");
                minionWantToAttack = myKeyboard.nextInt();

                for (int i = 0; i < notCurrentPlayingHero.myField.cardsInBattlefield.length; i++) {;
                    if((currentPlayingHero.myField.cardsInBattlefield.length != 0) && (notCurrentPlayingHero.myField.cardsInBattlefield.length != 0)) {
                        if ((currentPlayingHero.myField.cardsInBattlefield[chooseMinion - 1] != null) && (notCurrentPlayingHero.myField.cardsInBattlefield[minionWantToAttack - 1] != null) && (buffer[i] == minionWantToAttack) && (notCurrentPlayingHero.attackRestriction == 1)) {
                            Minions chooseMinionObject = (Minions) currentPlayingHero.myField.cardsInBattlefield[chooseMinion - 1];//Turn chooseMinion to a Minion object
                            Minions minionWantToAttackObejct = (Minions) notCurrentPlayingHero.myField.cardsInBattlefield[minionWantToAttack - 1];//Turn minionWantToAttack to a Minion object

                            if(chooseMinionObject.getAttacksAvailable() != 1) {

                                newHealthForMinionWantToAttack = minionWantToAttackObejct.getHealth() - chooseMinionObject.getAttack();//New health for minionWantToAttack is it's health - chooseMinion's attack
                                newHealthForChooseMinion = chooseMinionObject.getHealth() - minionWantToAttackObejct.getAttack();//New health for chooseMinion is it's health - minionWantToAttack's attack

                                minionWantToAttackObejct.setHealth(newHealthForMinionWantToAttack);//Set minionWantToAttack.health to the value we just got
                                chooseMinionObject.setHealth(newHealthForChooseMinion);//Set chooseMinion.health to the value we just got

                                chooseMinionObject.setAttacksAvailable(1);

                                currentPlayingHero.myField.checkAndDeleteMinion(p1Hero, p2Hero);//Chcek and delete Minions at the end for current playing hero
                                notCurrentPlayingHero.myField.checkAndDeleteMinion(p2Hero, p1Hero);//Chcek and delete Minions at the end fro not current playing hero
                                this.printBattleField(player1, player2, p1Hero, p2Hero, currentPlayingHero, notCurrentPlayingHero);
                            } else {
                                System.out.println("Sorry, you must wait a turn before attacking with this Minion");
                            }    
                        } else {
                        }
                    }    
                }    
            }   
            if(notCurrentPlayingHero.attackRestriction != 1) {
                System.out.println("\n1.Attack Minion\n2.Attack Hero");
                userInput = myKeyboard.nextInt();

                if(userInput == 1) {
                    System.out.println(currentPlayingHero.name + ", which Minion would you like to choose for attack? ");
                    chooseMinion = myKeyboard.nextInt();
                    
                    for(int i=0; i<notCurrentPlayingHero.myField.cardsInBattlefield.length; i++) {//Taunt
                        System.out.println(1 + i + ". " + notCurrentPlayingHero.myField.cardsInBattlefield[i]);
                    }     
                    
                    System.out.println("Which Minion belonging to " + notCurrentPlayingHero.name + " would you like to attack? ");
                    minionWantToAttack = myKeyboard.nextInt();

                    chooseMinion = chooseMinion - 1;//-1 because array starts from 0
                    minionWantToAttack = minionWantToAttack - 1;

                    if ((currentPlayingHero.myField.cardsInBattlefield[chooseMinion] != null) && (notCurrentPlayingHero.myField.cardsInBattlefield[minionWantToAttack] != null)) {
                        Minions chooseMinionObject = (Minions) currentPlayingHero.myField.cardsInBattlefield[chooseMinion];//Turn chooseMinion to a Minion object
                        Minions minionWantToAttackObejct = (Minions) notCurrentPlayingHero.myField.cardsInBattlefield[minionWantToAttack];//Turn minionWantToAttack to a Minion object

                        if(chooseMinionObject.getAttacksAvailable() != 1) {

                            newHealthForMinionWantToAttack = minionWantToAttackObejct.getHealth() - chooseMinionObject.getAttack();//New health for minionWantToAttack is it's health - chooseMinion's attack
                            newHealthForChooseMinion = chooseMinionObject.getHealth() - minionWantToAttackObejct.getAttack();//New health for chooseMinion is it's health - minionWantToAttack's attack

                            minionWantToAttackObejct.setHealth(newHealthForMinionWantToAttack);//Set minionWantToAttack.health to the value we just got
                            chooseMinionObject.setHealth(newHealthForChooseMinion);//Set chooseMinion.health to the value we just got

                            chooseMinionObject.setAttacksAvailable(1);

                            currentPlayingHero.myField.checkAndDeleteMinion(p1Hero, p2Hero);//Chcek and delete Minions at the end for current playing hero
                            notCurrentPlayingHero.myField.checkAndDeleteMinion(p2Hero, p1Hero);//Chcek and delete Minions at the end fro not current playing hero
                            this.printBattleField(player1, player2, p1Hero, p2Hero, currentPlayingHero, notCurrentPlayingHero);
                        } else {
                            System.out.println("Sorry, you must wait a turn before attacking with this Minion");
                        }    
                    } else {
                        System.out.println("Sorry, please choose the Minions on the field ");
                    }
                }
                if(userInput == 2) {
                    System.out.println(currentPlayingHero.name + ", which Minion would you like to choose for attack? ");
                    chooseMinion = myKeyboard.nextInt();
                    
                    chooseMinion = chooseMinion - 1;//-1 because array starts from 0
                    if (currentPlayingHero.myField.cardsInBattlefield[chooseMinion] != null) {
                        Minions chooseMinionObject = (Minions) currentPlayingHero.myField.cardsInBattlefield[chooseMinion];//Turn chooseMinion to a Minion object

                        if(chooseMinionObject.getAttacksAvailable() != 1) {

                            notCurrentPlayingHero.setHealth(notCurrentPlayingHero.health - chooseMinionObject.getAttack());  

                            chooseMinionObject.setAttacksAvailable(1);

                            currentPlayingHero.myField.checkAndDeleteMinion(p1Hero, p2Hero);//Chcek and delete Minions at the end for current playing hero
                            this.printBattleField(player1, player2, p1Hero, p2Hero, currentPlayingHero, notCurrentPlayingHero);
                        } else {
                            System.out.println("Sorry, you must wait a turn before attacking with this Minion");
                        }    
                    } 
                }
            }
        }    
    }    
    

    public void printBattleField(String player1, String player2, Hero p1Hero, Hero p2Hero, Hero currentPlayingHero, Hero notCurrentPlayingHero) {
        //p1Hero's Battle field
        if ((p1Hero == currentPlayingHero) && (p2Hero == notCurrentPlayingHero)) {
            System.out.println("\n" + "Battlefield: ");
            System.out.println(player1 + " the " + p1Hero.name + "(" + p1Hero.getHealth() + ") ---------------------------------------------------");
            if (p1Hero.myField.cardsInBattlefield != null) {
                for (int j = 0; j < p1Hero.myField.cardsInBattlefield.length; j++) {
                    if (p1Hero.myField.cardsInBattlefield[j] != null) {
                        p1Hero.myField.checkAndDeleteMinion(p1Hero, p2Hero);
                        System.out.println((j + 1) + ". " + p1Hero.myField.cardsInBattlefield[j]);
                    } else if (p1Hero.myField.cardsInBattlefield[j] == null) {
                        p1Hero.myField.checkAndDeleteMinion(p1Hero, p2Hero);
                    }
                }
            }

            System.out.println("\n-----------------------------------------------------------------------------------------------");

            if (p2Hero.myField.cardsInBattlefield != null) {
                for (int k = 0; k < p2Hero.myField.cardsInBattlefield.length; k++) {
                    if (p2Hero.myField.cardsInBattlefield[k] != null) {
                        p2Hero.myField.checkAndDeleteMinion(p1Hero, p2Hero);
                        System.out.println((k + 1) + ". " + p2Hero.myField.cardsInBattlefield[k]);
                    } else if (p2Hero.myField.cardsInBattlefield[k] == null) {
                        p2Hero.myField.checkAndDeleteMinion(p2Hero, p1Hero);
                    }
                }
            }
            System.out.println("\n" + player2 + " the " + p2Hero.name + "(" + p2Hero.getHealth() + ") ---------------------------------------------------");
        }

        //p2Hero's Battle field
        if ((p2Hero == currentPlayingHero) && (p1Hero == notCurrentPlayingHero)) {
            System.out.println("\n" + "Battlefield: ");
            System.out.println(player2 + " the " + p2Hero.name + "(" + p2Hero.getHealth() + ") ---------------------------------------------------");
            if (p2Hero.myField.cardsInBattlefield != null) {
                for (int j = 0; j < p2Hero.myField.cardsInBattlefield.length; j++) {
                    p2Hero.myField.checkAndDeleteMinion(p1Hero, p2Hero);
                    if (p2Hero.myField.cardsInBattlefield[j] != null) {
                        System.out.println((j + 1) + ". " + p2Hero.myField.cardsInBattlefield[j]);
                    } else if (p2Hero.myField.cardsInBattlefield[j] == null) {
                        p2Hero.myField.checkAndDeleteMinion(p2Hero, p1Hero);
                    }
                }
            }

            System.out.println("\n-----------------------------------------------------------------------------------------------");

            if (p1Hero.myField.cardsInBattlefield != null) {
                for (int k = 0; k < p1Hero.myField.cardsInBattlefield.length; k++) {
                    if (p1Hero.myField.cardsInBattlefield[k] != null) {
                        p1Hero.myField.checkAndDeleteMinion(p1Hero, p2Hero);
                        System.out.println((k + 1) + ". " + p1Hero.myField.cardsInBattlefield[k]);
                    } else if (p1Hero.myField.cardsInBattlefield[k] == null) {
                        p1Hero.myField.checkAndDeleteMinion(p1Hero, p2Hero);
                    }
                }
            }
            System.out.println("\n" + player1 + " the " + p1Hero.name + "(" + p1Hero.getHealth() + ") ---------------------------------------------------");
        }

    }

    public void checkStatus(String player1, String player2, Hero p1Hero, Hero p2Hero, Hero currentPlayingHero, Hero notCurrentPlayingHero) {

        if ((p1Hero == currentPlayingHero) && (p2Hero == notCurrentPlayingHero)) {
            System.out.println(player1 + " has " + p1Hero.currentMana + "/" + p1Hero.mana + " mana available");
            System.out.println(player1 + " has " + p1Hero.myDeck.listOfCards.length + " cards left in the deck");
            if (p1Hero.myField.cardsInBattlefield != null) {
                System.out.println(player1 + " has " + currentPlayingHero.myField.cardsInBattlefield.length + " cards on the Battlefield");
            } else {
                System.out.println(player1 + " has no cards on the Battlefield");
            }
        }

        if ((p2Hero == currentPlayingHero) && (p1Hero == notCurrentPlayingHero)) {
            System.out.println(player2 + " has " + p2Hero.currentMana + "/" + p2Hero.mana + " mana available");
            System.out.println(player2 + " has " + p2Hero.myDeck.listOfCards.length + " cards left in the deck");
            if (p2Hero.myField.cardsInBattlefield != null) {
                System.out.println(player2 + " has " + currentPlayingHero.myField.cardsInBattlefield.length + " cards on the Battlefield");
            } else {
                System.out.println(player2 + " has no cards on the Battlefield");
            }
        }

        //Print out Battle field
        this.printBattleField(player1, player2, p1Hero, p2Hero, currentPlayingHero, notCurrentPlayingHero);
    }

    public void endTurn(Hero p1Hero, Hero p2Hero, Hero currentPlayingHero, Hero notCurrentPlayingHero, int heroPower) {
        Minions[] theCardsInBattlefield = new Minions[currentPlayingHero.myField.cardsInBattlefield.length];
        
        if (currentPlayingHero.turnCount < 11) {
            currentPlayingHero.turnCount++;
        }
        if ((currentPlayingHero.turnCount < 11) && (currentPlayingHero.mana < 11)) {
            currentPlayingHero.mana++;
        }

        if (currentPlayingHero.myHand.cardsInHand.length < 10) {
            currentPlayingHero.drawACard();        
        }

        if ((p1Hero == currentPlayingHero) && (p2Hero == notCurrentPlayingHero)) {
            for(int i=0; i<currentPlayingHero.myField.cardsInBattlefield.length; i++){
                theCardsInBattlefield[i] = (Minions)currentPlayingHero.myField.cardsInBattlefield[i];
                if(theCardsInBattlefield[i] instanceof Minions) {
                    theCardsInBattlefield[i].setAttacksAvailable(0);
                }    
            }
            p1Hero.player1sTurn = 0;
            p2Hero.player2sTurn = 1;
        }

        if ((p2Hero == currentPlayingHero) && (p1Hero == notCurrentPlayingHero)) {
            for(int i=0; i<currentPlayingHero.myField.cardsInBattlefield.length; i++){
                theCardsInBattlefield[i] = (Minions)currentPlayingHero.myField.cardsInBattlefield[i];
                if(theCardsInBattlefield[i] instanceof Minions) {
                    theCardsInBattlefield[i].setAttacksAvailable(0);
                }    
            }    
            p1Hero.player1sTurn = 1;
            p2Hero.player2sTurn = 0;
        }
        p1Hero.heroPower = 1;
        p2Hero.heroPower = 1;
    }
}
