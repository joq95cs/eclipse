<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">

	.cabecera {
	
		font-size: 1.2em;
		font-weight: bold;
		color: #FFFFFF;
		background-color: #08088A;
		text-align: center;
	
	}
	
	.filas {
	
		text-align: center;
		background-color: #5882FA;
	
	}
	
	table {
	
		float: left;
	
	}
	
	#contenedor {
	
		margin-left: 1000px;
	
	}

</style>

</head>

<body>

	<table>
	
		<tr>
		
			<td class="cabecera">Código Artículo</td>
			<td class="cabecera">Sección</td>
			<td class="cabecera">Nombre Artículo</td>
			<td class="cabecera">Fecha</td>
			<td class="cabecera">Precio</td>
			<td class="cabecera">Importado</td>
			<td class="cabecera">País de Origen</td>
			<td class="cabecera">Acción</td>
			
		</tr>
		
		<c:forEach var="p" items="${lista_productos}">
		
			<!-- Link para cada producto con su campo clave -->
			
			<c:url var="link1" value="ControladorProductos">
			
				<c:param name="instruccion" value="cargar"></c:param>
				<c:param name="codigo_articulo" value="${p.codigo_articulo}"></c:param>
			
			</c:url>
			
			<!-- Link para eliminar cada registro con su campo clave -->
			
			<c:url var="link2" value="ControladorProductos">
			
				<c:param name="instruccion" value="eliminar"></c:param>
				<c:param name="codigo_articulo" value="${p.codigo_articulo}"></c:param>
			
			</c:url>
		
			<tr>
			
				<td class="filas">${p.codigo_articulo}</td>
				<td class=" filas">${p.seccion}</td>
				<td class="filas">${p.nombre_articulo}</td>
				<td class="filas">${p.fecha}</td>
				<td class="filas">${p.precio}</td>
				<td class="filas">${p.importado}</td>
				<td class="filas">${p.pais_origen}</td>
				<td class="filas"><a href="${link1}">Actualizar</a>&nbsp;<a href="${link2}">Eliminar</a></td>
			
			</tr>
			
		</c:forEach>
	
	</table>
	
	<div id="contenedor">
	
		<input type="button" value="Insertar registro" onclick="window.location.href='InsertaProducto.jsp'">
		
	</div>

</body>
</html>