<!-- The login page which redirects to either user or admin or error or manager pages after verification -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<link rel="stylesheet" type="text/css" href="Property.css" />
<script>
	function validLogin() {
		var username = document.form.uid.value;
		var password = document.form.pass.value;

		if (username == null || username == "") {
			alert("Username cannot be blank");
			return false;
		} else if (password == null || password == "") {
			alert("Password cannot be blank");
			return false;
		}
	}
</script>
</head>
<body>
	<marquee>
		<i><h1>ComakeIT</h1></i>
	</marquee>
	<h2 class="center">
		<u>Employee File Management System</u>
	</h2>
	<form name="form" onsubmit="return validLogin();"
		action="ValidateServlet" method="post">
		<b style="color: black">Login Here-----></b><br>
		<table class="center">
			<tr>
				<td><b>Id</b></td>
				<td><input type="text" name="uid" size="30px"></td>
			</tr>
			<tr>
				<td><b>Password</b></td>
				<td><INPUT type="password" name="pass" size="30px"></td>
			</tr>
			<tr>
				<td><input type="submit" class="submit" value="Login"></td>
				<td><input type="reset" class="submit" value="Reset"></td>
		</table>
		<br /> <br />
	</form>
</body>
</html>