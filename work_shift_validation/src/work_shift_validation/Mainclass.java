package work_shift_validation;

import java.io.IOException;
import java.util.Scanner;

public class Mainclass {

	public static void main(String[] args) {
		Workshift shift = new Workshift();
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("\n*** WORKSHIFT VALIDATOR ***\n1) Validate a workshift\n" +
					"0) End");
			System.out.print("Your choice: ");
			int selector = sc.nextInt();
			
			switch (selector) {
				case 1:
					shift.setDate();
					break;
				case 0:
					System.out.println("Thank you for using the software");
					break;
				default:
					System.out.println("Invalid input");
					break;
				}
			
			if (selector == 0) {
				break;
			}
			
		}	
		
	}

}
