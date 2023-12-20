package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class EventosRaton9 {

	public static void main(String[] args) {
		
		MarcoEventosRaton9 marco = new MarcoEventosRaton9();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class MarcoEventosRaton9 extends JFrame {
	
	public MarcoEventosRaton9() {
		
		Dimension dimensiones = Toolkit.getDefaultToolkit().getScreenSize();
		
		int ancho = dimensiones.width, alto = dimensiones.height;
		
		setBounds(3*ancho/8, 3*alto/8, ancho/4, alto/4);
		
		setTitle("Eventos de ratón 9");
		
		setResizable(false);
		
		OyenteEventosRaton9 oyente = new OyenteEventosRaton9();
		
		addMouseListener(oyente);
		
	}
	
}

class OyenteEventosRaton9 extends MouseAdapter {
	
	public void mouseClicked(MouseEvent e) {
		
		//System.out.println("Coordenada x: " + e.getX() + "\nCoordenada y: " + e.getY());
		
		System.out.println("Has hecho: " + e.getClickCount() + " clics");
		
		System.out.println();
		
	}
	
}