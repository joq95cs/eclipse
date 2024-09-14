package castellanos.joqsan.MQTT_Bomba;

import java.sql.*;

public class DB {
	
	public DB(String url, String user, String password) {
		
		this.user = user;
		this.password = password;
		
		connect(url);
	}
	
	private void connect(String url) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(url, user, password);
			
		} catch(Exception ex) {
			
			System.err.println("ERROR DE CONEXIÓN A LA BASE DE DATOS");
		}
	}
	
	public void insert(String sql, String valor) {
		
		try {
		
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, valor);
			ps.executeUpdate();
			
		} catch(Exception ex) {
			
			ex.printStackTrace();
		}
	}
	
	private Connection cn;
	private String user;
	private String password;
}
