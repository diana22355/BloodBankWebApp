<html>
<%@ page import="bloodbank.*" %>
<% User user = (User)session.getAttribute("user"); %>
<script type="text/JavaScript"> 
<%
String ErrorMsg =(String)session.getAttribute("errors");

	if (ErrorMsg ==null)
		ErrorMsg="";
%>
</script>
<body style="background-color:#c91d14;">
<center>
<form name="input" method="post" action="./SendUserUpdate">
<table>
<tr>
<td align="center">
<img src =bloodbankimages/index.png>
</td>
</tr>
<tr>
<td align="center"> <h1><em><font color="white"> <%=ErrorMsg%> </font></em></h1>
</td>
</tr>
<tr>
<td align="center"><h1><em><font color="#ffffff"size="8"> ICBlood Bank  </font></em></h1>
<h2> <font color="#ffffff">Please modify any required information and click "Submit" to save your changes.</font></h2> 
</td>
</tr>
<tr><td align="center">
<p><em><font color="#ffffff">Phone number (10 Digits maximum) </font></em></p>
<input style="background-color:#ffffff;" type="text" id="phone_n" name="phone_n" value="<%= user.getPhone() %>">
</td>
</tr>
<tr><td align="center">
<p><em><font color="#ffffff">Prescription medications (Y/N)</font></em></p>
<input style="background-color:#ffffff;" type="text" id="prescription" name="prescription" value="<%= user.getPrescription() %>">
</td>
</tr>
<tr><td align="center">
<p><em><font color="#ffffff">Tattoo in the last 3 months (Y/N)</font></em></p>
<input style="background-color:#ffffff;" type="text" id="tattoo" name="tattoo" value="<%= user.getTattoo() %>">
</td>
</tr>
<tr><td align="center">
<p><em><font color="#ffffff">Piercing in the last 3 months (Y/N)</font></em></p>
<input style="background-color:#ffffff;" type="text" id="piercing" name="piercing" value="<%= user.getPiercing()  %>">
</td>
</tr>
<tr><td align="center">
<p><em><font color="#ffffff">Surgery in the last 72 hours (Y/N)</font></em></p>
<input style="background-color:#ffffff;" type="text" id="surgery" name="surgery" value="<%= user.getSurgery()  %>">
</td>
</tr>
</table>
<% if(user.getGender().equalsIgnoreCase("F")){ %>
<table>
<tr><td align="center">
<p><em><font color="#ffffff">Have you been pregnant or had a baby in the last 6 months? (Y/N)</font></em></p>
<input style="background-color:#ffffff;" type="text" id="pregnancy" name="pregnancy" value="<%= user.getPregnancy()  %>">
</td>
</tr>
</table>
<% } %>
<table>
<tr> 
<td align="center">
<input type="submit" value="Submit">
</td>
</tr>
<tr>
<td align="center">
<a style="color:#ffffff;" href="MenuUser.jsp">Cancel</a>
</td></tr>
</table>
</form>
</center>
</body>
</html>