import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Inventory<br>
 * The Inventory Class implement an application that implement all the things from Food Item class
 * 
 * @author Prince Adrianne Felix
 * @since 2021-02-07 CST8132 Object-Oriented Programming
 * @version 1.0
 * 
 */
public class Inventory {

	/**Represents the FoodItem Object*/
	private FoodItem[] inventory;
	/**Represents the number of Items in an array*/
	private int numItems = 0;
	
	/**
	 * Class No-argument Constructor
	 */
	Inventory(){
		
	}
	/**
	 *  Class parameterized constructor that sets the size of the array
	 * @param n represents the size of the array
	 */
	Inventory(int n){
		inventory = new FoodItem[n];
	}
	
	/**
	 * This method prints the inventory items
	 */
	public String toString() {
		System.out.println("Inventory: ");
		/**In for loops, it should print all the item in an array*/
		for(int i = 0; i < numItems; i++) {
			inventory[i].toString();
			System.out.println();
		}
		System.out.println();
		return "";
		
	}
	
	/**
	 * This method checks if the item exist by calling isEqual method
	 * @param item represents the temporary food item object
	 * @return the index of the item, else return -1
	 */
	public int alreadyExist(FoodItem item) {
		/**Check if the item exist*/
		for(int i = 0; i < numItems; i++) 
			if(item.isEqual(inventory[i])) 
				return i;
				
		return -1;
	 
	}
	
	
	/**
	 * 
	 * @param scanner represents the Scanner Object
	 * @return true if successful, else return false
	 */
	public boolean addItem(Scanner scanner) {
		int loop = 1;
		
		/**Checks if array is full, if yes, prints an error message*/
		if(numItems == inventory.length)
			System.out.println("Array Full, Cannot add more items");
		else {

			/**Do while loop, until the user input is valid input*/
			do {
				/**Try catch, this will filter any input mismatch exception and other exception*/
				try {
				
					char userChoice;
					System.out.print("Do you wish to add a fruit(f), vegetable(v), sweetener(s) or a preserve(p)? ");
					userChoice = scanner.next().charAt(0);
					/**Switch case, this decide what the item is*/
					switch(userChoice) {
						
					case 'f':
						System.out.println();
						inventory[numItems] = new Fruit();

						loop = 0;
						break;
					case 'v':
						System.out.println();
						inventory[numItems] = new Vegetable();
						loop = 0;
						break;
					case 's':
						System.out.println();
						inventory[numItems] = new Sweetener();
						loop = 0;
						break;
					case 'p':
						System.out.println();
						inventory[numItems] = new Preserve();
						loop = 0;
						break;
					default:
						System.out.println("Invalid entry");
						break;
					}
					
				}catch(InputMismatchException ime) {
					System.err.flush();
					System.err.println("Input Mismatch Exception While Reading the which to add");
					System.err.flush();
					scanner.next();
				}catch(Exception e) {
					System.err.flush();
					System.err.println("Exception While Reading the which to add");
					System.err.flush();
					scanner.next();
				}
				
			}while(loop == 1);
			
			/**Reads the item base on the item that was input above*/
			inventory[numItems].addItem(scanner);
			numItems++;
		}
		
		return true;
		
	}
	
	/**
	 * This method decides if the user is buying or selling an item
	 * 
	 * @param scanner represents the Scanner Object
	 * @param buyOrSell decides if the user is buying or selling
	 * @return true if successful, else return false
	 */
	public boolean updateQuantity(Scanner scanner, boolean buyOrSell) {
		
		//Buy == true
		//Sell  == false
		int isOk = 0;
		
		/**Checks for any possible error*/
		if(numItems <= 0 && buyOrSell == true) {
			System.out.println("Error...could not buy item");
		}else if (numItems <= 0 && buyOrSell == false) {
			System.out.println("Error...could not sell item");
		}else {
			
			/**represents the quantity that the user would like to update*/
			int qnty = 0;
			
			/**Created a temporary food item*/
			FoodItem temp = new FoodItem();
			/**Ask the user for the item Code*/
			temp.inputCode(scanner);
			/*Assign the return value of already exist to tempNum*/
			int tempNum = alreadyExist(temp);

			/**If statement, that will decide what to output*/
			if(tempNum == -1 && buyOrSell == true) {
				System.out.println("Code not found in invenotry...\nError...could not buy item");
				return false;
			}else if(tempNum == -1 && buyOrSell == false) {
				System.out.println("Code not found in invenotry...\nError...could not sell item");
				return false;
			}else {
				/**If buying, should ask the user for the quantity then update the item quantity*/
				if(tempNum != -1 && buyOrSell == true) {
					
					/**In try Catch, this determines if the quantity is valid*/
					try {
						System.out.print("Eter valid quantity to buy: ");
						qnty = scanner.nextInt();
						
						/**In for loops, get the item and update it*/
						for(int i = 0; i < numItems; i++) {
							if(i == tempNum) {
								inventory[i].updateItem(qnty);
								isOk = 1;
							}
						}
					}catch(InputMismatchException ime) {
						System.err.flush();
						System.out.println("Invalid quantity...\nError...could not buy item");
						System.err.flush();
						scanner.next();
						return false;
					}finally {
						/**Checks if the quantity enetred is less than 0*/
						if(qnty < 0) {
							System.out.println("Invalid quantity...\nError...could not buy item");
							return false;
						}
					}
					
					
					/**If selling, should ask the user for the quantity then update the item quantity*/
				}else if(tempNum != -1 && buyOrSell == false){
					
					
					try {
						System.out.print("Eter valid quantity to sell: ");
						qnty = scanner.nextInt();
						
						/**In for loops, get the item and update it*/
						for(int i = 0; i < numItems; i++) {
							if(qnty >= inventory[i].itemQuantityInStock) {
								System.out.println("Insufficient stock inventory...\nError...could not buy item");
								return false;
							}
							if(i == tempNum) {
								inventory[i].updateItem(-qnty);
								isOk = 1;
							}
						}
					}catch(InputMismatchException ime) {
						System.err.flush();
						System.out.println("Invalid quantity...\nError...could not buy item");
						System.err.flush();
						scanner.next();
						return false;
					}finally {
						/**Checks if the quantity enetred is less than 0*/
						if(qnty < 0) {
							System.out.println("Invalid quantity...\nError...could not buy item");
							return false;
						}
//						/**Checks if the quantity enetred is too large*/
//						for(int i = 0; i < numItems; i++) {
//							if(qnty >= inventory[i].itemQuantityInStock) {
//								System.out.println();
//								return false;
//							}
//						}
					}
					
				}
			}

			
			
		}
		
		/**Return true if successful, else return false*/
		if(isOk == 1)
			return true;
		else
			return false;
	}

}
