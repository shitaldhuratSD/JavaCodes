package com.testyantra.dev.jdbc;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;


public class MyFirstJDBC {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;	
		
		try {
			//Load the driver
			java.sql.Driver div = new Driver();
			DriverManager.registerDriver(div);
			System.out.println("Driver Loaded....");
			
			//Get connection via Driver
			String dbUrl = "jdbc:mysql://localhost:3306/"+"ty_db?user=root&password=";  //localhost:3306", "root",""
			
			conn=DriverManager.getConnection(dbUrl);
			System.out.println("Connection Estd....");
			System.out.println("***************");
			
			//Issue SQL query via Connection
			String query = "select * from Users_info2";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);    // executeQuery present in statement.
			
			//Process the results returned by SQL query
			while(rs.next()) {
				int userid = rs.getInt("userid");
				String username = rs.getString("username");
				String email = rs.getString("email");
				
				System.out.println("User Id: "+userid);
				System.out.println("User Name: "+username);
				System.out.println("User Email: "+email);
				System.out.println("***************");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {			// closing all objects by using close().
			if(conn!= null) {
				try {
					conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(stmt!=null) {
				try {
					stmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs!= null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
