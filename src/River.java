import java.util.ArrayList;
import java.util.Random;

/**
 * This class fills the river with riverObjects and prints the 
 * river as the game board.
 *
 */
public class River {
	
    private RiverObjects[] riverList = new RiverObjects[100];
    private Trap trap = new Trap();
    private Current current = new Current();
    private ArrayList<Integer> trapLocations = trap.getTrapLocations();
    private ArrayList<Integer> currentLocations = current.getCurrentLocations();

    public River(){}
    
    /**
     * This method returns the array of river objects.
     * @param args Unused.
     * @return riverList
     */
    public RiverObjects[] getRiverList(){
    	return riverList;
    }
    
    /**
     * This method calls the hitTrap method from the trap class.
     * It returns a random number of steps backward the player should take.
     * @param args Unused.
     * @return Number of steps backward.
     */
    public int hitTrap() {
    	return trap.hitTrap();
    }
    
    /**
     * This method calls the hitCurrent method from the current class.
     * It returns a random number of steps forward the player should take.
     * @param args Unused.
     * @return Number of steps forward.
     */
    public int hitCurrent() {
    	return current.hitCurrent();
    }
    
    /**
     * This method places the player's number in the riverList array.
     * It instantiates a new object of type riverObjects for the player
     * using the player's number (1 or 2).
     * The object is placed in the riverList array according
     * to the location of the player.
     * @param playerno
     * @param location
     * @return Nothing.
     */
    public void setBoat(int playerno, int location) {
    	RiverObjects player = new RiverObjects(playerno);
    	riverList[location] = player;
    }
    
    /**
     * This method removes the player's riverObject from the
     * riverList array by instantiating a new empty object of 
     * type riverObjects and replacing the array element at
     * the player's location with this empty object.
     * @param location
     * @return Nothing.
     */
    public void removeBoat(int location) {
    	RiverObjects empty = new RiverObjects();
		riverList[location] = empty;
    }
    
    /**
     * This method calls the methods to determine the indexes for the
     * trap and current locations.
     * Based on the array of indexes, the riverList array is filled
     * with the appropriate riverObjects (trap, current, empty).
     * @param args Unused.
     * @return Nothing.
     */
    public void fillRiver() {
    	trap.setTrapLocations();
		current.setCurrentLocations();
    	for(int i = 0; i < 100; i++) {
    		if (trapLocations.contains(i)){
    			riverList[i] = trap;
    		}
    		else if (currentLocations.contains(i)){
    			riverList[i] = current;
    		}
    		else {
    			RiverObjects empty = new RiverObjects();
    			riverList[i] = empty;
    		}	
    	} //for block end
    }
    
    /**
     * This method prints the riverList array in a 10 x 10 grid.
     * @param args Unused.
     * @return Nothing.
     */
    public void generateRiver() {
    	int index = 0;
    	System.out.println("\n              # are Traps and ~ are Currents");
		System.out.println("      -------------------------------------------------");
		for(int i = 0; i < 10; i++) {
			System.out.print("      ");
			for(int j = 0; j < 10; j++) {
				System.out.print(" |");
				riverList[index].draw();
				System.out.print("| ");	
				index++;
			} //for block end
			System.out.println();
			System.out.println("      -------------------------------------------------");
		} //for block end
	}
}