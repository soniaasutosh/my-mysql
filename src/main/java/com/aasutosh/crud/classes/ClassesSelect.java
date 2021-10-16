package com.aasutosh.crud.classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.aasutosh.db.ConnectionManager;

public class ClassesSelect {

	public static void main(String[] args) {
		showData();
	}

	public static void showData() {
		Connection con = null;
		Statement stmt = null;
		ResultSet cursor = null;
		System.out.println("**********************************Class Records****************************************************");
		try {
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			String query = "select * from classes";
			cursor = stmt.executeQuery(query);
			while (cursor.next()) {
				String line = String.format("ID: %d \t Name : %s", cursor.getInt("class_id"),
						cursor.getString("class_name"));
				System.out.println(line);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.cleanup(con, stmt, cursor);
		}
	}

}
