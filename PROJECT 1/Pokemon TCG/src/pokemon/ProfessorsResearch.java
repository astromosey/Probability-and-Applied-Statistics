package pokemon;

import java.util.ArrayList;
import java.util.List;

public abstract class ProfessorsResearch extends Trainer {

    public ProfessorsResearch() {
        super("Professor's Research");  
    }
@Override
    public void executeEffect(Player player, GameState gameState) {
        // Example logic: Discard hand and draw seven new cards
        player.getDiscardPile().addAll(player.getHand());
        player.getHand().clear();
        for (int i = 0; i < 7; i++) {
            if (!gameState.getActiveDeck().isEmpty()) {
                player.getHand().add(gameState.getActiveDeck().remove(0));
            }
        }
        System.out.println("Professor's Research executed: Player discarded hand and drew 7 new cards.");
    }
    /**
     * Applies the effect of Professor's Research card.
     * The player discards their hand and draws seven new cards from the deck.
     *
     * @param player The player who plays this card.
     * @param deck The deck from which the player will draw new cards.
     */
    public void applyEffect(Player player, List<Card> deck) {
        // Discard the current hand
        ArrayList<Card> discardedCards = (ArrayList<Card>) player.getHand();
        player.getDiscardPile().addAll(discardedCards);
        player.clearHand();

        // Draw seven new cards from the deck
        for (int i = 0; i < 7; i++) {
            if (!deck.isEmpty()) {
                player.drawCard(deck);
            } else {
                System.out.println("Not enough cards in the deck to draw 7 cards.");
                break;
            }
        }

        System.out.println("Professor's Research played: Discarded hand and drew 7 new cards.");
    }
}
