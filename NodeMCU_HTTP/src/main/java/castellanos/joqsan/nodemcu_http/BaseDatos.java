package castellanos.joqsan.nodemcu_http;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BaseDatos {
	
	public BaseDatos() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		cn = DriverManager.getConnection(url, user, pass);
	}
	
	public int insertar(ArrayList<Object> datos) throws Exception {
		
		ps = cn.prepareStatement("INSERT INTO peliculas VALUES (NULL, ?, ?, ?, ?, NULL)");
		
		ps.setString(1, datos.get(0).toString());
		ps.setString(2, datos.get(1).toString());
		ps.setString(3, datos.get(2).toString());
		ps.setString(4, datos.get(3).toString());
		
		return ps.executeUpdate();
	}
	
	public int actualizar(ArrayList<Object> datos) throws Exception {
		
		ps = cn.prepareStatement("UPDATE peliculas SET nombre = ?, estudio = ?, agno = ?, genero = ? WHERE id_pelicula = ?");
		
		ps.setString(1, datos.get(0).toString());
		ps.setString(2, datos.get(1).toString());
		ps.setString(3, datos.get(2).toString());
		ps.setString(4, datos.get(3).toString());
		ps.setString(5, datos.get(4).toString());
		
		return ps.executeUpdate();
	}
	
	public ArrayList<Object> buscar(int id) throws Exception {
		
		ps = cn.prepareStatement("SELECT * FROM peliculas WHERE id_pelicula = ?");
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		
		ArrayList<Object> registro = new ArrayList<Object>();
		registro.add(rs.getInt("id_pelicula"));
		registro.add(rs.getString("nombre"));
		registro.add(rs.getString("estudio"));
		registro.add(rs.getInt("agno"));
		registro.add(rs.getString("genero"));
		
		return registro;
	}
	
	public int eliminar(int id) throws Exception {
		
		ps = cn.prepareStatement("DELETE FROM peliculas WHERE id_pelicula = ?");
		ps.setInt(1, id);
		
		return ps.executeUpdate();
	}
	
	private Connection cn;
	private PreparedStatement ps;
	
	private final String url = "jdbc:mysql://sql5.freemysqlhosting.net:3306/sql5718397";
	private final String user = "sql5718397";
	private final String pass = "MgNIwSeLGG";
}
