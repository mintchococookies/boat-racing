import java.util.ArrayList;
import java.util.Collections;

/**
 * This class is the superclass for Current, Trap and Boat classes
 *
 */
public class RiverObjects {
	
	private int index = 0;
	private int playerNumber = 0;
	private static ArrayList<Integer> temp = new ArrayList<Integer>(); 
	private ArrayList<Integer> locations = new ArrayList<Integer>();
	
	/**
	 * This is the empty constructor for this class
	 * @param args Unused.
	 * @return Nothing.
	 */
	public RiverObjects() {}
	
	/**
	 * This constructor accepts playerNo as parameter and then set the player's number
	 * @param playerNo
	 * @return Nothing.
	 */
	public RiverObjects(int playerNo) {
		playerNumber = playerNo;
	}
	
	/**
	 * This method prints an empty space on the RiverList when the player's number is 0
	 * It prints the player's number on the RiverList if the player's number is not 0
	 * It will be overridden by current and trap subclasses
	 * @param args Unused.
	 * @return Nothing.
	 */
	public void draw() {
		if (playerNumber == 0)	
			System.out.print(" ");
		else
			System.out.print(playerNumber);
	}
	
	/**
	 * This method generates 87 numbers from 6 to 92 into an ArrayList called temp 
	 * and then shuffles them
	 * @param args Unused.
	 * @return Nothing.
	 */
	//Shuffle the numbers 1-100
	public static void generateRandom(){
		temp.clear();
	    for (int i=6; i<93; i++) {
	        temp.add(i);
	    }
	    Collections.shuffle(temp);    
	}
	
	/**
	 * This method sets the location of the current and the trap based on the 
	 * number in between the "start" and "end" number of the shuffled temp ArrayList 
	 * and add them to the locations ArrayList
	 * @param start, end
	 * @return Nothing.
	 */
	public void setLocations(int start, int end) {
		//generateRandom();
		index = start;
    	while (index < end) {
    		locations.add(temp.get(index));
    		index++;
    	}
	}
	
	/**
	 * This method resets the location of the current and the trap by clearing 
	 * the locations ArrayList
	 * @param args Unused.
	 * @return Nothing.
	 */
	public void resetLocations() {
		locations.clear();
	}
	
	/**
	 * This method returns the location of the current and the trap which is 
	 * in the locations ArrayList
	 * @param args Unused.
	 * @return locations
	 */
	public ArrayList<Integer> getLocations() {
		return locations;
	}
}
