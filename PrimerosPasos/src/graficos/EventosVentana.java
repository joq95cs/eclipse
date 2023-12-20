package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class EventosVentana {

	public static void main(String[] args) {
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		
		Dimension tamagno = pantalla.getScreenSize();
		
		int ancho = tamagno.width;
		
		int alto = tamagno.height;
		
		MarcoVentana marco1 = new MarcoVentana();
		
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MarcoVentana marco2 = new MarcoVentana();
		
		marco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		marco1.setTitle("Ventana 1");
		
		marco2.setTitle("Ventana 2");
		
		marco1.setBounds(ancho/4, alto/4, ancho/4, alto/4);
		
		marco2.setBounds(2*ancho/4, alto/4, ancho/4, alto/4);

	}

}

class MarcoVentana extends JFrame {
	
	public MarcoVentana() {

		//setBounds(ancho/4, alto/4, ancho/2, alto/2);
		
		setVisible(true);
		
		//setTitle("Respondiendo");
		
		MVentana oyenteVentana = new MVentana();
		
		addWindowListener(oyenteVentana);
		
	}
	
}

class MVentana implements WindowListener {
	
	public void windowActivated(WindowEvent e) { //Cuando la ventana se pone activa
		
		System.out.println("Ventana activada");
		
	}
	
	public void windowClosed(WindowEvent e) {
		
		System.out.println("Ventana cerrada"); //Cuando cerramos un marco. Se requieren m�nimo 2
		
	}
	
	public void windowClosing(WindowEvent e) { //Cuando se cierra la ventana
		
		System.out.println("Cerrando ventana");
		
	}
	
	public void windowDeactivated(WindowEvent e) { //Cuando la ventana pasa a segundo plano
		
		System.out.println("Ventana desactivada");
		
	}
	
	public void windowDeiconified(WindowEvent e) { //Cuando se restaura una ventana
		
		System.out.println("Ventana restaurada");
		
	}
	
	public void windowIconified(WindowEvent e) { //Cuando se minimiza una ventana
		
		System.out.println("Ventana minimizada");
		
	}
	
	public void windowOpened(WindowEvent e) { //Cuando se abre una ventana
		
		System.out.println("Ventana abierta");
		
	}
	
}


