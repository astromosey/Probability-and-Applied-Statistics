package pokemon;

import java.util.ArrayList;
import java.util.Random;

public abstract class Nestball extends Trainer {

	public Nestball() {
		super("Nestball"); 
	}

	// This method simulates the effect of playing the Nestball card
	public void play(ArrayList<Card> deck, ArrayList<Card> bench) {
		// Check if the deck has any cards left to search through
		if (deck.isEmpty()) {
			System.out.println("The deck is empty, Nestball has no effect.");
			return;
		}

		ArrayList<Card> pokemonCards = new ArrayList<>();
		for (Card card : deck) {
			if (card instanceof Pokemon) {
				pokemonCards.add(card);
			}
		}

		// If there are Pokemon in the deck
		if (!pokemonCards.isEmpty()) {
			Random random = new Random();
			int index = random.nextInt(pokemonCards.size());
			Card selectedPokemon = pokemonCards.get(index);

			bench.add(selectedPokemon);
			deck.remove(selectedPokemon);

			System.out.println("Nestball played: " + selectedPokemon.getName() + " added to the bench.");
		} else {
			System.out.println("No Pokémon found in the deck.");
		}
	}
}
