package BinaryTrees;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab6Test {
	
	//Menu of the program
	private static void menu() {
		System.out.print("1: Add Value to Tree\n2: Diplay Tree (In-Order Traversal\n3: Display Height\n4: To Exit\n> ");
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//BinaryTree object
		BinaryTree bn = new BinaryTree();
		//Variable that holds user input
		int userChoice;
		
		//Do while loop, until the user decided to exit
		do {
			try {
				menu();
				userChoice = sc.nextInt();
				
				//Switch statement, to perform different task depends on what the user wants
				switch (userChoice) {
				case 1:
					System.out.print("Enter an Integer to add to the tree: ");
					int newData = sc.nextInt();
					bn.insertInTree(newData);
					break;
				case 2:
					bn.displayInOrder();
					break;
				case 3:
					bn.displayHeight();
					break;
				case 4:
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


