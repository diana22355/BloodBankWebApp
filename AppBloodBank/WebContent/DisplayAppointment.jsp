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
<caption><h2><font color="#b30707">Existing Users's Appointments</font></h2></caption>
<%String loc = String.valueOf(session.getAttribute("loc")); %>
<%String locIDs = String.valueOf(session.getAttribute("locID")); %>
<%
	

	int locID =Integer.parseInt(locIDs);

	
	String firstname;
	String lastname;
	String gender;
	Date dob;
	String phone;
	String email;
	int userID;
	int location_id;
	int app_date_time_id;
	Date date;
	Time time;
	int appointment_id;
	
	if (loc.equalsIgnoreCase("all"))
	{
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
		String query = "SELECT * FROM appointment";
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(query);
%>
<table>
<tr>
<td colspan="11" align="center"><img src =bloodbankimages/usermenu.png> <br></td>
</tr>
</table>
<table border="1"cellpadding="5">
<tr>
<th>User's Appointment ID</th>
<th>User ID</th>
<th>User's Firstname</th>
<th>User's Lastname</th>
<th>User's Date of Birth</th>
<th>User's Gender</th>
<th>User's Phone Number</th>
<th>User's Email</th>
<th>Location ID for Appointment</th>
<th>Appointment Date</th>
<th>Appointment Time</th>
</tr>
<%
while(rs.next())
	{
		userID = rs.getInt("user_id");
		location_id = rs.getInt("location_id");
		app_date_time_id = rs.getInt("app_date_time_id");
		appointment_id = rs.getInt("appointment_id");
		Statement stm2 = con.createStatement();
		String query2 = "select l.date , l.time , a.appointment_id from appointment a inner join appointment_date_time l on l.app_date_time_id=a.app_date_time_id "+
				"where a.user_id="+userID+";";
		ResultSet rs2 = stm2.executeQuery(query2);
		rs2.next();
		date = rs2.getDate("date");
		time = rs2.getTime("time");
		Statement stm3 = con.createStatement();
		String query3 = "SELECT * FROM users WHERE user_id ="+userID+"";
		ResultSet rs3 = stm3.executeQuery(query3);
		rs3.next();
		firstname = rs3.getString("firstname");
		lastname = rs3.getString("lastname");
		gender = rs3.getString("gender");
		dob = rs3.getDate("dob");
		phone = rs3.getString("phone_number");
		email=rs3.getString("email");
%>
<tr>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "appointment_id" value="<%= appointment_id %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "userID" value="<%= userID %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "firstname" value="<%= firstname %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "lastname" value="<%= lastname %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "dob" value="<%= dob %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "gender" value="<%= gender %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "phone" value="<%= phone %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "email" value="<%= email %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "location_id" value="<%= location_id %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "date" value="<%= date %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "time" value="<%= time %>">
</td>
</tr>
<% 
rs2.close();
rs3.close();
stm2.close();
stm3.close();
} 
rs.close();
stm.close();
con.close();
	}
	else
	{
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
		String query = "SELECT * FROM appointment WHERE location_id ="+locID+"";
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(query);
%>
<table>
<tr>
<td colspan="11" align="center"><img src =bloodbankimages/usermenu.png> <br></td>
</tr>
</table>
<table border="1"cellpadding="5">
<tr>
<th>User's Appointment ID</th>
<th>User ID</th>
<th>User's Firstname</th>
<th>User's Lastname</th>
<th>User's Date of Birth</th>
<th>User's Gender</th>
<th>User's Phone Number</th>
<th>User's Email</th>
<th>Location ID for Appointment</th>
<th>Appointment Date</th>
<th>Appointment Time</th>
</tr>
<%
	while(rs.next())
	{
		userID = rs.getInt("user_id");
		location_id = rs.getInt("location_id");
		app_date_time_id = rs.getInt("app_date_time_id");
		Statement stm2 = con.createStatement();
		String query2 = "select l.date , l.time , a.appointment_id from appointment a inner join appointment_date_time l on l.app_date_time_id=a.app_date_time_id "+
				"where a.user_id="+userID+";";
		ResultSet rs2 = stm2.executeQuery(query2);
		rs2.next();
		date = rs2.getDate("date");
		time = rs2.getTime("time");
		appointment_id = rs2.getInt("appointment_id");
		Statement stm3 = con.createStatement();
		String query3 = "SELECT * FROM users WHERE user_id ="+userID+"";
		ResultSet rs3 = stm3.executeQuery(query3);
		rs3.next();
		firstname = rs3.getString("firstname");
		lastname = rs3.getString("lastname");
		gender = rs3.getString("gender");
		dob = rs3.getDate("dob");
		phone = rs3.getString("phone_number");
		email=rs3.getString("email");
		
%>
<tr>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "appointment_id" value="<%= appointment_id %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "userID" value="<%= userID %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "firstname" value="<%= firstname %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "lastname" value="<%= lastname %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "dob" value="<%= dob %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "gender" value="<%= gender %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "phone" value="<%= phone %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "email" value="<%= email %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "location_id" value="<%= location_id %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "date" value="<%= date %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "time" value="<%= time %>">
</td>
</tr>
<%
rs2.close();
rs3.close();
stm2.close();
stm3.close();
	}
rs.close();
stm.close();
con.close();
}
%>
</table>
<table border="1"cellpadding="5">
<tr><td colspan="11" align="center">
<a style="color:#b30707;" href="MenuAdmin.jsp">Menu</a>
</td></tr>
</table>
</center>
</body>
</html>