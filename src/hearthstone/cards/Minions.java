
package hearthstone.cards;

public class Minions extends Cards{

    int attack;
    public int health;
    int attacksAvailable = 0;// How many time can a minion attack in this turn,      charge will= 1; 
    boolean beast = false;
    boolean murloc = false;
    boolean taunt = false;
    boolean charge = false;
    boolean freeze = false;
    boolean damage = false;

    
    public Minions(int cost, String name, String information) {
        super(cost, name, information);       
    }
    
    /**
     * 
     * @return 
     */
    
    public String toString() {
        if(getAttacksAvailable() == 0) {
            String canTheyAttack = "Yes";
            
            return name + "\t\t\tMana-Cost:(" + cost + ") Attack:(" + attack + ") Health:(" + health + ") Effect:(" + information + ")  Attack Avaliable:(" + canTheyAttack + ")";
        } else{
            String canTheyAttack = "No";
            
            return name + "\t\t\tMana-Cost:(" + cost + ") Attack:(" + attack + ") Health:(" + health + ") Effect:(" + information + ")  Attack Avaliable:(" + canTheyAttack + ")";
        }
    }
    
    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
    public void setCost(int cost) {
        this.cost = cost;
    }
    
    public void setBeast(boolean beast) {
        this.beast = beast;
    }
    
    public void setMurloc(boolean murloc) {
        this.murloc = murloc;
    } 
    
    public void setTaunt(boolean taunt) {
        this.taunt = taunt;
    }
    
    public void setDamage(boolean damage) {
        this.damage = damage;
    }
    
    public void setAttacksAvailable(int attacksAvailable) {
        this.attacksAvailable = attacksAvailable;
    }

    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return health;
    }
    
    public int getCost() {
        return cost;
    }
    
    public boolean getBeast() {
        return beast;
    }
    
    public boolean getMurloc() {
        return murloc;
    }
    
    public boolean getDamage() {
        return damage;
    }
     
    public int getAttacksAvailable() {
        return this.attacksAvailable;
    }
    
    public boolean getTaunt() {
        return this.taunt;
    }
    

    
}
