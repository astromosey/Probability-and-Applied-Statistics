package pokemon;

public class RareCandy extends Card {

    public RareCandy() {
        super("Rare Candy"); 
    }

    @Override
    public void play() {
        // Define what happens when a Rare Candy card is played
        System.out.println("Rare Candy played: This card can be used to evolve a Pokemon.");
    }

    @Override
    public void display() {
        // Display the card's details
        System.out.println("Card Name: " + getName());
    }
    
}
