import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Inventory<br>
 * The Inventory Class implement an application that implement all the things from Food Item class
 * 
 * @author Prince Adrianne Felix
 * @since 2021-04-07 CST8130 Data Structures
 * @version 1.0
 * 
 */
public class Inventory {

	/**Represents the FoodItem ArrayList*/
	private ArrayList<InventoryItem> inventory = new ArrayList<InventoryItem>();
	/**Represents the number of Items in an array*/
	private int numItems = 0;
	
	/**
	 * Class No-argument Constructor
	 */
	Inventory(){
	}
	
	@Override
	public String toString() {
		
		System.out.println("Inventory: ");
		/**In for loops, it should print all the item in an array*/
		for(int i = 0; i < numItems; i++) {
			inventory.get(i).toString();
			System.out.println();
		}
		System.out.println();
		return "";
		
	}
	
	/**
	 * This method checks if the item exist 
	 * @param item represents the temporary food item object
	 * @return the index of the item, else return -1
	 */
	public int alreadyExist(FoodItem item) {
		/**Check if the item exist*/
		return searchMethod(item.itemCode, 0, inventory.size() - 1);
	}

	
	/**
	 * 
	 * @param scanner represents the Scanner Object
	 * @return true if successful, else return false
	 */
	public boolean addItem(Scanner scanner) {
		int loop = 1;
		
		//Created a temporary Food Item, to hold item
		FoodItem temp = null;
		
		
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
					temp = new Fruit();
					loop = 0;
					break;
				case 'v':
					System.out.println();
					temp = new Vegetable();
					loop = 0;
					break;
				case 's':
					System.out.println();
					temp = new Sweetener();
					loop = 0;
					break;
				case 'p':
					System.out.println();
					temp = new Preserve();
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
		
		InventoryItem inv = new InventoryItem(temp);
		if(inv.addItem(scanner)) {
			push(inv);
			numItems++;
			return true;
		}
		
		return false;

		
		
		
	}
	
	public void push(InventoryItem temp) {
		InventoryComparator sort = new InventoryComparator();
		for(int i = 0; i < inventory.size(); i++) {
			if(sort.compare(inventory.get(i), temp) >= 0) {
				inventory.add(i, temp);
				return;
			}
		}
		
		inventory.add(temp);
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
			System.out.println("Error...could not buy item\n");
		}else if (numItems <= 0 && buyOrSell == false) {
			System.out.println("Error...could not sell item\n");
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
				System.out.println("Code not found in invenotry...\nError...could not buy item\n");
				return false;
			}else if(tempNum == -1 && buyOrSell == false) {
				System.out.println("Code not found in invenotry...\nError...could not sell item\n");
				return false;
			}else {
				/**If buying, should ask the user for the quantity then update the item quantity*/
				if(tempNum != -1 && buyOrSell == true) {
					
					/**In try Catch, this determines if the quantity is valid*/
					try {
						System.out.print("Enter valid quantity to buy: ");
						qnty = scanner.nextInt();
						
						/**In for loops, get the item and update it*/
						for(int i = 0; i < numItems; i++) {
							if(i == tempNum) {
								inventory.get(i).updateQuantity(scanner, qnty);
								isOk = 1;
							}
						}
						
						System.out.println();
					}catch(InputMismatchException ime) {
						System.err.flush();
						System.out.println("Invalid quantity...\nError...could not buy item\n");
						System.err.flush();
						scanner.next();
						return false;
					}finally {
						/**Checks if the quantity enetred is less than 0*/
						if(qnty < 0) {
							System.out.println("Invalid quantity...\nError...could not buy item\n");
							return false;
						}
					}
					
					
					/**If selling, should ask the user for the quantity then update the item quantity*/
				}else if(tempNum != -1 && buyOrSell == false){
					
					
					//Try catch Block, to catch any error
					try {
						System.out.print("Enter valid quantity to sell: ");
						qnty = scanner.nextInt();
						
						/**In for loops, get the item and update it*/
						for(int i = 0; i < numItems; i++) {
//							if(qnty >= inventory.get(i).itemQuantityInStock) {
//								System.out.println("Insufficient stock inventory...\nError...could not buy item\n");
//								return false;
//							}
							if(i == tempNum) {
								inventory.get(i).updateQuantity(scanner, -qnty);
								isOk = 1;
							}
						}
						System.out.println();
					}catch(InputMismatchException ime) {
						System.err.flush();
						System.out.println("\nInvalid quantity...\nError...could not buy item\n");
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
					
				}
			}

				
		}
		
		/**Return true if successful, else return false*/
		if(isOk == 1)
			return true;
		else
			return false;
	}
	
	
	/**This method prints the expiry details
	 * 
	 * @param scanner represents the Scanner object
	 */
	public void printExpiry(Scanner scanner) {
		FoodItem temp = new FoodItem();
		temp.inputCode(scanner);
		int item = searchMethod(temp.itemCode, 0, inventory.size()  -1);
		if(item != -1)
			inventory.get(item).printExpirySummary();
			
			

			
			
	}
	
	/**This method uses binary search to search the item
	 * 
	 * @param itemCode represents the item code
	 * @param start represents the start of the List
	 * @param end represents the end of the list
	 * @return returns the index
	 */
	public int searchMethod(int itemCode, int start, int end) {
		int middle = (start + end) / 2;
		if (start > end)
			return -1;
		if (inventory.isEmpty())
			return -1;
		if (inventory.get(middle).getItemCode() == itemCode)
			return middle;
		if (inventory.get(middle).getItemCode() > itemCode)
			return searchMethod(itemCode, start, middle - 1);
		if (inventory.get(middle).getItemCode() < itemCode)
			return searchMethod(itemCode, middle + 1, end);
		return -1;
	}
	
	/**This method search the item from the list
	 * 
	 * @param scanner represents the Scanner object
	 */
	public void searchItem(Scanner scanner) {
		FoodItem temp = new FoodItem();
		temp.inputCode(scanner);
		int item = searchMethod(temp.itemCode, 0, inventory.size()-1);
		if(item != -1)
			System.out.println(inventory.get(item).toString());
		else
			System.out.println("Food Item could not he found");
		
	}
	
	/**This method removes the espired items
	 * 
	 * @param current represents the date
	 */
	public void removeExp(LocalDate current) {
		ListIterator<InventoryItem> items = inventory.listIterator();
		while(items.hasNext())
			items.next().removeExpiredItems(current);
	}
	
	

}
