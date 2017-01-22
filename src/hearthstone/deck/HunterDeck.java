
package hearthstone.deck;

import hearthstone.cards.Cards;

public class HunterDeck extends Deck{

    public HunterDeck() {
        listOfCards  = new Cards [30];        
        manaCoin = new Cards [1];
        
        manaCoin[0] = new hearthstone.cards.ManaCoin();
        
        listOfCards[0]  = new hearthstone.cards.ArcaneShot();
        listOfCards[1]  = new hearthstone.cards.ArcaneShot();
        listOfCards[2]  = new hearthstone.cards.TimberWolf();
        listOfCards[3]  = new hearthstone.cards.TimberWolf();
        listOfCards[4]  = new hearthstone.cards.HuntersMark();
        listOfCards[5]  = new hearthstone.cards.HuntersMark();
        listOfCards[6]  = new hearthstone.cards.StonetuskBoar();
        listOfCards[7]  = new hearthstone.cards.StonetuskBoar();
        listOfCards[8]  = new hearthstone.cards.BlooddfenRaptor();
        listOfCards[9]  = new hearthstone.cards.BlooddfenRaptor();
        listOfCards[10] = new hearthstone.cards.RiverCrocolisk();
        listOfCards[11] = new hearthstone.cards.RiverCrocolisk();
        listOfCards[12] = new hearthstone.cards.AnimalCompanion();
        listOfCards[13] = new hearthstone.cards.AnimalCompanion();
        listOfCards[14] = new hearthstone.cards.KillCommand();
        listOfCards[15] = new hearthstone.cards.KillCommand();
        listOfCards[16] = new hearthstone.cards.SilverbackPatriarch();
        listOfCards[17] = new hearthstone.cards.SilverbackPatriarch();
        listOfCards[18] = new hearthstone.cards.IronfurGrizzly();
        listOfCards[19] = new hearthstone.cards.IronfurGrizzly();
        listOfCards[20] = new hearthstone.cards.Houndmaster();
        listOfCards[21] = new hearthstone.cards.Houndmaster();
        listOfCards[22] = new hearthstone.cards.Multishot();
        listOfCards[23] = new hearthstone.cards.Multishot();
        listOfCards[24] = new hearthstone.cards.OasisSnapjaw();
        listOfCards[25] = new hearthstone.cards.OasisSnapjaw();
        listOfCards[26] = new hearthstone.cards.StarvingBuzzard();
        listOfCards[27] = new hearthstone.cards.StarvingBuzzard();
        listOfCards[28] = new hearthstone.cards.CoreHound();
        listOfCards[29] = new hearthstone.cards.CoreHound();
    }  
}
