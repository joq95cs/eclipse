<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "org.json.JSONObject"%>
<%@ page import = "org.hibernate.cfg.*"%>
<%@ page import = "org.hibernate.*"%>
<%@ page import = "castellanos.joqsan.nodemcu_http.Pelicula"%>

<%

	response.setHeader("Access-Control-Allow-Origin", "*");

	SessionFactory factory = new Configuration().configure("castellanos/joqsan/nodemcu_http/hibernate.cfg.xml").addAnnotatedClass(Pelicula.class).buildSessionFactory();
	Session sesion = factory.openSession();
	
	sesion.beginTransaction();
	
	try {
		
		Pelicula pelicula = new Pelicula(
				
				request.getParameter("nombre"),
				request.getParameter("estudio"),
				Integer.parseInt(request.getParameter("agno")),
				request.getParameter("genero")
		);
		
		if(!pelicula.validar()) {
			
			throw new Exception("Empty fields");
		}
		
		sesion.persist(pelicula);
		sesion.getTransaction().commit();
		
		JSONObject json = new JSONObject();
	    json.put("estado", "correcto");
	    response.getWriter().write(json.toString());
		
	} catch(Exception ex) {
		
		sesion.getTransaction().rollback();
		
		JSONObject json = new JSONObject();
	    json.put("estado", "error");
	    response.getWriter().write(json.toString());
	    
	    ex.printStackTrace();
	    
	} finally {
		
		factory.close();
		sesion.close();
	}
%>