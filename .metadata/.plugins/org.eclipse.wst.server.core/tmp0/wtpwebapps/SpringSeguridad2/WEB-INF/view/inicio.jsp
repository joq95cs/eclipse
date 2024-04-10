<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<strong>It works!</strong>
	<br>
	<strong>User:&nbsp;</strong><span><security:authentication property="principal.username"/></span>
	<br>
	<strong>Rol:&nbsp;</strong><span><security:authentication property="principal.authorities"/></span>
	<br><br>
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	<button type="submit">Logout</button>
	</form:form>
</body>
</html>