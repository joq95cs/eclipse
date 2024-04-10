package com.joqsan.JavaMQTT;

import java.util.UUID;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.*;

public class Sub {
	
	public static void main(String[] args) throws Exception {
		
        String broker = "tcp://test.mosquitto.org:1883"; //Se define la direccion del broker
        String id = UUID.randomUUID().toString(); //Se genera un id unico para el cliente
        
        System.out.println("ID Cliente: " + id);

        MqttClient cliente = new MqttClient(broker, id, new MemoryPersistence()); //Se crea un cliente, pasandole el broker, el id y una instancia de MP
        
        MqttConnectOptions opciones = new MqttConnectOptions(); //Se crea una instancia para definir las opciones de conexion
        opciones.setAutomaticReconnect(true);
        opciones.setCleanSession(true);
        opciones.setConnectionTimeout(10);
        cliente.connect(opciones);
        System.out.println("Conexion exitosa al broker: " + broker);

        String topico = "castellanos/joqsan/#"; //Definimos el topico
        cliente.subscribe(topico, 1); //Nos suscribimos al cliente con QoS no. 1
        System.out.println("Suscripcion exitosa al topico: " + topico);

        cliente.setCallback(new MqttCallback() {
        	
        	@Override
        	public void connectionLost(Throwable t) {
        		
        		System.out.println("Conexión perdida: " + t.getMessage());
        	}

        	@Override
        	public void messageArrived(String topico, MqttMessage mensaje) throws Exception {
        		
        		System.out.println("\nMENSAJE RECIBIDO");
        		System.out.println("  Tema: " + topico);
        		System.out.println("  Contenido: " + new String(mensaje.getPayload()));
        	}
        	
        	@Override
        	public void deliveryComplete(IMqttDeliveryToken token) {}
        	
        });

        while(true) {
        	
        	Thread.sleep(1000); 
        }
    }
}
