package pokemon;

import java.util.ArrayList;

public class Pokemon extends Card {
    
    private int hp;
    private String type; 
    private int energyLevel;
    private static final int MAX_ENERGY_CAPACITY = 100; // maximum energy capacity
     private ArrayList<Energy> attachedEnergy; // Energy cards attached to the Pokémon

    public Pokemon(String name, int hp) {
        super(name);
        this.hp = hp;
        this.energyLevel = 0; // Initialize energy level to 0
      this.attachedEnergy = new ArrayList<>();
    }

   public void attachEnergy(Energy energyCard) {
        attachedEnergy.add(energyCard);
    }
   public boolean canAttack() {
    int energyCardsAttached = attachedEnergy.size();
    
    int energyRequirement = 1; // energy requirement for an attack
    
    return energyCardsAttached >= energyRequirement;
}
public void attack(Pokemon target) {
        int damage = 10; 
        target.takeDamage(damage);
        System.out.println(getName() + " used an attack on " + target.getName() + "!");
    }

    public boolean hasMaxEnergy() {
        return energyLevel >= MAX_ENERGY_CAPACITY;
    }
    

    public void takeDamage(int damage) {
        this.hp -= damage;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }
 


    // Getters and setters
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = Math.max(hp, 0); // Ensures the HP is not set to a negative value
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void play() {
        System.out.println(getName() + " played to the field!");
    }

    // Method to display the Pokemon's details
    @Override
    public void display() {
        System.out.println("Pokemon: " + getName() + ", HP: " + hp + ", Type: " + type);
    }

 
}
