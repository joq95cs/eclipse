<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "org.json.JSONObject"%>
<%@ page import = "java.util.ArrayList"%>
<%@ page import = "castellanos.joqsan.nodemcu_http.BaseDatos"%>

<%

	response.setHeader("Access-Control-Allow-Origin", "*");

	ArrayList<Object> datos = new ArrayList<Object>();
	
	datos.add(request.getParameter("nombre"));
	datos.add(request.getParameter("estudio"));
	datos.add(request.getParameter("agno"));
	datos.add(request.getParameter("genero"));
	datos.add(request.getParameter("id"));
	
	try {
		
		if(new BaseDatos().actualizar(datos) > 0) {
			
			JSONObject json = new JSONObject();
	        json.put("estado", "correcto");
	        response.getWriter().write(json.toString());
	        
		} else {
			
			JSONObject json = new JSONObject();
	        json.put("estado", "error");
	        response.getWriter().write(json.toString());
		}
		
	} catch (Exception e) {
		
		JSONObject json = new JSONObject();
	    json.put("estado", "error");
	    response.getWriter().write(json.toString());
		e.printStackTrace();
	}
%>