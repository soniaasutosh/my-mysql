package com.aasutosh.crud.enrollstudent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.aasutosh.crud.classes.ClassesSelect;
import com.aasutosh.crud.student.StudentSelect;
import com.aasutosh.db.ConnectionManager;

public class EnrollHostelInsert {
	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;
		ResultSet cursor = null;

		StudentSelect.showData();
		ClassesSelect.showData();
		EnrollStudentSelect.showData();

		try (Scanner in = new Scanner(System.in)) {
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();

			System.out.print("Do you want to enroll student with class (y/n) : ");
			String input = in.nextLine();

			while (input.equals("y")) {
				System.out.print("Enter Student Id : ");
				String studentId = in.nextLine();

				System.out.print("Enter Class Id : ");
				String classId = in.nextLine();

				String sqlQuery = "INSERT INTO student_classes(class_id, student_id) " + "VALUES" + "( " + classId + ","
						+ studentId + " )";
				System.out.println("query executing : " + sqlQuery);

				try {
					stmt.execute(sqlQuery);
				} catch (Exception e) {
					if(e.getMessage().contains("Duplicate entry")) {
						System.out.println("Already enrolled with  class id "+ classId);
					}
				}
				StudentSelect.showData();
				ClassesSelect.showData();
				EnrollStudentSelect.showData();

				System.out.print("Do you want to more enroll student with class (y/n) : ");
				input = in.nextLine();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.cleanup(con, stmt, cursor);
		}

	}
}
