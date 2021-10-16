package com.aasutosh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
    private static final String URL = "jdbc:mysql://localhost:3306/collage";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "test";


//	static {
//    	try {
//			//Class.forName("com.mysql.jdbc.Driver");
//    		//Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}  
//    }
    
    
    public static Connection getConnection() throws SQLException {
    	
    	Connection con=DriverManager.getConnection(URL,USERNAME,PASSWORD);  
    	
    	return con;
    }


	public static void cleanup(Connection con, Statement stmt, ResultSet cursor) {
		if(cursor != null) {
			try {
				cursor.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
