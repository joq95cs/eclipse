package hibernate1;

import java.sql.Connection;
import java.sql.DriverManager;

public class PruebaConexion {
	
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://sql3.freemysqlhosting.net:3306/sql3489103?useSSL=false";
		String user = "sql3489103";
		String pass = "1zgISGtI5U";
		
		try {
			
			System.out.println("Intentando conectar a " + url);
			Connection connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Conexión exitosa");
			
		} catch(Exception ex) {
			
			ex.printStackTrace();
		}
	}
}
