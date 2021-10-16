package com.aasutosh.crud.classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.aasutosh.db.ConnectionManager;

public class ClassesInsert {
	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;
		ResultSet cursor = null;

		try (Scanner in = new Scanner(System.in)) {
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();

			String input = "y";
			while (input.equals("y")) {
				System.out.print("Enter class name : ");
				String name = in.nextLine();
				
				String sqlQuery = "INSERT INTO `collage`.`classes`(`class_name`) " + "VALUES" + "('" + name
						+ "' )";
				System.out.println("query executing : "+sqlQuery);
				stmt.execute(sqlQuery);

				System.out.print("Do you want add more (y/n) : ");
				input = in.nextLine();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.cleanup(con, stmt, cursor);
		}

	}
}
