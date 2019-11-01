package com.testyantra.dev.dob;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.dev.bean.User;

public class UserDAOJDBCImpl implements UserInfoDAO {

	public UserDAOJDBCImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static final String DBURL="jdbc:mysql://localhost:3306/ty_db"
			+ "?user=root&password=";
	
	Scanner sc = new Scanner(System.in);
	
	@Override
	public User getAllInfo() {
		String query = "SELECT * FROM users_info2";
		User u = new User();
		try(Connection conn=DriverManager.getConnection(DBURL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query)){
			while(rs.next()) {
				u.setUserid(rs.getInt("userid"));
				u.setUsername(rs.getString("username"));
				u.setEmail(rs.getString("email"));
				System.out.println(u);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	@Override
	public void createProfile(User user) {
		String query = "Insert into users_info2"
				+ " values(?,?,?,?)";
		try(Connection conn = DriverManager.getConnection(DBURL);
				PreparedStatement pstmt = conn.prepareStatement(query)){
				pstmt.setInt(2, user.getUserid());
				pstmt.setString(1, user.getUsername());
				pstmt.setString(3, user.getEmail());
				pstmt.setString(4, user.getPasswd());
			int i = pstmt.executeUpdate();
			
			if(i>0) {
				System.out.println("Profile Created....");
			}else {
				System.out.println("Failed to Create Profile....");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
