package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class EventosMultiplesFuentes3 {

	public static void main(String[] args) {
		
		MarcoEMF3 marco = new MarcoEMF3();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class MarcoEMF3 extends JFrame {
	
	public MarcoEMF3() {
		
		Dimension dimensiones = Toolkit.getDefaultToolkit().getScreenSize();
		
		int ancho = dimensiones.width, alto = dimensiones.height;
		
		setBounds(3*ancho/4, 0, ancho/4, alto/4);
		
		setTitle("Eventos multiples fuentes 3");
		
		setResizable(false);
		
		LaminaEMF3 lamina = new LaminaEMF3();
		
		add(lamina);
		
	}
	
}

class LaminaEMF3 extends JPanel {
	
	public LaminaEMF3() {
		
		setBackground(Color.GREEN);
		
		JButton boton_nuevo = new JButton("Nuevo marco");
		
		boton_cerrar = new JButton("Cerrar todo");
		
		boton_nuevo.setBackground(Color.ORANGE);
		
		boton_cerrar.setBackground(Color.MAGENTA);
		
		add(boton_nuevo);
		
		add(boton_cerrar);
		
		Oyente1 oyente = new Oyente1();
		
		boton_nuevo.addActionListener(oyente);
		
	}
	
	private class Oyente1 implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			MarcosEmergentes3 marco = new MarcosEmergentes3(boton_cerrar);
			
			marco.setVisible(true);
			
		}
		
	}
	
	private JButton boton_cerrar;
	
}

class MarcosEmergentes3 extends JFrame {
	
	public MarcosEmergentes3(JButton boton_cerrar) {
		
		setBounds(x*45, x*45, 250, 130);
		
		x++;
		
		setTitle("Marco " + x);
		
		setResizable(false);
		
		Oyente2 oyente = new Oyente2();
		
		boton_cerrar.addActionListener(oyente);
		
		LaminasEmergentes3 lamina = new LaminasEmergentes3(Color.BLUE);
		
		if(x%2 == 0) {
			
			lamina = new LaminasEmergentes3(Color.RED);
			
		}
		
		add(lamina);
		
	}
	
	private class Oyente2 implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			dispose();
			
			x = 0;
			
		}
		
	}
	
	private static int x = 0;
	
}

class LaminasEmergentes3 extends JPanel {
	
	public LaminasEmergentes3(Color c) {
		
		setBackground(c);
		
	}
	
}
