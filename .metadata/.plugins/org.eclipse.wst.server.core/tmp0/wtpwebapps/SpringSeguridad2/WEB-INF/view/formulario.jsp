<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>

<body>

<div class="container">

	<div class="row mt-2">
	
		<h3 class="text-center">P&aacute;gina de login</h3>
	</div>
	
	<div class="row mt-2">
	
		<form:form action="${pageContext.request.contextPath}/login" method="POST" class="form-group">
			
			<table class="table table-bordered table-striped">
			
				<tr>
				
					<th><label for="username">User:</label></th>
					<td><input type="text" name="username" class="form-control"></td>
				</tr>
				
				<tr>
				
					<th><label for="password">Password:</label></th>
					<td><input type="password" name="password" class="form-control"></td>
				</tr>
				
				<tr>
				
					<td colspan=2><div class="text-center"><button type="submit" class="btn btn-success">Login</button></div></td>
				</tr>
			</table>
		</form:form>
	</div>
		
	<div class="row mt-2">
		
		<c:if test="${param.error!=null}">
				
			<strong class="text-danger text-center">¡Usuario o contrase&ntilde;a incorrectos!</strong>
		</c:if>
		
		<c:if test="${param.logout!=null}">
				
			<strong class="text-primary text-center">¡Sesi&oacute;n cerrada!</strong>
		</c:if>
	</div>
</div>
</body>
</html>