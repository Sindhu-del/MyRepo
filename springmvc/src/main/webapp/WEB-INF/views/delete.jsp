<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%String msg= (String)request.getAttribute("msg"); %>
	
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
</head>
<body>
<%if(msg!=null&&!msg.isEmpty()){ %>
	<h1>
		<%=msg%>
	</h1>
	<%} %>
	<fieldset>
		<legend> Delete</legend>
		<form action="./delete" method="get">
			<table>
				<tr>
					<td>Employee ID</td>
					<td>:</td>
					<td>input<input type="text" placeholder="enter employee id"
						name="id"></td>
				</tr>
				<tr>
					<td><input type="submit" name="submit" value="Delete"></td>
				</tr>
			</table>
		</form>
	</fieldset>


</body>
</html>