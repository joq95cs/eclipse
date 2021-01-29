<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Insertar registro</h1>

	<form action="ControladorProductos" method="get">
	
	<input type="hidden" name="instruccion" value="insertar">

		<table>
		
			<tr> <td>Código Artículo</td> <td><input type="text" name="codigo_articulo"></td> </tr>
			
			<tr> <td>Sección</td> <td><input type="text" name="seccion"></td> </tr>
			
			<tr> <td>Nombre Artículo</td> <td><input type="text" name="nombre_articulo"></td> </tr>
			
			<tr> <td>Fecha</td> <td><input type="text" name="fecha"></td> </tr>
			
			<tr> <td>Precio</td> <td><input type="text" name="precio"></td> </tr>
			
			<tr> <td>Importado</td> <td><input type="text" name="importado"></td> </tr>
			
			<tr> <td>País de Origen</td> <td><input type="text" name="pais_origen"></td> </tr>
			
			<tr> <td><input type="submit" value="Enviar" name="bt1"></td> <td><input type="button" value="Restablecer" name="bt2"></td></tr>
		
		</table>
	
	</form>

</body>
</html>