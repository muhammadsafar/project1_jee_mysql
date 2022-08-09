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
	<form action="CustomerServlet" method="post">
		<label>First Name : </label> <input type="text" name="fname" value="${cus.fname}"> <br>
		<label>Last Name : </label> <input type="text" name="lname" value="${cus.lname}"> <br>
		<label>Street : </label> <input type="text" name="street" value="${cus.street}"> <br>
		<label>City : </label> <input type="text" name="city" value="${cus.city}"> <br>
		<label>State : </label> <input type="text" name="state" value="${cus.state}"> <br>
		<label>ZipCode : </label> <input type="text" name="zipcode" value="${cus.zipcode}"> <br>
		<label>Email : </label> <input type="text" name="email" value="${cus.email}"> <br>
		<label>Password : </label> <input type="text" name="password" value="${cus.password}"> <br>
		<label>Phone : </label> <input type="text" name="phone" value="${cus.phone}"> <br>
		
		<input type="submit" value="Submit">
	</form>
	
	<%= request.getParameter("passedParam") %>

</body>
</html>