package sockets;

import javax.swing.*;

import java.awt.*;

import java.io.*;

import java.net.*;

public class Servidor  {

	public static void main(String[] args) {
		
		MarcoServidor mimarco=new MarcoServidor();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}	
}

class MarcoServidor extends JFrame implements Runnable {
	
	public MarcoServidor(){
		
		setSize(280,350);				
			
		JPanel milamina= new JPanel();
		
		milamina.setLayout(new BorderLayout());
		
		areatexto=new JTextArea();
		
		areatexto.setEditable(false);
		
		milamina.add(new JScrollPane(areatexto),BorderLayout.CENTER);
		
		add(milamina);
		
		setVisible(true);
		
		setLocationRelativeTo(null);
		
		Thread mihilo = new Thread(this);
		
		mihilo.start();
		
	}
	
	public void run() {
		
		try {
			
			ServerSocket servidor = new ServerSocket(9999);
			
			while(true) {
			
				Socket misocket = servidor.accept();
				
				DataInputStream flujo_entrada = new DataInputStream(misocket.getInputStream());
				
				String mensaje_texto = flujo_entrada.readUTF();
				
				areatexto.append(mensaje_texto + "\n"); 
				
				flujo_entrada.close();
				
				misocket.close();
			
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	private	JTextArea areatexto;
}
