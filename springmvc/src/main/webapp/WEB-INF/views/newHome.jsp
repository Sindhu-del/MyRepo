<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
String name=(String)request.getAttribute("username");
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> hello
<% if(name!="" && name!=null){%>

<%=name %>

<% } %>
</h1>
</body>
</html>