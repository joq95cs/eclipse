<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:set var="datos" value="Ana|Lopez|Directivo|75000"/>
	
	<c:set var="datosArray" value="${fn:split(datos, '|')}"/>
	
	Nombre &nbsp; <input type="text" value="${datosArray[0]}"> <br>
	
	Apellido &nbsp;<input type="text" value="${datosArray[1]}"> <br>
	
	Puesto &nbsp;<input type="text" value="${datosArray[2]}"> <br>
	
	Sueldo &nbsp;<input type="text" value="${datosArray[3]}">
	
	

</body>
</html>