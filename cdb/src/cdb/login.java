package cdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class login {
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
			System.out.println("enter name");
			String name=sc.next();
			System.out.println("enter address");
			String address=sc.next();
			String sql="select *from collegedetails where name=? and address=?";
			pmst = conn.prepareStatement(sql);
			pmst.setString(1, name);
			pmst.setString(2, address);
			ResultSet rs=pmst.executeQuery();
			if(rs.next())
			{
				System.out.println("Successfully logined");
			}
			pmst.close();
			conn.close();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
