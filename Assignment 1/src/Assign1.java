import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Assign1<br>
 * The Assign1 Class is the test class which will run all the
 *  methods that was done in the Inventory class
 * 
 * @author Prince Adrianne Felix
 * @since 2021-02-07 CST8132 Object-Oriented Programming
 * @version 1.0
 * 
 */
public class Assign1 {
	
	/**
	 * This method represents the Menu of the Prorgam
	 */
	public static void displayMenu() {
		System.out.print("Please select one of the following:\n");
		System.out.print("1: Add Item to Inventory\n2: Display Current Inventory\n3: Buy Item(s)\n4: Sell Item(s)\n5: To Exit\n> ");
	}
	
	/**
	 * The application's entry point
	 * 
	 * @param args an array of command-line arguments for the application
	 */
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		/**Initialized the default size of inventory*/
		Inventory inv = new Inventory(20);
		
		int userChoice;
		int loop = 1;
		
		/**Do while loop, until the user input is valid input*/
		do {
			/**Try catch, this will filter any input mismatch exception*/
			try {
				/**Calls the Menu*/
				displayMenu();
				userChoice = scanner.nextInt();
				
				/**In switch statement, the user will do base on what tey want*/
				switch(userChoice) {
				case 1:
					inv.addItem(scanner);
					break;
				case 2:
					inv.toString();
					break;
				case 3:
					inv.updateQuantity(scanner, true);
					break;
				case 4:
					inv.updateQuantity(scanner, false);
					break;
				case 5:
					System.out.println("Exiting...");
					loop = 0;
					break;
				default:
					System.out.println("\nInvalid Choice.. Please Try Again\n");
					break;
				}
				
			}catch(InputMismatchException ime) {
				System.err.flush();
				System.err.println("\nInput Mismatch Exception While reading the Menu\n");
				System.err.flush();
				scanner.next();
			}
		}while(loop == 1);

	}
}
