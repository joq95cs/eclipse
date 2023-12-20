package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class PruebaEventos6 {

	public static void main(String[] args) {
		
		MarcoEventos6 marco = new MarcoEventos6();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class MarcoEventos6 extends JFrame {
	
	public MarcoEventos6() {
		
		Dimension dimensiones = Toolkit.getDefaultToolkit().getScreenSize();
		
		int ancho = dimensiones.width, alto = dimensiones.height;
		
		setBounds(ancho/4, alto/4, ancho/4, alto/4);
		
		setTitle("Prueba");
		
		add(new LaminaEventos6());
		
	}
	
}

class LaminaEventos6 extends JPanel {
	
	public LaminaEventos6() {
		
		JButton boton = new JButton("Sonido");
		
		boton.addActionListener(new OyenteEventos6());
		
		add(boton);
		
	}
	
}

class OyenteEventos6 implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		
		Toolkit.getDefaultToolkit().beep();
		
	}
	
}
