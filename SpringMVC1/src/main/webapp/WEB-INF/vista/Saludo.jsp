<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/recursos/estilos/estilos.css">
</head>
<body>

	<p>Hola ${param.nombre}. Bienvenido...</p>
	
	<br>
	
	<p>${mensaje}</p>
	
	<img alt="foto" src="${pageContext.request.contextPath}/recursos/img/saturno.png">
</body>
</html>