<!-- This page shows the different functionalities that can be performed by a manager -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Property.css" />
</head>
<body>
	<h1>Welcome Manager!!!</h1>
	<form action="ApplyLeaveServlet" method="post">
		<table class="center">
			<tr>
				<td><label>Apply for leave</label></td>
				<td><input type="submit" value="Click Here" class="submit"  name="button10"></td>
			</tr>
			<tr>
				<td><label>Grant leave</label></td>
				<td><input type="submit" value="Click Here" class="submit" name="button11"></td>
			</tr>
			<tr>
				<td><label>Check Leave Status</label></td>
				<td><input type="submit" value="Click Here" class="submit" name="checkstatus"></td>
			</tr>
		</table>
	</form>
	<form action="index.jsp">
		<input type="submit" value="Logout" class="submit"
			style="margin-left: 350px; margin-top: 30px">
	</form>
</body>
</html>
