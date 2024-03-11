package pokemon;
public class Pikachu extends Pokemon {

    public Pikachu() {
        super("Pikachu", 70);
    }

    public void quickAttack(Pokemon target) {
        int damage = 10;
        target.takeDamage(damage);
        System.out.println("Pikachu used Quick Attack!");
    }

    public void thunderbolt(Pokemon target) {
        int damage = 50;
        target.takeDamage(damage);
        System.out.println("Pikachu used Thunderbolt!");
    }


    @Override
    public void display() {
        super.display();
        System.out.println("Attacks: Quick Attack, Thunderbolt");
    }
}
