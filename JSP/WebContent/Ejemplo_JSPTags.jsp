<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%

	String[] alumnos = {"Antonio", "Sandra", "María", "Paco"};

	pageContext.setAttribute("alumnos", alumnos);

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:forEach var="alumno" items="${alumnos}">
	
		${alumno} <br>
		
	
	</c:forEach>

</body>
</html>