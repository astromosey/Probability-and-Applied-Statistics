package pokemon;

public class GenericTrainer extends Trainer {

    public GenericTrainer() {
        super("Generic Trainer");
    }

    @Override
    public void executeEffect(Player player, GameState gameState) {
        System.out.println("Executing effect of Generic Trainer.");
        if (!gameState.getActiveDeck().isEmpty()) {
            Card card = gameState.getActiveDeck().remove(0);
            player.getHand().add(card);
            System.out.println(player.getName() + " draws 1 card from Generic Trainer.");
        }
    }
}
