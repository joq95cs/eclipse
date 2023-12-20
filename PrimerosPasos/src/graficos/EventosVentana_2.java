package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class EventosVentana_2 {

	public static void main(String[] args) {
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		
		Dimension tamagno = pantalla.getScreenSize();
		
		int ancho = tamagno.width, alto = tamagno.height;
		
		MarcoVentana2 marco1 = new MarcoVentana2();
		
		MarcoVentana2 marco2 = new MarcoVentana2();
		
		marco1.setBounds(ancho/4, 3*alto/8, ancho/4, alto/4);
		
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco2.setBounds(2*ancho/4, 3*alto/8, ancho/4, alto/4);
		
		marco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		marco1.setTitle("Marco 1");
		
		marco2.setTitle("Marco 2");
		
	}

}

class MarcoVentana2 extends JFrame {
	
	public MarcoVentana2() {
		
		this.setVisible(true);
		
		//MVentana2 oyente = new MVentana2();
		
		//this.addWindowListener(oyente);
		
		this.addWindowListener(new MVentana2());
		
	}
	
}

class MVentana2 extends WindowAdapter { //Hereda de la clase adaptadora y s�lo se sobreescribe el m�todo a usar
	
	public void windowIconified(WindowEvent e) {
		
		System.out.println("Ventana minimizada");
		
	}
	
}
