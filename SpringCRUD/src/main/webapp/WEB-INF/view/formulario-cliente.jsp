<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css">
</head>
<body>

	<form:form action="insertarActualizarCliente" modelAttribute="cliente" method="POST">
	
		<form:hidden path="id"></form:hidden>
		
		<table>
		
			<tr>
				
				<td>Nombre</td>
				<td><form:input path="nombre"></form:input></td>
			</tr>
			
			<tr>
				
				<td>Apellido</td>
				<td><form:input path="apellido"></form:input></td>
			</tr>
			
			<tr>
				
				<td>Email</td>
				<td><form:input path="email"></form:input></td>
			</tr>
			
			<tr>
			
				<td colspan="1"><input type="submit" value="Aceptar"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>