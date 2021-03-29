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
<form name="input" method="post" action="./CreateUser">
<table>
<tr>
<td align="center">
<img src =bloodbankimages/index.png>
</td>
</tr>
<tr>
<td align="center"><h1><em><font color="#ffffff"size="8"> ICBlood Bank  </font></em></h1>
<h2> <font color="#ffffff">Creation of a new User Account</font></h2> 
</td>
</tr>
<tr>
<td colspan="2" align="center"> <h1><em><font color="white"> <%=ErrorMsg%> </font></em></h1>
</td>
</tr>
<tr>
<td align="center">
<p> <font color="#ffffff"> Please specify your Firstname: </font></p>
<input style="background-color:#ffffff;" type="text" id="firstname" name="firstname" required>
</td>
</tr>
<tr><td align="center">
<p> <font color="#ffffff">Please specify your Lastname:</font></p>
<input style="background-color:#ffffff;" type="text" id="lastname" name="lastname" required>
</td>
</tr>
<tr><td align="center">
<p> <font color="#ffffff">Please specify your email address:</font></p>
<input style="background-color:#ffffff;" type="text" id="email" name="email" required>
</td>
</tr>
<tr><td align="center">
<p> <font color="#ffffff">Please specify a password:</font></p>
<input style="background-color:#ffffff;" type="text" id="password" name="password" required>
</td>
</tr>
<tr><td align="center">
<p> <font color="#ffffff">Please specify your phone number:</font></p>
<p><em><font color="#ffffff">10 Digits maximum</font></em></p>
<input style="background-color:#ffffff;" type="text" id="phone_n" name="phone_n" required>
</td>
</tr>
<tr><td align="center">
<p> <font color="#ffffff">Please specify your date of birth: (YYYY-MM-DD)</font></p>
<input style="background-color:#ffffff;" type="text" id="dob" name="dob" value="YYYY-MM-DD" required>
</td>
</tr>
<tr><td align="center">
<p> <font color="#ffffff">Please select your Gender:</font></p><br>
<input type="radio" id="female" name="gender" value="F" checked>
<label for="female"> Female </label>
<input type="radio" id="male" name="gender" value="M">
<label for="male"> Male </label><br><br>
</td></tr>
<tr><td align="center">
<p><font color="#ffffff"> Please select if you are taking prescription medications:</font></p><br>
<input type="radio" id="no" name="prescription" value="N" checked>
<label for="no"> No </label>
<input type="radio" id="yes" name="prescription" value="Y">
<label for="yes"> Yes </label><br><br>
</td></tr>
<tr><td align="center">
<p><font color="#ffffff">Please select if you have had a tattoo in the last 3 months:</font></p><br>
<input type="radio" id="no" name="tattoo" value="N" checked>
<label for="no"> No </label>
<input type="radio" id="yes" name="tattoo" value="Y">
<label for="yes"> Yes </label><br><br>
</td></tr>
<tr><td align="center">
<p><font color="#ffffff">Please select if you have had a piercing in the last 3 months:</font></p><br>
<input type="radio" id="no" name="piercing" value="N" checked>
<label for="no"> No </label>
<input type="radio" id="yes" name="piercing" value="Y">
<label for="yes"> Yes </label><br><br>
</td></tr>
<tr><td align="center">
<p><font color="#ffffff">Please select if you have had a surgery in last 72 hours:</font></p><br>
<input type="radio" id="no" name="surgery" value="N" checked>
<label for="no"> No </label>
<input type="radio" id="yes" name="surgery" value="Y">
<label for="yes"> Yes </label><br><br>
</td></tr>
<tr><td align="center">
<p><font color="#ffffff">Please select if you have been pregnant or had a baby in the last 6 months:</font></p><br>
<input type="radio" id="no" name="pregnancy" value="N" checked>
<label for="no"> No </label>
<input type="radio" id="yes" name="pregnancy" value="Y">
<label for="yes"> Yes </label><br><br>
</td></tr>
<tr> <td align="center">
<input type="submit" value="Submit">
</td>
</tr>
<tr><td align="center">
<a style="color:#ffffff;" href="loginUser.jsp">Cancel</a>
</td></tr>
</table>
</form>
</center>
</body>
</html>