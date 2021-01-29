<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

	String ciudad_favorita = request.getParameter("ciudad_favorita");

	//Crear la cookie
	
	Cookie cookie = new Cookie("agencia_viajes.ciudad_favorita", ciudad_favorita);
	
	// Vida de la cookie
	
	cookie.setMaxAge(365*24*60*60); //Un año de duración
	
	// Enviar a usuario
	
	response.addCookie(cookie);

%>

Gracias por enviar tus preferencias

<br>

<a href="AgenciaViajes.jsp">Ir a la agencia de viajes</a>

</body>
</html>