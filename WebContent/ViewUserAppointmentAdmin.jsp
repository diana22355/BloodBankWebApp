<html>
<head>
<title> Welcome to ICBlood Bank</title>
</head>
<body style="background-color:#f7dcdc;">
<center>
<h1><em><font color="#b30707" size="8"> Welcome to ICBlood Bank </font></em></h1>
<div align="center">
<caption><h2><font color="#b30707">View Users' Appointments</font></h2></caption>
<table>
<tr>
<td align="center"><img src =bloodbankimages/index.png> <br></td>
</tr>
</table>
</div>
<div>
		<h2><font color="#b30707"> Please select what appointments would you like to see:</font></h2>
		<form name="input" method="post" action="./ViewAppointmentAdmin">
		<input  type="radio" id="viewAll" name="ViewappointmentOption" value="viewAll">
		<label for="viewAll"> All Users' Appointments </label>
		<input  type="radio" id="specUser" name="ViewappointmentOption" value="specUser" checked>
		<label for="specUser"> Specific User's Appointment </label><br><br>
		<input type="submit" value="Submit">
		</form>
</div>
<table>
<tr>
<td align="center">
<a style="color:#b30707;" href="AdminAppointments.jsp">Return</a>
</td>
</tr>
</table>
</center>
</body>
</html>