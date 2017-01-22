package hearthstone;

import hearthstone.cards.Cards;

public class Paladin extends Hero {

    public Paladin(String heroName) {
        super(heroName);

    }

    @Override
    public int getHealth() {
        return health;
    }

    /**
     * 
     * @param notCurrentPlayingHero
     * @param currentPlayingHero
     * @param cost 
     */
    
    public void heroPower(Hero notCurrentPlayingHero, Hero currentPlayingHero, int cost) {
        cost = 2;

        Cards SilverHandRecruit = new hearthstone.cards.SilverHandRecruit();
        currentPlayingHero.myField.putHandCardIntoBattlefield(SilverHandRecruit);

    }
}
