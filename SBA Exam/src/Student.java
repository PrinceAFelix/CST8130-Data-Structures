import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Student<br>
 * Student class represents the students
 * 
 * 
 * @author Prince Adrianne Felix
 * @since 2021-04-15 CST8130 Data Structures
 * @version 1.0
 * 
 */
public class Student {
	protected int studentNumber;
	protected String studentName;
	protected float balance;
	
	
	Student(){}
	
	Student(int sn, String n, float b){
		this.studentNumber = sn;
		this.studentName = n;
		this.balance = b;
	}
	
	public String getName() {
		return studentName;
	}
	
	public void readInfo(Scanner sc) {
		try {
			System.out.print("Please Enter the Student's Name: ");
			sc.nextLine();
			studentName = sc.nextLine();
			System.out.print("Please Enter the Student Number: ");
			studentNumber = sc.nextInt();
			System.out.print("Please Enter the Student's Balance: ");
			String temp = sc.next();
			balance = Float.parseFloat(temp.substring(1));
		}catch(InputMismatchException ime) {
			System.err.flush();
			System.err.println("\nIncorrect format\n");
			System.err.flush();
			return;
		}catch(Exception e) {
			System.err.flush();
			System.err.println("\nIncorrect format\n");
			System.err.flush();
			return;
		}
		
	}
	
	public void printInfo() {
		System.out.printf("Student #: %d, Name: %s, Balance: $%.2f", studentNumber, studentName, balance);
	}
	

	
	
	
}


