package linkedlists;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab5Test {

	public static void main(String[] args) {
		
		/**
		 * Represents the Scanner object
		 */
		Scanner sc = new Scanner(System.in);
		
		/**
		 * Represents loop condition
		 */
		int loop = 1;
		
		/**
		 * Represents the expression to be checked 
		 */
		String expression;
		
		/**
		 * Represents the user Full Name
		 */
		String userName;
		
		/**
		 * Represents the linkedLists class object
		 */
		linkedLists ll = new linkedLists();
		
		System.out.print("Enter your Full Name: ");
		userName = sc.nextLine();
		
		//Do this block until the user decided to exit
		do {
			//Try catch block, to catch any possible error
			try {
				System.out.println();
				
				//Ask the user the expression they want to check
				System.out.print("Enter an expression (or exit to terminate): ");
				expression = sc.nextLine().trim().replaceAll("\t", ""); //Captures tab and white space scanner input errors
				
				//If the input is "exit", we terminate the program
				if(expression.equalsIgnoreCase("Exit")) {
					System.out.println("\nTerminating...");
					loop = 0;
				}else if(ll.isBalanced(expression) && ll.check == false) { //if the isBalanced is false and check is also false, then no braces are found
					System.err.println("No braces are found in the string... Please try again");
					//clear the Character list
					ll.cha.clear();
				}else {
					//if isBalance is true, then the expression is balanced
					if(ll.isBalanced(expression))
						System.out.println("The expression is balanced");
					else { //Else it's not balanced
						System.out.println("The expression is NOT balanced");
					}
					//clear the Character list
					ll.cha.clear();
				}
			}catch(InputMismatchException ime) { //Catch any Input Mismatch Exception
				System.out.flush();
				System.out.println("Input Mismatch Exception While Reading the Expression");
				System.out.flush();
				sc.next();
			}catch(Exception e) { //Catch any General Exception
				System.out.flush();
				System.out.println("Exception While Reading the Expression");
				System.out.flush();
				sc.next();
			}
		}while(loop == 1);
		
		//Close the scanner
		sc.close();
	}
}
