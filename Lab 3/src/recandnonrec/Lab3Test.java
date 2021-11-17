package recandnonrec;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Lab3Test {

	public static void main(String[] args) {
		
		/**
		 * Scanner object 
		 */
		Scanner sc = new Scanner(System.in);
		
		/**
		 * variables
		 */
		int userInput, key, loop = 1;
		
		/**
		 * This variable will store the name of the method we are using
		 */
		String method;
		
		/**
		 * Number object
		 */
		Binarysearch b = new Binarysearch();
		
	
		/**
		 * This block will run the program until the user decided to stop
		 */
		do {
			
			/**
			 * This block catches any possible error
			 */
			try {
				System.out.print("1. Initialize and populate an array of 20 random integers\n2. Perform a recursive binary search\n3. Perform a non-recursive binary search\n4. Exit\n>");
				userInput = sc.nextInt();
				
				//switch cases - this will determine what the user wants to do
				 switch (userInput) {
				 	//Case 1 will initialized the numbers array and generate some random numbers
					case 1:
						b = new Binarysearch(20);
						b.generateRandomInts();
						Arrays.sort(b.numbers);
						System.out.println("Array of randomly generated integers:");
						System.out.println(b);
						break;
					//Case 2 will search binary in recursive
					case 2:

						if(b.isArrayCreated() == -1)
							System.err.println("Array is not created.. please create array first");
						else {
							try {
								method = "Recursive";
								System.out.println("Please enter an integer value to search: ");
								key = sc.nextInt();
								//Calculate the time taken in nano and millis seconds
								long startNano = System.nanoTime();
								long startMilli = System.currentTimeMillis();
								b.recursiveBinarySearch(b.numbers, 0, b.numbers.length-1, key);
						        long endNano = System.nanoTime();
			                    long endMilli = System.currentTimeMillis();
								b.timeExecution(startNano, endNano, startMilli, endMilli, key, method);
								
							}catch(InputMismatchException ime) {
								System.err.flush();
								System.err.println("Input Mismatch Exception While reading the number to be search");
								System.err.flush();
								sc.next();
							}catch(Exception e) {
								System.err.flush();
								System.err.println("Exception While reading the number to be search");
								System.err.flush();
								sc.next();
								
								
							}
						}
						
						break;
					//Case 3 will search binary in non recursive mode
					case 3:

						if(b.isArrayCreated() == -1)
							System.err.println("Array is not created.. please create array first");
						else {
							
							try {
								method = "Non-Recursive";
								System.out.println("Please enter an integer value to search: ");
								key = sc.nextInt();
								//Calculate the time taken in nano and millis seconds
								long startNano = System.nanoTime();
		                        long startMilli = System.currentTimeMillis();
								b.nonRecursiveBinarySearch(b.numbers, key);
						        long endNano = System.nanoTime();
			                    long endMilli = System.currentTimeMillis();
								b.timeExecution(startNano, endNano, startMilli, endMilli, key, method);
							}catch(InputMismatchException ime) {
								System.err.flush();
								System.err.println("Input Mismatch Exception While reading the number to be search");
								System.err.flush();
								sc.next();
							}catch(Exception e) {
								System.err.flush();
								System.err.println("Exception While reading the number to be search");
								System.err.flush();
								sc.next();
							}
					
						}
						
						
						break;
					case 4:
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
