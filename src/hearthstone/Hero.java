package hearthstone;

import hearthstone.cards.Cards;
import hearthstone.deck.Deck;
import hearthstone.deck.HunterDeck;
import hearthstone.deck.MageDeck;
import hearthstone.deck.PaladinDeck;
import java.util.Random;

public class Hero {

    public int health;
    int heroPower;
    int mana;
    int turnCount;
    int currentMana;
    int choice;
    int count = 0;
    int dealDamage;
    int recieveDamage;
    int restriction;
    int restrictionTwo = 0;
    int attackRestriction;
    int player1sTurn;
    int player2sTurn;
    int cost;
    String name;
    public Deck myDeck;
    public Hand myHand;
    public Battlefield myField;

    
    private Random RNG = new Random();

    public Hero(String name) {
        this.name = name;//This. grabs variables and methods from within the class even if they are private. 
        health = 30;
        cost = 2;
        mana = 0;
    }

    /**
     * 
     * @param health 
     */
    
    public void setHealth(int health) {
        this.health = health;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void heroPower(Hero opponent, Hero me, int cost) {

    }

    public void setMana(int mana) {
        this.currentMana = mana;
    }

    public int getHealth() {
        return health;
    }

    public int getCost() {
        return cost;
    }
    
    public int getMana() {
        return currentMana;
    }

    Hero chooseClass(int choice) {

        if ((choice == 1) && (restriction == 0)) {
            restriction = 1;
            Hunter playerOne = new Hunter("Hunter");
            playerOne.myDeck = new HunterDeck();
            playerOne.myHand = new Hand();
            playerOne.myField = new Battlefield();

            return playerOne;
        }
        if ((choice == 1) && (restriction == 1)) {
            Hunter playerTwo = new Hunter("Hunter");
            playerTwo.myDeck = new HunterDeck();
            playerTwo.myHand = new Hand();
            playerTwo.myField = new Battlefield();

            return playerTwo;
        }
        if ((choice == 2) && (restriction == 0)) {
            restriction = 1;
            Mage playerOne = new Mage("Mage");
            playerOne.myDeck = new MageDeck();
            playerOne.myHand = new Hand();
            playerOne.myField = new Battlefield();

            return playerOne;
        }
        if ((choice == 2) && (restriction == 1)) {
            Mage playerTwo = new Mage("Mage");
            playerTwo.myDeck = new MageDeck();
            playerTwo.myHand = new Hand();
            playerTwo.myField = new Battlefield();

            return playerTwo;
        }
        if ((choice == 3) && (restriction == 0)) {
            restriction = 1;
            Paladin playerOne = new Paladin("Paladin");
            playerOne.myDeck = new PaladinDeck();
            playerOne.myHand = new Hand();
            playerOne.myField = new Battlefield();

            return playerOne;
        }
        if ((choice == 3) && (restriction == 1)) {
            Paladin playerTwo = new Paladin("Paladin");
            playerTwo.myDeck = new PaladinDeck();
            playerTwo.myHand = new Hand();
            playerTwo.myField = new Battlefield();

            return playerTwo;
        }
        return null;
    }

    public void drawACard() {
        //Everytime when we need to draw a card, call this function
        Cards cardDrawn = null;

        cardDrawn = myDeck.removeCardFromDeck();//Get card from Deck to Hand
        myHand.recieveCardFromDeck(cardDrawn);//Recieve from Hand
        myDeck.limitTheAmountOfCardsFromDeck(cardDrawn);
    }
    
    public void drawManaCoin() {
        Cards cardDrawn = null;

        cardDrawn = myDeck.manaCoin();//Get card from Deck to Hand
        myHand.recieveCardFromDeck(cardDrawn);//Recieve from Hand
        myDeck.limitTheAmountOfCardsFromDeck(cardDrawn);
    }
}
