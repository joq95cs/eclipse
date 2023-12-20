package crud.conexion;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Conexion
 */
@WebServlet("/Conexion")
public class Conexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Conexion() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String db_url = "jdbc:mysql://localhost:3306/spring_crud?useSSL=false";
		String db_username = "root";
		String db_password = "";
		
		String driver = "com.mysql.cj.jdbc.Driver";
		
		try {
			
			PrintWriter out = response.getWriter();
			out.print("BD: " + db_url);
			Class.forName(driver);
			
			Connection conexion = DriverManager.getConnection(db_url, db_username, db_password);
			out.print(" / CONECTADO");
			conexion.close();
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}