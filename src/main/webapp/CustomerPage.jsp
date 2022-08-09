<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

	<h1>Customer Data</h1>

	<label>First Name : </label> ${cus.fname }
	<br>

	<label>Last Name : </label> ${cus.lname }
	<br>

	<label>Email : </label> ${cus.email }
	<br>

	<c:url value="CustomerForm.jsp" var="theURL">
		<c:param name="passedParam" value="passed value" />
	</c:url>
	<c:import url="${theURL }" />

</body>
</html>