<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar alumno</title>
</head>
<body>

	<form:form action="procesarFormulario" modelAttribute="alumno">
	
		<p>Nombre: <form:input path="nombre"/> <form:errors path="nombre" style="color:red;"></form:errors></p>
		<p>Apellido: <form:input path="apellido"/></p>
		<p>Edad: <form:input path="edad"/> <form:errors path="edad" style="color:red;"></form:errors></p>
		<p>Email: <form:input path="email"/> <form:errors path="email" style="color:red;"></form:errors></p>
		<p>CP: <form:input path="codigoPostal"/> <form:errors path="codigoPostal" style="color:red;"></form:errors></p>
		<p>Optativas:</p>
		<form:select path="optativa" multiple="true">
		
			<form:option value="Diseño" label="Diseño"></form:option>
			<form:option value="Inglés" label="Inglés"></form:option>
			<form:option value="Karate" label="Karate"></form:option>
			<form:option value="Canto" label="Canto"></form:option>
		</form:select>
		<br>
		<p>Querétaro<form:radiobutton path="sede" value="Queretaro"/>Uruapan<form:radiobutton path="sede" value="Uruapan"/>Toluca<form:radiobutton path="sede" value="Toluca"/></p>
		<p>Chino<form:checkbox path="idiomas" value="Chino"/>Italiano<form:checkbox path="idiomas" value="Italiano"/>Japonés<form:checkbox path="idiomas" value="Japones"/></p>
		<input type="submit" value="Enviar"/>
	</form:form>
</body>
</html>