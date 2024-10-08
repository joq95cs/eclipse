package com.joqsan.MavenJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
	
    public static void main( String[] args ) {
    	
    	try {
    		
    		Connect connect = new Connect("practica_blog", "root", "");
    		ResultSet rs = connect.getResultSet("SELECT titulo, thumb FROM articulos");
    		
    		while(rs.next()) {
    			
    			String titulo = rs.getString("titulo");
    			String thumb = rs.getString("thumb");
    			
    			System.out.println("Titulo: " + titulo);
    			System.out.println("Thumb: " + thumb);
    			System.out.println();
    		}
    				
    	} catch (Exception e) {
    		
    		e.printStackTrace();
    	}
    }
}

class Connect {
	
	public Connect(String db_name, String db_user, String db_pass) throws SQLException {
		
		this.db_name = db_name;
		this.db_user = db_user;
		this.db_pass = db_pass;
		
		cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, db_user, db_pass);		
		st = cn.createStatement();	
	}
	
	public Connection getConnection() throws SQLException {
		
		return cn;
	}
	
	public Statement getStatement() throws SQLException {
		
		return st;
	}
	
	public ResultSet getResultSet(String sql) throws SQLException {
		
		return st.executeQuery(sql);
	}
		
	public void close() throws SQLException {
		
		cn.close();
		st.close();
		rs.close();
	}
	
	private String db_name;
	private String db_user;
	private String db_pass;
	private Connection cn;
	private Statement st;
	private ResultSet rs;
}
