import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Lab301Test<br>
 * Lab301Test class, Main class that calls a function from college system class
 * 
 * 
 * @author Prince Adrianne Felix
 * @since 2021-04-15 CST8130 Data Structures
 * @version 1.0
 * 
 */
public class Lab301Test {
	
	public static void menu() {
		System.out.print("Please select one of the following:\n1. Add Student to College System\n"
				+ "2. Display Students in the System \n"
				+ "3. Set College System Name\n"
				+ "4. Search for a Student\n"
				+ "5. Exit\n>");
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int userInput;
		CollegeSystem c = new CollegeSystem();
		
		do {
			try {
				menu();
				userInput = sc.nextInt();
				
				switch(userInput) {
				case 1:
					c.addStudent(sc);
					break;
				case 2:
					c.printStudent();
					break;
				case 3:
					c.setCollegeName(sc);
					break;
				case 4:
					c.searchStudent(sc);
					break;
				case 5:
					System.out.println("Exiting...");
					return;
				default:
					System.out.println("Unsupported choice\n");
				}
			}catch(InputMismatchException ime) {
				System.err.flush();
				System.err.println("\nYour choice is invalid\n");
				System.err.flush();
				sc.next();
			}catch(Exception e) {
				System.err.flush();
				System.err.println("\nYour choice is invalid\n");
				System.err.flush();
				sc.next();
			}
			
		}while(true);

	}

}
