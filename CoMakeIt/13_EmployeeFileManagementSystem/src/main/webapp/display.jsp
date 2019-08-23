<!-- This page displays the list of users in 2 cases
*Just the users present in the table in the sorted order
*Secondly,the list of users who have got update permission -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List" import="ManagerValid.Leave"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="Property.css" />
<title>Insert title here</title>
</head>
<body>
	<table>
		<%
			out.println("The following is the list of employees");
			List<String> list = (List<String>) request.getAttribute("list");
		%>
		<%
			for (String b : list) {
		%>
		<tr>
			<td><%=b%></td>

			<%
				}
			%>
		
	</table>
	<form action="admin.jsp">
		<input type="submit" value="Back" class="submit"/>
	</form>
</body>
</html>