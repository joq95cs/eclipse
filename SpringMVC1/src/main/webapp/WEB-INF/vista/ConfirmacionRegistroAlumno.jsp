<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmacion de registro</title>
</head>
<body>

	<p>El alumno con nombre <strong>${alumno.nombre}</strong>, apellido <strong>${alumno.apellido}</strong>, edad <strong>${alumno.edad}</strong>, email <strong>${alumno.email}</strong> y CP <strong>${alumno.codigoPostal}</strong> se ha registrado con éxito...</p>
	<p>La asignatura elegida es <strong>${alumno.optativa}</strong>...</p>
	<p>La sede elegida es <strong>${alumno.sede}</strong>...</p>
	<p>Los idiomas elegidos son <strong>${alumno.idiomas}</strong>...</p>
</body>
</html>