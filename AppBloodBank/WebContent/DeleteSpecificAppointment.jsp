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
<script type="text/JavaScript"> 
<%
String ErrorMsg =(String)session.getAttribute("errors");
	if (ErrorMsg ==null)
		ErrorMsg="";
%>
</script>
<%String userIDs = String.valueOf(session.getAttribute("userID")); %>
<body>
<center>
<form name="input" method="post" action="./DeleteAppointmentUser">
<h1><em><font color="#b30707" size="8"> Welcome to ICBlood Bank </font></em></h1>
<div align="center">
<caption><h2><font color="#b30707">Confirmation of User's Appointment</font></h2></caption>
<%
	int userID =Integer.parseInt(userIDs);
	boolean validationAppointment = true; 
	String firstname;
	String lastname;
	String gender;
	Date dob;
	String phone;
	String email;
	int location_id;
	int app_date_time_id;
	Date date;
	Time time;
	int appointment_id;
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
	String query = "SELECT * FROM appointment WHERE user_id ="+userID+"";
	ResultSet rs = stm.executeQuery(query);
	validationAppointment = rs.next();
	if(validationAppointment)
	{
	app_date_time_id = rs.getInt("app_date_time_id");
	location_id = rs.getInt("location_id");
	appointment_id = rs.getInt("appointment_id");
	Statement stm1 = con.createStatement();
	String query1 = "SELECT * FROM users WHERE user_id ="+userID+"";
	ResultSet rs1 = stm1.executeQuery(query1);
	rs1.next();
	firstname = rs1.getString("firstname");
	lastname = rs1.getString("lastname");
	gender = rs1.getString("gender");
	dob = rs1.getDate("dob");
	phone = rs1.getString("phone_number");
	email=rs1.getString("email");
	Statement stm2 = con.createStatement();
	String query2 = "SELECT * FROM appointment_date_time WHERE app_date_time_id ="+app_date_time_id+"";
	ResultSet rs2 = stm2.executeQuery(query2);
	rs2.next();
	date = rs2.getDate("date");
	time = rs2.getTime("time");

%>
<table>
<tr>
<td colspan="2" align="center"> <h1><em><font color="white"> <%=ErrorMsg%> </font></em></h1>
</td>
</tr>
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
</table>
<table border="1"cellpadding="5">
<tr><td colspan="11" align="center">
<input type="submit" value="Confirm User's Appointment">
</td></tr>
</table>
<%
rs.close();
rs1.close();
rs2.close();
stm.close();
stm1.close();
stm2.close();
con.close();
	}
	
	else{
%>
<caption><h2><font color="#b30707">The user does not have any appointment booked. </font></h2></caption>
<%
rs.close();
stm.close();
con.close();
	}
%>
<table border="1"cellpadding="5">
<tr><td colspan="11" align="center">
<a style="color:#b30707;" href="MenuAdmin.jsp">Menu</a>
</td></tr>
</table>
</div>
</form>
</center>
</body>
</html>