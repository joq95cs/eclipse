package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class EventosTeclado2 {

	public static void main(String[] args) {
		
		MarcoEventosTeclado marco = new MarcoEventosTeclado();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class MarcoEventosTeclado extends JFrame {
	
	public MarcoEventosTeclado() {
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		
		Dimension dimensiones = pantalla.getScreenSize();
		
		int ancho = dimensiones.width, alto = dimensiones.height;
		
		setBounds(3*ancho/8, 3*alto/8, ancho/4, alto/4);
		
		setTitle("Prueba eventos de teclado");
		
		OyenteEventosTeclado oyente = new OyenteEventosTeclado();
		
		addKeyListener(oyente);
		
	}
	
}

class OyenteEventosTeclado implements KeyListener {
	
	public void keyPressed(KeyEvent e) {
		
		int codigo = e.getKeyCode();
		
		System.out.println("Código: " + codigo);
		
	}

	public void keyReleased(KeyEvent e) {
		
		char caracter = e.getKeyChar();
		
		System.out.println("Caracter: " + caracter + "\n");
		
	}

	public void keyTyped(KeyEvent e) {
		
	}
	
}
