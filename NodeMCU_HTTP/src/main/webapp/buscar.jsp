<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "org.json.JSONObject"%>
<%@ page import = "java.util.ArrayList"%>
<%@ page import = "castellanos.joqsan.nodemcu_http.BaseDatos"%>

<%

	response.setHeader("Access-Control-Allow-Origin", "*");

	try {
		
		ArrayList<Object> datos = new BaseDatos().buscar(Integer.parseInt(request.getParameter("id")));
		
		JSONObject json = new JSONObject();
	    json.put("id_pelicula", datos.get(0));
	    json.put("nombre", datos.get(1));
	    json.put("estudio", datos.get(2));
	    json.put("agno", datos.get(3));
	    json.put("genero", datos.get(4));
	    
	    response.getWriter().write(json.toString());
		
	} catch (Exception e) {
		
		JSONObject json = new JSONObject();
	    json.put("estado", "error");
	    response.getWriter().write(json.toString());
		e.printStackTrace();
	}
%>