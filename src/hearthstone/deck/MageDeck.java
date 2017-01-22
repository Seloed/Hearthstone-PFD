
package hearthstone.deck;

import hearthstone.cards.Cards;

public class MageDeck extends Deck{
   
    public MageDeck() {
        listOfCards  = new Cards [30];
        manaCoin = new Cards [1];
        
        manaCoin[0] = new hearthstone.cards.ManaCoin();
           
        listOfCards[0]  = new hearthstone.cards.ArcaneMissiles();
        listOfCards[1]  = new hearthstone.cards.ArcaneMissiles();
        listOfCards[2]  = new hearthstone.cards.MirrorImage();
        listOfCards[3]  = new hearthstone.cards.ArcaneExplosion();
        listOfCards[4]  = new hearthstone.cards.Frostbolt();
        listOfCards[5]  = new hearthstone.cards.BlooddfenRaptor();
        listOfCards[6]  = new hearthstone.cards.BlooddfenRaptor();
        listOfCards[7]  = new hearthstone.cards.ArcaneIntellect();
        listOfCards[8]  = new hearthstone.cards.ArcaneIntellect();
        listOfCards[9]  = new hearthstone.cards.RazorfenHunter();
        listOfCards[10] = new hearthstone.cards.RazorfenHunter();
        listOfCards[11] = new hearthstone.cards.ShatteredSunCleric();
        listOfCards[12] = new hearthstone.cards.ShatteredSunCleric();
        listOfCards[13] = new hearthstone.cards.Fireball();
        listOfCards[14] = new hearthstone.cards.Polymorph();
        listOfCards[15] = new hearthstone.cards.WaterElemental();
        listOfCards[16] = new hearthstone.cards.WaterElemental();
        listOfCards[17] = new hearthstone.cards.ChillwindYeti();
        listOfCards[18] = new hearthstone.cards.ChillwindYeti();
        listOfCards[19] = new hearthstone.cards.GnomishInventor();
        listOfCards[20] = new hearthstone.cards.GnomishInventor();
        listOfCards[21] = new hearthstone.cards.SenjinShieldmasta();
        listOfCards[22] = new hearthstone.cards.SenjinShieldmasta();
        listOfCards[23] = new hearthstone.cards.BoulderfistOgre();
        listOfCards[24] = new hearthstone.cards.BoulderfistOgre();
        listOfCards[25] = new hearthstone.cards.LordOfTheArena();
        listOfCards[26] = new hearthstone.cards.LordOfTheArena();
        listOfCards[27] = new hearthstone.cards.Flamestrike();
        listOfCards[28] = new hearthstone.cards.Flamestrike();
        listOfCards[29] = new hearthstone.cards.WarGolem();      
    }
}

