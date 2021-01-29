package graficos;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class EventosMultiplesOyentes {

	public static void main(String[] args) {
		
		MarcoEventosMultiplesOyentes marco = new MarcoEventosMultiplesOyentes();

		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);
		
	}

}

class MarcoEventosMultiplesOyentes extends JFrame {
	
	public MarcoEventosMultiplesOyentes() {
		
		Dimension dimensiones = Toolkit.getDefaultToolkit().getScreenSize();
		
		int ancho = dimensiones.width, alto = dimensiones.height;
		
		setSize(ancho/4, alto/4);
		
		setLocation(3*ancho/4, 0);
		
		setTitle("Eventos multiples oyentes");
		
		setResizable(false);
		
		LaminaEventosMultiplesOyentes lamina = new LaminaEventosMultiplesOyentes();
		
		add(lamina);
		
	}
	
}

class LaminaEventosMultiplesOyentes extends JPanel {
	
	public LaminaEventosMultiplesOyentes() {
		
		JButton boton_nuevo = new JButton("Nuevo marco");
		
		add(boton_nuevo);
		
		boton_cerrar = new JButton("Cerrar todo");
		
		add(boton_cerrar);
		
		OyenteEventosMultiplesOyentes oyente = new OyenteEventosMultiplesOyentes();
		
		boton_nuevo.addActionListener(oyente);
		
	}
	
	JButton boton_cerrar;
	
	private class OyenteEventosMultiplesOyentes implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			MarcosEmergentes marco_emergente = new MarcosEmergentes(boton_cerrar);
			
			marco_emergente.setVisible(true);
			
		}
		
	}
	
}

class MarcosEmergentes extends JFrame {
	
	public MarcosEmergentes(JButton boton_cerrar) {
		
		Dimension dimensiones = Toolkit.getDefaultToolkit().getScreenSize();
		
		int ancho = dimensiones.width, alto = dimensiones.height;
		
		setBounds(40*contador, 40*contador, ancho/4, alto/4);
		
		contador++;
		
		setTitle("Marco " + contador);
		
		OyenteCerrarMarcosEmergentes oyente_cerrar = new OyenteCerrarMarcosEmergentes();
		
		boton_cerrar.addActionListener(oyente_cerrar);
		
	}
	
	private static int contador = 0;
	
	private class OyenteCerrarMarcosEmergentes implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			dispose();
			
			contador = 0;
			
		}
		
	}
	
}

