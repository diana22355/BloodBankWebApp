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


<%String status_r = String.valueOf(session.getAttribute("status")); %>

<body>
<center>
<form name="input" method="post" action="./ModifyRequest">
<h1><em><font color="#b30707" size="8"> Welcome to ICBlood Bank </font></em></h1>
<div align="center">
<caption><h2><font color="#b30707">Doctors' Requests per status</font></h2></caption>
<%
	
	int req_id;
	String req_status;
	Date req_date;
	Date donation_date;
	float req_liters;
	int blood_id;
	String cert_id;
	float liters_donated;
	String blood_type;
	String doctor_name;
	String doctor_lastname;
	String doctor_phone;
	String doctor_gender;
	String hospital_name;
	String hospital_address;
	String hospital_zip;
	String hospital_city;
	String hospital_province;
	String hospital_country;
	int hospital_id;
	int admin_id;
	String admin_name;
	String admin_lastname;
	String admin_phone;
	String admin_email;
	boolean validationRequest = true;

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
		String query = "SELECT * FROM request WHERE status_r ='"+status_r+"'";
		ResultSet rs = stm.executeQuery(query);
		validationRequest= rs.next();
		if(validationRequest)
		{
			Statement stm1 = con.createStatement();
			String query1 = "SELECT * FROM request WHERE status_r ='"+status_r+"'";
			ResultSet rs1 = stm1.executeQuery(query1);
		
%>
<table>
<tr>
<td colspan="24" align="center"><img src =bloodbankimages/usermenu.png> <br></td>
</tr>
</table>
<table border="1"cellpadding="5">
<tr>
<th>Request ID</th>
<th>Status</th>
<th>Request Date</th>
<th>Blood (Liters)</th>
<th>Blood Type</th>
<th>Date of Blood Donation</th>
<th>Doctor's Certificate ID</th>
<th>Doctor's Firstname</th>
<th>Doctor's Lastname</th>
<th>Doctor's Gender</th>
<th>Doctor's Phone Number</th>
<th>Doctor's Hospital ID</th>
<th>Doctor's Hospital Name</th>
<th>Doctor's Hospital Address</th>
<th>Doctor's Hospital Zip Code</th>
<th>Doctor's Hospital City</th>
<th>Doctor's Hospital Province</th>
<th>Doctor's Hospital Country</th>
<th>Administrator ID</th>
<th>Administrator's Firstname</th>
<th>Administrator's Lastname</th>
<th>Administrator's Phone Number</th>
<th>Administrator's Phone Email</th>
</tr>
<%
while(rs1.next())
	{
	req_id = rs1.getInt("request_id");
	req_status = rs1.getString("status_r");
	req_date = rs1.getDate("date_request");
	req_liters = rs1.getFloat("liters_r");
	blood_id = rs1.getInt("blood_id");
	cert_id = rs1.getString("certificate_id");
	
	Statement stm2 = con.createStatement();
	String query2 = "SELECT * FROM blood_type WHERE blood_id ="+blood_id+"";
	ResultSet rs2 = stm2.executeQuery(query2);
	rs2.next();
	liters_donated = rs2.getFloat("liters");
	blood_type = rs2.getString("blood_type");
	donation_date = rs2.getDate("date_donation");
	
	Statement stm3 = con.createStatement();
	String query3 = "SELECT * FROM doctor WHERE certificate_id ='"+cert_id+"'";
	ResultSet rs3 = stm3.executeQuery(query3);
	rs3.next();
	doctor_name = rs3.getString("firstname_d");
	doctor_lastname = rs3.getString("lastname_d");
	doctor_phone = rs3.getString("phone_d");
	doctor_gender = rs3.getString("gender");
	hospital_id = rs3.getInt("hospital_id");
	
	Statement stm4 = con.createStatement();
	String query4 = "SELECT * FROM hospital WHERE hospital_id ="+hospital_id+"";
	ResultSet rs4 = stm4.executeQuery(query4);
	rs4.next();
	hospital_name = rs4.getString("name_h");
	hospital_address = rs4.getString("address_h");
	hospital_zip = rs4.getString("zip_code_h");
	
	Statement stm5 = con.createStatement();
	String query5 = "SELECT * FROM zip_code_hospital WHERE zip_code_h ='"+hospital_zip+"'";
	ResultSet rs5 = stm5.executeQuery(query5);
	rs5.next();
	hospital_city = rs5.getString("city");
	hospital_province = rs5.getString("province");
	hospital_country = rs5.getString("country");
	
	Statement stm6 = con.createStatement();
	String query6 = "SELECT * FROM admin_request WHERE request_id ="+req_id+"";
	ResultSet rs6 = stm5.executeQuery(query6);
	rs6.next();
	admin_id = rs6.getInt("admin_id");
	
	Statement stm7 = con.createStatement();
	String query7 = "SELECT * FROM admin WHERE admin_id ="+admin_id+"";
	ResultSet rs7 = stm5.executeQuery(query7);
	rs7.next();
	admin_name = rs7.getString("firstname");
	admin_lastname = rs7.getString("lastname");
	admin_phone = rs7.getString("phone_number");
	admin_email = rs7.getString("email");
%>
<tr>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "req_id" value="<%= req_id %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "req_status" value="<%= req_status %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "req_date" value="<%= req_date %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "liters_donated" value="<%= liters_donated %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "blood_type" value="<%= blood_type %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "donation_date" value="<%= donation_date %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "cert_id" value="<%= cert_id %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "doctor_name" value="<%= doctor_name %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "doctor_lastname" value="<%= doctor_lastname %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "doctor_gender" value="<%= doctor_gender %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "doctor_phone" value="<%= doctor_phone %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "hospital_id" value="<%= hospital_id %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "hospital_name" value="<%= hospital_name %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "hospital_address" value="<%= hospital_address %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "hospital_zip" value="<%= hospital_zip %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "hospital_city" value="<%= hospital_city %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "hospital_province" value="<%= hospital_province %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "hospital_country" value="<%= hospital_country %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "admin_id" value="<%= admin_id %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "admin_name" value="<%= admin_name %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "admin_lastname" value="<%= admin_lastname %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "admin_phone" value="<%= admin_phone %>">
</td>
<td>
<input style="background-color:#f7dcdc;" type="text" name = "admin_email" value="<%= admin_email %>">
</td>
</tr>
<% 
rs2.close();
rs3.close();
rs4.close();
rs5.close();
rs6.close();
rs7.close();
stm2.close();
stm3.close();
stm4.close();
stm5.close();
stm6.close();
stm7.close();
} 
rs.close();
stm.close();
rs1.close();
stm1.close();
con.close();
%>
</table>
<table>
<tr>
<td colspan="24" align="center">
<p> <font color="#b30707"> Please specify the desired Request ID: </font></p>
<input style="background-color:#FFFFFF;" type="text" id="value_request_ID" name="value_request_ID" required>
</td>
</tr>
<tr><td colspan="24" align="center">
		<p> <font color="#b30707">Please select the required status:</font></p><br>
		<select id="status" name="status">
		<label for="status">Select Request Status</label>
		<option value="PENDING" selected>Pending</option>
		<option value="ACCEPTED">Accepted</option>
		<option value="DELIVERED">Delivered</option>
		<option value="CANCELLED">Cancelled</option>
		</select><br><br>
</td>
</tr>
<tr><td colspan="24" align="center">
<input type="submit" value="Submit">
</td></tr>
</table>
<%
	}
	
	else
	{
%>
<caption><h2><font color="#b30707">Currently, there are not Requests with the status selected within our Blood Bank System. </font></h2></caption>
<%
rs.close();
stm.close();
con.close();
	}
%>
<table>
<tr><td colspan="11" align="center">
<a style="color:#b30707;" href="EditDoctorRequest.jsp">Return</a>
</td></tr>
</table>
</div>
</form>
</center>
</body>
</html>