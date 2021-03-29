<html>
<head>
<title> Welcome to ICBlood Bank</title>
</head>
<body style="background-color:#f7dcdc;">
<center>
<h1><em><font color="#b30707" size="8"> Welcome to ICBlood Bank </font></em></h1>
<div align="center">
<caption><h2><font color="#b30707">Doctors' Requests</font></h2></caption>
<table>
<tr>
<td colspan="9" align="center"><img src =bloodbankimages/usermenu.png> <br></td>
</tr>
</table>
</div>
<div>
		<h2><font color="#b30707"> Please select what option would you like to perform:</font></h2>
		<form name="input" method="post" action="./ViewEditDoctorRequests">
		<input  type="radio" id="view" name="RequestOption" value="view">
		<label for="view"> View Doctors' Requests </label>
		<input  type="radio" id="edit" name="RequestOption" value="edit" checked>
		<label for="edit"> Edit Doctors' Requests </label><br><br>
		<input type="submit" value="Submit">
		</form>
</div>
<table>
<tr>
<td align="center">
<a style="color:#b30707;" href="MenuAdmin.jsp">Menu</a>
</td></tr>
</table>
</center>
</body>
</html>