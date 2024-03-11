package pokemon;

public interface TrainerAction {

	// Method to execute the primary action of the Trainer card.
	void executeAction(GameState gameState);

	// Method to check if the Trainer card can be played given the current game state.
	boolean canPlay(GameState gameState);

	default void postAction(GameState gameState) {
	}
}
