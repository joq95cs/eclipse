package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class EventosRaton2 {

	public static void main(String[] args) {
		
		MarcoEventosRaton2 marco = new MarcoEventosRaton2();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class MarcoEventosRaton2 extends JFrame {
	
	public MarcoEventosRaton2() {
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		
		Dimension dimensiones = pantalla.getScreenSize();
		
		int ancho = dimensiones.width, alto = dimensiones.height;
		
		setSize(ancho/4, alto/4);
		
		setLocation(3*ancho/8, 3*alto/8);
		
		setTitle("Prueba eventos de ratón 2");
		
		OyenteEventosRaton2 oyente = new OyenteEventosRaton2();
		
		addMouseListener(oyente);
		
	}
	
}

class OyenteEventosRaton2 extends MouseAdapter {
	
	public void mouseEntered(MouseEvent e) {
		
		System.out.println("Has entrado en el marco");
		
	}
	
	public void mouseExited(MouseEvent e) {
		
		System.out.println("Has salido del marco");
		
	}
	
	public void mouseClicked(MouseEvent e) {
		
		System.out.println("Has hecho clic en el marco");
		
	}
	
}
