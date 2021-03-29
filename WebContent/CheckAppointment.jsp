<html>
<head>
<title> Welcome to ICBlood Bank</title>
</head>
<%@ page import="bloodbank.*" %>
<% User user = (User)session.getAttribute("user"); %>
<% Appointment app = (Appointment)session.getAttribute("appointment"); %>
<% Location loc = (Location)session.getAttribute("location"); %>

<body style="background-color:#f7dcdc;">
<center>
<h1><em><font color="#b30707" size="8"> Welcome to ICBlood Bank </font></em></h1>
<div align="center">
<caption><h2><font color="#b30707">User Information</font></h2></caption>
<table>
<tr>
<td colspan="9" align="center"><img src =bloodbankimages/usermenu.png> <br></td>
</tr>
</table>
<table border="1"cellpadding="5">
<tr>
<th>Firstname</th>
<th>Lastname</th>
<th>Gender</th>
<th>Date of Birth</th>
<th>Phone Number</th>
</tr>
            
<tr>
                    <td><input style="background-color:#f7dcdc;" type="text" name = "firstname" value="<%= user.getFirstname() %>"></td>
					<td><input style="background-color:#f7dcdc;" type="text" name = "lastname" value="<%= user.getLastname() %>"></td>
					<td><input style="background-color:#f7dcdc;" type="text" name = "gender" value="<%= user.getGender() %>"></td>
					<td><input style="background-color:#f7dcdc;" type="text" name = "dob" value="<%= user.getDob() %>"></td>
					<td><input style="background-color:#f7dcdc;" type="text" name = "phone" value="<%= user.getPhone() %>"></td>
</tr>
</table>
</div>
<div align="center">
<caption><h2><font color="#b30707">Appointment Information</font></h2></caption>
<table border="1"cellpadding="5">
<tr>
<th>Appointment ID</th>
<th>Date</th>
<th>Time</th>
<th>Address</th>
<th>City</th>
<th>Zip Code</th>
<th>Country</th>
<th>Province</th>
<th>Location Phone number</th>
</tr>
            
<tr>
                    <td><input style="background-color:#f7dcdc;" type="text" name = "appointment" value="<%= app.getAppointment_id() %>"></td>
					<td><input style="background-color:#f7dcdc;" type="text" name = "date" value="<%= app.getDate() %>"></td>
					<td><input style="background-color:#f7dcdc;" type="text" name = "time" value="<%= app.getTime() %>"></td>
					<td><input style="background-color:#f7dcdc;" type="text" name = "address" value="<%= loc.getAddress_b() %>"></td>
					<td><input style="background-color:#f7dcdc;" type="text" name = "city" value="<%= loc.getCity() %>"></td>
					<td><input style="background-color:#f7dcdc;" type="text" name = "zip_code" value="<%= loc.getZip_c_b() %>"></td>
					<td><input style="background-color:#f7dcdc;" type="text" name = "country" value="<%= loc.getCountry() %>"></td>
					<td><input style="background-color:#f7dcdc;" type="text" name = "province" value="<%= loc.getProvince() %>"></td>
					<td><input style="background-color:#f7dcdc;" type="text" name = "phone_l" value="<%= loc.getPhone_b() %>"></td>
</tr>
</table>
</div>
<table>
<tr>
<td align="center"><a style="color:#000000;" href="./MenuUser.jsp">Menu</a>
</td>
</tr>
</table>
</center>
</body>
</html>