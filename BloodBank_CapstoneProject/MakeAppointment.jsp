<html>
<head>
</head>
<script type="text/JavaScript"> 
<%
String ErrorMsg =(String)session.getAttribute("errors");
	if (ErrorMsg ==null)
		ErrorMsg="";
%>
</script>
<style>
 label {
        color: #ffffff;
      }
</style>
<body style="background-color:#c91d14;">
<center>
<form name="input" method="post" action="./UpdateAppointment">
<table> 
<tr><td align="center">
<img src =bloodbankimages/index.png></td></tr>
<tr>
<td align="center">
<h1><em><font color="#ffffff"size="8"> ICBlood Bank  </font></em></h1>
<h2><font color="#ffffff">Appointment Information</h2></font></td></tr>
<tr>
<td colspan="2" align="center"> <h1><em><font color="white"> <%=ErrorMsg%> </font></em></h1>
</td></tr>

<tr><td align="center">
		<p> <font color="#ffffff">Please select the desired Location:</font></p><br>
		<select id="location" name="location">
		<label for="location"> Select Location </label>
		<option value="1200 Main Lane Road" selected>1200 Main Lane Road, V4B2A8, Toronto, ON</option>
		<option value="87 Airlington Street">87 Airlington Street, G4Q1X2, Brampton, ON  </option>
		<option value="1980 Oak Drive">1980 Oak Drive, E9B2V5, London, ON </option>
		<option value="35 Green Bay Road">35 Green Bay Road, M3T6J8, Hamilton, ON </option>
		</select><br><br>
</td></tr>
<tr>
<td>
<label for="appointment">Please select the desired date:</label>
<input type="date" id="appointment" name="appointment" required>
<br> <br>
</td></tr>
<tr><td align="center">
		<p> <font color="#ffffff">Please select the desired Time for your Appointment:</font></p><br>
		<select id="time" name="time">
		<label for="time"> Select time </label>
		<option value="08:00" selected>08:00 AM</option>
		<option value="09:00">09:00 AM</option>
		<option value="10:00">10:00 AM </option>
		<option value="11:00">11:00 AM</option>
		<option value="12:00">12:00 PM</option>
		<option value="13:00">13:00 PM</option>
		<option value="14:00">14:00 PM</option>
		<option value="15:00">15:00 PM</option>
		<option value="16:00">16:00 PM</option>
		<option value="17:00">17:00 PM</option>
		</select><br><br>
</td></tr>
<tr><td align="center">
<input type="submit" value="Submit">
<br>
</td>
</tr>
</td></tr><br><br>
<tr><td align="center">
<a style="color:#ffffff;" href="MenuUser.jsp">Cancel</a>
</td></tr>
</table>
</form>
</center>
</body>
</html>