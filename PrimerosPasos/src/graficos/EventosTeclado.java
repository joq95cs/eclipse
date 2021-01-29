package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class EventosTeclado {

	public static void main(String[] args) {
		
		MarcoConTeclas marco = new MarcoConTeclas();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class MarcoConTeclas extends JFrame {
	
	public MarcoConTeclas() {
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		
		Dimension dimensiones = pantalla.getScreenSize();
		
		int ancho = dimensiones.width, alto = dimensiones.height;
		
		setBounds(3*ancho/8, 3*alto/8, ancho/4, alto/4);
		
		setTitle("Eventos de teclado");
		
		addKeyListener(new EventoDeTeclado());
		
	}
	
}

class EventoDeTeclado implements KeyListener {
	
	public void keyPressed(KeyEvent e) {
		
		//int codigo = e.getKeyCode(); //Almacenamos el código de la tecla pulsada
		
		//System.out.println(codigo);
		
	}
	
	public void keyReleased(KeyEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {
		
		char letra = e.getKeyChar();
		
		System.out.println(letra);
		
	}
	
}
