package hearthstone.deck;

import hearthstone.cards.Cards;
import java.util.Random;

public class Deck {

    public Cards[] listOfCards;
    public Cards[] manaCoin;
    Random RNG = new Random();

    public Cards[] getListOfCards() {
        return listOfCards;
    }

    public void setListOfCards(Cards[] listOfCards) {
        this.listOfCards = listOfCards;
    }

    public Cards manaCoin() {
        Cards cardNeedsToSend = null;
        cardNeedsToSend = manaCoin[0];
    
        return cardNeedsToSend;
    }
    
    public Cards removeCardFromDeck() {
        //This is a deleting card function when we draw a card
        //It also has the fuction to send the card to Hand
        Cards newListOfCards[] = new Cards[listOfCards.length - 1];  //New cards list for the deck after deleting
        Cards cardNeedsToSend = null;//Buffer, also the card that we draw and need to send to Hand
        int randomNumber = RNG.nextInt(listOfCards.length - 1);
        cardNeedsToSend = listOfCards[randomNumber];//Card chosen by random number and put that card into Buffer

        if (listOfCards != null) {
            for (int i = 0; i < randomNumber - 1; i++) {
                newListOfCards[i] = listOfCards[i];//Move cards before cardNeedsToSend into new boxes
            }
            for (int j = randomNumber; j < listOfCards.length - 2; j++) {
                newListOfCards[j] = listOfCards[j + 1];//Move cards after cardNeedsToSend into new boxes
            }
        } else {
            return null;
        }
        return cardNeedsToSend;
    }
    
    public void limitTheAmountOfCardsFromDeck(Cards cardNeedsToSend) {   
        boolean swapped = true;
        Cards tempListOfCards[] = new Cards[listOfCards.length - 1];
        Cards buffer;
        
        //cardNeedsToSend is the buffer where the value of the card is stored
        //Swap cardNeedsToSend with the last card in the array and then remove the card by shrinking the array         
        while(swapped) {
            swapped = false;
            for(int i=1; i<listOfCards.length; i++) {
                if(listOfCards[i-1] == cardNeedsToSend && listOfCards[listOfCards.length - 1] != cardNeedsToSend) {//Using i-1 insures it will never exceed the array length
                    buffer = listOfCards[i-1];
                    listOfCards[i-1] = listOfCards[listOfCards.length - 1];
                    listOfCards[listOfCards.length - 1] = buffer; 
                    swapped = true;
                }
            }
        }       
        System.arraycopy(listOfCards, 0, tempListOfCards, 0, listOfCards.length - 1);
        listOfCards = tempListOfCards;
    }
}
