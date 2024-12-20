package project2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/get")
public class getservlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id")); 
	
	try {
		PrintWriter pw=resp.getWriter();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/swiggy","root","root");
		String sql="select *from login where id=?";
		PreparedStatement pmst=con.prepareStatement(sql);
		pmst.setInt(1, id);
		ResultSet rs=pmst.executeQuery();
		while (rs.next()) {
			pw.println(" name :"+rs.getString("name"));
			pw.println(" email :"+rs.getString("email"));
			pw.println(" password :"+rs.getString("password"));
		}
		con.close();
		pmst.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
