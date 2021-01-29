package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class EventosRaton3 {

	public static void main(String[] args) {
		
		MarcoEventosRaton3 marco = new MarcoEventosRaton3();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class MarcoEventosRaton3 extends JFrame {
	
	public MarcoEventosRaton3() {
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		
		Dimension dimensiones = pantalla.getScreenSize();
		
		int ancho = dimensiones.width, alto = dimensiones.height;
		
		setBounds(ancho/4, alto/4, ancho/2, alto/2);
		
		setTitle("Prueba eventos de ratón 3");
		
		OyenteEventosRaton3 oyente = new OyenteEventosRaton3();
		
		 addMouseListener(oyente);
		
	}
	
}

class OyenteEventosRaton3 extends MouseAdapter {
	
	public void mouseEntered(MouseEvent e) {
		
		Toolkit sonido = Toolkit.getDefaultToolkit();
		
		sonido.beep();
		
	}
	
	public void mouseExited(MouseEvent e) {
		
		Toolkit sonido = Toolkit.getDefaultToolkit();
		
		sonido.beep();
		
	}
	
}


