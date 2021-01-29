package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class EventosRaton7 {

	public static void main(String[] args) {
		
		MarcoEventosRaton7 marco = new MarcoEventosRaton7();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class MarcoEventosRaton7 extends JFrame {
	
	public MarcoEventosRaton7() {
		
		Dimension dimensiones = Toolkit.getDefaultToolkit().getScreenSize();
		
		int ancho = dimensiones.width, alto = dimensiones.height;
		
		setBounds(3*ancho/8, 3*alto/8, ancho/4, alto/4);
		
		setTitle("Prueba eventos de ratón 7");
		
		setResizable(false);
		
		LaminaEventosRaton7 lamina = new LaminaEventosRaton7();
		
		add(lamina);
		
	}
	
}

class LaminaEventosRaton7 extends JPanel {
	
	public LaminaEventosRaton7() {
		
		BotonEventosRaton7 boton = new BotonEventosRaton7();
		
		add(boton);
		
	}
	
}

class BotonEventosRaton7 extends JButton {
	
	public BotonEventosRaton7() {
		
		setText("Beep");
		
		OyenteEventosRaton7 oyente = new OyenteEventosRaton7();
		
		addActionListener(oyente);
		
	}
	
}

class OyenteEventosRaton7 implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		
		Toolkit.getDefaultToolkit().beep();
		
		System.out.println("Has hecho clic");
		
	}
	
}