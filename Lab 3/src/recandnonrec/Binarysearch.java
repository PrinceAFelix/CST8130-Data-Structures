package recandnonrec;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;



public class Binarysearch {
	
	/**
	 * Stores int value
	 */
	protected int [] numbers;
	protected int rec;
	


	/**
	 * Scanner Object to read input 
	 */
	Scanner scan  = new Scanner(System.in);
	
	/**
	 * Secure Random Object to generate random numbers
	 */
	SecureRandom rand = new SecureRandom();
	
	/**
	 * No arg constructor
	 */
	Binarysearch(){
		
	}
	
	/**Parameterized constructor
	 * 
	 * @param size represents the size of the array
	 */
	Binarysearch(int size){
		numbers = new int[size];
	}
	
	/**This methods search the binary in non recursive mode
	 * 
	 * @param num represents the array
	 * @param key represents the number to be search
	 * @return a number if the key is found or not
	 */
	
	
	public int nonRecursiveBinarySearch(int num[], int key) {

		int first = 0; //left side of the search
		int last = num.length - 1; //right side of the search
		int middle = (first + last + 1) / 2; // Middle of the search
		int loc = -1;

		do {
			System.out.print(remainingElements(num, first, last));
			
			for(int i = 0; i < middle; i++)
				System.out.print(" ");
			if (key == num[middle])
				loc = middle;
			else if (key < num[middle])
				last = middle - 1;
			else
				first = middle + 1;
			
			middle = (first + last + 1) / 2;
		}while(first <= last && loc == -1);
		
		if(loc == -1) {
			System.out.printf("\nNumber %d was not found%n%n", key);
			return -1;
		}
		else {
			System.out.printf("\nNumber %d was found at index position %d : Iterative Binary Search%n%n", key, loc);
		}
		
		rec = 0;
		
		return loc;
	}

	/**This methods search the binary in recursive mode
	 * 
	 * @param num represents the array
	 * @param first represents the first index in the array
	 * @param last represents the last index in the array
	 * @param key represents the number to be search
	 * @return a number if the key is or is not found
	 */
	 public int recursiveBinarySearch(int num[],int first,int last,int key) {
		 
		 int middle = (first + last + 1) / 2;
		 System.out.print(remainingElements(num, first, last));
		 
		 for(int i = 0; i < middle; i++)
				System.out.print(" ");
         if(first<=last) {	
        	 if(key == num[middle]) {
        		 System.out.printf("\nNumber %d was found at index position %d : Recursive Binary Search%n%n",key, middle);
        		 return middle;
        		 }
        	 //If the key is greater than the middle then we search in the right side by calling the function itself
        	 else if(key > num[middle])
        		 return recursiveBinarySearch(num,middle+1,last,key);
             else
                 return recursiveBinarySearch(num,first,middle-1,key);
        	 }
         
         rec = 1;
         // if not found
         System.out.printf("\nNumber %d was not found : recursive binary search%n%n", key);
            
         return -1;
             
             
	 }
	 
	 /**This method prints the numbers in the array
	  * @return the string
	  */
	public String toString() {
		
		//Prints the numbers by irretating through array
		System.out.print("[ ");
		for(int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.print("]");
		System.out.println();
	
		return "";
	}
	

	/**This method generates a number and store it to the array
	 * 
	 */
	public void generateRandomInts() {
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = 10 + rand.nextInt(90);
		}
	}
	
	/**This method displays elements remaining each time half of the array iss dropped
	 * 
	 * @param num represents the array
	 * @param first represents the first index of the array
	 * @param end represents the last index of the arrau
	 * @return the array and display it
	 */
	public static String remainingElements(int num[], int first, int end) {
		
		StringBuilder temp = new StringBuilder();
		
		for (int i = 0; i < first; i++) {
			temp.append(" ");
		}
		
		for (int i = first ; i <= end; i++) {
			temp.append(num[i] + " ");
			first += 1;
		}
		
		return String.format("%s%n",  temp);
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
	
	/**This method will print the time taken of each method
	 * 
	 * @param startNano represents the starting time in nano
	 * @param endNano represents the end time in nano
	 * @param startMilli represents the start time in milli
	 * @param endMillirepresents the end time in milli
	 * @param target represents the number to be search
	 * @param method represents which method we are using
	 */
	public void timeExecution(long startNano, long endNano, long startMilli, long endMilli, int target, String method) {
	
         System.out.println("Time taken to search " + target + " using " + method + " method is  "+ (endNano - startNano) +"ns");
         System.out.println("Time taken to search " + target + " using " + method + " method is  " + ( endMilli - startMilli) + "ms\n");
    

	}
	
}
