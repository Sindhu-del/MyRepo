<%@page import="com.te.springmvc.bean.EmpBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp" %>	
	<% String msg=(String)request.getAttribute("msg");%>
	<%EmpBean empbean=(EmpBean)request.getAttribute("data"); %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend> Search</legend>
		<form action="./search" method="get">

			<table>
				<tr>
					<td>Search by Id</td>
					<td><input type="text" placeholder="enter employee id"
						name="id"></td>
				</tr>

				<tr>
					<td><input type="submit" name="submitbtn" value="search"></td>
				</tr>
			</table>

		</form>
	</fieldset>
	
	<%if(empbean!=null) {%>
	<h4>Name:<%=empbean.getName() %></h4>
	<h4>ID:<%=empbean.getId()%></h4>
	<h4>DOB:<%=empbean.getDob() %></h4>
	<h4></h4>
	<%} %>
</body>
</html>