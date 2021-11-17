package arrays;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Prince Adrianne Felix
 * Student Number: 040933287 
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * @author/Professor James Mwangi PhD. 
 * @author Linda Crane
 * @author Melissa Sienkiewicz
 */
public class Numbers {

	
	/**
	 * Stores Float values.
	 */
	private Float [] numbers;
	/**
	 * Store the number of items currently in the array.
	 */
	private int numItems = 0;


	/**
	 * Default Constructor
	 */
	public Numbers() {
		// TODO Write code here to initialize a "default" array since this is the default constructor
		numbers = new Float[5];
	}

	/**
	 * Constructor that initializes the numbers array.
	 * @param size - Max size of the numbers array
	 */
	public Numbers(int size) {
		// TODO Write code here to initialize the numbers array of max 'size'
		numbers = new Float[size];
	}
	

	/**
	 * Adds a value in the array
	 * @param keyboard - Scanner object to use for input
	 */
	public void addValue(Scanner keyboard) {
		
		//Detect any possible errors using the try catch
		try {
			
			//checks if the array is full or not
			if(numItems == numbers.length) {
				System.out.println("Array full");
			}else {
				System.out.print("Enter Value: ");
				numbers[numItems] = keyboard.nextFloat();
				numItems += 1;
			}
			
		}catch(InputMismatchException ime) {
			System.out.println("\nInput Mismatch Exception While Reading The Value\n");
			keyboard.next();
		}catch(Exception e) {
			System.err.println("\nException While Reading The Value\n");
			keyboard.next();
		}
		
		
		
	}


	/**
	 * Calculates the average of all the values in the numbers array.
	 * @return float value that represents the average
	 */
	public float calcAverage() {
		float temp = 0;
		// TODO Write code to return the average of the values in the array
		//Add everything in the array and store it on the temp variable
		for(int i = 0; i < numItems; i++) {
			 temp = temp + numbers[i];
		}
		
		/**Checks if there's a value in the temp variable*/
		if (temp == 0)
			return (float) 0.0;
		else
			return (float) temp/numItems;
		
	}

	@Override
	public String toString() {
		// TODO Write code for an appropriate toString method
		
		//Goes through the array and returns the value of it when printing the Numbers Object in test class
		System.out.println("Numbers are:");
		for(int i = 0; i < numItems; i++) {
			System.out.print(numbers[i] + "\n");
		}
		
		System.out.println();
		
		return "";
		
		
	}
	
}
