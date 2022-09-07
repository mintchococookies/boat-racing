import java.util.Scanner;

/**
 * This class generates the difficulty of the level after user
 * chooses their choice of difficulty
 *
 */

public class Difficulty {
	public static int trapQuantity;
	public static int currentQuantity;
	private int difficulty;
	private String level;
	
	/**
	 * This is the empty constructor for this class
	 * @param args Unused.
	 * @return Nothing.
	 */
	public Difficulty() {}
	
	
	/**
	 * This method allows the user to select the level of difficulty 
	 * @param args Unused.
	 * @return Nothing.
	 */
	public void setDifficulty() {
		while (true) {
			System.out.println("\n================= Select Game Difficulty =================\n");
			System.out.println("1: Easy Level. 12 Currents and 8 Traps. ");
			System.out.println("2: Intermediate Level. 10 Currents and 10 Traps. ");
			System.out.println("3: Hard Level. 8 Currents and 12 Traps. ");
			System.out.print("\nChoose Your Difficulty: ");
			
			Scanner input = new Scanner(System.in);
			difficulty = input.nextInt();
			
			if (difficulty == 1 || difficulty == 2 || difficulty == 3) {
				setTrapQuantity(difficulty);
				setCurrentQuantity(difficulty);
				break;
			}
			else {
				System.out.println("\nPlease select only 1, 2, or 3.");
			}		
		} //while block end
	}
	
	/**
	 * This method returns the level of difficulty chosen
	 * @param args Unused.
	 * @return level
	 */
	public String getDifficulty() {
		if (difficulty == 1)
			level = "Easy";
		if (difficulty == 2)
			level = "Intermediate";
		if (difficulty == 3)
			level = "Hard";
		return level;
	}
	
	/**
	 * This method is used to set the quantity of traps according
	 * to the difficulty level chosen by the player
	 * @param d
	 * @return Nothing.
	 */
	public void setTrapQuantity(int d) {
		switch (d) {
			case 1: 
				trapQuantity = 8;
				break;
			case 2:
				trapQuantity = 10;
				break;
			case 3:
				trapQuantity = 12;
				break;
		} //switch block end
	}
	
	/**
	 * This method is used to set the quantity of currents according
	 * to the difficulty level chosen by the player
	 * @param d
	 * @return Nothing.
	 */
	public void setCurrentQuantity(int d) {
		switch (d) {
			case 1: 
				currentQuantity = 12;
				break;
			case 2:
				currentQuantity = 10;
				break;
			case 3:
				currentQuantity = 8; 
				break;
		} //switch block end
	}	
}
