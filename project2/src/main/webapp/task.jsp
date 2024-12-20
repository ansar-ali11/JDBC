<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>email</th>
				<th>password</th>
			</tr>
		</thead>
		<tbody>
			<%
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swiggy", "root", "root");
				String sql = "select *from login where name=? and email=? ";
				PreparedStatement pmst = con.prepareStatement(sql);
				pmst.setString(1, name);
				pmst.setString(2, email);
				ResultSet rs = pmst.executeQuery();
				while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getInt("id")%></td>
				<td><%=rs.getString("name")%></td>
				<td><%=rs.getString("email")%></td>
				<td><%=rs.getString("password")%></td>
			</tr>
			<%
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
			%>
		</tbody>
	</table>
	<form action="" method="get">
		<input type="text" name="name" placeholder="enter name"> <input
			type="email" name="email" placeholder="enter email">
		<button type="submit">submit</button>
	</form>
</body>
</html>