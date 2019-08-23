<!-- This page is the leave form to be filled by admin  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href="Property.css" />
<body>
	<form action="ApplyLeave" method="post">
		<h3 align="center">
			<u>Apply For Leave</u>
		</h3>
		<br>
		<hr style="border: 1px solid black;">
		<br>
		<div class="center" align="center"
			style="border: 2px solid black; width: 400px; height: 200px;">
			<label>Reason</label> <select name="leavereasons">
				<option value="vacation">Vacation</option>
				<option value="sick">Sick</option>
				<option value="casual">Casual</option>
			</select><br>
			<hr style="border: 1px solid black;">
			<label>Start Date</label> <input type="date" name="startdate"
				placeholder="YYYY-MM-DD" /><br>
			<hr style="border: 1px solid black;">
			<label>Number Of Days</label> <input type="text" name="count" /><br>
			<hr style="border: 1px solid black;">
			<input type="submit" value="Submit" name="button1" class="submit" />
		</div>
	</form>
	</div>
</body>
</html>