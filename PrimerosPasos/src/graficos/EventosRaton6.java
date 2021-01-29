package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class EventosRaton6 {

	public static void main(String[] args) {
		
		MarcoEventosRaton6 marco = new MarcoEventosRaton6();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class MarcoEventosRaton6 extends JFrame {
	
	public MarcoEventosRaton6() {
		
		Dimension dimensiones = Toolkit.getDefaultToolkit().getScreenSize();
		
		int ancho = dimensiones.width, alto = dimensiones.height;
		
		setBounds(3*ancho/8, 3*alto/8, ancho/4, alto/4);
		
		setTitle("Prueba eventos de ratón 6");
		
		setResizable(false);
		
		LaminaMarcoEventos6 lamina = new LaminaMarcoEventos6();
		
		add(lamina);
		
	}
	
}

class LaminaMarcoEventos6 extends JPanel {
	
	public LaminaMarcoEventos6() {
		
		JButton boton = new JButton("Beep");
		
		add(boton);
		
		OyenteEventosRaton6 oyente = new OyenteEventosRaton6();
		
		boton.addActionListener(oyente);
		
	}
	
}

class OyenteEventosRaton6 implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		
		Toolkit.getDefaultToolkit().beep();
		
		System.out.println("Has hecho clic");
		
	}
	
}