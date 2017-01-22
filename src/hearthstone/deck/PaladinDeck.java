
package hearthstone.deck;

import hearthstone.cards.Cards;

public class PaladinDeck extends Deck{

    public PaladinDeck() {
        listOfCards  = new Cards [30];
        manaCoin = new Cards [1];
        
        manaCoin[0] = new hearthstone.cards.ManaCoin();

        listOfCards[0]  = new hearthstone.cards.BlessingOfMight();
        listOfCards[1]  = new hearthstone.cards.BlessingOfMight();
        listOfCards[2]  = new hearthstone.cards.Humility();
        listOfCards[3]  = new hearthstone.cards.Humility();
        listOfCards[4]  = new hearthstone.cards.ElvenArcher();
        listOfCards[5]  = new hearthstone.cards.ElvenArcher();
        listOfCards[6]  = new hearthstone.cards.GoldshireFootman();
        listOfCards[7]  = new hearthstone.cards.GoldshireFootman();
        listOfCards[8]  = new hearthstone.cards.GrimscaleOracle();
        listOfCards[9]  = new hearthstone.cards.GrimscaleOracle();
        listOfCards[10] = new hearthstone.cards.MurlocTidehunter();
        listOfCards[11] = new hearthstone.cards.MurlocTidehunter();
        listOfCards[12] = new hearthstone.cards.BluegillWarrior();
        listOfCards[13] = new hearthstone.cards.BluegillWarrior();
        listOfCards[14] = new hearthstone.cards.IronforgeRifleman();
        listOfCards[15] = new hearthstone.cards.IronforgeRifleman();
        listOfCards[16] = new hearthstone.cards.HammerOfWrath();
        listOfCards[17] = new hearthstone.cards.HammerOfWrath();
        listOfCards[18] = new hearthstone.cards.BlessingOfKings();
        listOfCards[19] = new hearthstone.cards.BlessingOfKings();
        listOfCards[20] = new hearthstone.cards.Consecration();
        listOfCards[21] = new hearthstone.cards.Consecration();
        listOfCards[22] = new hearthstone.cards.DragonlingMechanic();
        listOfCards[23] = new hearthstone.cards.DragonlingMechanic();
        listOfCards[24] = new hearthstone.cards.FrostwolfWarlord();
        listOfCards[25] = new hearthstone.cards.FrostwolfWarlord();
        listOfCards[26] = new hearthstone.cards.GuardianOfKings();
        listOfCards[27] = new hearthstone.cards.GuardianOfKings();
        listOfCards[28] = new hearthstone.cards.StormwindChampion();
        listOfCards[29] = new hearthstone.cards.StormwindChampion();
    }
}
