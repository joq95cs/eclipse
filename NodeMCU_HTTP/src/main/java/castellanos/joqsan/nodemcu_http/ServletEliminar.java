package castellanos.joqsan.nodemcu_http;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/eliminar")
public class ServletEliminar extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
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
	}
}