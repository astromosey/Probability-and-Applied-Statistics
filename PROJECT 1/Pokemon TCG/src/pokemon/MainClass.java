package pokemon;
import java.util.Scanner;

public class MainClass {

    private static final Scanner scanner = new Scanner(System.in);
    private static PokemonCardGame game;

    private static void displayInstructions() {
        System.out.println("\nInstructions:");
        System.out.println("1. The game starts by drawing an initial hand of cards.");
        System.out.println("2. Each turn, players can perform various actions such as playing Pokémon, Energy, or Trainer cards.");
        System.out.println("3. Players can attack with their active Pokémon if conditions are met.");
        System.out.println("4. The game continues until one player's Pokémon faints or the deck runs out.");
    }

    private static void playFullGame() {
        System.out.println("\nInitializing a new game...");
        game = new PokemonCardGame(); // Initialize a new game
        game.playGame(); // Play the full game
    }

    private static void mainMenu() {
        System.out.println("\nWelcome to the Pokemon Card Game Simulator!");
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Play Full Game");
            System.out.println("2. View Instructions");
            System.out.println("3. Run Simulators");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            if (choice!=4){
            switch (choice) {
                case 1:
                    playFullGame();
                    break;
                case 2:
                    displayInstructions();
                    break;
                case 3:
                     Simulator simulator = new Simulator();
                     simulator.runSimulation();
                     break;
                     
                case 4:
                    exit = true;
                    System.out.println("Exiting the game. Thank you for playing!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }}
    }

    public static void main(String[] args) {
        mainMenu();
        scanner.close();
    }
}
