package sorting;

public class SortingAlgorithms {
	
	
	/**Checks if there changes*/
	private boolean changesMade = true;

	/**
	 * No arg constructor
	 */
	SortingAlgorithms(){
		
	}
	
	/**
	 * Binary Search object
	 */
	Binarysearch b = new Binarysearch();
	
	/**This method sort the array using bubule sort
	 * 
	 * @param array represents the array of numbers
	 */
	public void bubbleSort(int array[]) {
		int n = array.length;//Get the array length
		for(int i = 0; i < n; i++) {
			changesMade = false;//Check if changes were made, false if not
			for(int j = 0; j < n - i - 1; j++) {
				//Check if the array index 0 is greater than the array of next index
				if(array[j] > array[j+1]) {
					int temp = array[j];//Set temp to the current array
					array[j] = array[j+1];//Switch the current array to the value of next array
					array[j+1] = temp; //Finally, set the next array to the temp
					changesMade = true; //True if changes were made
				}
			}
		}
		
		//Print the sorted array
		System.out.print(b.toString(array));
		
	}
	
	/**This method sort the array using insertion
	 * 
	 * @param array represents the array of numbers 
	 */
	public void insertionSort(int array[]) {
		
		int n = array.length;//Get the array length
		
		for(int i = 1; i < n; i++) {
			changesMade = false;
			int current = array[i];//Represents the current array
			int j = i-1;
			//Switch the elements that are greater than the current array
			while((j > -1) && (array[j] > current)){
				array [j+1] = array[j];
				j--;
			}
			array[j+1] = current;
			changesMade = true;
		}
		
		
		//Print the sorted array
		System.out.print(b.toString(array));
		
	}
	
	/**This method sort the array using selection
	 * 
	 * @param array represents the array of numbers 
	 */
	public void selectionSort(int array[]) {
		int n = array.length;//Get the array length
		int smallest;
		for(int current = 0; current < n; current++) {
			changesMade = false;
			smallest = current; //start smallest at next
			for(int j = current + 1; j < n; j++) {
				//Check if array index j is less than the array index current
				if (array[j] < array[smallest])
					smallest = j; //Set smallest to J if so
			}
			
			int temp = array[current]; //Set temp to the current array
			array[current] = array[smallest];//Switch the current array to the value of next array
			array[smallest] = temp; //Finally, set the next array to the temp
			changesMade = true;
		}
		
		//Print the sorted array
		System.out.print(b.toString(array));
	}

	
	/**This method sort the array using merge
	 * 
	 * @param array represents the array of numbers
	 * @param left represents the left side of the array
	 * @param right represents the right side of the array
	 */
	public void mergeSort(int[] array, int left, int right) {
		
		//Check if the right side is less or equal than the left side
		if (right <= left) {
			changesMade = false;
			return;
		}
			
		
		int mid = (left+right)/2;//Finds the midpoint
		//Calls recursively for both sides of mid point
		mergeSort(array, left, mid);
		mergeSort(array, mid+1, right);
		//Calls the merge method
		merge(array, left, mid, right);
		changesMade = true;
		
	}
	
	/**This method merge two sub arrays
	 * 
	 * @param array represents the array of numbers
	 * @param left represents the left side of the array
	 * @param mid represents the midpoint of the array
	 * @param right represents the right side of the array
	 */
	public void merge(int[] array, int left, int mid, int right) {
		// calculating the two sides to be merge
		int lengthLeft = mid - left + 1;
		int lengthRight = right - mid;

		//Create the two temporary arrays
		int leftArray[] = new int [lengthLeft];
		int rightArray[] = new int [lengthRight];

		//Copy the arrays to the temp array
		for (int i = 0; i < lengthLeft; i++)
			leftArray[i] = array[left+i];
		for (int i = 0; i < lengthRight; i++)
			rightArray[i] = array[mid+i+1];

		//Index of first and second sub arrays
		int leftIndex = 0, rightIndex = 0;

		for (int i = left; i < right + 1; i++) {
		// if there are still uncopied elements in R and L, copy minimum of the two
			if (leftIndex < lengthLeft && rightIndex < lengthRight) {
				if (leftArray[leftIndex] < rightArray[rightIndex]) {
					array[i] = leftArray[leftIndex];
					leftIndex++;
				}else {
					array[i] = rightArray[rightIndex];
					rightIndex++;
				}
			}
			// if all the elements have been copied from rightArray, copy the rest of leftArray
			else if (leftIndex < lengthLeft) {
				array[i] = leftArray[leftIndex];
				leftIndex++;
			}
			// if all the elements have been copied from leftArray, copy the rest of rightArray
			else if (rightIndex < lengthRight) {
				array[i] = rightArray[rightIndex];
				rightIndex++;
			}
		}
	}
	
	/**This method sort the array using quick sort
	 * 
	 * @param array represents the array of numbers
	 * @param start represents the start index of the array
	 * @param end represents the lat index of the array
	 */
	public void quickSort(int[] array, int start, int end) {
		
		//Check if the right side is less or equal than the left side
		if (start >= end) {
			changesMade = false;
			return;
		}
			
		
		//Set all the needed values
		int pivot = start, left = start + 1, right = end;
		
		while (left < right) {
			//Increment the left while it met the following
			while (array[left] < array[pivot] && left < right)
				left++;
			//Decrement the right while it met the following
			while (array[right] > array[pivot] && left < right)
				right--;
			
			//Swap the array
			int temp = array[left];
			array[left] = array[right];
			array[right] = temp;
			if (left < right) {
				left++;
				right--;
			}
			
		}
		
		if (array[left] > array[pivot]) {
			//Move the pivot and call recursively
			int temp = array[pivot];
			array[pivot] = array[left-1];
			array[left-1] = temp;
			quickSort(array, start, left-2);
			quickSort(array, left, end);
			changesMade = true;
			
		}else {
			//Move the pivot and call recursively
			int temp = array[pivot];
			array[pivot] = array[left];
			array[left] = temp;
			quickSort(array, start, left-1);
			quickSort(array, left+1, end);
			changesMade = true;
		}
		
		
	}
	
	/**This method calculate and print the time execution of a method
	 * 
	 * @param startNano represents the start nano time
	 * @param endNano  represents the end nano time
	 * @param startMilli represents the start milli time
	 * @param endMilli  represents the end milli time
	 */
	public void timeExecution(long startNano, long endNano, long startMilli, long endMilli) {
		
		long nano = endNano - startNano;
		long milli = endMilli - startMilli;
		
        System.out.println("\n\nTime taken in nanoseconds: "+ nano +"ns");
        System.out.println("Time taken in milliseconds: " + milli + "ms\n");
   

	}
	
	/**This method prints Big O complexity
	 * 
	 * @param rec represents the boolean if the user uses a recursive or not
	 * @return Strings
	 */
	public String toString(boolean rec) {
		if(rec == true) 
			System.out.print("\nRecursive Divide-And-Conquer  - O(n log n) Complexity");
		else
			System.out.print("\nSimple sorting algorithm  - O(n2) Complexity");
		return "";
			
	}
	
	
}
