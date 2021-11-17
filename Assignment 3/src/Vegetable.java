import java.util.Scanner;

/**
 * Vegetable<br>
 * Vegetable Class represents the Vegetable food item, this class 
 * inherit the super class fields and methods
 * 
 * @author Prince Adrianne Felix
 * @since 2021-04-07 CST8130 Data Structures
 * @version 1.0
 */
public class Vegetable extends FoodItem {
	
	/**Represents the name of the farm supplier*/
	private String farmName;
	
	/**
	 * Class No-argument Constructor
	 */
	Vegetable(){
		
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
	Vegetable(String fN, int ic, String in, float ip, int is, float itc){
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
		System.out.printf("Farm supplier: %s", farmName);
		
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
