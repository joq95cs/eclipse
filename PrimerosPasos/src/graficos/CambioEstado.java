package graficos;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class CambioEstado {

	public static void main(String[] args) {
		
		MarcoEstado marco = new MarcoEstado();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class MarcoEstado extends JFrame {
	
	public MarcoEstado() {
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		
		Dimension dimensiones = pantalla.getScreenSize();
		
		int ancho = dimensiones.width, alto = dimensiones.height;
		
		setBounds(ancho/4, alto/4, ancho/2, alto/2);
		
		setTitle("Marco estado");
		
		setVisible(true);
		
		CambiaEstado nuevo_estado = new CambiaEstado();
		
		addWindowStateListener(nuevo_estado);
		
	}
	
}

class CambiaEstado implements WindowStateListener {
	
	public void windowStateChanged(WindowEvent e) {
		
		System.out.println("La ventana ha cambiado de estado...");
		
	}
	
}

