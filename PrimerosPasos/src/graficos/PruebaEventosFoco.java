package graficos;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class PruebaEventosFoco {

	public static void main(String[] args) {
		
		MarcoEventosFoco marco = new MarcoEventosFoco();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class MarcoEventosFoco extends JFrame {
	
	public MarcoEventosFoco() {
		
		Dimension dimensiones = Toolkit.getDefaultToolkit().getScreenSize();
		
		int ancho = dimensiones.width, alto = dimensiones.height;
		
		setBounds(ancho/4, alto/4, ancho/2, alto/2);
		
		setResizable(false);
		
		setTitle("Prueba eventos de foco");
		
		LaminaEventosFoco lamina = new LaminaEventosFoco();
		
		add(lamina);
		
	}
	
}

class LaminaEventosFoco extends JPanel {
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		setLayout(null); //El layout queda invalidado. No hay colocación por defecto. Podemos colocar los elementos donde queramos
		
		cuadro1 = new JTextField();
		
		cuadro2 = new JTextField();
		
		cuadro1.setBounds(120, 10, 150, 20);
		
		cuadro2.setBounds(120, 50, 150, 20);
		
		add(cuadro1);
		
		add(cuadro2);
		
		OyenteEventosFoco oyente = new OyenteEventosFoco();
		
		cuadro1.addFocusListener(oyente);
		
	}
	
	JTextField cuadro1;
	
	JTextField cuadro2;
	
	private class OyenteEventosFoco implements FocusListener {
		
		public void focusLost(FocusEvent e) {
			
			System.out.println("Has perdido el foco del cuadro de texto 1");
			
		}
		
		public void focusGained(FocusEvent e) {
			
			System.out.println("Has ganado el foco del cuadro de texto 1");
			
		}
		
	}
	
}
