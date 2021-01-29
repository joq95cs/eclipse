package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class HolaMundoTexto {

	public static void main(String[] args) {
		
		MarcoHMTexto marco = new MarcoHMTexto();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class MarcoHMTexto extends JFrame {
	
	public MarcoHMTexto() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(3*ancho/8, 3*alto/8, ancho/4, alto/4);
		
		setTitle("Hola Mundo");
		
		setResizable(false);
		
		JPanel lamina1 = new JPanel();
		
		JPanel lamina2 = new JPanel();
		
		lamina1.setLayout(new BorderLayout());
		
		lamina2.setLayout(new FlowLayout());
		
		boton1 = new JButton("Saludar");
		
		boton2 = new JButton("Limpiar");
		
		boton3 = new JButton("Salir");
		
		MouseAdapter oyente = new OyenteHMT();
		
		boton1.addMouseListener(oyente);
		
		boton2.addMouseListener(oyente);
		
		boton3.addMouseListener(oyente);
		
		etiqueta = new JLabel("", SwingConstants.CENTER);
		
		lamina2.add(boton1);
		
		lamina2.add(boton2);
		
		lamina2.add(boton3);
		
		lamina1.add(lamina2, BorderLayout.NORTH);
		
		lamina1.add(etiqueta, BorderLayout.CENTER);
		
		add(lamina1);
		
	}
	
	private class OyenteHMT extends MouseAdapter {
		
		public void mouseClicked(MouseEvent e) {
			
			if(e.getSource() == boton1) {
				
				etiqueta.setText("¡Hola Mundo!");
				
			}
			
			else if(e.getSource() == boton2) {
				
				etiqueta.setText(null);
				
			}
			
			else {
				
				System.exit(0);
				
			}
			
		}
		
	}
	
	private JLabel etiqueta;
	
	private JButton boton1, boton2, boton3;
	
}


