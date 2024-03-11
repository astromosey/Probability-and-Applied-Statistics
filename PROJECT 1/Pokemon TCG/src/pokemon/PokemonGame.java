package pokemon;

import java.util.ArrayList;
import java.util.List;

import pokemon.GameState;
import pokemon.Pokemon;
import pokemon.Trainer;
public class PokemonGame {
    private Player playerOne;
    private Player playerTwo;
    private boolean isGameOver;
     private GameState gameState;
     private String name; 
    private List<Card> hand = new ArrayList<>();
    private List<Card> deck = new ArrayList<>();
    private List<Card> discardPile = new ArrayList<>();
    private Pokemon activePokemon;
    private int prizes; // Number of prizes the player has

    public PokemonGame(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.isGameOver = false;
    }



    public void runGame() {
        // Initial setup before the game starts
        System.out.println("Starting the Pokemon Card Game...");

        // Game loop
        while (!isGameOver) {
            // Player One's turn
            System.out.println("Player One's turn:");
            performTurn(playerOne);

            // Check if Player Two is out of prizes, indicating Player One has won
            if (checkForWin(playerTwo)) {
                System.out.println("Player One wins!");
                break;
            }

            // Player Two's turn
            System.out.println("Player Two's turn:");
            performTurn(playerTwo);

            // Check if Player One is out of prizes, indicating Player Two has won
            if (checkForWin(playerOne)) {
                System.out.println("Player Two wins!");
                break;
            }
        }

        System.out.println("Game Over");
    }

    private void performTurn(Player player) {
        System.out.println(player.getName() + "'s turn:");

        // 1. Draw a card
        player.drawCard();
        System.out.println(player.getName() + " draws a card.");

        // 2. Play cards from hand
        if (!player.getHand().isEmpty()) {
            Card card = player.getHand().get(0); 
            card.play();
            player.getHand().remove(card); // Remove the card from hand after playing it
        }

        // 3. Attack with Pokemon 
        if (player.getActivePokemon() != null && player.getActivePokemon().canAttack()) {
            // Assuming there's a method to get the opponent and their active Pokemon:
            Player opponent = getOpponent(player);
            Pokemon target = opponent.getActivePokemon();
            if (target != null) {
                player.getActivePokemon().attack(target);
            }
        }

        // End of the turn
        System.out.println(player.getName() + "'s turn ends.");
    }

    private Player getOpponent(Player player) {
        return player == playerOne ? playerTwo : playerOne;
    }

private int playerOneScore;
    private int playerTwoScore;
    private static final int WINNING_SCORE = 10; 


    public boolean checkForWin(Player player) {
        // Check if any player has reached the winning score
        if (playerOneScore >= WINNING_SCORE) {
            System.out.println("Player One wins the game!");
            return true;
        } else if (playerTwoScore >= WINNING_SCORE) {
            System.out.println("Player Two wins the game!");
            return true;
        }
        return false;
    }

    
    private void playCards(Player player) {
        for (Card card : new ArrayList<>(player.getHand())) {
            if (player.decidesToPlayCard(card)) {
                card.play();
                player.getHand().remove(card);
                System.out.println(player.getName() + " plays " + card.getName());

                if (card instanceof Pokemon) {
                } else if (card instanceof Energy) {
                    // Attach energy to a Pokemon
                } 
                  else if (card instanceof Trainer) {
            ((Trainer) card).executeEffect(player, gameState);
        }
        player.getHand().remove(card); // Remove the card after playing
            }
        }
    }
private void executeTrainerCardEffect(Trainer trainerCard, Player player, GameState gameState) {
    System.out.println(player.getName() + " uses Trainer card " + trainerCard.getName() + " effect.");
    trainerCard.executeEffect(player, gameState);
}


    private void attackOpponent(Player player) {
        Player opponent = getOpponent(player);
        Pokemon target = opponent.getActivePokemon();
        if (target != null) {
            player.getActivePokemon().attack(target);
            System.out.println(player.getActivePokemon().getName() + " attacks " + target.getName());

            // End the turn after attacking 
        }
    }

  
}
