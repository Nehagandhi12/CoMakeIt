<!-- This page is displayed when the user logs in for the first time but goes to update address which is not allowed as the first time logged in users must change their password first -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Property.css" />
</head>
<body>
	<h1>Welcome!! Logged In For The First Time</h1>
	<h1>Excited??</h1>
	<h3>Before doing anything ,you have to change your password first</h3>
	<form action="user.jsp">
		<img
			src="data:image/png;base64,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"
			class="center"> <br /> <input type="submit" value="Click Here" class="submit"
			name="button6" style="margin-left: 200px" class="center">
	</form>
</body>
</html>