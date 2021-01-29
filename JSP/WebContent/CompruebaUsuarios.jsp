<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ page import = "java.sql.*" %>

<%

	String usuario = request.getParameter("usuario");
	
	String contra = request.getParameter("contra");
	
	Class.forName("com.mysql.jdbc.Driver");
	
	try {
	
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_jsp?serverTimezone=UTC&useSSL=false", "root", "");
		
		PreparedStatement cp = cn.prepareStatement("SELECT * FROM USUARIOS WHERE Usuario = ? AND Contrasena = ?");
		
		cp.setString(1, usuario);
		
		cp.setString(2, contra);
		
		ResultSet rs = cp.executeQuery();
		
		if(rs.absolute(1)) {
			
			out.println("Acceso correcto");
			
		} else {
			
			out.println("Datos incorrectos");
			
		}
		
	} catch(Exception e) {
		
		out.println("Ha habido un error");
		
	}
	
%>

</body>
</html>