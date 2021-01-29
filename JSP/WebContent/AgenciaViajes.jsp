<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Agencia de viajes</h1>

<%

	//Valor por defecto
	
	String ciudad_favorita = "Madrid";

	//Lee la cookie de la petición del navegador
	
	Cookie[] cookies = request.getCookies();
	
	//Buscar las preferencias, la ciudad favorita
	
	if(cookies != null) {
		
		for(Cookie c: cookies) {
			
			if("agencia_viajes.ciudad_favorita".equals(c.getName())) {
				
				ciudad_favorita = c.getValue();
				
				break;
				
			}
			
		}
		
	}

%>

<h3>Vuelos a <%= ciudad_favorita %></h3>

<p>Esto es un texto de ejemplo</p>
<p>Esto es un texto de ejemplo</p>
<p>Esto es un texto de ejemplo</p>

<h3>Hoteles en <%= ciudad_favorita %></h3>

<p>Esto es un texto de ejemplo</p>
<p>Esto es un texto de ejemplo</p>
<p>Esto es un texto de ejemplo</p>

<h3>Ofertas en restaurantes en <%= ciudad_favorita %></h3>

<p>Esto es un texto de ejemplo</p>
<p>Esto es un texto de ejemplo</p>
<p>Esto es un texto de ejemplo</p>

</body>
</html>