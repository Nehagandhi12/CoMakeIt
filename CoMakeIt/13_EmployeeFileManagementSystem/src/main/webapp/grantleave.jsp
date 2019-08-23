<!-- Displays the list of admin or managers who have requested to the logged in manager for a leave -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List" import="ManagerValid.Leave"
	import="ManagerValid.ManagerServlet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: #E7BE77">
	<table border="2" style="border: 2px solid black; width: 100%">
		<a href=manager.jsp>Go Back</a>
		<form action="ManagerServlet" method="post">
			<%
				out.println("The following is the list of employees");
				List<Leave> list = (List<Leave>) request.getAttribute("listPersons");
			%>
			<%
				for (Leave b : list) {
			%>
			<tr>
				<td><%=b.getLeaveid()%></td>
				<td><%=b.getEmpid()%></td>
				<td><%=b.getStartdate()%></td>
				<td><%=b.getLeavereason()%></td>
				<td><%=b.getNumberofdays()%></td>
				<td><%=b.getStatus()%></td>
				<td><a href=ManagerServlet?leaveid=
					<%out.print(b.getLeaveid());%>&status=accept>>accept</a></td>
				<td><a href=ManagerServlet?leaveid=
					<%out.print(b.getLeaveid());%>&status=reject>>reject</a></td>
				</td>
			</tr>
			<%
				}
			%>
		</form>
		</form>
	</table>
</body>
</html>