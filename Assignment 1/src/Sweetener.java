import java.util.Scanner;

/**
 * Sweetener<br>
 * Sweetener Class represents the Sweetener food item, this class 
 * inherit the super class fields and methods
 * 
 * @author Prince Adrianne Felix
 * @since 2021-02-07 CST8132 Object-Oriented Programming
 * @version 1.0
 */
public class Sweetener extends FoodItem {
	
	/**Represents the name of the farm supplier*/
	private String farmName;
	
	
	/**
	 * Class No-argument Constructor
	 */
	Sweetener() {
		
	}
	

	/**
	 * Class parameterized  constructor, that calls the super constructor and sets the remaining data members
	 * 
	 * @param fN represents the farm name
	 * @param ic represents the item code
	 * @param in represents the item name
	 * @param ip represents the item price
	 * @param is represents the item quantity in stock
	 * @param itc represents the item cost
	 */
	Sweetener(String fN, int ic, String in, float ip, int is, float itc){
		/**Calls the super method*/
		super(ic, in, ip, is, itc);
		this.farmName = fN;
	}
	
	/**
	 * Overrides the super class toString, this adds the farm name to the current to string
	 */
	@Override
	public String  toString() {
		/**Calls the super method*/
		super.toString();
		System.out.printf("Sweetener supplier: %s", farmName);
		
		return "";
	}
	
	/**
	 * Overrides the add item, this adds the farm name to the current add item
	 */
	@Override
	public boolean addItem(Scanner scanner) {
		/**Calls the super method*/
		super.addItem(scanner);
		System.out.print("Enter the name of the farm supplier: ");
		scanner.nextLine();
		farmName = scanner.nextLine();
		int isOk = 1;
		
		/**Returns true if successful, else return false*/
		if (isOk == 1) {
			return true;
		}else
			return false;
		
	}
	
}
