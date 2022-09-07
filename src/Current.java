import java.util.ArrayList;
import java.util.Random;

/**
 * This class represent the current object in the game
 * It is a subclass of RiverObjects
 */
public class Current extends RiverObjects {
	
	private int forward;
	
	/**
	 * This method prints '~' symbol to represent a current
	 * It overrides the method draw() from its superclass
	 * @param args Unused.
	 * @return Nothing.
	 */
	@Override
	public void draw() {
		System.out.print("~");
	}
	

	/**
	 * This method sets the locations of the currents
	 * by first clearing the locations ArrayList and 
	 * then setting new location numbers into the locations ArrayList
	 * @param args Unused.
	 * @return Nothing.
	 */
	public void setCurrentLocations(){
		super.resetLocations();
		super.setLocations(20, 20 + Difficulty.currentQuantity);
	}
	
	/**
	 * This method returns the locations of the currents which is in the 
	 * getCurrentLocations ArrayList
	 * @param args Unused.
	 * @return getLocations
	 */
	public ArrayList<Integer> getCurrentLocations() {
		return super.getLocations();
	}
	
	/**
	 * This method returns a random number between 1 to 6 for the 
	 * number of spaces the player moves forward when a current is hit
	 * @param args Unused.
	 * @return forward
	 */
	public int hitCurrent() {
    	forward = (1 + (new Random().nextInt(6)));
    	return forward;
    }
}
