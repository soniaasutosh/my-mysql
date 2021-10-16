package com.aasutosh.crud.enrollstudent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.aasutosh.db.ConnectionManager;

public class EnrollStudentSelect {
	public static void main(String[] args) {
		showData();
	}

	public static void showData() {
		Connection con = null;
		Statement stmt = null;
		ResultSet cursor = null;
		System.out.println("**********************************Student Enrollments****************************************************");
		try {
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			String query =    " SELECT "  
							+ " s.student_id," 
							+ " s.student_name," 
							+ " c.class_name," 
							+ " a.city," 
							+ " a.mobile_number,"
							+ " ifnull(sh.status,'inactive') as hostel_status,"
							+ " sh.start_date as hostel_start_date,"
							+ " sh.end_date as hostel_end_date"
							+ " FROM student s" 
							+ " left join address a using(student_id)" 
							+ " left join student_classes sc using(student_id)" 
							+ " left join classes c using(class_id) "
							+ " left join student_hostel sh using(student_id)";   
			cursor = stmt.executeQuery(query);
			while (cursor.next()) {
				StringBuffer line=new StringBuffer();
				
				line.append("Id :"+cursor.getInt("student_id"));
				line.append("\t");
				line.append("Name :"+cursor.getString("student_name"));
				line.append("\t");
				line.append("Class :"+cursor.getString("class_name"));
				line.append("\t");
				line.append("City :"+cursor.getString("city"));
				line.append("\t");
				line.append("Mob :"+cursor.getString("mobile_number"));
				line.append("\t");
				line.append("Hostel Status :"+cursor.getString("hostel_status"));
				line.append("\t");
				line.append("Hostel Status :"+cursor.getString("hostel_start_date"));
				line.append("\t");
				line.append("Hostel Status :"+cursor.getString("hostel_end_date"));
				
				System.out.println(line);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.cleanup(con, stmt, cursor);
		}
	}
}
