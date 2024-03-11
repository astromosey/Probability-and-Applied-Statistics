package pokemon;

public abstract class Trainer extends Card {

    public Trainer(String name) {
        super(name);
    }

    public void playEffect() {
        System.out.println("Trainer card " + getName() + " effect activated.");
    }
    

   public abstract void executeEffect(Player player, GameState gameState);

    @Override
    public void play() {
        System.out.println("Playing Trainer card: " + getName());
    }
}
