package com.js;

import java.security.DrbgParameters.NextBytes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.exception.EmployeeNotFoundException;

public class EmpDataBaseImplimentation implements EmployeeDataBase {
	Scanner sc = new Scanner(System.in);

	@Override
	public void AddEmployee() {
		System.out.println("enter the employee slno");
		int slno = sc.nextInt();
		System.out.println("enter the employee name");
		String name = sc.next();
		System.out.println("enter the employee age");
		int age = sc.nextInt();
		System.out.println("enter the employee salary");
		double salary = sc.nextDouble();
		System.out.println("enter the employee disignation");
		String disignation = sc.next();

		Employee employee = new Employee(slno, name, age, salary, disignation);
		String id = employee.getId();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase", "root",
					"root");
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into employee values(?,?,?,?,?,?)");
			preparedStatement.setInt(1, slno);
			preparedStatement.setString(2, id);
			preparedStatement.setString(3, name);
			preparedStatement.setInt(4, age);
			preparedStatement.setDouble(5, salary);
			preparedStatement.setString(6, disignation);

			preparedStatement.execute();

			System.out.println("data is entered");
			System.out.println();
			System.out.println();
			preparedStatement.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override

	public void DisplayEmployee() {
		System.out.println("enter id : ");
		String id = sc.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase", "root",
					"root");
			PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where id=?");
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				System.out.println("the emp slno is -> " + resultSet.getInt(1));
				System.out.println("the emp id is -> " + resultSet.getString(2));
				System.out.println("the emp name is -> " + resultSet.getString(3));
				System.out.println("the emp age is -> " + resultSet.getInt(4));
				System.out.println("the emp salary is -> " + resultSet.getDouble(5));
				System.out.println("the emp designation is -> " + resultSet.getString(6));
			
				System.out.println();
				System.out.println();
			} else {
				try {
					throw new EmployeeNotFoundException("EmployeeNotPresent");
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
			preparedStatement.close();
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

	}

	@Override
	public void DisplayAllEmployee() {

		System.out.println("enter the id: ");

		String id = sc.next();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase", "root",
					"root");
			PreparedStatement preparedStatement = connection.prepareStatement("select * from employee");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				System.out.println("emp slno -> " + resultSet.getInt(1));
				System.out.println("emp id -> " + resultSet.getString(2));
				System.out.println("emp name -> " + resultSet.getString(3));
				System.out.println("emp age -> " + resultSet.getInt(4));
				System.out.println("emp salary -> " + resultSet.getDouble(5));
				System.out.println("emp designation -> " + resultSet.getString(6));

				System.out.println();
				System.out.println();
			
			}
			preparedStatement.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void RemoveEmployee() {
		System.out.println("enter remove id: ");
		String id = sc.next();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase", "root",
					"root");

			PreparedStatement preparedStatement = connection.prepareStatement("delete from employee where id=?");
			preparedStatement.setString(1, id);
			preparedStatement.execute();
			preparedStatement.close();

			System.out.println("deleted");
			System.out.println();
			System.out.println();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void UpdateEmployee() {
		System.out.println("Enter the Employee id: ");
		String eid = sc.next();

		System.out.println("A : update age");
		System.out.println("B : update name");
		System.out.println("C : update salary");

		char choice = sc.next().charAt(0);

		switch (choice) {
		case 'a': {

			System.out.println("enter new age: ");
			int newAge = sc.nextInt();

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase",
						"root", "root");
				PreparedStatement preparedStatement = connection
						.prepareStatement("update employee set age=? where id=? ");
				preparedStatement.setInt(1, newAge);
				preparedStatement.setString(2, eid);
				preparedStatement.executeUpdate();
				System.out.println("age updated ");
				preparedStatement.close();
				System.out.println();
				System.out.println();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
			break;

		case 'b': {

			System.out.println("new name");
			String newName = sc.next();

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase",
						"root", "root");
				PreparedStatement preparedStatement = connection
						.prepareStatement("update employee set name=? where id=? ");
				preparedStatement.setString(1, newName);
				preparedStatement.setString(2, eid);
				preparedStatement.executeUpdate();
				System.out.println("name updated ");
				preparedStatement.close();
				System.out.println();
				System.out.println();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
			break;
		case 'c': {

			System.out.println("new salary");
			String newSalary = sc.next();

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase",
						"root", "root");
				PreparedStatement preparedStatement = connection
						.prepareStatement("update employee set salary=? where id=? ");
				preparedStatement.setString(1, newSalary);
				preparedStatement.setString(2, eid);
				preparedStatement.executeUpdate();
				System.out.println("salary updated ");
				preparedStatement.close();
				System.out.println();
				System.out.println();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
			break;

		default: {
			System.err.println("invalid data error");
		}

		}

	}

	@Override
	public void CountEmployee() {
		System.out.println("count of all employee");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase", "root",
					"root");
			PreparedStatement preparedStatement = connection.prepareStatement("select count(*) from employee");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
			}
			System.out.println();
			System.out.println();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void GetEmployeeWithHighestSalry() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase", "root",
					"root");
			PreparedStatement preparedStatement = connection.prepareStatement("select max(salary) from employee");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				System.out.println("the max salary " + resultSet.getDouble(1));

			}
			System.out.println();
			System.out.println();
			preparedStatement.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void GetEmployeeWithLowestSalry() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase", "root",
					"root");
			PreparedStatement preparedStatement = connection.prepareStatement("select min(salary) from employee");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				System.out.println("minimum salary" + resultSet.getDouble(1));
			}
			preparedStatement.close();
			System.out.println();
			System.out.println();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void RemoveOfAllEmployee() {

		System.out.println("removing all employee");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase", "root",
					"root");
			PreparedStatement preparedStatement = connection.prepareStatement("truncate table employee ");
			preparedStatement.execute();
			preparedStatement.close();
			System.out.println();
			System.out.println();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
