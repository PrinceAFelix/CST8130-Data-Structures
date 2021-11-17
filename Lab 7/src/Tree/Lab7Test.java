package Tree;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab7Test {

	public static void menu() {
		System.out.print("1. Create a TreeMap of data from the text file.\n"
				+ "2. Display the TreeMap.\n"
				+ "3. Search for a given key or value in the TreeMap.\n"
				+ "4. Create and display a keys TreeSet and a values TreeSet from the TreeMap\n"
				+ "5. Add new key-value data to the TreeMap.\n"
				+ "6. Sort and display values TreeSet in descending order.\n"
				+ "7. Exit\n>");
	}
	
	public static void main(String[] args) {
		
		//Represents the Scanner Object
		Scanner sc = new Scanner(System.in);
		
		//Represents the TreeMapSet Object
		TreeMapSet t = new TreeMapSet();
		
		//Represents the user choice input
		int userChoice;
		
		//Do while loop, until the user decided to exit
		
		do {
			try {
				
				menu();
				userChoice = sc.nextInt();
				
				//Switch statement, to perform different task depends on what the user wants
				switch (userChoice) {
				case 1:
					t.createMap(sc);
					break;
				case 2:
					t.displayTreeMap();
					break;
				case 3:
					t.findTreeMap(sc);
					break;
				case 4:
					t.printAscending();
					break;
				case 5:
					t.addTreeMap(sc);
					break;
				case 6:
					t.sortNames();
					break;
				case 7:
					System.out.println("Exiting...");
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



