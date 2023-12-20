package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class EventosMultiplesOyentes2 {

	public static void main(String[] args) {
		
		MarcoEventosMultiplesOyentes2 marco = new MarcoEventosMultiplesOyentes2();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class MarcoEventosMultiplesOyentes2 extends JFrame {
	
	public MarcoEventosMultiplesOyentes2() {
		
		Dimension dimensiones = Toolkit.getDefaultToolkit().getScreenSize();
		
		int ancho = dimensiones.width, alto = dimensiones.height;
		
		setBounds(3*ancho/4, 0, ancho/4, alto/4);
		
		setTitle("Eventos multiples oyentes");
		
		setResizable(false);
		
		LaminaEventosMultiplesOyentes2 lamina = new LaminaEventosMultiplesOyentes2();
		
		add(lamina);
		
	}
	
}

class LaminaEventosMultiplesOyentes2 extends JPanel {
	
	public LaminaEventosMultiplesOyentes2() {
		
		JButton boton_nueva = new JButton("Nueva ventana");
		
		add(boton_nueva);
		
		boton_cerrar = new JButton("Cerrar ventanas");
		
		add(boton_cerrar);
		
		Oyente1 oyente = new Oyente1();
		
		boton_nueva.addActionListener(oyente);
		
	}
	
	private JButton boton_cerrar;
	
	private class Oyente1 implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			MarcosEmergentes2 marco = new MarcosEmergentes2(boton_cerrar);
			
			marco.setVisible(true);
			
		}
		
	}
	
}

class MarcosEmergentes2 extends JFrame {
	
	public MarcosEmergentes2(JButton boton_cerrar) {
		
		setBounds(contador*40, contador*40, 300, 150);
		
		contador++;
		
		setTitle("Ventana " +  contador);
		
		setResizable(false);
		
		Oyente2 oyente = new Oyente2();
		
		boton_cerrar.addActionListener(oyente);
		
	}
	
	private static int contador = 0;
	
	private class Oyente2 implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			dispose();
			
			contador = 0;
			
		}
		
	}
	
}
