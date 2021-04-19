<%@page import="java.util.Iterator"%>
<%@page import="com.te.springmvc.bean.EmpBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp"%>
<%
String message = (String) request.getAttribute("errmsg");
List<EmpBean> dataList = (List<EmpBean>) request.getAttribute("data");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AllData</title>
</head>
<body>
<fieldset style="width:300px">
	<form action="./alldata" method="get" >

		<%
		if (message != null && !message.isEmpty()) {
		%>
		<h3 style="color: red">
			<%=message%>
		</h3>
		<%
		}
		%>
		<%
		Iterator<EmpBean> data = dataList.listIterator();
		%>
		<table>
		
		<tr>
		<th>ID</td>
		<th>Name</td>
		<th>DOB</td>
		<br>
		</tr>
		
		<%
		while (data.hasNext()) {
		%><% EmpBean emp=data.next();%>
		<tr> <hr></tr> 
			<tr>
			<br>
				<td><%=emp.getId()%></td>
				<td><%=emp.getName()%></td>
				<td><%=emp.getDob() %></td>
			</tr>
		</table>
		<%
		}
		%>
	</form>
	</fieldset>
</body>
</html>