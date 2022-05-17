
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * CollegeSystem<br>
 * CollegeSystem Class Represents the College System that operates the addition of student
 * 
 * 
 * @author Prince Adrianne Felix
 * @since 2021-04-15 CST8130 Data Structures
 * @version 1.0
 * 
 */
public class CollegeSystem{
	

	private Student[] student;
	private String name;
	private static int count = 0;
	
	CollegeSystem(){
		student = new Student[20];
	}
	
	public void addStudent(Scanner sc) {
		
		student[count] = new Student();
		student[count].readInfo(sc);
		count++;
		
		System.out.println();
	
	}
	
	public String setCollegeName(Scanner sc) {
		try {
			System.out.print("Please Enter the College System's Name: ");
			sc.nextLine();
			name = sc.nextLine();
		}catch(InputMismatchException ime) {
			System.err.flush();
			System.err.println("\nIncorrect format\n");
			System.err.flush();
			sc.next();
		}catch(Exception e) {
			System.err.flush();
			System.err.println("\nIncorrect format\n");
			System.err.flush();
			sc.next();
		}
		
		System.out.println();
		
		return name;
		
		
		
	}
	
	public void printStudent() {

		
		if(name == null)
			name = "Unknown";
		System.out.println("College System Information:\nName: " + name);
		if(count == 0)
			System.out.println("No Students in College System\n");
	

		for(int i = 0; i < count; i++) {
			student[i].printInfo();
			System.out.println();
			
		}
		
		System.out.println();
		
	}
	
	public void searchStudent(Scanner sc) {
		int tempSNumber = 0;
		System.out.print("Please Enter the Student Number to Search for: ");
		tempSNumber = sc.nextInt();
		
		for(int i = 0; i < count; i++) {
			if(tempSNumber == student[i].studentNumber) {
				System.out.println("Student found at index " + i);
				student[i].printInfo();
			}else {
				System.out.println("Student not found in College System");
				return;
			}
		}
		System.out.println();
	}

	


}
