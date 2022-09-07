import java.util.ArrayList;
import java.util.Random;

/**
 * This class represent the trap object in the game
 * It is a subclass of RiverObjects
 */

public class Trap extends RiverObjects{
	
	private int backward;
	
	/**
	 * This method prints '#' symbol to represent a trap
	 * It overrides the method draw() from its superclass
	 * @param args Unused.
	 * @return Nothing.
	 */
	@Override
	public void draw() {
		System.out.print("#");
	}
	
	/**
	 * This method sets the locations of the traps
	 * by first clearing the locations ArrayList and 
	 * then setting new location numbers into the locations ArrayList
	 * @param args Unused.
	 * @return Nothing.
	 */
	public void setTrapLocations(){
		super.resetLocations();
		super.setLocations(0, Difficulty.trapQuantity);
	}
	
	/**
	 * This method returns the locations of the traps which is in the 
	 * getTrapLocations ArrayList
	 * @param args Unused.
	 * @return getLocations
	 */
	public ArrayList<Integer> getTrapLocations() {
		return super.getLocations();
	}
	
	/**
	 * This method returns a random number between 1 to 6 for the 
	 * number of spaces the player moves backward when a trap is hit
	 * @param args Unused.
	 * @return backward
	 */
	public int hitTrap() {
    	backward = -(1 + (new Random().nextInt(6)));
    	return backward;
    }
}