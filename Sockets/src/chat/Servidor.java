package chat;

import javax.swing.*;

import java.awt.*;

import java.io.*;

import java.net.*;

import java.util.*;

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
		
		milamina.add(areatexto,BorderLayout.CENTER);
		
		add(milamina);
		
		setVisible(true);
		
		setLocationRelativeTo(null);
		
		Thread mihilo = new Thread(this);
		
		mihilo.start();
		
	}
	
	public void run() {
		
		try {
			
			ServerSocket servidor = new ServerSocket(9999);
			
			String nick, ip, mensaje;
			
			ArrayList<String> listaIp = new ArrayList<String>();
			
			PaqueteEnvio paquete_recibido;
			
			while(true) {
			
				Socket misocket = servidor.accept();
				
				ObjectInputStream paquete_datos = new ObjectInputStream(misocket.getInputStream());
				
				paquete_recibido = (PaqueteEnvio) paquete_datos.readObject();
				
				nick = paquete_recibido.getNick();
				
				ip = paquete_recibido.getIp();
				
				mensaje = paquete_recibido.getMensaje();
				
				if(!mensaje.equals(" online")) {
				
					areatexto.append(nick + ": " + mensaje + " para " + ip + "\n");
					
					Socket enviaDestinatario = new Socket(ip, 9090);
					
					ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
					
					paqueteReenvio.writeObject(paquete_recibido);
					
					paqueteReenvio.close();
					
					enviaDestinatario.close();
					
					misocket.close();
					
				} else {
					
					//DETECTA ONLINE----------------------------
					
					InetAddress localizacion = misocket.getInetAddress();
					
					String ipRemota = localizacion.getHostAddress();
					
					System.out.println("Online: " + ipRemota);
					
					listaIp.add(ipRemota);
					
					paquete_recibido.setIps(listaIp);
					
					for(String z: listaIp) {
						
						System.out.println("Array: " + z);
						
						Socket enviaDestinatario = new Socket(z, 9090);
						
						ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
						
						paqueteReenvio.writeObject(paquete_recibido);
						
						paqueteReenvio.close();
						
						enviaDestinatario.close();
						
						misocket.close();
						
					}
					
					//--------------------------------------------
					
				}
			
			}
			
		} catch (IOException | ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	private	JTextArea areatexto;
}
