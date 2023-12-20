<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Lista de clientes</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css">
</head>
<body>

	<h1>Lista de clientes</h1>

	<table>
	
		<tr>
		
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Email</th>
			
		</tr>
		
		<c:forEach var="cliente" items="${clientes}">
		
			<c:url var="actualizar" value="/clientes/editarCliente">
			
				<c:param name="id" value="${cliente.id}"></c:param>
			</c:url>
			
			<c:url var="eliminar" value="/clientes/eliminarCliente">
			
				<c:param name="id" value="${cliente.id}"></c:param>
			</c:url>
		
			<tr>
			
				<td>${cliente.nombre}</td>
				<td>${cliente.apellido}</td>
				<td>${cliente.email}</td>
				
				<td><a href="${actualizar}"><input type="button" value="Actualizar"></a></td>
				<td><a href="${eliminar}"><input type="button" value="Eliminar" onclick="if(!(confirm('¿Eliminar registro?'))) return false"></a></td>
			</tr>
		</c:forEach>
	</table>
	
	<input type="button" value="Agregar cliente" onclick="window.location.href='nuevoCliente'; return false;">
	
</body>
</html>