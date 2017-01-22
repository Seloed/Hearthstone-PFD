package hearthstone.cards;

import hearthstone.Hero;

public abstract class Cards {
    
    public int cost;
    public String name;
    public String information;

    public Cards(int cost, String name, String information) {
        this.cost = cost;
        this.name = name;
        this.information = information;
    }
    
    /**
     * 
     * @param currentPlayingHero
     * @param notCurrentPlayingHero 
     */
    
    public void effect(Hero currentPlayingHero, Hero notCurrentPlayingHero) {
       
    }
}
