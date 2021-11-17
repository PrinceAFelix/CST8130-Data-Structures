import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * InventoryItem<br>
 * The InventoryItem Class implement an application that implement all the things from Food Item class
 * 
 * @author Prince Adrianne Felix
 * @since 2021-04-07 CST8130 Data Structures
 * @version 1.0
 * 
 */
public class InventoryItem {

	/**Represents the item quantity in stock*/
	private int itemQuantityInStock;
	/**Represents the FooDitem object*/
	private FoodItem item;
	/**represents the Queue Staructure*/
	private Queue<LocalDate> expiries;

	/**Parametrized Constructor
	 * 
	 * @param temp represents the FoodItem
	 */
	InventoryItem(FoodItem temp){
		this.item = temp;
		expiries = new LinkedList<LocalDate>();
	}
	
	/**
	 * 
	 * @param scanner represents the Scanner Object
	 * @return valid
	 */
	public boolean addItem(Scanner scanner) {
		boolean valid = false;
		int tempQuan = 0;
		if(item == null)
			return false;
		if(item.addItem(scanner)) { //Read the inputs
			do {//Ask for the quantity
				System.out.print("Enter the quantity for the item: ");
				try {
					if(scanner.hasNextInt()) {
						tempQuan = scanner.nextInt(); //Store the input
					}
				}catch(InputMismatchException ime) {
					System.err.flush();
					System.err.println("Input Mismatch Exception While Reading quantity");
					System.err.flush();
					scanner.next();
				}finally {
					if(tempQuan < 0) {
						valid = false;
						System.out.println("Invalid Entry");
					}else {
						valid  = true;
						return updateQuantity(scanner, tempQuan);
					}
				}
				
				
			}while(!valid);
		}
		
		
		return valid;
		
	}
	
	@Override
	public String toString() {
		System.out.print(item.toString() + " qty: " + itemQuantityInStock);
		return "";
	}
	
	/**This method gets the itemcode of the food item
	 * 
	 * @return itemCode
	 */
	public int getItemCode() {
		if (item != null)
			return item.itemCode;
		return -1;
	}
	
	/**This method ask the user to input a item code
	 * 
	 * @param scanner represents the scanner object
	 * @return the input code
	 */
	public boolean inputCode(Scanner scanner) {
		if (item == null)
			item = new FoodItem();
		return item.inputCode(scanner);
	}
	
	/**
	 * This method prints e=the epxiry summary details
	 */
	public void printExpirySummary() {
		//Define a Iterator
		Iterator<LocalDate> expireItem = expiries.iterator();
		LocalDate cc = expiries.peek();
		
		//Counter variable
		int counter = 0;
		System.out.println(toString());
		System.out.println("Expiry Details:");
		
		if (cc != null && cc.equals(LocalDate.MAX))
			System.out.print("No Expiry: ");
		else
			System.out.print(cc + ": ");
		
		do {
			LocalDate now = expireItem.next();
			if (now.equals(cc))
				counter++; //Increment everytime its the same
			else {
				System.out.println(counter); //else set the date to current
				cc = now;
				counter = 1;
				
				if (cc.equals(LocalDate.MAX))
					System.out.print("No Expiry: ");
				else
					System.out.print(cc + ": ");
			}
			
		}while(expireItem.hasNext());
		
		System.out.println(counter + "\n");
		
	}
	
	/**This method removes the expired items
	 * 
	 * @param today represents the LocalDate 
	 */
	public void removeExpiredItems(LocalDate today) {
		for(int i = 0; i < expiries.size(); i++) { //Iterate through list and remove 
			if( expiries.peek().compareTo(LocalDate.MAX) != 0 && expiries.peek().isBefore(today)) {
				expiries.remove();
				itemQuantityInStock--; //Decrement the stock
			}
		}
	}
	
	/**
	 * 
	 * @param scanner represents the Scanner Object
	 * @param amount represents the amount to be updated 
	 * @return return true if successful
	 */
	public boolean updateQuantity(Scanner scanner, int amount) {
		
		//Check for error
		if (amount < 0 && itemQuantityInStock < (amount * -1)) {
			return false;
		}
		
		//Variable
		boolean loop = false;
		
		//Set temp date to null
		LocalDate exp = null;
		
		if (amount > 0) {
		
			do {
				System.out.print("Enter the expiry date of the item (yyyy-mm-dd or none): "); //Ask for the expiry date
				if(scanner.hasNext()) {
					String inputDate = scanner.next(); 
					try { //Catch for any error
						if (inputDate.equalsIgnoreCase("none"))
							exp = LocalDate.MAX; //If none set exp to max
						else
							exp = LocalDate.parse(inputDate);
						loop = true;
					} catch (DateTimeParseException e) {
						System.out.println("Could not create date from input, please use format yyyy-mm-dd");
						System.out.println(e.getLocalizedMessage());
				
						loop = false;
					}
				}else {
					System.out.println("Invalid Entry");
					scanner.next();
					loop = false;
				}
				
				
			}while(!loop);
			
			//In for loop add the expiry date
			for (int i = 0; i < amount; i++)
				expiries.add(exp);
		}else {
			for (int i = 0; i < (amount * -1); i++)
				expiries.remove();
		}
		

		//Update the stock quantity
		itemQuantityInStock += amount;
		return true;
	}

	
}
