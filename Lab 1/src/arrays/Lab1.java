package arrays;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * CET - CS Academic Level 3
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Prince Adrianne Felix
 * Student Number: 040933287
 * Course: CST8130 - Data Structures
 * @author/Professor James Mwangi PhD. 
 * @author Linda Crane
 * @author Melissa Sienkiewicz
 */
public class Lab1 {

	/**
	 * The application's entry point
	 * @param args an array of command-line arguments for the application
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * Scanner Object
		 */
		 Scanner keyboard = new Scanner(System.in);
		 
		 /**
		  * Numbers Object
		  */
		 Numbers n = new Numbers();
		 
		 /**
		  * Stores int value
		  */
		 int userChoice;
		 
		 /**
		  * Stores int value 
		  */
		 int loop = 1;
		 
		 
		 //Do while loop - It will run until the user decided to exit
		 do {
			 try {
				 
				 //Menu for the user. It will ask the user what they want to do
				 System.out.print("Please select one of the following:\n1: Initialize a default array\n2: To specify the max size of the array\n3: Add value to the array\n4: Display values in the array\n5: Display the averagr of the values\n6: To Exit\n> ");
				 userChoice = keyboard.nextInt();

				 //switch cases - this will determine what the user wants to do
				 switch (userChoice) {
					case 1: 
						n = new Numbers();
						break;
					case 2:
						try{
							System.out.print("Enter new size of array: ");
							int size =  keyboard.nextInt();
							n = new Numbers(size);
							
						}catch(InputMismatchException ime) {
							 System.out.println("\nInput Mismatch Exception While Reading the Size of the Array\n");
							 keyboard.next();
						}
						
						break;
						
					case 3:
						n.addValue(keyboard);
						break;
					case 4:
						System.out.print(n);
						break;
					case 5:
						System.out.printf("Average is: %.2f\n" , n.calcAverage());
						break;
					case 6:
						System.out.println("Exiting...");
						loop = 0;
						break;
					default:
						System.out.println("\nInvalid Choice\n");
						break;
						
					}
			 
			 
			 }catch(InputMismatchException ime) {
				 System.out.println("\nInput Mismatch Exception While Reading the Menu\n");
				 keyboard.next();
			 
			 }catch(Exception e){
				 System.err.println("\nException While Reading the Menu");
			 }
		 }while(loop == 1);

	}

}

