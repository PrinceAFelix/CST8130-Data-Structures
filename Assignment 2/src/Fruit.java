import java.util.Scanner;

/**
 * Fruit<br>
 * Fruit Class represents the fruit food item, this class 
 * inherit the super class fields and methods
 * 
 * @author Prince Adrianne Felix
 * @since 2021-03-20 CST8130 Data Structures
 * @version 1.0
 * 
 */
public class Fruit extends FoodItem{
	
	/**Represents the name of the supplier*/
	private String orchardName;

	/**
	 * Class No-argument Constructor
	 */
	Fruit(){
		
	}
	
	/**
	 * Class parameterized  constructor, that calls the super constructor and sets the remaining data members
	 * @param oN represents the supplier name
	 * @param ic represents the item code
	 * @param in represents the item name
	 * @param ip represents the item price
	 * @param is represents the item quantity in stock
	 * @param itc represents the item cost
	 */
	Fruit(String oN, int ic, String in, float ip, int is, float itc){
		/**Calls the super constructor*/
		super(ic, in, ip, is, itc);
		this.orchardName = oN;
	}
	
	/**
	 * Overrides the super class toString, this adds the supplier name to the current to string
	 */
	@Override
	public String  toString() {
		super.toString();
		System.out.printf("Orchard supplier: %1s", orchardName);
		
		return "";
	}
	
	/**
	 * Overrides the add item, this adds the supplier name to the current add item
	 */
	@Override
	public boolean addItem(Scanner scanner) {
		/**Calls the super method*/
		super.addItem(scanner);
		System.out.print("Enter the name of the orchard supplier: ");
		scanner.nextLine();
		orchardName = scanner.nextLine();
		int isOk = 1;
		
		
		
		/**Returns true if successful, else return false*/
		if (isOk == 1) {
			return true;
		}else
			return false;
		
	}
}
