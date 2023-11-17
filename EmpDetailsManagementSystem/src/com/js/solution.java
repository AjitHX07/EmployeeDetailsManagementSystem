package com.js;

import java.util.Scanner;

import com.exception.invalidChoiceExecption;

public class solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		EmployeeDataBase e = new EmpDataBaseImplimentation();

		while (true) {

			System.out.println("________welcome-to-emplyeeDB________");
			System.out.println("Press 1: AddEmployee");
			System.out.println("Press 2: DisplayEmployee");
			System.out.println("Press 3: DisplayAllEmployee");
			System.out.println("Press 4: RemoveEmployee");
			System.out.println("Press 5: UpdateEmployee");
			System.out.println("Press 6: countEmployee");
			System.out.println("Press 7: GEtEmployeewithHeightSalary");
			System.out.println("Press 8: GEtEmployeewithLowestSalary");
			System.out.println("Press 9: RemoveAllEmployee");
			System.out.println("Press 10: Exit");
			System.out.println();
			System.out.println("Enter your choice");

			System.out.println();
			

			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				e.AddEmployee();

				break;
			case 2:
				e.DisplayEmployee();

				break;
			case 3:
				e.DisplayAllEmployee();
				;

				break;
			case 4:
				e.RemoveEmployee();

				break;
			case 5:
				e.UpdateEmployee();

				break;
			case 6:
				e.CountEmployee();
				;

				break;
			case 7:
				e.GetEmployeeWithHighestSalry();

				break;
			case 8:
				e.GetEmployeeWithLowestSalry();

				break;
			case 9:
				e.RemoveOfAllEmployee();

				break;
			case 10:
				System.out.println("thank you");
				System.exit(0);
				break;

			default:
				try {
					throw new invalidChoiceExecption("Invalid choice");

				} catch (Exception e2) {
					System.err.println(e2.getMessage());
				}
			}

		}

	}

}
