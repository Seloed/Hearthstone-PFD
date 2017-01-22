package hearthstone.cards;

public class LordOfTheArena extends Minions{
    
    public LordOfTheArena() {
        super(6, "Lord of the Arena", "Taunt");
        
        this.attack = 6;
        this.health = 5;
        this.attacksAvailable = 1;
        this.taunt  = true;
    }    
}
