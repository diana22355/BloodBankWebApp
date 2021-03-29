<html>
<head>
<title> Welcome to ICBlood Bank</title>
</head>
<body style="background-color:#f7dcdc;">
<center>
<form name="input" method="post" action="./FilterDoctorRequest">
<h1><em><font color="#b30707" size="8"> Welcome to ICBlood Bank </font></em></h1>
<div align="center">
<caption><h2><font color="#b30707">Filter and Confirmation of Doctors' Requests</font></h2></caption>
<table>
<tr>
<td align="center"><img src =bloodbankimages/usermenu.png> <br></br></td>
</tr>
<tr><td align="center">
		<p> <font color="#b30707">Please select the Doctors' Request Status:</font></p><br>
		<select id="status" name="status">
		<label for="status"> Select Request Status </label>
		<option value="PENDING" selected>Pending</option>
		<option value="ACCEPTED">Accepted</option>
		<option value="DELIVERED">Delivered</option>
		<option value="CANCELLED">Cancelled</option>
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
<td align="center">
<a style="color:#b30707;" href="MenuAdmin.jsp">Cancel</a>
</td>
</tr>
</table>
</div>
</form>
</center>
</body>
</html>