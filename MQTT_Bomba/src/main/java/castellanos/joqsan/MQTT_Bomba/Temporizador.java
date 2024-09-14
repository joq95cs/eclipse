package castellanos.joqsan.MQTT_Bomba;

public class Temporizador extends Thread {
	
	public Temporizador(int segundos, int segs, MQTT_Pub mqtt, int opcion, DB db) {
		
		this.segundos = segundos;
		this.mqtt = mqtt;
		this.opcion = opcion;
		this.segs = segs;
		this.db = db;
	}
	
	public void run() {
		
		try {
			
			if(opcion == 2) {
				
				Thread.sleep(segs * 1000);
			}
			
			App.marco.getLamina().getBotones(0).setEnabled(false);
			App.marco.getLamina().getBotones(1).setEnabled(false);
			App.marco.getLamina().getBotones(2).setEnabled(false);
			db.insert("INSERT INTO bitacora (evento_enviado) VALUES (?)", "ON");
			
			mqtt.publicar("ON");
			App.marco.getLamina().getEtiquetas(2).setText("Estado de bomba: ON");
			
			Thread.sleep(segundos * 1000);
			
			mqtt.publicar("OFF");
			App.marco.getLamina().getEtiquetas(2).setText("Estado de bomba: OFF");
			
			App.marco.getLamina().getBotones(0).setEnabled(true);
			App.marco.getLamina().getBotones(1).setEnabled(true);
			App.marco.getLamina().getBotones(2).setEnabled(true);
			db.insert("INSERT INTO bitacora (evento_enviado) VALUES (?)", "OFF");
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
	}
	
	private int segundos;
	private int segs;
	private MQTT_Pub mqtt;
	private int opcion;
	private DB db;
}
