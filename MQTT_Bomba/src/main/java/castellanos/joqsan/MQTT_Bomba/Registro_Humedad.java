package castellanos.joqsan.MQTT_Bomba;

public class Registro_Humedad extends Thread {
	
	public Registro_Humedad() {
		
		db = new DB("jdbc:mysql://localhost:3306/bitacora_bomba", "root", "");
	}
	
	public void run() {
		
		try {
			
			while(true) {
				
				Thread.sleep(1000 * segs);
				
				db.insert("INSERT INTO humedad (humedad_medida) VALUES (?)", MQTT_SubHum.humedad + "");
				//System.out.println("INSERTADO");
			}
		
		} catch(Exception ex) {
			
			ex.printStackTrace();
		}
		
	}
	
	private DB db;
	private final int segs = 10;
}
