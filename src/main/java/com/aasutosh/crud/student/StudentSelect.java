package com.aasutosh.crud.student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.aasutosh.db.ConnectionManager;
import com.aasutosh.pojo.Student;

public class StudentSelect {

	public static void main(String[] args) {
		showData();
	}

	public static void showData(){
		Connection con = null;
		Statement stmt = null;
		ResultSet cursor = null;
        System.out.println("**********************************Student Records****************************************************");
		try {
			con = ConnectionManager.getConnection();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String query = "select * from student";
			cursor = stmt.executeQuery(query);
			int rowCount = cursor.last() ? cursor.getRow() : 0;
			Student[] studentArr=new Student[rowCount];
			
			if(rowCount>0) {
				cursor.beforeFirst();
			}
			int index=0;
			while (cursor.next()) {
				
				studentArr[index++]=new Student()
									.setStudentId(cursor.getInt("student_id"))
									.setStudentName(cursor.getString("student_name"));
				
				String line = String.format("ID: %d \t Name : %s \t\t Age:%d", cursor.getInt("student_id"),
						cursor.getString("student_name"), cursor.getInt("age"));
				System.out.println(line);
				
			}
			
			
			System.out.println("**********************************Print Again Student Records****************************************************");
			for (int i = 0; i < studentArr.length; i++) {
				System.out.println(studentArr[i]);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.cleanup(con, stmt, cursor);
		}
	}

}
