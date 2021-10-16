package com.aasutosh.crud.student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.aasutosh.db.ConnectionManager;

public class StudentUpdate {
	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;
		ResultSet cursor = null;

		try (Scanner in = new Scanner(System.in)) {
			
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			
			String input = "y";
			while (input.equals("y")) {
				
				StudentSelect.showData();
				
				System.out.print("Enter student id :");
				String id=in.nextLine();
				
				System.out.print("What do you want to update name(n) or age(a) : ");
				
				String field = in.nextLine().equals("n")?"student_name":"age";
				
				System.out.print("Enter new  "+field+ " :");
				String value = in.nextLine();

				String sqlQuery = "update student set "+field+" ='"+value+"' where student_id="+id;
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
