package ssp;

import java.security.SecureRandom;

public class Numbers {
	
	/**
	 * Stores Integer values.
	 */
	private Integer [] numbers;
	/**
	 * Store the number of items currently in the array.
	 */
	private int numItems = 0;
	
	/**
	 * An object that will generate random numbers
	 */
	SecureRandom rand = new SecureRandom();
	
	
	/**
	 * NO-arg Constructor
	 */
	Numbers(){
		
	}
	
	/**
	 * 
	 * @param size represents the size of the array
	 */
	Numbers(int size){
		numbers = new Integer[size];
	}
	
	
	/**
	 * Generates random  numbers and stores it in the array
	 */
	public void generateNumbers() {
		if(isArrayCreated() == -1) {
			System.err.println("Array is not created... please create the array first");
		}else {
			numItems = 1;
			for (int i = 0; i < numbers.length; i++) {
				numbers[i] = 1 + rand.nextInt(50);
			}
		}
		
	}
	
	/**
	 * 
	 * @param num represents the number to be searched
	 * @return how many times the number appears in te array
	 */
	public int findCount(int num) {
		
		numItems = 0;
		//Irritates through the array and see how many times the chosen number was seen
		for(int i = 0; i < numbers.length; i++) {
			if (numbers[i] == num)
				numItems++;
			
		}
		
		return numItems;
	}
	
	/**
	 * Prints the numbers in the array
	 */
	public String toString() {
		
		//checks if the array is created
		if(isArrayCreated() == -1) {
			System.err.print("Array is not created... please create the array first\n");
		}else {
			
			//Checks if the array is empty
			if(isEmpty() == -1) {
				System.err.print("Array is empty");
			}else {
				//If its not empty, it should print the numbers in the array
				for(int i = 0; i < numbers.length; i++) {
					System.out.print(numbers[i] + " ");
				}
				
				System.out.println();
			}
			
		}

		return "";
	}
	
	/**Checks if the array is created
	 * 
	 * @return an int
	 */
	public int isArrayCreated() {
		
		if(numbers == null)
			return -1;
		else
			return 0;
	}
	
	/**Checks if the array is empty
	 * 
	 * @return an int 
	 */
	public int isEmpty() {
		if(numbers.length == 0)
			return -1;
		else
			return 0;
	}

}
