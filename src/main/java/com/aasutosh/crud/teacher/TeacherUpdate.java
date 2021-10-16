package com.aasutosh.crud.teacher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.aasutosh.db.ConnectionManager;

public class TeacherUpdate {
	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;
		ResultSet cursor = null;

		try (Scanner in = new Scanner(System.in)) {

			con = ConnectionManager.getConnection();
			stmt = con.createStatement();

			String input = "y";
			while (input.equals("y")) {

				TeacherSelect.showData();
				System.out.print("Enter teacher id :");
				String id = in.nextLine();

				 

				String field = "teacher_name";

				System.out.print("Enter teacher name :");
				String value = in.nextLine();

				String sqlQuery = "update teacher set " + field + " ='" + value + "' where teacher_id=" + id;
				System.out.println("query executing : " + sqlQuery);
				stmt.execute(sqlQuery);

				System.out.print("Do you want to update more (y/n) : ");
				input = in.nextLine();

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.cleanup(con, stmt, cursor);
		}

	}

 
}
