package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class TemporizadorSleep {

	public static void main(String[] args) {
		
		MarcoTS marco = new MarcoTS();
		
		marco.setVisible(true);

	}

}

class MarcoTS extends JFrame {
	
	public MarcoTS() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(3*ancho/8, 3*alto/8, ancho/4, alto/4);
		
		setTitle("Temporizador");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(false);
		
		add(new LaminaTS());
		
	}
	
}

class LaminaTS extends JPanel {
	
	public LaminaTS() {
		
		setLayout(new BorderLayout());
		
		boton = new JButton("Iniciar");
		
		boton.addMouseListener(new OyenteTS());
		
		etiqueta = new JLabel("", JLabel.CENTER);
		
		add(boton, BorderLayout.NORTH);
		
		add(etiqueta, BorderLayout.CENTER);
		
	}
	
	private class OyenteTS extends MouseAdapter {
		
		public void mouseClicked(MouseEvent e) {
			
			for(int i=0; i<60; i++) {
				
				for(int j=0; j<60; j++) {
					
					System.out.println(i + " : " + j);
					
					try {
						
						Thread.sleep(1000);
						
					} catch(InterruptedException ie) {
						
					}
					
				}
				
			}
			
		}
		
		public void mouseEntered(MouseEvent e) {
			
			etiqueta.setText("Presione para iniciar temporizador");
			
		}
		
		public void mouseExited(MouseEvent e) {
			
			etiqueta.setText("");
			
		}
		
	}
	
	private JButton boton;
	
	private JLabel etiqueta;
	
}