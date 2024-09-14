package castellanos.joqsan.MQTT_Bomba;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI {
	
	public static class Marco extends JFrame {
		
		public Marco(Lamina lamina, int ancho, int alto, String titulo) {
			
			setTitle(titulo);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			int w = Toolkit.getDefaultToolkit().getScreenSize().width, 
				h = Toolkit.getDefaultToolkit().getScreenSize().height;
			
			setSize(ancho, alto);
			setLocation(w/2 - getWidth()/2, h/2 - getHeight()/2);
			setResizable(false);
			
			this.lamina = lamina;
			add(lamina);
			
		}
		
		public Lamina getLamina() {
			
			return lamina;
		}
		
		private Lamina lamina;
	}
	
	public static class Lamina extends JPanel {
		
		public Lamina() {
			
			initComponents();
			setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			
			c.gridwidth = 1;
			c.gridheight = 1;
			c.weightx = 0.5;
			c.weighty = 0.5;
			
			c.gridx = 1;
			c.gridy = 0;
			add(et_temperatura, c);
			
			c.gridy = 1;
			add(et_humedad, c);
			
			c.gridy = 2;
			add(et_estado, c);
			
			c.gridx = 0;
			c.gridy = 3;
			add(bt_encender, c);
			
			c.gridx = 1;
			c.gridy = 3;
			add(bt_apagar, c);
			
			c.gridx = 2;
			c.gridy = 3;
			add(bt_cronometro, c);
		}
		
		private void initComponents() {
			
			et_temperatura = new JLabel("Temperatura ambiental: 0 °C");
			et_humedad = new JLabel("Humedad de tierra: 0");
			et_estado = new JLabel ("Estado de bomba: ON");
			
			Listener listener = new Listener();
			
			bt_encender = new JButton("ENCENDER");
			bt_encender.setBackground(Color.green);
			bt_encender.setForeground(Color.white);
			bt_encender.addActionListener(listener);
			
			bt_apagar = new JButton("APAGAR");
			bt_apagar.setBackground(Color.red);
			bt_apagar.setForeground(Color.white);
			bt_apagar.addActionListener(listener);
			
			bt_cronometro = new JButton("TEMPORIZADOR");
			bt_cronometro.setBackground(Color.orange);
			bt_cronometro.setForeground(Color.white);
			bt_cronometro.addActionListener(listener);
		}

		public JLabel getEtiquetas(int i) {
			
			JLabel[] etiquetas = {et_temperatura, et_humedad, et_estado};
			return etiquetas[i];
		}
		
		public JButton getBotones(int i) {
			
			JButton[] botones = {bt_encender, bt_apagar, bt_cronometro};
			return botones[i];
		}
		
		private JButton bt_encender;
		private JButton bt_apagar;
		private JButton bt_cronometro;
		private JLabel et_temperatura;
		private JLabel et_humedad;
		private JLabel et_estado;
		
		private class Listener implements ActionListener {
			
			public Listener() {
				
				try {
				
					mqtt = new MQTT_Pub("tcp://broker.hivemq.com", "castellanos/joqsan/bomba");
					db = new DB("jdbc:mysql://localhost:3306/bitacora_bomba", "root", "");
					
				} catch(Exception ex) {
					
					ex.printStackTrace();
				}
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource().equals(bt_encender)) {
					
					try {
						
						mqtt.publicar("ON");
						et_estado.setText("Estado de bomba: ON");
						db.insert("INSERT INTO bitacora (evento_enviado) VALUES (?)", "ON");
						
					} catch(Exception ex) {
						
						ex.printStackTrace();
					}
							
				} else if(e.getSource().equals(bt_apagar)) {
					
					try {
						
						mqtt.publicar("OFF");
						et_estado.setText("Estado de bomba: OFF");
						db.insert("INSERT INTO bitacora (evento_enviado) VALUES (?)", "OFF");
						
					} catch(Exception ex) {
						
						ex.printStackTrace();
					}
							
				} else {
							
					int opcion = 0;
						
					try {
							
						String obj = JOptionPane.showInputDialog(null, "Seleccione una opción:\n\n1) Temporizador sencillo\n2) Temporizador doble\n3) Temporizador según temperatura\n4) Temporizador según humedad", "Temporizador", JOptionPane.QUESTION_MESSAGE);
							
						if(obj == null) {
								
							return;
						}
							
						opcion = Integer.parseInt(obj);
						
						if(opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4) {
							
							throw new Exception();
						}
							
					} catch(Exception ex) {
							
						System.err.println("OPCIÓN INCORRECTA");
						return;
					}
						
					int segundos = 0, segs = 0;
					double temp = 0, hum = 0;
					
					if(opcion == 3) {
						
						try {
							
							String obj3 = JOptionPane.showInputDialog(null, "Ingrese temperatura para encender", "Temporizador", JOptionPane.QUESTION_MESSAGE);
							
							if(obj3 == null) {
								
								return;
							}
							
							temp = Double.parseDouble(obj3);
							String obj0 = JOptionPane.showInputDialog(null, "Ingrese tiempo en segundos para apagar", "Temporizador", JOptionPane.QUESTION_MESSAGE);
							
							if(obj0 == null) {
								
								return;
							}
							
							segundos = Integer.parseInt(obj0);
							new Programador(opcion, temp, hum, segundos, mqtt, db).start();
							System.out.println("\nPROGRAMADOR INICIADO");
							
						} catch(Exception ex) {
							
							System.err.println("ERROR");
						}
						
					} else if(opcion == 4) {
						
						try {
						
							String obj4 = JOptionPane.showInputDialog(null, "Ingrese humedad para encender", "Temporizador", JOptionPane.QUESTION_MESSAGE);
							
							if(obj4 == null) {
								
								return;
							}
							
							hum = Double.parseDouble(obj4);
							String obj0 = JOptionPane.showInputDialog(null, "Ingrese tiempo en segundos para apagar", "Temporizador", JOptionPane.QUESTION_MESSAGE);
							
							if(obj0 == null) {
								
								return;
							}
							
							segundos = Integer.parseInt(obj0);
							new Programador(opcion, temp, hum, segundos, mqtt, db).start();
							System.out.println("\nPROGRAMADOR INICIADO");
						
						} catch(Exception ex) {
							
							System.err.println("ERROR");
						}
						
					} else {
						
						try {
							
							if(opcion == 2) {
								
								String obj2 = JOptionPane.showInputDialog(null, "Ingrese tiempo en segundos para encender", "Temporizador", JOptionPane.QUESTION_MESSAGE);
								
								if(obj2 == null) {
									
									return;
								}
								
								segs = Integer.parseInt(obj2);
							}
							
							String obj1 = JOptionPane.showInputDialog(null, "Ingrese tiempo en segundos para apagar", "Temporizador", JOptionPane.QUESTION_MESSAGE);
							
							if(obj1 == null) {
								
								return;
							}
							
							segundos = Integer.parseInt(obj1);
							new Temporizador(segundos, segs, mqtt, opcion, db).start();
							System.out.println("\nTEMPORIZADOR INICIADO");
						
						} catch(Exception ex) {
							
							System.err.println("ERROR");
						}
					}
				}
			}
			
			private MQTT_Pub mqtt;
			private DB db;
		}
	}
}
