import java.util.Scanner;

/**
 * This class generates the flow of the game
 *
 */
public class Game {
	boolean startGame;
	private int diceValue;
	private int forward;
	private int backward;
	private Dice dice = new Dice();
	private Difficulty difficulty = new Difficulty();
	private River river = new River();
	private Scoreboard scoreboard;
	
	Scanner input = new Scanner(System.in);
	Scanner enter = new Scanner(System.in);
	
	/**
	 * This method start the game flow
	 * The boat objects are initiate by getting both players' name
	 * Both players take turns to roll the dice and move in the river according to dice value
	 * Player that reaches location 100 wins the game
	 * Player will move backward a random number of 1 to 6 steps if they hit a trap
	 * Player will move forward a random number of 1 to 6 steps if they hit a current
	 * @param args Unused.
	 * @return Nothing.
	 */
	public void startGame() {
		//Get both players' names to instantiate the boat Objects
		System.out.printf("\n<<Game Started>>\n");
		System.out.printf("\nEnter Player 1's Name: ");
		Boat player1 = new Boat(1, input.nextLine());
		System.out.printf("Enter Player 2's Name: ");
		Boat player2 = new Boat(2, input.nextLine());
		
		//Initialize the river
		difficulty.setDifficulty();
		RiverObjects.generateRandom();
		river.fillRiver();
		
		System.out.printf("\n<<%s Level>>\n", difficulty.getDifficulty());
		System.out.println("\n==================== The Game Begins =====================");
		System.out.println("\n               Keep Hitting Enter to Play!");	
		
		river.generateRiver();
		
		//Game loop
		while (startGame) {
			for (int player = 1; player < 3; player++) {
				//PLAYER 1'S TURN
				if (player == 1) {
					if (player1.getPlayerLocation() > 0)
						if (player1.getPlayerLocation() == player2.getPlayerLocation())
							river.setBoat(2, player2.getPlayerLocation() - 1);
						else
							river.removeBoat(player1.getPlayerLocation() - 1);
					
					//Roll the dice and move PLAYER 1	
					enter.nextLine();
					diceValue = dice.roll();
					player1.move(diceValue);
					
					//PLAYER 1 wins
					if (player1.getPlayerLocation() == 100) {
						river.setBoat(1, 99);
						river.generateRiver();
						player1.win();
						if (difficulty.getDifficulty() == "Easy") {
							scoreboard = new Scoreboard(1);
							scoreboard.scoreboardReplacement(player1.getPlayerName(), player1.getMoves());
						}
						else if (difficulty.getDifficulty() == "Intermediate") {
							scoreboard = new Scoreboard(2);
							scoreboard.scoreboardReplacement(player1.getPlayerName(), player1.getMoves());
						}
						else if (difficulty.getDifficulty() == "Hard") {
							scoreboard = new Scoreboard(3);
							scoreboard.scoreboardReplacement(player1.getPlayerName(), player1.getMoves());
						}
						startGame = false;
						break;
					} //if block end
					
					//Continue game
					if (player1.getPlayerLocation() != 100) {
						while (river.getRiverList()[(player1.getPlayerLocation() - 1)] instanceof Trap ||
								river.getRiverList()[(player1.getPlayerLocation() - 1)] instanceof Current &&
								player1.getPlayerLocation() != 100) {
							if (river.getRiverList()[(player1.getPlayerLocation() - 1)] instanceof Trap) {
								backward = river.hitTrap();
								System.out.println("Hit a trap at location " + player1.getPlayerLocation() + "! Moved " + Math.abs(backward) + " steps back.");
								player1.setPlayerLocation(backward);
							}
							if (river.getRiverList()[(player1.getPlayerLocation() - 1)] instanceof Current) {
								forward = river.hitCurrent();
								System.out.println("Rode the current from location " + player1.getPlayerLocation() + "! Moved " + forward + " steps forward.");
								player1.setPlayerLocation(forward);
							}
						}					
						if (player1.getPlayerLocation() == player2.getPlayerLocation())
							System.out.println(player1.getPlayerName() + " meets " + player2.getPlayerName() + " at location " + player1.getPlayerLocation() + "!\n");
						else
							System.out.println(player1.getPlayerName() + " is now at location " + player1.getPlayerLocation() + ".\n");
		    			river.setBoat(1, player1.getPlayerLocation() - 1);
					} //if block end
					
					//Generate board
					river.generateRiver();	
					
				} //if block end
				
				//PLAYER 2'S TURN
				if (player == 2) {
					if (player2.getPlayerLocation() > 0)
						if (player2.getPlayerLocation() == player1.getPlayerLocation())
							river.setBoat(1, player1.getPlayerLocation() - 1);
						else
							river.removeBoat(player2.getPlayerLocation() - 1);
					
					//Roll the dice and move PLAYER 2
					enter.nextLine();	
					diceValue = dice.roll();
					player2.move(diceValue);
					
					//PLAYER 2 wins
					if (player2.getPlayerLocation() == 100) {
						river.setBoat(2, 99);
						river.generateRiver();
						player2.win();
						if (difficulty.getDifficulty() == "Easy") {
							scoreboard = new Scoreboard(1);
							scoreboard.scoreboardReplacement(player2.getPlayerName(), player2.getMoves());
						}
						else if (difficulty.getDifficulty() == "Intermediate") {
							scoreboard = new Scoreboard(2);
							scoreboard.scoreboardReplacement(player2.getPlayerName(), player2.getMoves());
						}
						else if (difficulty.getDifficulty() == "Hard") {
							scoreboard = new Scoreboard(3);
							scoreboard.scoreboardReplacement(player2.getPlayerName(), player2.getMoves());
						}
						startGame = false;
						break;
					} //if block end
					
					//Continue game
					if (player2.getPlayerLocation() != 100) {
						while (river.getRiverList()[(player2.getPlayerLocation() - 1)] instanceof Trap ||
								river.getRiverList()[(player2.getPlayerLocation() - 1)] instanceof Current) {
							if (river.getRiverList()[(player2.getPlayerLocation() - 1)] instanceof Trap) {
								backward = river.hitTrap();
								System.out.println("Hit a trap at location " + player2.getPlayerLocation() + "! Moved " + Math.abs(backward) + " steps back.");
								player2.setPlayerLocation(backward);
							}
							if (river.getRiverList()[(player2.getPlayerLocation() - 1)] instanceof Current) {
								forward = river.hitCurrent();
								System.out.println("Rode the current from location " + player2.getPlayerLocation() + "! Moved " + forward + " steps forward.");
								player2.setPlayerLocation(forward);
							}
						}
						if (player2.getPlayerLocation() == player1.getPlayerLocation())
							System.out.println(player2.getPlayerName() + " meets " + player1.getPlayerName() + " at location " + player2.getPlayerLocation() + "!\n");
						else
							System.out.println(player2.getPlayerName() + " is now at location " + player2.getPlayerLocation() + ".\n");
		    			river.setBoat(2, player2.getPlayerLocation() - 1);
					}				
					
					//Generate board
					river.generateRiver();	
					
				} //if block end
			} //for block end
		} //while block end
	}
}