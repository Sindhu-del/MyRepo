<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
String name = (String) request.getAttribute("name");
int pwd = (int) request.getAttribute("pwd");
%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>
		Name:
		<%=name%>
	</h1>
	<br>
	<h1>
		Password
		<%=pwd%></h1>
</body>
</html>