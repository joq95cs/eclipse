package com.joqsan.MQTT_Led;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Marco extends JFrame {
	
	public Marco() throws Exception {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Led con MQTT");
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		setBounds(w/2 - 150, h/2 - 100, 300, 200);
		add(new Lamina());
	}

}

class Lamina extends JPanel {
	
	public Lamina() throws Exception {
		
		mqtt = new MQTT("tcp://192.168.31.159", "castellanos/joqsan/led");
		setLayout(new GridLayout(1, 2));
		boton_encender = new JButton("Encender");
		boton_encender.setBackground(Color.green);
		boton_encender.setForeground(Color.white);
		boton_apagar = new JButton("Apagar");
		boton_apagar.setBackground(Color.red);
		boton_apagar.setForeground(Color.white);
		Oyente oyente = new Oyente();
		boton_encender.addMouseListener(oyente);
		boton_apagar.addMouseListener(oyente);
		JPanel l1 = new JPanel();
		l1.add(boton_encender);
		JPanel l2 = new JPanel();
		l2.add(boton_apagar);
		add(l1);
		add(l2);
	}
	
	private JButton boton_encender;
	private JButton boton_apagar;
	private MQTT mqtt;
	
	private class Oyente extends MouseAdapter {
		
		public void mouseClicked(MouseEvent e) {
			
			if(e.getSource().equals(boton_encender)) {
				
				//System.out.println("Encender");
				try {
					
					mqtt.publicar("ON");
					//System.out.println("Publicado: ON");
					
				} catch (Exception ex) {
					
					ex.printStackTrace();
				}
				
			} else {
				
				//System.out.println("Apagar");
				try {
					
					mqtt.publicar("OFF");
					//System.out.println("Publicado: OFF");
					
				} catch (Exception ex) {
					
					ex.printStackTrace();
				}
			}
		}
	}
}
