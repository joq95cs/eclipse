package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class EventosRaton10 {

	public static void main(String[] args) {

		MarcoEventosRaton10 marco = new MarcoEventosRaton10();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class MarcoEventosRaton10 extends JFrame {
	
	public MarcoEventosRaton10() {
		
		Dimension dimensiones = Toolkit.getDefaultToolkit().getScreenSize();
		
		int ancho = dimensiones.width, alto = dimensiones.height;
		
		setBounds(3*ancho/8, 3*alto/8, ancho/4, alto/4);
		
		setTitle("Eventos de ratón 10");
		
		setResizable(false);
		
		OyenteEventosRaton10 oyente = new OyenteEventosRaton10();
		
		addMouseListener(oyente);
		
	}
	
}

class OyenteEventosRaton10 extends MouseAdapter {
	
	public void mousePressed(MouseEvent e) {
		
		if(e.getModifiersEx() == MouseEvent.BUTTON1_DOWN_MASK) {
			
			System.out.println("Has pulsado el botón izquierdo");
			
		}
		
		if(e.getModifiersEx() == MouseEvent.BUTTON3_DOWN_MASK) {
			
			System.out.println("Has pulsado el botón derecho");
			
		}
		
		if(e.getModifiersEx() == MouseEvent.BUTTON2_DOWN_MASK) {
			
			System.out.println("Has pulsado la rueda del ratón");
			
		}
		
	}
	
}