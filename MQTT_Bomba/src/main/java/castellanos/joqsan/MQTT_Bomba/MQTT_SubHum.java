package castellanos.joqsan.MQTT_Bomba;

import java.util.UUID;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MQTT_SubHum extends Thread {
	
	public MQTT_SubHum(String broker, String topico) throws Exception {
		
		this.broker = broker;
		this.topico = topico;
		id = UUID.randomUUID().toString();
		int status = conectar();
		
		if(status != 0) {
			
			throw new Exception("Error de conexion");
		}
	}
	
	public int desconectar() {
		
		try {
			
			cliente.disconnect();
			
		} catch (Exception e) {
			
			return 1;
		}
		
		return 0;
	}
	
	private int conectar() {
		
		try {
			
			cliente = new MqttClient(broker, id, new MemoryPersistence());
			MqttConnectOptions opciones = new MqttConnectOptions(); //Se crea una instancia para definir las opciones de conexion
	        opciones.setAutomaticReconnect(true);
	        opciones.setCleanSession(true);
	        opciones.setConnectionTimeout(10);
	        cliente.connect(opciones);
	        cliente.subscribe(topico, 0);
	        
	        cliente.setCallback(new MqttCallback() {
	        	
	        	@Override
	        	public void connectionLost(Throwable t) {}

	        	@Override
	        	public void messageArrived(String topico, MqttMessage mensaje) throws Exception {
	        		
	        		humedad = Double.parseDouble(new String(mensaje.getPayload()));
	        		App.marco.getLamina().getEtiquetas(1).setText("Humedad de tierra: " + humedad);
	        	}
	        	
	        	@Override
	        	public void deliveryComplete(IMqttDeliveryToken token) {}
	        	
	        });
	        
		} catch(Exception e) {
			
			return 1;
		}
		
		return 0;
	}
	
	
	public void run() {
		
		try {
			
			Thread.sleep(500);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	private String broker;
	private String id;
	private String topico;
	private MqttClient cliente;
	
	public static double humedad = 0;
}