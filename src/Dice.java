import java.util.Random;

/**
 * This class returns a random dice value between 1 to 6.
 */
public class Dice{
	
	private int diceValue;
	
	public Dice(){
		diceValue = 0;
	}
	
	/**
	 * This is the main method which uses the Random class
	 * to generate and return a random dice value between 1 to 6.
	 * @param args Unused.
	 * @return DiceValue
	 */
	public int roll() {	
		diceValue = 1 + (new Random().nextInt(6)) ;
		return diceValue;
	 }
}