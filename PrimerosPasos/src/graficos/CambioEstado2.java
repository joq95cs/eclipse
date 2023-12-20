package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class CambioEstado2 {

	public static void main(String[] args) {
		
		MarcoEstado2 marco = new MarcoEstado2();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class MarcoEstado2 extends JFrame {
	
	public MarcoEstado2() {
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		
		Dimension dimensiones = pantalla.getScreenSize();
		
		int ancho = dimensiones.width, alto = dimensiones.height;
		
		setBounds(3*ancho/8, 3*alto/8, ancho/4, alto/4);
		
		setTitle("Marco estado 2");
		
		addWindowStateListener(new CambiaEstado2());
		
	}
	
}

class CambiaEstado2 implements WindowStateListener {
	
	public void windowStateChanged(WindowEvent e) {
		
		System.out.println("La ventana ha cambiado de estado...");
		
		//System.out.println(e.getNewState());
		
		if(e.getNewState() == Frame.MAXIMIZED_BOTH) {
			
			System.out.println("La ventana está a pantalla completa...");
			
		}
		
	}
	
	
	
	
}
