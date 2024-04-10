package com.joqsan.JavaMQTT;

import java.util.*;
import java.util.concurrent.Callable;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Pub {
	
    public static void main( String[] args ) throws Exception {
    	
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

        String topico = "castellanos/joqsan/test"; // Tema al que se publicará el mensaje
        String contenido = "Estamos probando..."; // Contenido del mensaje
        MqttMessage mensaje = new MqttMessage(contenido.getBytes());
        mensaje.setQos(1);
        cliente.publish(topico, mensaje);
        System.out.println("Topico: " + topico);
        System.out.println("Mensaje: " + contenido);
        System.out.println("Publicacion exitosa");

        cliente.disconnect();
        System.out.println("Desconectado del broker");
        System.exit(0);
    }
}

