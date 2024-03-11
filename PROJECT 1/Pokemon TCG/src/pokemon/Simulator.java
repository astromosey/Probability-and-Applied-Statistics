package pokemon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Simulator {

    private ArrayList<Card> deck;
    private ArrayList<Card> hand;
    private ArrayList<Card> bench;
    private Player mockPlayer;
    private GameState mockGameState;
    private final int simulations = 100000; // Number of simulations for Monte Carlo

    public Simulator() {
        deck = new ArrayList<>();
        hand = new ArrayList<>();
        bench = new ArrayList<>();
        initializeDeck();
        mockPlayer = new Player("Mock Player", new ArrayList<>(deck), 0); 
        mockGameState = new GameState(mockPlayer, null, deck, new ArrayList<>());
    }

    private void initializeDeck() {
        deck.clear();
        // Fill the deck with 20 Pokemon cards, 20 Energy cards, and 20 Trainer cards
        for (int i = 0; i < 20; i++) {
            deck.add(new Pokemon("Generic Pokemon " + i, 50)); // Add Pokemon cards
        }
        for (int i = 0; i < 20; i++) {
            deck.add(new Energy("Basic Energy " + i, "Generic Type")); // Add Energy cards
        }
        for (int i = 0; i < 20; i++) {
            deck.add(new GenericTrainer()); // Add GenericTrainer cards
        }
        shuffleDeck();

        if (deck.size() != 60) {
            throw new IllegalStateException("Deck must contain exactly 60 cards.");
        }
    }
       public List<Boolean> simulateMulligans() {
    List<Boolean> mulligansResults = new ArrayList<>();
    int mulliganCount = 0;
    for (int i = 0; i < simulations; i++) {
        Collections.shuffle(deck);
        ArrayList<Card> initialHand = new ArrayList<>(deck.subList(0, 7));
        boolean hasPokemon = initialHand.stream().anyMatch(card -> card instanceof Pokemon);
        mulligansResults.add(!hasPokemon);
        if (!hasPokemon) {
            mulliganCount++;
        }
    }
    double mulliganRate = (double) mulliganCount / simulations;
    System.out.println("Mulligan rate: " + mulliganRate);
    System.out.println("Mulligans results size: " + mulligansResults.size()); 

    // Verify the first few results
    for (int i = 0; i < Math.min(mulligansResults.size(), 10); i++) {
        System.out.println("Mulligan result " + (i + 1) + ": " + mulligansResults.get(i));
    }

    return mulligansResults;
}
    public void runSimulation() {
        System.out.println("Starting simulation...");
        drawInitialHand();
        simulateTurns(10);
        List<SimulationResult> simulationResults = new ArrayList<>();

        for (int rareCandyCount = 1; rareCandyCount <= 4; rareCandyCount++) {
            List<Boolean> successResults = simulateMulligans(); 

            long successCount = successResults.stream().filter(Boolean::booleanValue).count();
            double rateOfSuccess = (double) successCount / successResults.size();
            double rateOfBricks = 1 - rateOfSuccess;

            // Add the simulation result to the list
            simulationResults.add(new SimulationResult(16, rareCandyCount, rateOfSuccess, rateOfBricks));
        }
          simulatePokemonInDeck();
        // Save the collected results to a CSV file
        saveResultsToFile("simulation_results.csv", simulationResults);
        System.out.println("Results saved.");
    }

    private void saveResultsToFile(String fileName, List<SimulationResult> results) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.append("Pokemon in Deck,Rare Candy in Deck,Rate of Success,Rate of Bricks\n");
            for (SimulationResult result : results) {
                writer.append(result.getPokemonInDeck() + "," + result.getRareCandyInDeck() + "," +
                              result.getRateOfSuccess() + "," + result.getRateOfBricks() + "\n");
            }
            writer.flush();
        } catch (IOException e) {
            System.err.println("An error occurred while writing the file: " + e.getMessage());
        }
    }

    private void shuffleDeck() {
        Collections.shuffle(deck, new Random());
    }

    private void drawInitialHand() {
        for (int i = 0; i < 7 && !deck.isEmpty(); i++) {
            hand.add(deck.remove(0)); // Draw the top card
        }
        System.out.println("Initial hand drawn: " + hand.size() + " cards.");
    }

    private void simulateTurns(int numberOfTurns) {
        Pokemon activePokemon = null;
        for (int turn = 1; turn <= numberOfTurns; turn++) {
            if (deck.isEmpty()) {
                System.out.println("The deck is empty. Ending simulation.");
                break;
            }
            System.out.println("Turn " + turn);
            Card drawnCard = deck.remove(0);
            hand.add(drawnCard);
            System.out.println("Drew a card: " + drawnCard.getName());

        }
    }

    public static class SimulationResult {
        private int pokemonInDeck;
        private int rareCandyInDeck;
        private double rateOfSuccess;
        private double rateOfBricks;

        public SimulationResult(int pokemonInDeck, int rareCandyInDeck, double rateOfSuccess, double rateOfBricks) {
            this.pokemonInDeck = pokemonInDeck;
            this.rareCandyInDeck = rareCandyInDeck;
            this.rateOfSuccess = rateOfSuccess;
            this.rateOfBricks = rateOfBricks;
        }

        // Getters
        public int getPokemonInDeck() {
            return pokemonInDeck;
        }

        public int getRareCandyInDeck() {
            return rareCandyInDeck;
        }

        public double getRateOfSuccess() {
            return rateOfSuccess;
        }

        public double getRateOfBricks() {
            return rateOfBricks;
        }
    }
     private void initializeDeckWithPokemon(int pokemonCount) {
        deck.clear();
        // Fill the deck with a specified number of Pokemon cards and the rest with Energy cards
        for (int i = 0; i < pokemonCount; i++) {
            deck.add(new Pokemon("Generic Pokemon", 50)); 
        }
        for (int i = pokemonCount; i < 60; i++) {
            deck.add(new Energy("Generic Energy", "Generic Type")); 
        }
    }
     private List<Card> drawHand() {
        // Assume the first 7 cards are the hand
        return new ArrayList<>(deck.subList(0, Math.min(deck.size(), 7)));
    }
    private double simulateSuccessRateForPokemonCount(int pokemonCount) {
        int successCount = 0;
        for (int i = 0; i < simulations; i++) {
            initializeDeckWithPokemon(pokemonCount);
            Collections.shuffle(deck);
            List<Card> hand = drawHand();
            if (hand.stream().anyMatch(card -> card instanceof Pokemon)) {
                successCount++;
            }
        }
        return (double) successCount / simulations;
    }
public void simulatePokemonInDeck() {
        List<Double> successRates = new ArrayList<>();
        for (int i = 1; i <= 43; i++) { 
            double successRate = simulateSuccessRateForPokemonCount(i);
            successRates.add(successRate);
        }
        writePokemonSuccessRatesToFile("pokemon_success_rates.csv", successRates);
    }

    private void writePokemonSuccessRatesToFile(String fileName, List<Double> successRates) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.append("Pokemon in Deck,Rate of Success\n");
            for (int i = 0; i < successRates.size(); i++) {
                writer.append((i + 1) + "," + successRates.get(i) + "\n");
            }
            writer.flush();
        } catch (IOException e) {
            System.err.println("An error occurred while writing the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Simulator simulator = new Simulator();
        simulator.runSimulation();
    }
}
