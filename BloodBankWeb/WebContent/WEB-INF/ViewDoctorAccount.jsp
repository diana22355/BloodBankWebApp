<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
<title> ICBlood Bank </title>
</head>
<%@ page import="bloodbank.*" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.DriverManager" %>
<body>
<center>
<h1><em><font color="#b30707" size="8"> Welcome to ICBlood Bank </font></em></h1>
<div align="center">
<caption><h2><font color="#b30707">Existing Doctor Accounts</font></h2></caption>
<%
	String certificate_id="";
	String firstname="";
	String lastname="";
	String gender="";
	String phone="";
	int hospital_id;
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String connectionUrl = "jdbc:sqlserver://bloodbanksqlserver.database.windows.net:1433;database=BloodBankDatabase;user=capstoneserver@bloodbanksqlserver;password={C@pstoneS3rver};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
	try 
	{
		Class.forName(driver);
	}
	catch(ClassNotFoundException e)
	{
		System.out.println(e.getMessage());
	}
	Connection con = DriverManager.getConnection(connectionUrl); 
	Statement stm = con.createStatement();
	String query = "SELECT * FROM doctor";
	ResultSet rs = stm.executeQuery(query);
%>
<table border="1"cellpadding="5">
<tr>
<th>Certificate ID</th>
<th>Firstname</th>
<th>Lastname</th>
<th>Gender</th>
<th>Phone Number</th>
<th>Hospital ID</th>
</tr>
<%
	while(rs.next())
	{
		certificate_id = rs.getString("certificate_id");
		firstname = rs.getString("firstname_d");
		lastname = rs.getString("lastname_d");
		gender = rs.getString("gender");
		phone = rs.getString("phone_d");
		gender = rs.getString("gender");
		hospital_id = rs.getInt("hospital_id");
%>
<tr>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "certificate_id" value="<%= certificate_id %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "firstname" value="<%= firstname %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "lastname" value="<%= lastname %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "gender" value="<%= gender %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "phone" value="<%= phone %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "hospital_id" value="<%= hospital_id %>">
</td>
</tr>
<% } %>
</table>
<table border="1"cellpadding="5">
<tr><td align="center">
<a style="color:#b30707;" href="MenuAdmin.jsp">Menu</a>
</td></tr>
</table>
</center>
</body>
</html>