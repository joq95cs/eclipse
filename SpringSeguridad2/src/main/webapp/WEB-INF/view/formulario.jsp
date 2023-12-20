<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3 style="text-align:center">Login</h3>

<form:form action="${pageContext.request.contextPath}/login" method="POST">

	<p>
	
		User: <input type="text" name="username">
		<br><br>
		Pass: <input type="password" name="password">
	</p>
	
	<input type="submit" value="Login">

</form:form>

</body>
</html>