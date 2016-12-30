<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import = "com.Queries" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Updating an employee</title>
<link rel="stylesheet" href="css/style.css" >
</head>
<body>
<div id="header">
<img src="img/im.jpg" width="100%" height="100px">
</div>
<div id="sidebar">
<a href="index.html">Home</a><br>
<a href="insert.html" >Insert</a><br>
<a href="update.html">Update</a><br>
<a href="delete.html">Delete</a><br>
<a href="search.html">Search</a><br>
<a href="viewall.jsp">ViewAll</a>
</div>
<div id="main">
<% if((int)request.getAttribute("rowsAffected")==1)
{ 
%>
<h2>Details updated Successfully as shown below</h2>
<table>
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Salary</th>
	</tr>
	<tr>
		<td><%=request.getAttribute("Id") %></td>
		<td><%=request.getAttribute("Name") %></td>
		<td><%=request.getAttribute("Salary") %></td>
	</tr>
</table>
<%
} 
else
{%>
<h2>ID did not exist</h2>
<%
}
%>
</div>
</body>
</html>