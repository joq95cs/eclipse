package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class EventosRaton8 {

	public static void main(String[] args) {
		
		MarcoEventosRaton8 marco = new MarcoEventosRaton8();

	}

}

class MarcoEventosRaton8 extends JFrame {
	
	public MarcoEventosRaton8() {
		
		Dimension dimensiones = Toolkit.getDefaultToolkit().getScreenSize();
		
		int ancho = dimensiones.width, alto = dimensiones.height;
		
		setBounds(3*ancho/8, 3*alto/8, ancho/4, alto/4);
		
		setTitle("Prueba eventos de ratón 8");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(false);
		
		setVisible(true);
		
		JButton boton = new JButton("Beep");
		
		boton.addActionListener(new OyenteEventosRaton8());
		
		JPanel lamina = new JPanel();
		
		lamina.add(boton);
		
		add(lamina);
		
	}
	
}

class OyenteEventosRaton8 implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		
		Toolkit.getDefaultToolkit().beep();
		
		System.out.println("Has hecho clic");
		
	}
	
}