<html>

<body>

	<h1>Objetos predefinidos</h1>
	
	Petici�n datos del navegador: <%= request.getHeader("User-Agent") %>
	
	<br>
	
	Petici�n idioma utilizado: <%= request.getLocale() %>


</body>

</html>