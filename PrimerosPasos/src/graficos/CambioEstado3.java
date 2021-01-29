package graficos;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class CambioEstado3 {

	public static void main(String[] args) {
		
		MarcoEstado3 marco = new MarcoEstado3();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);
		
	}

}

class MarcoEstado3 extends JFrame {
	
	public MarcoEstado3() {
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		
		Dimension dimensiones = pantalla.getScreenSize();
		
		int ancho = dimensiones.width, alto = dimensiones.height;
		
		setSize(ancho/4, alto/4);
		
		setLocation(3*ancho/8, 3*alto/8);
		
		setTitle("Prueba eventos de ventana");
		
		addWindowStateListener(new CambiaEstado3());
		
	}
	
}

class CambiaEstado3 implements WindowStateListener {
	
	Toolkit sonido = Toolkit.getDefaultToolkit();
	
	public void windowStateChanged(WindowEvent e) {
		
		if(e.getNewState() == Frame.NORMAL) {
			
			System.out.println("La ventana está normal...");
			
			sonido.beep();
			
		}
		
		if(e.getNewState() == Frame.MAXIMIZED_BOTH) {
			
			System.out.println("La ventana ha sido maximizada...");
			
			sonido.beep();
			
		}
		
		if(e.getNewState() == Frame.ICONIFIED) {
			
			System.out.println("La ventana ha sido minimizada...");
			
			sonido.beep();
			
		}
		
	}
	
}
