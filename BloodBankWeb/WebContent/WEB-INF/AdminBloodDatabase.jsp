<html>
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
<form name="input" method="post" action="./CreateBloodDonation">
<table>
<tr>
<td align="center">
<img src =bloodbankimages/index.png>
</td>
</tr>
<tr>
<td align="center"><h1><em><font color="#ffffff"size="8"> ICBlood Bank  </font></em></h1>
<h2> <font color="#ffffff">Registration of a new Blood Donation</font></h2> 
</td>
</tr>
<tr>
<td colspan="2" align="center"> <h1><em><font color="white"> <%=ErrorMsg%> </font></em></h1>
</td>
</tr>
<tr>
<td align="center">
<p> <font color="#ffffff"> Please specify User's Firstname: </font></p>
<input style="background-color:#ffffff;" type="text" id="firstname" name="firstname" required>
</td>
</tr>
<tr><td align="center">
<p> <font color="#ffffff">Please specify User's Lastname:</font></p>
<input style="background-color:#ffffff;" type="text" id="lastname" name="lastname" required>
</td>
</tr>
<tr><td align="center">
<p> <font color="#ffffff">Please specify User's email:</font></p>
<input style="background-color:#ffffff;" type="text" id="email" name="email" required>
</td>
</tr>
<tr><td align="center">
<p> <font color="#ffffff">Please specify how many Blood liters were donated:</font></p>
<p><em><font color="#ffffff">Enter value in liters (L)</font></em></p>
<input style="background-color:#ffffff;" type="text" id="liters" name="liters" required>
</td>
</tr>
<tr><td align="center">
		<p> <font color="#ffffff">Please specify the type of Blood donated:</font></p><br>
		<select id="blood" name="blood">
		<label for="blood"> Select Blood Type </label>
		<option value="O+" selected>O+</option>
		<option value="O-">O-</option>
		<option value="A+">A+</option>
		<option value="A-">A-</option>
		<option value="B-">B-</option>
		<option value="B+">B+</option>
		<option value="AB+">AB+</option>
		<option value="AB+">AB+</option>
		</select><br><br>
</td>
<td>
<label for="appointment">Please select Blood Donation date:</label>
<input type="date" id="donation" name="donation" required>
<br> <br>
</td></tr>
</tr>
<tr> <td align="center">
<input type="submit" value="Submit">
</td>
</tr>
<tr><td align="center">
<a style="color:#ffffff;" href="MenuAdmin.jsp">Cancel</a>
</td></tr>
</table>
</form>
</center>
</body>
</html>