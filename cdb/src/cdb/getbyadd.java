package cdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class getbyadd {
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
		System.out.println("enter table name");
		String sql="select *from "+sc.next()+" where id=?";
		pmst = conn.prepareStatement(sql);
		System.out.println("enter id");
		pmst.setInt(1, sc.nextInt());
		ResultSet rs=pmst.executeQuery();
		while(rs.next())
		{
			System.out.println("id: "+rs.getInt("id"));
			System.out.println("name: "+rs.getString("name"));
			System.out.println("address: "+rs.getString("address"));
		}
		pmst.close();
		conn.close();
		sc.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
