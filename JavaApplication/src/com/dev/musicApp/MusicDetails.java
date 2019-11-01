package com.dev.musicApp;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class MusicDetails {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;
		Statement st = null;
		ResultSet rs = null;

		try {


			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded...");


			String dbUrl = "jdbc:mysql://localhost:3306/"+"MusicPlayer?user=root&password=";
			String filePath = "D:\\db.properties";

			FileReader reader = new FileReader(filePath);

			Properties prop = new Properties();
			prop.load(reader);

			con = DriverManager.getConnection(dbUrl,prop);
			System.out.println("Connection Establish..");
			System.out.println("*********************");

			System.out.println(" .. Music Files .. ");
			System.out.println();
			System.out.println("Press 1 to Play a Song");
			System.out.println("Press 2 to Search a Song");
			System.out.println("Press 3 to Show all Songs");
			System.out.println("Press 4 to Operate on Songs Database");
			System.out.println();

			System.out.println("Press any one option: ");
			int num = sc.nextInt();	

			switch (num) {
			case 1: 
				System.out.println(" Play a Song ");
				System.out.println(" ");
				System.out.println("Press 1 to Play all Songs ");
				System.out.println("Press 2 to Play Songs Randomly ");
				System.out.println("Press 3 to Play a Perticular Song");

				int num2;
				System.out.println(" Choose Options: ");
				num2 = sc.nextInt();

				if(num2 == 1) {
					System.out.println(" Play all songs ");

					String query = "select * from MusicFiles";
					st = con.createStatement();
					rs = st.executeQuery(query);    // executeQuery present in statement.

					while(rs.next()) {
						int Song_ID = rs.getInt("Song_ID");
						String Song_Title = rs.getString("Song_Title");
						String Artist_Namae = rs.getString("Artist_Namae");
						String Album_Name = rs.getString("Album_Name");
						String Song_Location = rs.getString("Song_Location");
						String Description = rs.getString("Description");

						System.out.println("Song_ID: "+Song_ID);
						System.out.println("Song_Title: "+Song_Title);
						System.out.println("Artist_Name: "+Artist_Namae);
						System.out.println("Album_Name: "+Album_Name);
						System.out.println("Song_Location: "+Song_Location);
						System.out.println("Song Description: "+Description);
						System.out.println("***************");
					}

				}
				else if(num2 == 2) {
					System.out.println(" Play Songs Randomly ");

					String query8 = "SELECT * FROM MusicFiles ORDER BY RAND() LIMIT 5";
					pstmt= con.prepareStatement(query8);


					rs = pstmt.executeQuery();

					while(rs.next()) {
						int Song_ID = rs.getInt("Song_ID");
						String Song_Title = rs.getString("Song_Title");


						System.out.print(Song_ID);
						System.out.println(" "+Song_Title);

					}


				}
				else if(num2 == 3) {
					System.out.println(" Play a Particular Song ");


					String query11 = "SELECT * FROM MusicFiles WHERE Song_Title = ? ";
					pstmt= con.prepareStatement(query11);

					sc.nextLine();
					System.out.println("Enter the Song Title...");
					pstmt.setString(1, sc.nextLine());

					rs = pstmt.executeQuery();

					while(rs.next()) {
						int Song_ID = rs.getInt("Song_ID");
						String Song_Title = rs.getString("Song_Title");


						System.out.print(Song_ID);
						System.out.println(" "+Song_Title);

					}
					//System.out.println(" Song Not Found..");

				}
				else {
					System.out.println(" Invalid Option.. ");
				}

				break;	
			case 2: 
				System.out.println(" Search a Song ");

				String query6 = "SELECT * FROM MusicFiles WHERE Song_Title = ? ";
				pstmt= con.prepareStatement(query6);

				sc.nextLine();
				System.out.println("Enter the Song Title...");
				pstmt.setString(1, sc.nextLine());

				rs = pstmt.executeQuery();

				while(rs.next()) {
					int Song_ID = rs.getInt("Song_ID");
					String Song_Title = rs.getString("Song_Title");
					String Artist_Namae = rs.getString("Artist_Namae");
					String Album_Name = rs.getString("Album_Name");
					String Song_Location = rs.getString("Song_Location");
					String Description = rs.getString("Description");

					System.out.println("Song_ID: "+Song_ID);
					System.out.println("Song_Title: "+Song_Title);
					System.out.println("Artist_Name: "+Artist_Namae);
					System.out.println("Album_Name: "+Album_Name);
					System.out.println("Song_Location: "+Song_Location);
					System.out.println("Song Description: "+Description);
					System.out.println("***************");

				}


				break;
			case 3: 
				System.out.println(" Show all Songs ");
				System.out.println(" ");

				String query = "select * from MusicFiles";
				st = con.createStatement();
				rs = st.executeQuery(query);    // executeQuery present in statement.

				while(rs.next()) {
					int Song_ID = rs.getInt("Song_ID");
					String Song_Title = rs.getString("Song_Title");

					System.out.print(Song_ID);
					System.out.println(" "+Song_Title);
				}

				break;

			case 4: 
				System.out.println(" Operate on Songs Database ");
				System.out.println();
				System.out.println("Press 1 to Add Song to Song Repository");
				System.out.println("Press 2 to Edit an existing Song info");
				System.out.println("Press 3 to Delete an existing Song info");
				System.out.println();

				int num3;
				System.out.println(" Choose Options: ");
				num3 = sc.nextInt();

				if(num3 == 1) {
					System.out.println(" Add Song ");

					String query2 = "INSERT INTO MusicFiles values(?,?,?,?,?,?)";
					pstmt= con.prepareStatement(query2);

					System.out.println("Enter the Song Id..");
					pstmt.setInt(1, sc.nextInt());

					sc.nextLine();
					System.out.println("Enter the Song Title...");
					pstmt.setString(2, sc.nextLine());

					System.out.println("Enter the Artist Name...");
					pstmt.setString(3, sc.nextLine());

					System.out.println("Enter the Album Name...");
					pstmt.setString(4, sc.nextLine());

					System.out.println("Enter the Song Location...");
					pstmt.setString(5, sc.nextLine());

					System.out.println("Enter the Song Description...");
					pstmt.setString(6, sc.nextLine());

					int count = pstmt.executeUpdate();

					if(count > 0) {
						System.out.println("Query ok, "+count+" row affected");
					}else {
						System.out.println("Something Went Wrong");
					}

				}
				else if(num3 == 2) {
					System.out.println(" Edit an existing Song ");

					String query3 = "UPDATE MusicFiles SET Artist_Namae = ? Where Song_ID = ?";

					pstmt = con.prepareStatement(query3);

					System.out.println("Enter Song Id...");
					pstmt.setInt(2, sc.nextInt());

					System.out.println("Enter the new Artist_Name...");
					pstmt.setString(1, sc.next());

					int count = pstmt.executeUpdate();

					if(count > 0) {
						System.out.println("Query ok, "+count+" row affected");
					}else {
						System.out.println("Something Went Wrong");
					}

				}


				else if(num3 == 3) {
					System.out.println(" Delete an Existing Song ");

					String query4 = "DELETE FROM MusicFiles WHERE Song_ID = ?";

					pstmt = con.prepareStatement(query4);
					System.out.println("Enter user Id for Deletion...");
					pstmt.setInt(1, Integer.parseInt(sc.next()));

					int count = pstmt.executeUpdate();

					if(count > 0) {
						System.out.println("Query ok, "+count+" row affected");
					}else {
						System.out.println("Something Went Wrong");
					}

				}
				else {
					System.out.println(" Invalid Option.. ");
				}

				break;

			default:
				System.out.println(" Number not found ");
				break;
			}



		} catch (Exception e) {

			e.printStackTrace();
		}finally {				
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

					e.printStackTrace();
				}
			}

			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if(st!=null) {
				try {
					st.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			sc.close();
		}


	}

}
