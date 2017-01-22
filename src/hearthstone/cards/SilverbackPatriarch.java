
package hearthstone.cards;

public class SilverbackPatriarch extends Minions{
    
    public SilverbackPatriarch() {
        super(3, "Silverback Patriarch", "Taunt");
        
        this.attack = 1;
        this.health = 4;
        this.attacksAvailable = 1;
        this.beast = true;
        this.taunt  = true;
    }    
}
