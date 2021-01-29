package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class EventosRaton5 {

	public static void main(String[] args) {
		
		MarcoEventosRaton5 marco = new MarcoEventosRaton5();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class MarcoEventosRaton5 extends JFrame {
	
	public MarcoEventosRaton5() {
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		
		Dimension dimensiones = pantalla.getScreenSize();
		
		int ancho = dimensiones.width, alto = dimensiones.height;
		
		setBounds(3*ancho/8, 3*alto/8, ancho/4, alto/4);
		
		setTitle("Prueba eventos de ratón 5");
		
		setResizable(false);
		
		LaminaEventosRaton5 lamina = new LaminaEventosRaton5();
		
		add(lamina);
		
		
	}
	
}

class LaminaEventosRaton5 extends JPanel {
	
	public LaminaEventosRaton5() {
		
		add(boton);
		
		OyenteEventosRaton5 oyente = new OyenteEventosRaton5();
		
		boton.addMouseListener(oyente);
		
	}
	
	JButton boton = new JButton("Beep");
	
}

class OyenteEventosRaton5 extends MouseAdapter {
	
	public void mouseEntered(MouseEvent e) {
		
		System.out.println("Si haces clic sonará un beep");
		
	}
	
	public void mouseClicked(MouseEvent e) {
		
		Toolkit.getDefaultToolkit().beep();
		
	}
	
}


