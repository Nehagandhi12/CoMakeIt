<!-- This page gives a view of different functionalities available to the user -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Property.css" />
<script>
	
</script>
<meta charset="ISO-8859-1">
</head>
<body>
	<form name="form" action="UserServlet" method="post">
		<h1>Welcome User!!!</h1>
		<table class="center">
			<tr>
				<td><label>Update Address</label></td>
				<td><input type="text" name="updateaddress"
					placeholder="Enter address"></td>
				<td><input type="submit" value="Submit" class="submit" name="button1"></td>
			</tr>
			<tr>
				<td><label>Change Password</label></td>
				<td><input type="text" name="changepassword"
					placeholder="enter password"></td>
				<td><input type="submit" class="submit" value="Submit" name="button2"></td>
			</tr>
		</table>
	</form>
	<form action="index.jsp">
		<input type="submit" value="Logout" class="submit"
			style="margin-left: 440px; margin-top: 30px">
	</form>
</body>
</html>