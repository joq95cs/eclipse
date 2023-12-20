<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Actualizar registro</h1>

	<form action="ControladorProductos" method="get">
	
	<input type="hidden" name="instruccion" value="actualizar">
	
	<input type="hidden" name="codigo_articulo" value="${producto_actualizar.codigo_articulo}">

		<table>
			
			<tr> <td>Sección</td> <td><input type="text" name="seccion" value="${producto_actualizar.seccion}"></td> </tr>
			
			<tr> <td>Nombre Artículo</td> <td><input type="text" name="nombre_articulo" value="${producto_actualizar.nombre_articulo}"></td> </tr>
			
			<tr> <td>Fecha</td> <td><input type="text" name="fecha" value="${producto_actualizar.fecha}"></td> </tr>
			
			<tr> <td>Precio</td> <td><input type="text" name="precio" value="${producto_actualizar.precio}"></td> </tr>
			
			<tr> <td>Importado</td> <td><input type="text" name="importado" value="${producto_actualizar.importado}"></td> </tr>
			
			<tr> <td>País de Origen</td> <td><input type="text" name="pais_origen" value="${producto_actualizar.pais_origen}"></td> </tr>
			
			<tr> <td><input type="submit" value="Actualizar" name="bt1"></td> <td><input type="button" value="Restablecer" name="bt2"></td></tr>
		
		</table>
	
	</form>

</body>
</html>