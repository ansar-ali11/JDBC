package cdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class delete {
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
			String sql="delete from "+sc.next()+" where name=?";
			pmst = conn.prepareStatement(sql);
			System.out.println("enter name");
			pmst.setString(1, sc.next());
			int i = pmst.executeUpdate();
			if (i > 0) {
				System.out.println("data is deleted");
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