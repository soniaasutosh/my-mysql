package com.aasutosh.crud.teacher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.aasutosh.db.ConnectionManager;

public class TeacherSelect {

	public static void main(String[] args) {
		showData();
	}

	public static void showData() {
		Connection con = null;
		Statement stmt = null;
		ResultSet cursor = null;

		try {
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			String query = "select * from teacher";
			cursor = stmt.executeQuery(query);
			while (cursor.next()) {
				String line = String.format("ID: %d \t Name : %s", cursor.getInt("teacher_id"),
						cursor.getString("teacher_name"));
				System.out.println(line);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.cleanup(con, stmt, cursor);
		}
	}

}
