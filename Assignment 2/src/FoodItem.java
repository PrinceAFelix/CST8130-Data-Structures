

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Food Item<br>
 * The FoodItem Class implement an application that ask the user
 * what the food item is, For example: food item name, item price, etc.
 * 
 * @author Prince Adrianne Felix
 * @since 2021-03-20 CST8130 Data Structures
 * @version 1.0
 * 
 */
public class FoodItem {

	/**Represents the unique code of the item*/
	protected int itemCode;
	/**Represents the name of the item*/
	protected String itemName;
	/**Represents the sales price of the item*/
	protected float itemPrice;
	/**Represents the quantity in stock of the item*/
	protected int itemQuantityInStock;
	/**Represents the cost of the item*/
	protected float itemCost;
	
	/**
	 * Class No-argument Constructor
	 */
	FoodItem(){
		
	}
	
	/**
	 * Class parameterized  constructor, that sets all the local variable
	 * 
	 * @param ic represents the item code
	 * @param in represents the item name
	 * @param ip represents the item price
	 * @param is represents the item quantity in stock
	 * @param itc represents the item cost
	 */
	FoodItem(int ic, String in, float ip, int is, float itc){
		
		this.itemCode = ic;
		this.itemName = in;
		this.itemPrice = ip;
		this.itemQuantityInStock = is;
		this.itemCost = itc;
	}
	
	/**
	 * This method prints/display all the data members in the class
	 */
	public String toString() {
		/*Printf to print all the data members*/
		System.out.printf("Item: %d %1s %1d Price: $%.2f Cost: $%.2f ", itemCode, itemName, itemQuantityInStock, itemPrice, itemCost);
		
		return "";
		
	}
	
	/**
	 * This method update the quantity field by amount
	 * 
	 * @param amount represents the amount that the user would like to use
	 * @return true if successful, else return false
	 */
	public boolean updateItem(int amount) {
		
		this.itemQuantityInStock += amount;
		return true;

	}
	
	/**
	 * This method checks if the item code of the temporary object is the same as the original item code
	 * 
	 * @param item represents the Temporary FoodItem Object
	 * @return true if successful, else return false
	 */
	public boolean isEqual(FoodItem item) {
		
		/*Checks if the temp item code match the item code of the original, return true of yes, else return false*/
		if (item.itemCode == this.itemCode) 
			return true;
		
		return false;
		
	}
	
	
	
	/**
	 * This method will be use to ask the user for the information of the food that the user is inputting
	 * 
	 * @param scanner represents the Scanner object
	 * @return true if successfully reads in all fields
	 */
	public boolean addItem(Scanner scanner) {
		
		/**Represents the status, whether it's okay or not*/
		int isOK = 0;
		
		/**Calls the inputCode method*/
		inputCode(scanner);
		
		/**Ask the user for the name of the item*/
		System.out.print("Enter the name for the item: ");
		scanner.nextLine();
		itemName = scanner.nextLine();
		
		isOK = 0;
		
		/**Do while loop, until the user input is valid input*/
		do {
			/**Try catch, this will filter any input mismatch exception*/
			try {
				System.out.print("Enter the quantity for the item: ");
				itemQuantityInStock = scanner.nextInt();
				isOK = 1;
			}catch(InputMismatchException ime) {
				System.err.flush();
				System.out.println("Invalid entry");
				System.err.flush();
				scanner.next();
			}finally {
				/**This finally will be executed no matter what the exception is
				 * if Item quantity in stock is not greater than, it should do the following
				 * */
				if (itemQuantityInStock < 0) 
					System.out.println("Invalid entry");
			}
			
		}while(isOK == 0 || itemQuantityInStock < 0);
		
		isOK = 0;
		
		/**Do while loop, until the user input is valid input*/
		do {
			/**Try catch, this will filter any input mismatch exception*/
			try {
				System.out.print("Enter the cost of the item: ");
				itemCost = scanner.nextFloat();
				isOK = 1;
			}catch(InputMismatchException ime) {
				System.err.flush();
				System.out.println("Invalid entry");
				System.err.flush();
				scanner.next();
			}finally {
				/**This finally will be executed no matter what the exception is
				 * if Item cost is not greater than, it should do the following
				 * */
				if (itemCost < 0.0) {
					System.out.println("Invalid entry");
					itemCost = 0;
					isOK = 0;
				}
			}
		}while(isOK == 0 || itemCost < 0.0);
		
		isOK = 0;
		
		/**Do while loop, until the user input is valid input*/
		do {
			/**Try catch, this will filter any input mismatch exception*/
			try {
				System.out.print("Enter the sales price of the item: ");
				itemPrice = scanner.nextFloat();
				isOK = 1;
			}catch(InputMismatchException ime) {
				System.err.flush();
				System.out.println("Invalid entry");
				System.err.flush();
				scanner.next();
			}finally {
				/**This finally will be executed no matter what the exception is
				 * if Item price is not greater than, it should do the following
				 * */
				if (itemPrice < 0.0) {
					System.out.println("Invalid entry");
					itemPrice = 0;
					isOK = 0;
				}
			}
				
		}while(isOK == 0 || itemPrice < 0.0);
		
		/**Return true/false if successful*/
		if(isOK == 1)
			return true;
		else
			return false;
	}
	
	/**
	 * This method reads a valid item code that will represents the item code of the food
	 * @param scanner Represents the Scanner Object
	 * @return true if successful, else return false
	 */
	public boolean inputCode(Scanner scanner) {
		/**Represents the status, whether it's okay or not*/
		int isOK = 0;
		/**Represents the code that the user is inputting*/
		int code = 0;
		
		/**Do while loop, until the user input is valid input*/
		do {
			/**Try catch, this will filter any input mismatch exception*/
			try {
				
				System.out.print("Enter the code for the item: ");
				code = scanner.nextInt();
				this.itemCode = code;
				isOK = 1;
				return true;
			
			}catch(InputMismatchException ime) {
				System.err.flush();
				System.out.println("Invalid code");
				System.err.flush();
				scanner.next();
			}
		}while(isOK == 0);
		
		/**Return true/false if successful*/
		if(isOK == 1)
			return true;
		else
			return false;
	}
	
}


