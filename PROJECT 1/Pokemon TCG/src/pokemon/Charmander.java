package pokemon;

public class Charmander extends Pokemon {

    public Charmander() {
        super("Charmander", 60); // Assume Charmander has 60 HP
    }

    public void ember(Pokemon target) {
        int damage = 20; // damage value
        target.takeDamage(damage);
        System.out.println("Charmander used Ember on " + target.getName() + " causing " + damage + " damage!");
    }

    public void flamethrower(Pokemon target) {
        int damage = 40; // damage value
        target.takeDamage(damage);
        System.out.println("Charmander used Flamethrower on " + target.getName() + " causing " + damage + " damage!");
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Attacks: Ember, Flamethrower");
    }
}
