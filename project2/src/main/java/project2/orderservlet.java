package project2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/order")
public class orderservlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String product=req.getParameter("product");
		
		
		try {
			PrintWriter pw=res.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/swiggy","root","root");
			String sql="insert into orders(name,email,product) values(?,?,?)";
			PreparedStatement pmst=con.prepareStatement(sql);
			pmst.setString(1, name);
			pmst.setString(2, email);
			pmst.setString(3, product);
			int i=pmst.executeUpdate();
			if(i > 0)
			{
				pw.println("ordered successfully");
			}
			else
			{
				pw.println("error");
			}
			pmst.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
