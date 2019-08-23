<!-- This page shows the different available option to logged in admin -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Property.css" />
</head>
<script>
	
</script>
<body>
	<h1>Welcome admin!!!</h1>
	<form action="AdminServlet" method="post">
		<table style="width: 500px; height: 330px" class="center">
			<tr>
				<td><label>Add New User</label></td>
				<td><input type="submit" value="Click Here" name="button1"></td>
			</tr>
			<tr>
				<td><label>Delete User</label></td>
				<td><input type="text" name="deleteuser"
					placeholder="Enter Userid You want to delete" size="35"></td>
				<td><input type="submit" value="Click Here" name="button2"></td>
			</tr>
			<tr>
				<td><label>Display List Of User</label></td>
				<td><input type="submit" value="Click Here" name="button3"></td>
			</tr>
			<tr>
				<td><label>Grant Permission To Valid Users</label></td>
				<td><input type="submit" value="Click Here" name="button4"></td>
			</tr>
			<tr>
				<td>
					</form>
					<form action="ApplyLeave" method="post">
						<label>Apply for leave</label>
				</td>
				<td><input type="submit" value="Click Here" name="button5"></td>
			</tr>
			<tr>
				<td><label>Check Leave Status</label></td>
				<td><input type="submit" value="Click Here" name="checkstatus"></td>
			</tr>
		</table>
	</form>
	<form action="index.jsp">
		<input type="submit" value="Logout" class="submit"
			style="margin-left: 350px; margin-top: 10px">
	</form>
	<br>
	<br> <
</body>

</body>