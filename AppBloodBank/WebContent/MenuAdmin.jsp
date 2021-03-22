<html>
<head>
<title> Welcome to ICBlood Bank</title>
</head>
<script type="text/JavaScript"> 
<%
String ErrorMsg =(String)session.getAttribute("errors");
	if (ErrorMsg ==null)
		ErrorMsg="";
%>
</script>
<%@ page import="bloodbank.*" %>
<% Admin admin = (Admin)session.getAttribute("admin"); %>
<% Location loc = (Location)session.getAttribute("location"); %>
<body style="background-color:#f7dcdc;">
<center>
<h1><em><font color="#b30707" size="8"> Welcome to ICBlood Bank </font></em></h1>
<div align="center">
<caption><h2><font color="#b30707">Admin Information</font></h2></caption>
<table>
<tr>
<td colspan="2" align="center"> <h1><em><font color="red"> <%=ErrorMsg%> </font></em></h1>
</td>
</tr>
<tr>
<td colspan="9" align="center"><img src =bloodbankimages/usermenu.png> <br></td>
</tr>
</table>
<table border="1"cellpadding="5">
<tr>
<th>Admin ID</th>
<th>Firstname</th>
<th>Lastname</th>
<th>Phone Number</th>
<th>Email</th>
<th>Gender</th>
</tr>       
<tr>
                    <td><input style="background-color:#f7dcdc;" type="text" name = "admin_id" value="<%= admin.getAdmin_id() %>"></td>
                    <td><input style="background-color:#f7dcdc;" type="text" name = "firstname" value="<%= admin.getFirstname() %>"></td>
					<td><input style="background-color:#f7dcdc;" type="text" name = "lastname" value="<%= admin.getLastname() %>"></td>
					<td><input style="background-color:#f7dcdc;" type="text" name = "phone_number" value="<%= admin.getPhone() %>"></td>
					<td><input style="background-color:#f7dcdc;" type="text" name = "email" value="<%= admin.getEmail() %>"></td>
					<td><input style="background-color:#f7dcdc;" type="text" name = "gender" value="<%= admin.getGender() %>"></td>
					

</tr>
</div>
<div>
</table>
<caption><h2><font color="#b30707">Workplace Information:</font></h2></caption>
<table>
<tr>
<th>Location ID</th>
<th>Address</th>
<th>City</th>
<th>Zip Code</th>
<th>Province</th>
<th>Country</th>
<th>Office phone number</th>
</tr>
<tr>
<tr>
                    <td><input style="background-color:#f7dcdc;" type="text" name = "location_id" value="<%=admin.getlocationID() %>"></td>
                    <td><input style="background-color:#f7dcdc;" type="text" name = "address_a" value="<%= loc.getAddress_b() %>"></td>
                    <td><input style="background-color:#f7dcdc;" type="text" name = "city" value="<%= loc.getCity() %>"></td>
					<td><input style="background-color:#f7dcdc;" type="text" name = "zip_code" value="<%= loc.getZip_c_b() %>"></td>
					<td><input style="background-color:#f7dcdc;" type="text" name = "province" value="<%= loc.getProvince() %>"></td>
					<td><input style="background-color:#f7dcdc;" type="text" name = "country" value="<%= loc.getCountry() %>"></td>
					<td><input style="background-color:#f7dcdc;" type="text" name = "phone_number" value="<%= loc.getPhone_b() %>"></td>
					

</tr>
</tr>
</table>
</div>
<div>
		<h2><font color="#b30707"> Available Options</font></h2>
		<form name="input" method="post" action="./MenuAdmin">
		<p>Please select which option would you like to perform:</p>
		<input  type="radio" id="account" name="option" value="account">
		<label for="account"> Create a new Doctor account </label>
		<input  type="radio" id="view_account" name="option" value="view_account" checked>
		<label for="view_account"> View existing Doctor Accounts </label><br><br>
		<input  type="radio" id="delete_account" name="option" value="delete_account">
		<label for="delete_account"> Delete Doctor Account </label><br><br>
		<input type="radio" id="appointment" name="option" value="appointment">
		<label for="appointment"> View or Edit Users' Appointments </label>
		<input  type="radio" id="request" name="option" value="request">
		<label for="request"> View or Edit Doctors' requests </label>
		<input  type="radio" id="blood_database" name="option" value="blood_database">
		<label for="blood_database"> Modify BloodBank Database </label><br><br>
		<input type="submit" value="Submit">
		</form>
</div>

<table>
<tr>
<td align="center"><a style="color:#000000;" href="./CloseSession">Sign off</a>
</td>
</tr>
</table>
</center>
</body>
</html>