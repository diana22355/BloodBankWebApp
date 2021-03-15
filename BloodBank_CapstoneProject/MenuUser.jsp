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
<% User user = (User)session.getAttribute("user"); %>
<body style="background-color:#f7dcdc;">
<center>
<h1><em><font color="#b30707" size="8"> Welcome to ICBlood Bank </font></em></h1>
<div align="center">
<caption><h2><font color="#b30707">User Information</font></h2></caption>
<table>
<tr>
<td colspan="2" align="center"> <h1><em><font color="red"> <%=ErrorMsg%> </font></em></h1>
</td></tr>
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
<th>Prescription</th>
<th>Piercing in last 3 months</th>
<th>Tattoo in last 3 months</th>
<th>Surgery in last 72 hours</th>
</tr>
            
<tr>
                    <td><input style="background-color:#f7dcdc;" type="text" name = "firstname" value="<%= user.getFirstname() %>"></td>
					<td><input style="background-color:#f7dcdc;" type="text" name = "lastname" value="<%= user.getLastname() %>"></td>
					<td><input style="background-color:#f7dcdc;" type="text" name = "gender" value="<%= user.getGender() %>"></td>
					<td><input style="background-color:#f7dcdc;" type="text" name = "dob" value="<%= user.getDob() %>"></td>
					<td><input style="background-color:#f7dcdc;" type="text" name = "phone" value="<%= user.getPhone() %>"></td>
					<td><input style="background-color:#f7dcdc;" type="text" name = "prescription" value="<%= user.getPrescription() %>"></td>
					<td><input style="background-color:#f7dcdc;" type="text" name = "piercing" value="<%= user.getPiercing() %>"></td>
					<td><input style="background-color:#f7dcdc;" type="text" name = "tattoo" value="<%= user.getTattoo() %>"></td>
					<td><input style="background-color:#f7dcdc;" type="text" name = "surgery" value="<%= user.getSurgery() %>"></td>
					

</tr>
</table>
</div>
<% if(user.getGender().equalsIgnoreCase("F")){ %>
<table>
<tr>
<th>Pregnancy in last 6 months</th> 
</tr>
<tr>
<td><input style="background-color:#f7dcdc;" type="text" name = "pregnancy" value="<%= user.getPregnancy() %>"></td>
</tr>
</table>
<% } %>

<div>
		<h2><font color="#b30707"> Available Options</font></h2>
		<form name="input" method="post" action="./MenuUser">
		<p>Please select which option would you like to perform:</p>
		<input  type="radio" id="appointment" name="option" value="appointment">
		<label for="appointment"> Make an Appointment </label>
		<input type="radio" id="check" name="option" value="check" checked>
		<label for="check"> Check my Appointments </label>
		<input  type="radio" id="info" name="option" value="info">
		<label for="info"> Update my Information </label><br><br>
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