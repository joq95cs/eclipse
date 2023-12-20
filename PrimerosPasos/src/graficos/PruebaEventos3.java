package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class PruebaEventos3 {

	public static void main(String[] args) {
		
		MarcoBotones3 marco = new MarcoBotones3();

	}

}

class MarcoBotones3 extends JFrame { 
	
	public MarcoBotones3() {
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		
		Dimension tamagno = pantalla.getScreenSize();
		
		int ancho = tamagno.width;
		
		int alto = tamagno.height;
		
		setBounds(ancho/4, alto/4, ancho/2, alto/2);
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("BOTONES Y EVENTOS 3");
		
		LaminaBotones3 lamina = new LaminaBotones3();
		
		add(lamina);
		
	}
	
}

class LaminaBotones3 extends JPanel {
	
	public LaminaBotones3() {
		
		add(botonNaranja);
		
		add(botonAmarillo);
		
		add(botonRojo);
		
		add(botonBlanco);
		
		ColorFondo colorNaranja = new ColorFondo(Color.orange);
		
		ColorFondo colorAmarillo = new ColorFondo(Color.yellow);
		
		ColorFondo colorRojo = new ColorFondo(Color.red);
		
		ColorFondo colorBlanco = new ColorFondo(Color.white);
		
		botonNaranja.addActionListener(colorNaranja);
		
		botonAmarillo.addActionListener(colorAmarillo);
		
		botonRojo.addActionListener(colorRojo);
		
		botonBlanco.addActionListener(colorBlanco);
		
	}
	
	JButton botonNaranja = new JButton("NARANJA");
	
	JButton botonAmarillo = new JButton("AMARILLO");
	
	JButton botonRojo = new JButton("ROJO");
	
	JButton botonBlanco = new JButton("BLANCO");
	
	private class ColorFondo implements ActionListener { //Clase oyente
		
		public ColorFondo(Color c) {
			
			colorFondo = c;
			
		}
		
		public void actionPerformed(ActionEvent e) {
			
			setBackground(colorFondo);
			
		}
		
		private Color colorFondo; 
		
	}
	
}


