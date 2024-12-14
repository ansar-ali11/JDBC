package cdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class insertion {
	private static final String Driver = "com.mysql.cj.jdbc.Driver";
	private static final String username = "root";
	private static final String password = "root";
	private static final String url = "jdbc:mysql://localhost:3306/college";
	private static  Connection conn;
	private static  PreparedStatement pmst;

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			String sql="insert into collegedetails(name,address) values(?,?)";
			pmst = conn.prepareStatement(sql);
			System.out.println("Enter name");
			pmst.setString(1, sc.next());
			System.out.println("enter address");
			pmst.setString(2, sc.next());
			int i = pmst.executeUpdate();
			if (i > 0) {
				System.out.println("data is inserted");
			} else {
				System.out.println("error");
			}
			pmst.close();
			conn.close();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
