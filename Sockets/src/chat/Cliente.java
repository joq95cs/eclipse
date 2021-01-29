package chat;

import javax.swing.*;

import java.util.*;

import java.awt.event.*;

import java.io.*;

import java.net.*;

public class Cliente {

	public static void main(String[] args) {
		
		MarcoCliente mimarco = new MarcoCliente();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoCliente extends JFrame{
	
	public MarcoCliente() {
		
		setTitle("Chat");
		
		setResizable(false);
		
		setSize(270, 350);
				
		LaminaMarcoCliente milamina = new LaminaMarcoCliente();
		
		add(milamina);
		
		setLocationRelativeTo(null);
		
		setVisible(true);
		
		addWindowListener(new EnvioOnline());
		
	}	
	
}

class EnvioOnline extends WindowAdapter {
	
	public void windowOpened(WindowEvent e) {
		
		try {
			
			Socket misocket = new Socket("192.168.0.5", 9999);
			
			PaqueteEnvio datos = new PaqueteEnvio();
			
			datos.setMensaje(" online");
			
			ObjectOutputStream paquete_datos = new ObjectOutputStream(misocket.getOutputStream());
			
			paquete_datos.writeObject(datos);
			
			misocket.close();
			
			
		} catch(Exception e2) {}
		
	}
	
}

class LaminaMarcoCliente extends JPanel implements Runnable {
	
	public LaminaMarcoCliente() {
		
		String nick_usuario = JOptionPane.showInputDialog("Nick: ");
		
		JLabel n_nick = new JLabel("Nick: ");
		
		add(n_nick);
		
		nick = new JLabel();
		
		nick.setText(nick_usuario);
		
		add(nick);
	
		JLabel texto = new JLabel("Online: ");
		
		add(texto);
		
		ip = new JComboBox();
		
		add(ip);
		
		campochat = new JTextArea(12, 20);
		
		campochat.setEditable(false);
		
		add(new JScrollPane(campochat)); 
	
		campo1 = new JTextField(20);
	
		add(campo1);		
	
		miboton = new JButton("Enviar");
		
		EnviaTexto mievento = new EnviaTexto();
		
		miboton.addActionListener(mievento);
		
		add(miboton);
		
		Thread mihilo = new Thread(this);
		
		mihilo.start();
		
	}
	
	public void run() {
		
		try {
			
			ServerSocket servidor_cliente = new ServerSocket(9090);
			
			Socket cliente;
			
			PaqueteEnvio paqueteRecibido;
			
			while(true) {
				
				cliente = servidor_cliente.accept();
				
				ObjectInputStream flujoentrada = new ObjectInputStream(cliente.getInputStream());
				
				paqueteRecibido = (PaqueteEnvio) flujoentrada.readObject();
				
				if(!paqueteRecibido.getMensaje().equals(" online")) {
				
					campochat.append(paqueteRecibido.getNick() + ": " + paqueteRecibido.getMensaje() + "\n");
				
				} else {
					
					//campochat.append("\n" + paqueteRecibido.getIps());
					
					ArrayList<String> ipsMenu = new ArrayList<String>();
					
					ipsMenu = paqueteRecibido.getIps();
					
					ip.removeAllItems();
					
					for(String z: ipsMenu) {
						
						ip.addItem(z);
						
					}
					
				}
				
			}
			
			
		} catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
			
		}
		
	}
	
	private class EnviaTexto implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			campochat.append(campo1.getText() + "\n");
			
			try {
				
				Socket misocket = new Socket("192.168.0.5", 9999);
				
				PaqueteEnvio datos = new PaqueteEnvio();
				
				datos.setNick(nick.getText());
				
				datos.setIp(ip.getSelectedItem().toString());
				
				datos.setMensaje(campo1.getText());
				
				ObjectOutputStream paquete_datos = new ObjectOutputStream(misocket.getOutputStream());
				
				paquete_datos.writeObject(datos);
				
				misocket.close();
				
			} catch (IOException e1) {
				
				JOptionPane.showMessageDialog(null, "No hay conexión", "Error", 0);
				
			}
			
		}
		
	}
		
	private JTextField campo1;
	
	private JComboBox ip;
	
	private JLabel nick;
	
	private JButton miboton;
	
	private JTextArea campochat;
	
}

/*Debe implementarse la interfaz serializable porque los objetos se van a enviar por la red*/
class PaqueteEnvio implements Serializable { //Clase de los datos que se van a enviar

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	public ArrayList<String> getIps() {
		return ips;
	}

	public void setIps(ArrayList<String> ips) {
		this.ips = ips;
	}

	private String nick, ip, mensaje;
	
	private ArrayList<String> ips;
	
}
