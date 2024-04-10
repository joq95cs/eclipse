package com.joqsan.MQTT_Led;

public class App {
	
	public static void main(String[] args) {
		
		try {
			
			new Marco().setVisible(true);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
