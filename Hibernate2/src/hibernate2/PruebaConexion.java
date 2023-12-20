package hibernate2;

import java.sql.Connection;
import java.sql.DriverManager;

public class PruebaConexion {
	
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/hibernate?useSSL=false";
		String user = "root";
		String pass = "";
		
		try {
			
			System.out.println("Intentando conectar a " + url);
			Connection connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Conexión exitosa");
			
		} catch(Exception ex) {
			
			ex.printStackTrace();
		}
	}
}
