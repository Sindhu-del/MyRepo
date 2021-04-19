<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@include file="header.jsp" %>
<%
String msg = (String) request.getAttribute("errmsg");
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Login form</title>
</head>
<body>
	<%if(msg!=null&&!msg.isEmpty()){ %>
	<h1>
		<%=msg%>
	</h1>
	<%} %>
	<fieldset style="width: 300px; margin-left:40%; margin-top:30px; height: 250px" >
	<legend style="border: 1px solid blue"> Login Here</legend>
	<form action="./emplogin" method="post">
		
			

			<table style="padding-top:30px">
				<tr >
					<td>Employee id</td>
					<td>:</td>
					<td><input type="text" placeholder="Enter your emp id "
						name="id"></td>
				</tr>

				<tr>
					<td>Password</td>
					<td>:</td>
					<td><input type="password" placeholder="Enter Password "
						name="pwd"></td>

				</tr>
				<tr>
					<td><input type="submit" name="submit" style="padding:10px;margin-top:20px ; margin-left:120%;"></td>
				</tr>

			</table>

		</fieldset>

	</form>

</body>
</html>