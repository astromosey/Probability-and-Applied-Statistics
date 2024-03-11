package pokemon;

public class Energy extends Card {

    private String energyType; // The type of the energy (e.g., Fire, Water, Grass)

    // Constructor to initialize an energy card with its name and type
    public Energy(String name, String energyType) {
        super(name); 
        this.energyType = energyType;
    }

    // Getter for the energy type
    public String getEnergyType() {
        return energyType;
    }

    // Setter for the energy type
    public void setEnergyType(String energyType) {
        this.energyType = energyType;
    }

    @Override
    public void play() {
        System.out.println("Energy card played: " + getName() + " - Type: " + energyType);
    }

    // Override the display method to include energy type details
    @Override
    public void display() {
        super.display();
        System.out.println("Energy Type: " + energyType);
    }
}
