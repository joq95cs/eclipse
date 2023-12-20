package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class EventosRaton {

	public static void main(String[] args) {
		
		MarcoEventosRaton marco = new MarcoEventosRaton();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class MarcoEventosRaton extends JFrame {
	
	public MarcoEventosRaton() {
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		
		Dimension dimensiones = pantalla.getScreenSize();
		
		int ancho = dimensiones.width, alto = dimensiones.height;
		
		setSize(ancho/4, alto/4);
		
		setLocation(3*ancho/8, 3*alto/8);
		
		setTitle("Prueba eventos de ratón");
		
		OyenteEventosRaton oyente = new OyenteEventosRaton();
		
		addMouseListener(oyente);
		
	}
	
}

class OyenteEventosRaton implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("Haz hecho clic en el marco");
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("Acabas de entrar en el marco");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("Acabas de salir del marco");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("Acabas de presionar");
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		System.out.println("Acabas de soltar");
		
	}
	
}