package hashing_hashtables;

public class HashingHT {

	/**Represents the array for a hashtable*/
	protected String[] dataBuckets = new String[100];

	/**No-arg constructor*/
	HashingHT(){}

	
	/**This method returns the index of a given string
	 * 
	 * @param str represents the String
	 * @return total % 100
	 */
	public int hash(String str) {
		int total = 0;
		for(int i= 0; i < str.length(); i++) //Calculate the total
			total += (int)str.charAt(i);
	
		//Do the modulus of 100
		return total % 100;
	}
	
	/**This method adds a Value to the HashTable
	 * 
	 * @param str represents the String
	 * @param index represents the index of the String
	 * @return true if successful, false if not
	 */
	public boolean add(String str, int index) {

		if(!search(str, index)) { //Check is exist, then add if not
			dataBuckets[index] = str;
			return true;
		}else {//If already exist, print a message
			System.out.println("String " + str + " is already in structure at index " + index);
			return false;
		}
		
		
	}
	
	/**This method search a Value to the HashTable
	 * 
	 * @param str represents the String
	 * @param index represents the index of the String
	 * @return true if successful, false if not
	 */
	public boolean search(String str, int index) {
		 for(int i = 0; i < 100; i++) {
			 if (str.equals(dataBuckets[i])) {
				 return true;
			 }
		 }
		
		 return false;
	
	}
	
	/**This method delete a Value to the HashTable
	 * 
	 * @param str represents the String
	 * @param index represents the index of the String
	 * @return true if successful, false if not
	 */
	public boolean delete(String str, int index) {

		//Checks if it contains
		if(search(str, index)) {
			dataBuckets[index] = null; //Remove if we found the value
			System.out.println(str + " deleted");
			return true;
		}else
			return false;
	}
	
	/**
	 * This method display the entire the HashTable
	 */
	public void display() {

		System.out.println("----------------");
		System.out.printf("%s%2s%3s%2s%2s\n", "|", "Index", "|", "Value", "|");
		for(int i = 0; i < dataBuckets.length; i++) { //Loop Through the HashTable
			if(dataBuckets[i] != null) { //Check if some indexes are empty, print if not
				System.out.println("----------------");
				System.out.printf("%s%2s%6s%2s%5s\n", "|", i,  "|", dataBuckets[i].toString().replace("[",  "").replace("]", ""), "|");
			}
		}
		System.out.println("----------------");
		
	}
}
