<html>
<head>
<title> Welcome to ICBlood Bank</title>
</head>
<body style="background-color:#f7dcdc;">
<center>
<form name="input" method="post" action="./ViewAppointmentLocation">
<h1><em><font color="#b30707" size="8"> Welcome to ICBlood Bank </font></em></h1>
<div align="center">
<caption><h2><font color="#b30707">View Users' Appointments</font></h2></caption>
<table>
<tr>
<td align="center"><img src =bloodbankimages/usermenu.png> <br></td>
</tr>
<tr><td align="center">
		<p> <font color="#ffffff">Please select the desired Location to see Users's Appointments:</font></p><br>
		<select id="location" name="location">
		<label for="location"> Select Location </label>
		<option value="1200 Main Lane Road" selected>1200 Main Lane Road, V4B2A8, Toronto, ON</option>
		<option value="87 Airlington Street">87 Airlington Street, G4Q1X2, Brampton, ON  </option>
		<option value="1980 Oak Drive">1980 Oak Drive, E9B2V5, London, ON </option>
		<option value="35 Green Bay Road">35 Green Bay Road, M3T6J8, Hamilton, ON </option>
		<option value="all"> All Locations </option>
		</select><br><br>
</td>
</tr>
<tr>
<td align="center">
<input type="submit" value="Submit">
<br>
</td>
</tr>
<tr>
<td>
<a style="color:#b30707;" href="MenuAdmin.jsp">Cancel</a>
</td>
</tr>
</table>
</div>
</form>
</center>
</body>
</html>