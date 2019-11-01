package com.testyantra.dev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCUpdation {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;

		//load the driver
		try {
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

			//Issue SQL Query

			String query = "UPDATE users_info2 SET email = ? Where userid = ? AND password = ?";

			pstmt = con.prepareStatement(query);

			System.out.println("Enter the new Email Id...");
			pstmt.setString(1, sc.nextLine());

			System.out.println("Enter user Id...");
			pstmt.setInt(2, Integer.parseInt(sc.nextLine()));

			System.out.println("Enter the password...");
			pstmt.setString(3, sc.nextLine());

			int count = pstmt.executeUpdate();

			if(count > 0) {
				System.out.println("Query ok, "+count+" row affected");
			}else {
				System.out.println("Something Went Wrong");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}finally {
			if(con!=null) {
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		sc.close();

	}
}
