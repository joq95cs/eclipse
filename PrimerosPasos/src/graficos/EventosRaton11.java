package graficos;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class EventosRaton11 {

	public static void main(String[] args) {
		
		MarcoEventosRaton11 marco = new MarcoEventosRaton11();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class MarcoEventosRaton11 extends JFrame {
	
	public MarcoEventosRaton11() {
		
		Dimension dimensiones = Toolkit.getDefaultToolkit().getScreenSize();
		
		int ancho = dimensiones.width, alto = dimensiones.height;
		
		setBounds(3*ancho/8, 3*alto/8, ancho/4, alto/4);
		
		setTitle("Eventos de ratón 11");
		
		setResizable(false);
		
		OyenteEventosRaton11 oyente = new OyenteEventosRaton11();
		
		addMouseMotionListener(oyente);
		
	}
	
}

class OyenteEventosRaton11 implements MouseMotionListener {

	public void mouseDragged(MouseEvent arg0) {
		
		System.out.println("Estás arrastrando");
		
	}

	public void mouseMoved(MouseEvent arg0) {
		
		System.out.println("Está moviendo");
		
	}
	
}