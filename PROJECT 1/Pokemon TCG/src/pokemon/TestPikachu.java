package pokemon;

public class TestPikachu {

	public static void main(String[] args) {
		Pikachu attackingPikachu = new Pikachu();
		Pikachu defendingPikachu = new Pikachu();

		System.out.println("Initial state:");
		displayPikachuStats(attackingPikachu, "Attacking Pikachu");
		displayPikachuStats(defendingPikachu, "Defending Pikachu");

		// Attacking Pikachu uses Quick Attack on Defending Pikachu
		System.out.println("\nAttacking Pikachu uses Quick Attack:");
		attackingPikachu.quickAttack(defendingPikachu);
		displayPikachuStats(defendingPikachu, "Defending Pikachu");

		// Attacking Pikachu uses Thunderbolt on Defending Pikachu
		System.out.println("\nAttacking Pikachu uses Thunderbolt:");
		attackingPikachu.thunderbolt(defendingPikachu);
		displayPikachuStats(defendingPikachu, "Defending Pikachu");

		// Check if the Defending Pikachu has fainted
		if (defendingPikachu.getHp() <= 0) {
			System.out.println("\nThe Defending Pikachu has fainted!");
		}
	}

	private static void displayPikachuStats(Pikachu pikachu, String pikachuName) {
		System.out.println(pikachuName + " - HP: " + pikachu.getHp());
	}
}
