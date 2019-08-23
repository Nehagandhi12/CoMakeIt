<!-- Gets the details from the admin about the new user -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Property.css" />
</head>
<body>
	<h3>
		<b>Enter the required details of user</b>
	</h3>
	<form action="AddUserServlet" method="post">
		<table class="center">
			<tr>
				<td><label>Enter UserId</label></td>
				<td><input type="text" name="userid"></td>
			</tr>
			<tr>
				<td><label>Enter Username</label></td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td><label>Enter Address</label></td>
				<td><input type="text" name="address"></td>
			</tr>
		</table>
		<input type="submit" value="Submit the details" name="button1"
			class="submit" style="margin-left: 350px; margin-top: 30px">

	</form>
</body>
</html>