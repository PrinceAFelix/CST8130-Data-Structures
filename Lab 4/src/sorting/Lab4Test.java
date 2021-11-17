package sorting;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab4Test {
	
	public static void mainMenu() {
		System.out.print("1. Initialize and populate an array of 20 random integers\n2. Perform a recursive binary search\n3. Perform a non-recursive binary search\n4. Sort the array\n5. Quit\n> ");

	}
	
	public static void sortMenu() {
		System.out.print("\nSelect a sorting algorithm to sort the data array\n"
				+ "\n\tB. Bubble Sort"
				+ "\n\tI. Insertion Sort"
				+ "\n\tS. Selection Sort"
				+ "\n\tM. Merge Sort"
				+ "\n\tQ. Quick Sort"
				+ "\n\n\tX. Return to Main Menu\n"
				+ "\n> ");
	}

public static void main(String[] args) {
		
		/**
		 * Scanner object 
		 */
		Scanner sc = new Scanner(System.in);
		
		/**
		 * variables
		 */
		int userInput, key, loop = 1, loop2 = 1;
		char userChoice;
		
		long startNano;
		long startMilli;
        long endNano;
        long endMilli;
	
		int[] arr = new int[20];
		int[] bubble = new int[20];
		int[] insertion = new int[20];
		int[] selection = new int[20];
		int[] merge =  new int[20];
		int[] quick = new int[20];
		
		/**
		 * This variable will store the name of the method we are using
		 */
		String method;
		
		/**
		 * Binary Search object
		 */
		Binarysearch b = new Binarysearch();
		
		SortingAlgorithms s = new SortingAlgorithms();
	
		/**
		 * This block will run the program until the user decided to stop
		 */
		do {
			
			/**
			 * This block catches any possible error
			 */
			try {
				mainMenu();
				userInput = sc.nextInt();
				
				//switch cases - this will determine what the user wants to do
				 switch (userInput) {
				 	//Case 1 will initialized the numbers array and generate some random numbers
					case 1:
						arr = b.generateRandomInts();
						System.out.println("Array of randomly generated integers:");
						System.out.println(b.toString(arr));
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
								startNano = System.nanoTime();
								startMilli = System.currentTimeMillis();
								b.recursiveBinarySearch(arr, 0, arr.length-1, key);
						        endNano = System.nanoTime();
			                    endMilli = System.currentTimeMillis();
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
								startNano = System.nanoTime();
		                        startMilli = System.currentTimeMillis();
								b.nonRecursiveBinarySearch(arr, key);
						        endNano = System.nanoTime();
			                    endMilli = System.currentTimeMillis();
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
						int n = arr.length;
						
						for(int  i = 0; i < n; i++) {
							bubble[i] = arr[i];
							insertion[i] = arr[i];
							selection[i] = arr[i];
							merge[i] = arr[i];
							quick[i] = arr[i];
						}
						do {
							try {
								System.out.println();
								sortMenu();
								userChoice = sc.next().toUpperCase().charAt(0);
								
								switch(userChoice) {
								case 'B':
									System.out.print(b.toString(arr));
									System.out.println(s.toString(false));
									startNano = System.nanoTime();
			                        startMilli = System.currentTimeMillis();
									s.bubbleSort(bubble);
									endNano = System.nanoTime();
					                endMilli = System.currentTimeMillis();
									s.timeExecution(startNano, endNano, startMilli, endMilli);
									break;
								case 'I':
									System.out.print(b.toString(arr));
									System.out.println(s.toString(false));
									startNano = System.nanoTime();
			                        startMilli = System.currentTimeMillis();
									s.insertionSort(insertion);
									endNano = System.nanoTime();
					                endMilli = System.currentTimeMillis();
									s.timeExecution(startNano, endNano, startMilli, endMilli);
									break;
								case 'S':
									System.out.print(b.toString(arr));
									System.out.println(s.toString(false));
									startNano = System.nanoTime();
			                        startMilli = System.currentTimeMillis();
									s.selectionSort(selection);
									endNano = System.nanoTime();
					                endMilli = System.currentTimeMillis();
									s.timeExecution(startNano, endNano, startMilli, endMilli);
									break;
								case 'M':
									System.out.print(b.toString(arr));
									System.out.println(s.toString(true));
									startNano = System.nanoTime();
			                        startMilli = System.currentTimeMillis();
									s.mergeSort(merge, 0, n-1);
									endNano = System.nanoTime();
					                endMilli = System.currentTimeMillis();
									System.out.print(b.toString(merge));
									s.timeExecution(startNano, endNano, startMilli, endMilli);
									break;
								case 'Q':
									System.out.print(b.toString(arr));
									System.out.println(s.toString(true));
									startNano = System.nanoTime();
			                        startMilli = System.currentTimeMillis();
									s.quickSort(quick, 0, n-1);
									endNano = System.nanoTime();
					                endMilli = System.currentTimeMillis();
									System.out.print(b.toString(quick));
									s.timeExecution(startNano, endNano, startMilli, endMilli);
									break;
								case 'X':
									System.out.println("Returning to main menu...");
									loop2 = 0;
									break;
								default:
									System.out.println("Invalid choice... Please try again\n");
									break;
								}
								
									
								
							}catch(InputMismatchException ime) {
								System.err.flush();
								System.err.println("Input Mismatch Exception While reading the sort menu");
								System.err.flush();
								sc.next();
							}catch(Exception e) {
								System.err.flush();
								System.err.println("Exception While reading the sort menu");
								System.err.flush();
								sc.next();
							}
						}while(loop2 == 1);
						
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
		
		sc.close();
	}


}
