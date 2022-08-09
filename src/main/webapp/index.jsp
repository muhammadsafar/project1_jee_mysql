<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Add Form</h3>
	<form action="ProccessServlet" method="post">
		<label>Name : </label> <input type="text" name="name"> <br>
		<label>NIP : </label> <input type="text" name="nip"> <br>
		<label>Age : </label> <input type="text" name="age"> <br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>