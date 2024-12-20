package project2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class updateservlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("username");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/swiggy","root","root");
			String sql="update login set name=?, email=?, password=? where id=2 ";
			PreparedStatement pmst=con.prepareStatement(sql);
			pmst.setString(1, name);
			pmst.setString(2, email);
			pmst.setString(3, password);
			int i=pmst.executeUpdate();
			if(i > 0)
			{
				resp.sendRedirect("welcome.jsp");
			}
			else
			{
				resp.sendRedirect("updateservlet.java");
			}
			con.close();
			pmst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
