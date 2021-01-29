package web_productos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import java.sql.*;

/**
 * Servlet implementation class ServletPruebas
 */
@WebServlet("/ServletPruebas")
public class ServletPruebas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Definir el DataSource
	
	@Resource(name="jdbc/Productos")
	
	private DataSource pool;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPruebas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Crear PrintWriter
		
		PrintWriter salida = response.getWriter();
		
		response.setContentType("text/plain");
		
		//Crear conexión con base de datos
		
		Connection cn = null;
		
		Statement st = null;
		
		ResultSet rs = null;
		
		try {
			
			String sentencia = "SELECT * FROM PRODUCTOS";
			
			cn = pool.getConnection();
			
			st = cn.createStatement();
			
			rs = st.executeQuery(sentencia);
			
			while(rs.next()) {
				
				String nombre = rs.getString(3);
				
				salida.println(nombre);
				
			}
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
