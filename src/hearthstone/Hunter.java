package hearthstone;

public class Hunter extends Hero {

    public Hunter(String heroName) {
        super(heroName);
    }

    @Override

    public int getHealth() {
        return health;
    }

    /**
     * 
     * @param opponent
     * @param me
     * @param cost 
     */
    
    public void heroPower(Hero opponent, Hero me, int cost) {
        cost = 2;

        opponent.setHealth(opponent.health - 2);
    }
}
