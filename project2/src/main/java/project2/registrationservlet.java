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
@WebServlet("/login")

public class registrationservlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name=req.getParameter("username");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		try {
			PrintWriter pw=res.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/swiggy","root","root");
			String sql="insert into login(name,email,password) values(?,?,?)";
			PreparedStatement pmst=con.prepareStatement(sql);
			pmst.setString(1, name);
			pmst.setString(2, email);
			pmst.setString(3, password);
			int i=pmst.executeUpdate();
			if(i > 0)
			{
				res.sendRedirect("welcome.jsp");
			}
			else
			{
				res.sendRedirect("registrationservlet.java");
			}
			pmst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
