import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Assign1<br>
 * The Assign1 Class is the test class which will run all the
 *  methods that was done in the Inventory class
 * 
 * @author Prince Adrianne Felix
 * @since 2021-04-07 CST8130 Data Structures
 * @version 1.0
 * 
 */
public class Assign3 {
	

	/**
	 * This method represents the Menu of the Prorgam
	 */
	public static void displayMenu() {
		System.out.print("Please select one of the following:\n");
		System.out.print("1: Add Item to Inventory\n2: Display Current Inventory\n3: Buy Item(s)\n4: Sell Item(s)\n5: Search for Item\n6: Remove Expired Items\n7: Print Expiry\n8: Change Today's Date\n9: To Exit\n> ");
	}
	
	/**
	 * The application's entry point
	 * 
	 * @param args an array of command-line arguments for the application
	 */
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		/**Initialized the default size of inventory*/
		Inventory inv = new Inventory();
		LocalDate current = LocalDate.now();
		
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
					System.out.print(inv);
					break;
				case 3:
					inv.updateQuantity(scanner, true);
					break;
				case 4:
					inv.updateQuantity(scanner, false);
					break;
				case 5:
					inv.searchItem(scanner);
					break;
				case 6:
					inv.removeExp(current);
					break;
				case 7:
					inv.printExpiry(scanner);
					break;
				case 8:
					System.out.print("Please enter today's date (yyyy-mm-dd): ");
					if (scanner.hasNext()) {
						String tempDate = scanner.next();
						try {
							current = LocalDate.parse(tempDate);
						} catch (DateTimeParseException e) {
							System.err.flush();
							System.out.println("Could not create date from input, please use format yyyy-mm-dd");
							System.out.println(e.getLocalizedMessage());
							System.err.flush();
						}
					}
					break;
				case 9:
					System.out.println("Exiting...");
					scanner.close();
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
