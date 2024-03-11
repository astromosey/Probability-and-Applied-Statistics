package pokemon;

public class Bulbasaur extends Pokemon {

    public Bulbasaur() {
        super("Bulbasaur", 70);
    }

    public void vineWhip(Pokemon target) {
        int damage = 15;
        target.takeDamage(damage);
        System.out.println("Bulbasaur used Vine Whip on " + target.getName());
    }

    public void seedBomb(Pokemon target) {
        int damage = 30;
        target.takeDamage(damage);
        System.out.println("Bulbasaur used Seed Bomb on " + target.getName());
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Attacks: Vine Whip, Seed Bomb");
    }
}
