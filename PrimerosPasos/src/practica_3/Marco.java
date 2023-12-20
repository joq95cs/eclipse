package practica_3;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Marco extends JFrame {
	
	public Marco() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("Pizarra");
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setSize(700, 400);
		
		setLocation(ancho/2-getWidth()/2, alto/2-getHeight()/2);
		
		add(new LaminaBoton(), BorderLayout.NORTH);
		
		l = new Lamina();
		
		add(l, BorderLayout.CENTER);
		
	}
	
	private Lamina l;
	
	private class LaminaBoton extends JPanel{
		
		public LaminaBoton() {
			
			JButton botonLimpiar = new JButton("Limpiar");
			
			botonLimpiar.addMouseListener(new MouseAdapter() {
				
				public void mouseClicked(MouseEvent e) {
					
					l.repaint();
					
				}
				
			});
			
			add(botonLimpiar);
			
		}
		
	}
	
}