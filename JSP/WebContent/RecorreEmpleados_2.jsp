<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.*, java.sql.*, jsp_tags.*" %>

<%

	ArrayList<Empleado> datos = new ArrayList<Empleado>();

	Class.forName("com.mysql.jdbc.Driver"); //Es para encontrar el driver

	try {
		
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_jsp?serverTimezone=UTC&useSSL=false", "root", "");
		
		Statement st = cn.createStatement();
		
		String instruccion = "SELECT * FROM EMPLEADOS";
		
		ResultSet rs = st.executeQuery(instruccion);
		
		while(rs.next()) {
			
			datos.add(new Empleado(rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5)));
			
		}
		
		rs.close();
		
		cn.close();
		
	} catch(Exception e) {
		
		out.println("Ha sucedido un error");
		
		e.printStackTrace();
		
	}
	
	pageContext.setAttribute("empleados", datos);


%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">

	.cabecera {
	
		font-weight: bold;
	
	}

</style>
</head>
<body>

	<table border="1">
	
	<tr class = "cabecera"><td>Nombre</td><td>Apellido</td><td>Puesto</td><td>Salario</td><td>Bonus</td></tr>

	<c:forEach var="empleado" items="${empleados}">
	
		<tr>
	
			<td>${empleado.nombre}</td><td>${empleado.apellido}</td><td>${empleado.puesto}</td>
			
			<td><c:choose>
			
				<c:when test="${empleado.salario<40000}">
				
					${empleado.salario+5000}
				
				</c:when>
				
				<c:when test="${empleado.salario>40000 && empleado.salario<=50000}">
				
					${empleado.salario+2000}
				
				</c:when>
				
				<c:otherwise>
				
					${empleado.salario}	
				
				</c:otherwise>
			
			</c:choose>
			
			</td>
			
			<td><c:choose>
			
				<c:when test="${empleado.salario<40000}">
				
					5000
				
				</c:when>
				
				<c:when test="${empleado.salario>40000 && empleado.salario<=50000}">
				
					2000
				
				</c:when>
				
				<c:otherwise>
				
					NO
				
				</c:otherwise>
			
			</c:choose>
			
			
			</td>
	
		</tr>
	
	</c:forEach>
	
	</table>

</body>
</html>