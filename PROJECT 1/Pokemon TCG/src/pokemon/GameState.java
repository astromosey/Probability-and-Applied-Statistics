package pokemon;

import java.util.ArrayList;
import java.util.List;

public class GameState {
    private Player activePlayer;
    private Player opponentPlayer;
    private int turnNumber;
    private ArrayList<Card> activeDeck;
    private ArrayList<Card> activeDiscardPile;

    public GameState(Player activePlayer, Player opponentPlayer, ArrayList<Card> activeDeck, ArrayList<Card> activeDiscardPile) {
        this.activePlayer = activePlayer;
        this.opponentPlayer = opponentPlayer;
        this.turnNumber = 1; // Initialize the turn number to 1
        this.activeDeck = activeDeck;
        this.activeDiscardPile = activeDiscardPile;
    }

    // Getters and setters for the fields
    public Player getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(Player activePlayer) {
        this.activePlayer = activePlayer;
    }

    public Player getOpponentPlayer() {
        return opponentPlayer;
    }

    public void setOpponentPlayer(Player opponentPlayer) {
        this.opponentPlayer = opponentPlayer;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }

    public List<Card> getActiveDeck() {
        return activeDeck;
    }

    public void setActiveDeck(ArrayList<Card> activeDeck) {
        this.activeDeck = activeDeck;
    }

    public List<Card> getActiveDiscardPile() {
        return activeDiscardPile;
    }

    public void setActiveDiscardPile(ArrayList<Card> activeDiscardPile) {
        this.activeDiscardPile = activeDiscardPile;
    }
    public boolean isGameOver() {
        if (activePlayer.getDeck().isEmpty() || opponentPlayer.getDeck().isEmpty()) {
            return true; // Game over if either player's deck is empty
        }
        return false;
    }
    
    // Method to get the opponent player
    public Player getOpponentPlayer(Player currentPlayer) {
        if (currentPlayer == activePlayer) {
            return opponentPlayer;
        } else {
            return activePlayer;
        }
    }
}
