import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Preserve<br>
 * Preserve Class represents the preserve food item, this class 
 * inherit the super class fields and methods
 * 
 * @author Prince Adrianne Felix
 * @since 2021-03-20 CST8130 Data Structures
 * @version 1.0
 * 
 */
public class Preserve extends FoodItem {

	private int jarSize;
	
	/**
	 * Class No-argument Constructor
	 */
	Preserve() {
		
	}
	
	/**
	 * Class parameterized  constructor, that calls the super constructor and sets the remaining data members
	 * 
	 * @param js represents the jar size
	 * @param ic represents the item code
	 * @param in represents the item name
	 * @param ip represents the item price
	 * @param is represents the item quantity in stock
	 * @param itc represents the item cost
	 */
	Preserve(int js, int ic, String in, float ip, int is, float itc){
		super(ic, in, ip, is, itc);
		this.jarSize = js;
	}
	
	/**
	 * Overrides the super class toString, this adds the jar size to the current to string
	 */
	@Override
	public String  toString() {
		/**Calls the super method*/
		super.toString();
		System.out.printf("Size: %dmL", jarSize);
		
		return "";
	}
	
	/**
	 * Overrides the add item, this adds the jar size to the current add item
	 */
	@Override
	public boolean addItem(Scanner scanner) {
		int isOk = 1;
		
		/**Calls the super method*/
		super.addItem(scanner);
		
		/**Do while loop, until the user input is valid input*/
		do {
			/**Try catch, this will filter any input mismatch exception*/
			try {
				System.out.print("Enter the size of the jar in millilitres: ");
				jarSize = scanner.nextInt();
				isOk = 1;
			}catch(InputMismatchException ime) {
				System.err.flush();
				System.out.println("Invalid entry");
				System.err.flush();
				scanner.next();
			}finally {
				/**This finally will be executed no matter what the exception is
				 * if Item quantity in stock is not greater than, it should do the following
				 * */
				if (jarSize < 0) 
					System.out.println("Invalid entry");
					
			}
			
		}while(isOk == 0 || itemQuantityInStock < 0);
		
		
		/**Returns true if successful, else return false*/
		if (isOk == 1) {
			return true;
		}else
			return false;
		
	}
}
