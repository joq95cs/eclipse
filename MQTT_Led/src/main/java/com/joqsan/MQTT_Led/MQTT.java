package com.joqsan.MQTT_Led;

import java.util.UUID;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MQTT {
	
	public MQTT(String broker, String topico) throws Exception {
		
		this.broker = broker;
		this.topico = topico;
		id = UUID.randomUUID().toString();
		int status = conectar();
		
		if(status == 0) {
			
			//System.out.println("Conexion exitosa");
			
		} else {
			
			throw new Exception("Error de conexion");
		}
	}
	
	public void publicar(String contenido) throws Exception {
		
		try {
			
			MqttMessage mensaje = new MqttMessage(contenido.getBytes());
			mensaje.setQos(1);
			cliente.publish(topico, mensaje);
		
		} catch(Exception e) {
			
			throw new Exception();
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
	        
		} catch(Exception e) {
			
			return 1;
		}
		
		return 0; //No hubo error en la conexion
	}
	
	private String broker;
	private String id;
	private String topico;
	private MqttClient cliente;
}
