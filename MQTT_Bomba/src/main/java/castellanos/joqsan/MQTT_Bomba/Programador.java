package castellanos.joqsan.MQTT_Bomba;

public class Programador extends Thread {
	
	public Programador(int opcion, double temp, double hum, int segundos, MQTT_Pub mqtt, DB db) {
		
		this.opcion = opcion;
		this.temp = temp;
		this.hum = hum;
		this.segundos = segundos;
		this.mqtt = mqtt;
		this.db = db;
	}
	
	public void run() {
		
		while(true) {
			
			try {
				
				Thread.sleep(500);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			if(opcion == 3) {
				
				if(MQTT_SubTemp.temperatura != temp) {
					
					continue;
				}
				
				new Temporizador(segundos, 0, mqtt, 1, db).start();
				break;
				
			} else {
				
				if(MQTT_SubHum.humedad != hum) {
					
					continue;
				}
				
				//System.out.println("Aqui ando");
				new Temporizador(segundos, 0, mqtt, 1, db).start();
				break;
			}
		}
	}
	
	private int opcion, segundos;
	private double  temp, hum;
	private MQTT_Pub mqtt;
	private DB db;
}
