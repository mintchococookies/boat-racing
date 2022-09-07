/**
 * This class represent the players in the game
 *
 */

public class Boat extends RiverObjects {
	private String playerName;
	private int playerNumber;
	private int playerLocation = 0;
	private int moves = 0;
	
	/**
	 * This is the empty constructor for this class
	 * @param args Unused.
	 * @return Nothing.
	 */
	public Boat() {}
	
	/**
	 * This constructor sets the player's number and player's name
	 * @param number
	 * @param name
	 */
	public Boat(int number, String name) {
		playerName = name;
		playerNumber = number;	
	}
	
	/**
	 * This method returns the player's name
	 * @param args Unused.
	 * @return playerName
	 */
	public String getPlayerName() {
		return playerName;
	}
	
	/**
	 * This method returns the player's number
	 * @param args Unused.
	 * @return playerNumber
	 */
	public int getPlayerNumber() {
		return playerNumber;
	}
	
	/**
	 * This method used to set current index of the player's boat in riverList array
	 * @param location
	 * @return Nothing.
	 */
	public void setPlayerLocation(int location) {
		if (playerLocation + location <= 100) 
			playerLocation += location;	
		else
			playerLocation = 100;
	}
	
	/**
	 * this method returns the index of the player's boat in riverList Array
	 * @param args Unused.
	 * @return playerLocation
	 */
	public int getPlayerLocation() {
		return playerLocation;
	}
	
	/**
	 * This method increments total number of moves the player 
	 * has made each time they take a turn
	 * @param args Unused.
	 * @return Nothing.
	 */
	public void increaseMoves() {
		moves ++;
	}
	

	/**
	 * This method returns the total number of moves the player 
	 * has made each time they take a turn
	 * @param args Unused.
	 * @return moves
	 */
	public int getMoves() {
		return moves;
	}
	
	/**
	 * This method calls the setPlayerLocation and increaseMoves methods
	 * @param diceValue
	 * @return Nothing.
	 */
	public void move(int diceValue) {
		System.out.println("=============================================================");
		System.out.printf( "                      Player %d's turn!\n", playerNumber);
		System.out.printf("\n%s was at location %d.", playerName, playerLocation);
		System.out.printf("\n%s rolled a %d.\n", playerName, diceValue);
		setPlayerLocation(diceValue);
		increaseMoves();
	}
	
	/**
	 * This method displays a winning message with player's name and 
	 * number of moves they used
	 * @param args Unused.
	 * @return Nothing.
	 */
	public void win() {
		System.out.printf("\n%s (Player %d) wins!", playerName, playerNumber);
		System.out.printf("\nMoves: %d", moves);
		System.out.println("\n====================== The Game Ends =======================");
	}
}
