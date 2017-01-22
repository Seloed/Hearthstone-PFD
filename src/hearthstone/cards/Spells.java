
package hearthstone.cards;

public class Spells extends Cards {
    int attack;
    boolean damage = false;

    public Spells(int cost, String name, String information) {
        super(cost, name, information);
    }
    
    /**
     * 
     * @return 
     */
    
    public String toString() {
        return this.name + "\t\t\tMana-Cost:(" + cost + ") Effect:(" + information + ")";
    }
    
    public void setCost(int cost) {
        this.cost = cost;
    }
    
    public void setAttack(int attack) {
        this.attack = attack;
    }   
    
    public void setDamage(boolean damage) {
        this.damage = damage;
    }
    
    public int getCost() {
        return cost;
    }
    
    public int getAttack() {
        return attack;
    }  
    
    public boolean getDamage() {
        return damage;
    }
}
