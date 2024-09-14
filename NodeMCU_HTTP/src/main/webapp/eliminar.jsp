<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "org.json.JSONObject"%>
<%@ page import = "java.util.ArrayList"%>
<%@ page import = "castellanos.joqsan.nodemcu_http.BaseDatos"%>

<%

	response.setHeader("Access-Control-Allow-Origin", "*");

	try {
		
		if(new BaseDatos().eliminar(Integer.parseInt(request.getParameter("id"))) > 0) {
			
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