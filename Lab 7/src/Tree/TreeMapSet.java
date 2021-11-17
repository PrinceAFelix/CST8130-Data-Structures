package Tree;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;


public class TreeMapSet {

	/**Represents the checker*/
	protected boolean updated = false;
	/**Represents the checker when to display the message*/
	protected int displayMessage = 0;
	
	/**
	 * No Arg contructor
	 */
	TreeMapSet(){}
	
	/**Represents the TreeMap Object*/
	TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
	
	/**This method creates a TreeMap of data from a file
	 * 
	 * @param sc represents Scanner object
	 */
	public void createMap(Scanner sc) {
		
		//Opening the file
		try {
			sc = new Scanner(Paths.get("src\\Tree\\productowners.txt"));
		}catch(FileNotFoundException fe) {//Check for any possible error
			System.err.println("Error Opening File");
		}catch(IOException ioe) {
			System.out.println("IO Exception - related to employees.txt file");
					
		}
		
		//Read the content of the data
		while(sc.hasNextLine()) {
			
			String keyVal = sc.nextLine();
			String kv[] = keyVal.split(",");
			
			//Insert the content of the data in the TreeMap
			if (kv.length == 2) {
				treeMap.put(Integer.parseInt(kv[1].trim()), kv[0].trim());
			} else if (kv.length == 3) {
				treeMap.put(Integer.parseInt(kv[2].trim()), kv[0].trim() + " " + kv[1].trim());
			}
		}
		
		System.out.println();

		System.out.println("...TreeMap created...");
		
		System.out.println();
		if (sc != null) {
			sc.close();
		}
		
		displayMessage += 1;
		
	}
	
	/**
	 * This method displays the contents of the TreeMap
	 */
	public void displayTreeMap() {
		
		System.out.println();
		if (updated) {
			System.out.println("Updated Tree Map is:\nContents of TreeMap: " + treeMap);
		}else 
			System.out.println("Contents of TreeMap: " + treeMap);
		
		System.out.println();
		
		displayMessage += 1;
		
	}
	
	/**This method search a key to a TreeMap
	 * 
	 * @param sc represents Scanner object
	 */
	public void findTreeMap(Scanner sc) {
		
		//Represents the key
		int userInput;
		try {
			
			System.out.print("Enter a key to search: ");
			userInput = sc.nextInt();
			
			System.out.println();
			if(treeMap.containsKey(userInput)) //Checks if key to search was in the TreeMap
				System.out.println("...key " + userInput + " was found... ");
			else
				System.out.println("...key " + userInput + " not found...");
			System.out.println();
			
		}catch(InputMismatchException ime) { //Catch any Input Mismatch Exception
			System.out.flush();
			System.out.println("Input Mismatch Exception While Reading the key to search");
			System.out.flush();
			sc.next();
		}catch(Exception e) { //Catch any General Exception
			System.out.flush();
			System.out.println("Exception While Reading the key to search");
			System.out.flush();
			sc.next();
		}
		
		
		
		
		displayMessage += 1;
		
	}
	
	/**
	 * This method creates and displays a keys and values TreeSet from TreeMap data in ascending order
	 */
	public void printAscending() {
		//TreeSet keys and values
		TreeSet<Integer> keys = new TreeSet<Integer>();
		TreeSet<String> value = new TreeSet<String>();
		
		//Copy TreeMap to TreeSet
		for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
			keys.add(entry.getKey());
			value.add(entry.getValue());
		}

		//Print the sorted TreeSet
		System.out.println();
		if (displayMessage == 7) {
			System.out.println("Keys TreeSet is " + keys);
			System.out.println("\t\tThe New Keys were added and were able to display in the TreeSet");
			System.out.println("Names TreeSet  is " + value);
			System.out.println("\t\tTreeSets doesn't support duplicates that's why the two new data value wasn't added to TreeSet");
		}
		else 
			System.out.println("\nKeys TreeSet is " + keys + "\nNames TreeSet  is " + value + "\n");	

		System.out.println();
		
	}
	
	/**
	 * This method sort the names TreeSet in descending order
	 */
	public void sortNames() {
		
		//Use SortedSet and Comparator to implement reverse alphabetical sorting
		 SortedSet<String> names = new TreeSet<String>(new Comparator<String>() {
			public int compare(String s1, String s2) {
				return -s1.compareTo(s2);
			}
		});
		
		//Copy the TreeMap to TreeSet
		for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
			names.add(entry.getValue());
		}
		
		//Print the descending order
		System.out.println("\n...Names Treeset was sorted in descending order...");
		System.out.println(names+"\n");
		
		displayMessage += 1;
		
	}
	
	/**This method adds a new key-value to a TreeMap
	 * 
	 * @param sc represents Scanner object
	 */
	public void addTreeMap(Scanner sc) {
		
		try {
			
			String keyVal; //Represents the new key-value
			System.out.print("\nEnter a key-value data: ");
			sc.nextLine();
			keyVal = sc.nextLine();
			
			//Insert into array and split
			String kv[] = keyVal.split(",");
			
			if(kv.length <= 1 || kv.length == 0) {
				System.err.println("\nPlease enter the correct format key-value\n");
				return;
			}
			
			if (kv.length == 2) { //If array length is 2 add to TreeMap
				treeMap.put(Integer.parseInt(kv[1].trim()), kv[0].trim());
			} else if (kv.length == 3) { //If array length is 3 add to TreeMap
				treeMap.put(Integer.parseInt(kv[2].trim()), kv[0].trim() + " " + kv[1].trim());
			}
			
			System.out.println();
			
		}catch(InputMismatchException ime) { //Catch any Input Mismatch Exception
			System.out.flush();
			System.out.println("Input Mismatch Exception While Reading the key-value data");
			System.out.flush();
			sc.next();
		}catch(Exception e) { //Catch any General Exception
			System.out.flush();
			System.out.println("Exception While Reading the key-value data");
			System.out.flush();
			sc.next();
		}
		
	
		
		updated = true;
		
		displayMessage += 1;
		
		
	}
	
		

}
