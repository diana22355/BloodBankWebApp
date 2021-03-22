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
<form name="input" method="post" action="./SpecificUserAppointment">
<table>
<tr>
<td align="center">
<img src =bloodbankimages/index.png>
</td>
</tr>
<tr>
<td align="center"><h1><em><font color="#ffffff"size="8"> ICBlood Bank  </font></em></h1>
<h2> <font color="#ffffff">User's Appointment</font></h2> 
</td>
</tr>
<tr>
<td colspan="2" align="center"> <h1><em><font color="white"> <%=ErrorMsg%> </font></em></h1>
</td>
</tr>
<tr>
<td align="center">
<p> <font color="#ffffff"> Please specify the User's Firstname: </font></p>
<input style="background-color:#ffffff;" type="text" id="firstname" name="firstname" required>
</td>
</tr>
<tr><td align="center">
<p> <font color="#ffffff">Please specify the User's Lastname:</font></p>
<input style="background-color:#ffffff;" type="text" id="lastname" name="lastname" required>
</td>
</tr>
<tr><td align="center">
<p> <font color="#ffffff">Please specify the User's email:</font></p>
<input style="background-color:#ffffff;" type="text" id="email" name="email" required>
</td>
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