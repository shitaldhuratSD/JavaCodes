package com.testyantra.dev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;



public class JDBCInsertion {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			//load the Driver.
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded...");
			
			// Get connection via Driver
			String dbUrl = "jdbc:mysql://localhost:3306/"+"ty_db"; 
			System.out.println("Enter the Username and Password");
			String user = sc.nextLine();
			String password = sc.nextLine();
			con = DriverManager.getConnection(dbUrl,user,password);
			System.out.println("Connection Establish..");
			System.out.println("*********************");
			
			//Issue the SQL Query
			String query = "INSERT INTO users_info2 values(?,?,?,?)";
			pstmt= con.prepareStatement(query);
			
			System.out.println("Enter the User Name...");
			pstmt.setString(1, sc.nextLine());
			
			System.out.println("Enter the User Id..");
			pstmt.setInt(2, Integer.parseInt(sc.nextLine()));
			
			System.out.println("Enter the user Email...");
			pstmt.setString(3, sc.nextLine());
			
			System.out.println("Enter the user Passwoed...");
			pstmt.setString(4, sc.nextLine());
			
			int count = pstmt.executeUpdate();
			
			//Process the Results
			if(count > 0) {
				System.out.println("Query ok, "+count+" row affected");
			}else {
				System.out.println("Something Went Wrong");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {				// Close all the JDBC objects
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(pstmt!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			sc.close();
		}

	}

}
