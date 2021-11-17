package hashing_hashtables;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab8Test {
	
	/**
	 * This method prints the menu of the program
	 */
	public static void menu() {
		System.out.print("1. Add\n"
				+ "2. Search\n"
				+ "3. Delete\n"
				+ "4. Displlay entire hastable\n"
				+ "5. Exit\n>");
	}
	

	public static void main(String[] args) {
		
		/**Represents the Scanner Object*/
		Scanner sc = new Scanner(System.in);
		
		/**Represents the HashingHT object*/
		HashingHT h = new HashingHT();
		
		/**Represents the user choice input*/
		int userChoice;
		
		/**Represents the String input*/
		String str;
		
		/**Represents the String index*/
		int index;
		
	
		//Loop until the user decide to stop
		do {
			try {
				menu();
				userChoice = sc.nextInt();
				
				str = "";
				index = 0;
				//Switch statement, to perform different task depends on what the user wants
				switch (userChoice) {
				case 1:
					//Ask for the String
					System.out.print("Enter string: ");
					str = sc.next();
					
					//Checks if the input is a number
					if(Character.isDigit(str.charAt(0)) == true) {
						System.err.print("Cannot add Integer...please try again\n");
						break;
					}
					
					//Get the index
					index = h.hash(str);
					if(h.add(str, index)) //Add the string
						System.out.println("entered at " + index);
					break;
				case 2:
					//Ask for the String
					System.out.print("Enter string: ");
					str = sc.next();
					
					//Checks if the input is a number
					if(Character.isDigit(str.charAt(0)) == true) {
						System.err.print("Strings only...please try again\n");
						break;
					}
					
					//Get the index
					index = h.hash(str);
					if(h.search(str, index)) {//Search the string
						System.out.println(str + " found at index " + index);
						break;
					}else
						System.out.println(str + " not found");
					break;
				case 3:
					//Ask for the String
					System.out.print("Enter string to delete: ");
					str = sc.next();
					
					//Checks if the input is a number
					if(Character.isDigit(str.charAt(0)) == true) {
						System.err.print("Strings only...please try again\n");
						break;
					}
					
					//Get the index
					index = h.hash(str);
					if(!h.search(str, index)) //Checks if the String exist
						System.out.println(str + " does not exist");
					else
						h.delete(str, index); //Delete the string
					break;
				case 4:
					//Display the entire hashtable
					h.display();
					break;
				case 5:
					System.out.println("Prince Felix has ended the program");
					sc.close();
					return;
				default:
					System.out.println("Invalid Option, Please try again.");
					break;
				}
			}catch(InputMismatchException ime) { //Catch any Input Mismatch Exception
				System.out.flush();
				System.out.println("Input Mismatch Exception While Reading the Menu");
				System.out.flush();
				sc.next();
			}catch(Exception e) { //Catch any General Exception
				System.out.flush();
				System.out.println("Exception While Reading the Menu");
				System.out.flush();
				sc.next();
					}
		}while(true);
		
	}
}



