package pokemon;

public class TestPokemonCardGame {

	public static void main(String[] args) {
		System.out.println("Starting Pokemon Card Game simulation...");

		// Initialize the Pokemon card game
		PokemonCardGame game = new PokemonCardGame();

		// Run the game
		game.playGame();

		System.out.println("Pokemon Card Game simulation ended.");
	}
}
