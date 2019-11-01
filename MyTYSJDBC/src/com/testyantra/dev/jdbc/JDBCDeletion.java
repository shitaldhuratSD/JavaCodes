package com.testyantra.dev.jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class JDBCDeletion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;

		//load the driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded...");

			// Get connection via Driver
			String dbUrl = "jdbc:mysql://localhost:3306/ty_db"; 
			String filePath = "D:\\db.properties";
			
			FileReader reader = new FileReader(filePath);
			
			Properties prop = new Properties();
			prop.load(reader);
			
			con = DriverManager.getConnection(dbUrl,prop);
			System.out.println("Connection Establish..");
			System.out.println("*********************");

			//Issue SQL Query
			String query = "DELETE FROM users_info2 WHERE userid = ?"+" AND password  = ?";
			
			pstmt = con.prepareStatement(query);
			System.out.println("Enter user Id for Deletion...");
			pstmt.setInt(1, Integer.parseInt(sc.nextLine()));
			
			System.out.println("Enter the password for deletion...");
			pstmt.setString(2, sc.nextLine());
			
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
