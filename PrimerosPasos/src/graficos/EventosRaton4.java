package graficos;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class EventosRaton4 {

	public static void main(String[] args) {
		
		MarcoEventosRaton4 marco = new MarcoEventosRaton4();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class MarcoEventosRaton4 extends JFrame {
	
	public MarcoEventosRaton4() {
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		
		Dimension dimensiones = pantalla.getScreenSize();
		
		int ancho = dimensiones.width, alto = dimensiones.height;
		
		setSize(ancho/4, alto/4);
		
		setLocation(3*ancho/8, 3*alto/8);
		
		setTitle("Prueba eventos de ratón 4");
		
		OyenteEventosRaton4 oyente = new OyenteEventosRaton4();
		
		addMouseListener(oyente);
		
	}
	
}

class OyenteEventosRaton4 extends MouseAdapter {
	
	public void mouseClicked(MouseEvent e) {
		
		Toolkit.getDefaultToolkit().beep();
		
	}
	
}
