package pokemon;

public class TestSim {

    public static void main(String[] args) {
        System.out.println("Starting the simulation...");

        // Initialize the simulator
        Simulator simulator = new Simulator();

        // Run the simulation
        simulator.runSimulation();

        System.out.println("Simulation completed.");
    }
}
