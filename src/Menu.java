import java.util.Scanner;

/**
 * This class displays the Boat Racing game menu.
 * The menu allows the user to begin the game, view the score boards, 
 * view the game instructions and exit the game.
 *
 */
public class Menu {
	private boolean menu;
	private int menuInput;
	private int scoreboardChoice;
	private Game game = new Game();
	private Scoreboard SB;
	Scanner goBack = new Scanner(System.in);
	
	/**
	 * This method displays the menu and shows different screens depending
	 * on the user's menu input.
	 * @param args Unused.
	 * @return Nothing.
	 */
	public void displayMenu(){
		menu = true;
		//loop menu display so menu is re-displayed if invalid input is entered.
		while (menu == true) {
			System.out.println("================= Welcome to Boat Racing =================\n");
			System.out.println("                       ,:',:`,:'");
			System.out.println("                    __||_||_||_||__");
			System.out.println("               ____['''''''''''''''''']____");
			System.out.println("               \\ \" ''''''''''''''''''''''  |");
			System.out.println("         ~~^~^~^~^~^^~^~^~^~^~^~^~^~~^~^~^^~~^~^");			
			System.out.println("\n               Enter 1 to Start the Game");
			System.out.println("               Enter 2 to View the Scoreboard");
			System.out.println("               Enter 3 to Read Game Instructions");
			System.out.println("               Enter 4 to Exit the Game \n");
			System.out.print("Enter your choice: ");
			Scanner input = new Scanner(System.in);
			menuInput = input.nextInt();
			
			switch (menuInput) {
			//Start the Game
			case 1: 
				game.startGame = true;
				game.startGame();
				System.out.printf("\nPress Enter To Return To The Main Menu\n");
				goBack.nextLine();
				displayMenu();
				break;
			//Allow the user to choose which level's score board they want to view.
			//Then displays the score board for the selected level.
			case 2:
				while (true) {
					System.out.println("\n======================= Scoreboard =======================\n");
					System.out.printf("Please Select The Scoreboard You Want To See:\n");
					System.out.println("\nEnter 1 to View the Scoreboard for Level Easy");
					System.out.println("Enter 2 to View the Scoreboard for Level Intermediate");
					System.out.println("Enter 3 to View the Scoreboard for Level Hard");
					System.out.print("\nEnter your choice: ");
					Scanner option = new Scanner(System.in);
					scoreboardChoice = option.nextInt();
					System.out.println();
					if (scoreboardChoice == 1) {
						SB = new Scoreboard(1);
						SB.displayScoreboard();					
						break;
					}
					else if (scoreboardChoice == 2) {
						SB = new Scoreboard(2);
						SB.displayScoreboard();				
						break;
					}
					else if (scoreboardChoice == 3) {
						SB = new Scoreboard(3);
						SB.displayScoreboard();			
						break;
					}
					else {
						System.out.println("Please Enter 1, 2, or 3 only.");
					}
				}
				System.out.printf("\nPress Enter To Return To The Main Menu\n");
				goBack.nextLine();
				displayMenu();
				break;
			//Print game instructions
			case 3:
				System.out.println("\n================ How to Play Boat Racing =================\n");
				System.out.println("1. Two players take turns rolling a dice to move their");
				System.out.println("   boats along a river. But beware! The river has");
				System.out.println("   randomly positioned traps and currents!");
				System.out.println("\n2. Landing on a Trap (#) makes your boat move back a");
				System.out.println("   few steps. Some traps are stronger and can make");
				System.out.println("   your boat move back further than others!");
				System.out.println("\n3. Landing on a Current (~) makes your boat move");
				System.out.println("   forward a few steps. Some currents are stronger");
				System.out.println("   and can make your boat move forward further than");
				System.out.println("   others!");
				System.out.println("\n4. The first player to reach the end of the river");
				System.out.println("   wins!");
				System.out.println("\n==========================================================");
				System.out.printf("\nPress Enter To Return To The Main Menu\n");
				goBack.nextLine();
				displayMenu();
				break;
			//Exits the game
			case 4:
				System.out.println("Thank you for playing Boat Racing. Bye bye!");
				menu = false;
				break;
			//Invalid input error
			default:
				System.out.println("\nPlease Enter 1, 2, 3, or 4 only.\n");
			} //switch block end
		} //while block end
	}
}
