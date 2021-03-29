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
<form name="input" method="post" action="./CreateDoctor">
<table>
<tr>
<td align="center">
<img src =bloodbankimages/index.png>
</td>
</tr>
<tr>
<td align="center"><h1><em><font color="#ffffff"size="8"> ICBlood Bank  </font></em></h1>
<h2> <font color="#ffffff">Creation of a new Doctor Account</font></h2> 
</td>
</tr>
<tr>
<td colspan="2" align="center"> <h1><em><font color="white"> <%=ErrorMsg%> </font></em></h1>
</td>
</tr>
<tr>
<td align="center">
<p> <font color="#ffffff"> Please specify Doctor's certificate ID: </font></p>
<input style="background-color:#ffffff;" type="text" id="certificate_id" name="certificate_id" required>
</td>
</tr>
<tr><td align="center">
<p> <font color="#ffffff">Please specify Doctor's Firstname:</font></p>
<input style="background-color:#ffffff;" type="text" id="firstname" name="firstname" required>
</td>
</tr>
<tr><td align="center">
<p> <font color="#ffffff">Please specify Doctor's Lastname:</font></p>
<input style="background-color:#ffffff;" type="text" id="lastname" name="lastname" required>
</td>
</tr>
<tr><td align="center">
<p> <font color="#ffffff">Please specify Doctor's password:</font></p>
<input style="background-color:#ffffff;" type="text" id="password" name="password" required>
</td>
</tr>
<tr><td align="center">
<p> <font color="#ffffff">Please specify Doctor's phone number:</font></p>
<p><em><font color="#ffffff">10 Digits maximum</font></em></p>
<input style="background-color:#ffffff;" type="text" id="phone_n_d" name="phone_n_d" required>
</td>
</tr>
<tr><td align="center">
<p> <font color="#ffffff">Please select Doctor's Gender:</font></p><br>
<input type="radio" id="female" name="gender" value="F" checked>
<label for="female"> Female </label>
<input type="radio" id="male" name="gender" value="M">
<label for="male"> Male </label><br><br>
</td></tr>
<tr><td align="center">
<p> <font color="#ffffff">Please specify Doctor's Hospital name:</font></p>
<input style="background-color:#ffffff;" type="text" id="hospital_name" name="hospital_name" required>
</td>
</tr>
<tr><td align="center">
<p> <font color="#ffffff">Please specify Doctor's Hospital address:</font></p>
<input style="background-color:#ffffff;" type="text" id="hospital_address" name="hospital_address" required>
</td>
</tr>
<tr><td align="center">
<p> <font color="#ffffff">Please specify Doctor's Hospital City:</font></p>
<input style="background-color:#ffffff;" type="text" id="hospital_city" name="hospital_city" required>
</td>
</tr>
<tr><td align="center">
<p> <font color="#ffffff">Please specify Doctor's Hospital Zip Code:</font></p>
<input style="background-color:#ffffff;" type="text" id="hospital_z_c" name="hospital_z_c" required>
</td>
</tr>
<tr><td align="center">
<p> <font color="#ffffff">Doctor's Hospital Province:</font></p><br>
<input type="radio" id="province_h" name="province_h" value="ON" checked>
<label for="country_h"> Ontario (Currently, services are only available within Ontario) </label><br><br>
</td></tr>
<tr><td align="center">
<p> <font color="#ffffff">Doctor's Hospital Country:</font></p><br>
<input type="radio" id="country_h" name="country_h" value="Canada" checked>
<label for="country_h"> Canada (Currently, services are only available within Ontario) </label><br><br>
</td></tr>
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