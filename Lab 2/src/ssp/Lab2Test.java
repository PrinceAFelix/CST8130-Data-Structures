package ssp;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Lab2Test {

	public static void main(String[] args) {
		
		/**
		 * Scanner object 
		 */
		Scanner sc = new Scanner(System.in);
		/**
		 * variables
		 */
		int userInput, size, numToSearch, loop = 1;
		
		/**
		 * Number object
		 */
		Numbers n = new Numbers();
		
	do {
		try {
			System.out.print("1. Create array with new size\n2. Generate random numbers and store it in the array\n3. Search a number and display its number of occurences\n4. Display array\n5. Quit\n> ");
			userInput = sc.nextInt();
			
			//switch cases - this will determine what the user wants to do
			 switch (userInput) {
				case 1:
					//Catch an input mismatch exception
					try {
						System.out.println("Enter required size: ");
						size = sc.nextInt();
						n = new Numbers(size);
					}catch(InputMismatchException ime) {
						System.err.flush();
						System.err.println("\nInput Mismatch Exception While Reading the size\n");
						System.err.flush();
						sc.next();
					}
					
					break;
				case 2:
					//Call the generate numbers method
					n.generateNumbers();
					break;
				case 3:
					//Checks if array is created or not
					if(n.isArrayCreated() == -1) {
						System.err.println("Array is not created... please create the array first");
					}else {
						
						if(n.isEmpty() == -1) {
							System.err.println("Array is empty");
						}else {
							//Catch an input mismatch exception and other exceptions
							try {
								System.out.println("Enter the number to be searched: ");
								numToSearch = sc.nextInt();
								System.out.println("Number " + numToSearch + " occurred " + n.findCount(numToSearch) + " times in the array");
							}catch(InputMismatchException ime) {
								System.err.flush();
								System.err.println("\nInput Mismatch Exception While Reading the Number to be Searched\n");
								System.err.flush();
								sc.next();
							}catch(Exception e) {
								System.err.flush();
								System.err.println("\nException While Reading the Number to be Searched\n");
								System.err.flush();
							}
							
						}
						
					}
					
					break;
				case 4:
					//Print the toString
					System.out.println(n);
					break;
				case 5:
					System.out.println("Bye.... have a nice day!");
					loop = 0;
					break;
				default:
					System.err.println("\nInvalid Choice\n");
					break;
			 }
			
		}catch(InputMismatchException ime) {
			System.err.flush();
			System.err.println("\nInput Mismatch Exception While Reading the Menu\n");
			System.err.flush();
			sc.next();
		}
	}while(loop != 0);

	}

}
