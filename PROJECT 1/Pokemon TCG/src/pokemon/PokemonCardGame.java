package pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PokemonCardGame {

    private Player currentPlayer;
    private Player opponent;
    private GameState gameState;
    private Scanner scanner;

    public PokemonCardGame() {
        this.scanner = new Scanner(System.in);
        initializeGame();
    }

    private void initializeGame() {
        List<Card> playerOneDeck = generateFullDeck();
        List<Card> playerTwoDeck = generateFullDeck();
        this.currentPlayer = new Player("Player 1", playerOneDeck, 3);
        this.opponent = new Player("Player 2", playerTwoDeck, 3);
        this.gameState = new GameState(currentPlayer, opponent, new ArrayList<>(currentPlayer.getDeck()), new ArrayList<>());
        System.out.println("Game has been initialized.");
    }

    private List<Card> generateFullDeck() {
        List<Card> deck = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            deck.add(new Pokemon("Pokemon " + i, 50)); 
        }
        return deck;
    }

    public void playGame() {
        while (!gameState.isGameOver()) {
            playTurn(currentPlayer);
            if (gameState.isGameOver()) {
                break;
            }
            switchPlayers();
        }
        announceWinner();
    }

    private void playTurn(Player player) {
        System.out.println("\n" + player.getName() + "'s turn:");
        System.out.println("Hand: ");
        listPlayerHand(player);

        int action = getPlayerAction();
        
        switch (action) {
            case 1: // Draw a card
                drawCard(player);
                break;
            case 2: // Play a card
                playCard(player);
                break;
            case 3: // Attack
                performAttack(player);
                break;
            default:
                System.out.println("Invalid action. Please try again.");
                break;
        }
    }

    private int getPlayerAction() {
        System.out.println("Choose an action: ");
        System.out.println("1: Draw a card");
        System.out.println("2: Play a card");
        System.out.println("3: Attack");
        System.out.print("Enter choice (1-3): ");
        return scanner.nextInt();
    }

    private void listPlayerHand(Player player) {
        int index = 1;
        for (Card card : player.getHand()) {
            System.out.println(index++ + ": " + card.getName());
        }
    }

    private void drawCard(Player player) {
        if (!player.getDeck().isEmpty()) {
            Card card = player.getDeck().remove(0);
            player.getHand().add(card);
            System.out.println(player.getName() + " drew a card: " + card.getName());
        } else {
            System.out.println(player.getName() + "'s deck is empty.");
        }
    }

    private void playCard(Player player) {
        System.out.println("Select a card to play: ");
        int cardIndex = scanner.nextInt();
        if (cardIndex > 0 && cardIndex <= player.getHand().size()) {
            Card card = player.getHand().get(cardIndex - 1);
            card.play();
            player.getHand().remove(card);
        } else {
            System.out.println("Invalid card selection.");
        }
    }

    private void performAttack(Player player) {
        if (player.getActivePokemon() != null) {
            System.out.println(player.getName() + " attacks with " + player.getActivePokemon().getName());
        }
    }

    private void switchPlayers() {
        Player temp = currentPlayer;
        currentPlayer = opponent;
        opponent = temp;
        gameState.setActivePlayer(currentPlayer);
    }

    private void announceWinner() {
        System.out.println("Game Over. Winner: " + currentPlayer.getName());
    }
}
