package pokemon;
public class Card {
    private String name;

    public Card(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void play() {
        System.out.println("Playing card: " + name);
    }

    public void display() {
        System.out.println("Card Name: " + name);
    }
}
