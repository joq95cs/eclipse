package castellanos.joqsan.nodemcu_http;

import java.io.IOException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.json.JSONObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/insertar")
public class ServletInsertar extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
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
	}
}
