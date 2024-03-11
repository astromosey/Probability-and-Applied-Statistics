package pokemon;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> hand = new ArrayList<>();
    private List<Card> discardPile = new ArrayList<>();
    private List<Card> deck = new ArrayList<>();
//      private List<Card> hand = new ArrayList<>();
    private List<Card> prizeCards = new ArrayList<>(); // List to hold the prize cards
    private List<Pokemon> bench = new ArrayList<>();
//    private List<Card> hand = new ArrayList<>();
//    private List<Card> discardPile = new ArrayList<>();
       private String name; // Assuming a name field for identification
//    private List<Card> hand = new ArrayList<>();
//    private List<Card> deck = new ArrayList<>();
//    private List<Card> discardPile = new ArrayList<>();
    private Pokemon activePokemon;
    private int prizes; // Number of prizes the player has
     

    // Method to set the active Pokemon
    public void setActivePokemon(Pokemon pokemon) {
        this.activePokemon = pokemon;
    }

    // Method to get the active Pokemon
    public Pokemon getActivePokemon() {
        return activePokemon;
    }
    public List<Card> getHand() {
        return hand;
    }
public Player(String name, List<Card> initialDeck, int startingPrizes) {
        this.name = name;
        // Initialize deck, shuffle, and draw initial hand in constructor
        this.prizes = startingPrizes;
    
        if (initialDeck.size() == 60) {
            this.deck = new ArrayList<>(initialDeck); // Initialize the deck with 60 cards
            shuffleDeck(); // Shuffle the deck before starting the game
            drawInitialHand(); // Draw the initial hand of 7 cards
        } else {
            throw new IllegalArgumentException("Initial deck must contain 60 cards.");
        }
    }

    private void shuffleDeck() {
        // Shuffle the deck of cards
        java.util.Collections.shuffle(deck);
    }

    private void drawInitialHand() {
        for (int i = 0; i < 7 && !deck.isEmpty(); i++) {
            drawCard();
        }
    }
 public String getName() {
        return this.name;
    }
 public boolean isOutOfPrizes() {
        return this.prizes <= 0;
    }
        public boolean decidesToPlayCard(Card card) {
        return true;
    }
        public void printHand(Player player) {
    System.out.println(player.getName() + "'s hand:");
    for (Card card : player.getHand()) {
        System.out.println(card.getName());
    }
}
public void printField(GameState gameState) {
    System.out.println("Active Player: " + gameState.getActivePlayer().getName());
    System.out.println("Active Pokémon: " + (gameState.getActivePlayer().getActivePokemon() != null ? gameState.getActivePlayer().getActivePokemon().getName() : "None"));
    System.out.println("Bench: ");
    for (Card card : gameState.getActivePlayer().getBench()) {
        if (card instanceof Pokemon) {
            System.out.println(((Pokemon) card).getName());
        }
    }
}

public void printPrizeCards(Player player) {
    System.out.println(player.getName() + "'s prize cards:");
    for (Card card : player.getPrizeCards()) { 
        System.out.println(card.getName());
    }
}
   // Method to get the player's prize cards
    public List<Card> getPrizeCards() {
        return prizeCards;
    }

    // Method to get the player's bench
    public List<Pokemon> getBench() {
        return bench;
    }

    public boolean decidesToAttack() {
        return true;
    }

    public void losePrize() {
        if (this.prizes > 0) {
            this.prizes--;
        }
    }
    public void drawCard() {
        if (!deck.isEmpty()) {
            hand.add(deck.remove(0)); // Draw the top card from the deck
        } else {
            System.out.println("The deck is empty, cannot draw a card.");
        }
    }

 

    
  

    public List<Card> getDeck() {
        return deck;
    }

    public List<Card> getDiscardPile() {
        return discardPile;
    }

  

    public void clearHand() {
        hand.clear();
    }

    public void drawCard(List<Card> deck) {
        if (!deck.isEmpty()) {
            hand.add(deck.remove(0)); // Assumes the top card is at the beginning of the list
        }
    }
}
