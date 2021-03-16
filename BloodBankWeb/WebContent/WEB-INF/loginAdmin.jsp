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
<body style="background-color:#c91d14;">
<center>
<img src =bloodbankimages/index.png>
<h1><em><font color="#ffffff" size="8"> Welcome to ICBlood Bank </font></em></h1> <br><br>
<h3><font color="#ffffff"  size="6"> Sign on </font><br></h3>

<form name="input" method="post" action="./LoginAdmin">
<table>
<tr>
<td colspan="2" align="center"> <h1><em><font color="white"> <%=ErrorMsg%> </font></em></h1>
</td>
</tr>
<tr>
<td><strong> <font color="#ffffff" size="5"> Email </font></strong></td>
<td><input type="text" name="email" value=""> </td>
</tr>
<tr><td><strong><font color="#ffffff" size="5">Password </font></strong></td>
<td><input type="password" name="password" value=""> <br><br> </td>
</tr>
</table>
<table>
<tr>
<td><input type="submit"  value = "Login" ></td>
<td><input type="reset"  value = "Clear" ><br></td>
</tr>
<tr>
<td colspan="2" align="center"><a style="color:#ffffff;" href="index.jsp">Menu</a>
</td>
</tr>
</table>
</form>
</center>
</body>
</html>