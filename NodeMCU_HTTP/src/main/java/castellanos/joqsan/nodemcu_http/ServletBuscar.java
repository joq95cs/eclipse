
package castellanos.joqsan.nodemcu_http;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/buscar")
public class ServletBuscar extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
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
	}
}