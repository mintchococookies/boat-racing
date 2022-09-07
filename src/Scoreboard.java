import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class updates the score boards for the easy, intermediate and hard levels.
 */
public class Scoreboard {
	private String [] player = new String [5];
	private int [] totalMoves = new int [5];
	private int level;
	
	private Scanner input;
	private Formatter output;

	/**
	 * This method reads the current standings from the scoreboard.txt files
	 * and saves them into an array.
	 * The level is passed into this function to determine if the score board
	 * for the easy, intermediate or hard level should be read.
	 * @param level
	 * @exception FileNotFoundException on file opening error.
	 * @exception NoSuchElementException on file not properly formed error.
	 */
	public Scoreboard(int level) {
		this.level = level;
		try {
			if (level == 1) {
				input = new Scanner (new File("scoreboard1.txt"));
			}
			if (level == 2) {
				input = new Scanner (new File("scoreboard2.txt"));
			}
			if (level == 3) {
				input = new Scanner (new File("scoreboard3.txt"));
			}
			while (input.hasNext()) {
				for (int i = 0; i < totalMoves.length; i++) {
					player [i] = input.next();
					totalMoves [i] = input.nextInt();
				}
			}
			if (input != null) {
				input.close();
			}
		} //try block end
		
		catch (FileNotFoundException fe) {
			System.out.println ("Error opening file.");
		} //catch block end
		catch (NoSuchElementException ex) {
			System.out.println("File improperly formed.");
		} //catch block end
	}
	
	/**
	 * This method overwrites the contents of the relevant scoreboard.txt 
	 * files based on the updated array of player names and scores.
	 * @param args Unused.
	 * @return Nothing.
	 * @see scoreboardReplacement() 
	 */
	public void overwrite () {
		try {		
			if (level == 1) {
				output = new Formatter ("scoreboard1.txt");
			}
			if (level == 2) {
				output = new Formatter ("scoreboard2.txt");			
			}
			if (level == 3) {
				output = new Formatter ("scoreboard3.txt");
			}
			for (int i = 0; i < totalMoves.length; i++) {
				output.format("%s ", player [i]);
				output.format("%d \n", totalMoves [i]);
			}
			if (output != null) {
				output.close();
			}
			
		} //try block end 
		
		catch (SecurityException se) {
			System.out.println ("You do not have write access.");
			System.exit(1);
		} //catch block end
		catch (FileNotFoundException fe) {
			System.out.println ("Error opening/creating file.");
			System.exit(1);
		} //catch block end 
		
	}
	/**
	 * This method compares the winner's score with the scores in the array filled
	 * by the Scoreboard method.
	 * If the winner's score is within the top 5 highest scores, the array
	 * is updated with their name and number of moves made.
	 * Calls the overwrite method to overwrite the score board text file.
	 * @param name
	 * @param movesMade
	 * @return Nothing.
	 * @see Scoreboard()
	 */
	public void scoreboardReplacement (String name, int movesMade) {
		if (movesMade <= totalMoves[4] && movesMade > totalMoves[3]) {
			player [4] = name;
			totalMoves [4] = movesMade;
		}
		else if (movesMade <= totalMoves[3] && movesMade > totalMoves[2]) {
			player [4] = player [3];
			totalMoves [4] = totalMoves [3];
			player [3] = name;
			totalMoves [3] = movesMade;
		}
		else if (movesMade <= totalMoves[2] && movesMade > totalMoves[1]) {
			player [4] = player [3];
			totalMoves [4] = totalMoves [3];
			player [3] = player [2];
			totalMoves [3] = totalMoves [2];
			player [2] = name;
			totalMoves [2] = movesMade;
		}
		else if (movesMade <= totalMoves[1] && movesMade > totalMoves[0]) {
			player [4] = player [3];
			totalMoves [4] = totalMoves [3];
			player [3] = player [2];
			totalMoves [3] = totalMoves [2];
			player [2] = player [1];
			totalMoves [2] = totalMoves [1];
			player [1] = name;
			totalMoves [1] = movesMade;
		}
		else if (movesMade <= totalMoves [0]) {
			player [4] = player [3];
			totalMoves [4] = totalMoves [3];
			player [3] = player [2];
			totalMoves [3] = totalMoves [2];
			player [2] = player [1];
			totalMoves [2] = totalMoves [1];
			player [1] = player [0];
			totalMoves [1] = totalMoves [0];
			player [0] = name;
			totalMoves [0] = movesMade;
		}
		overwrite ();
	}
	
	/**
	 * This method prints the score board based on the array of scores.
	 * @param args Unused.
	 * @return Nothing.
	 */
	public void displayScoreboard () {
		if (level == 1) {
			System.out.println("\n=================== SCOREBOARD - EASY ====================\n");
		}
		if (level == 2) {
			System.out.println("\n=============== SCOREBOARD - INTERMEDIATE ================\n");
		}
		if (level == 3) {
			System.out.println("\n=================== SCOREBOARD - HARD ====================\n");
		}
		System.out.println("                      PLAYER         MOVES");
		System.out.println("             -------------------------------");
		for ( int k = 0; k < player.length; k++ ) {
			System.out.print("             ");
			System.out.printf("| %20s | %3d  |\n", player[k], totalMoves[k]);
			System.out.println("             -------------------------------");
		}
		System.out.println("\n==========================================================");
	}
}
