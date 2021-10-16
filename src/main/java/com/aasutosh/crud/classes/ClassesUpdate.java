package com.aasutosh.crud.classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.aasutosh.db.ConnectionManager;

public class ClassesUpdate {
	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;
		ResultSet cursor = null;

		try (Scanner in = new Scanner(System.in)) {
			
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			
			String input = "y";
			while (input.equals("y")) {
				
				ClassesSelect.showData();
				
				System.out.print("Enter class id :");
				String id=in.nextLine();
				
				
				
				
				
				System.out.print("Enter new class name:");
				String value = in.nextLine();

				String sqlQuery = "update classes  set class_name ='"+value+"' where class_id="+id;
				System.out.println("query executing : "+sqlQuery);
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
