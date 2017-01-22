package hearthstone;

import hearthstone.cards.Cards;

public class Hand {

    Cards cardsInHand[];

    public Hand() {

    }
    
    /**
     * 
     * @param bufferCard 
     */

    public void recieveCardFromDeck(Cards bufferCard) {

        if (cardsInHand == null) {
            cardsInHand = new Cards[1];
            cardsInHand[0] = bufferCard;
            //If there isn't any card in hand, create one new box for the first card        
        } else {
            Cards newCardsInHandBuffer[] = new Cards[cardsInHand.length + 1];//Creating new boxes for old + new card
            for (int i = 0; i < cardsInHand.length; i++) {
                newCardsInHandBuffer[i] = cardsInHand[i];//All old cards transfer to buffer
            }
            System.arraycopy(cardsInHand, 0, newCardsInHandBuffer, 0, cardsInHand.length);
            cardsInHand = newCardsInHandBuffer;//Turn buffer into cardsInHand[] 
            cardsInHand[cardsInHand.length - 1] = bufferCard;//New card fill up the last spot on the boxes
        }
    }

    public void deleteHandCards(int playingCard) {
        boolean swapped = true;
        Cards newCardsInHand[] = new Cards[cardsInHand.length - 1];
        Cards buffer;

        if (cardsInHand[playingCard] == null) {
            while (swapped) {
                swapped = false;
                for (int i = 1; i < cardsInHand.length; i++) {
                    if (cardsInHand[i - 1] == null && cardsInHand[i] != null) {//Using i-1 ensures it will never exceed the array length
                        buffer = cardsInHand[i - 1];
                        cardsInHand[i - 1] = cardsInHand[i];
                        cardsInHand[i] = buffer;
                        swapped = true;
                    }
                }
            }
        }
        System.arraycopy(cardsInHand, 0, newCardsInHand, 0, cardsInHand.length - 1);
        cardsInHand = newCardsInHand;
    }
}
