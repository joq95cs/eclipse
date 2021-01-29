package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class PruebaEventos4 {
	
	public static void main(String[] args) {
		
		MarcoBotones4 marco = new MarcoBotones4();
		
		marco.setVisible(true);
	}
	
}

class MarcoBotones4 extends JFrame {
	
	public MarcoBotones4() {
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		
		Dimension dimensiones = pantalla.getScreenSize();
		
		int ancho = dimensiones.width, alto = dimensiones.height;
		
		setBounds(ancho/4, alto/4, ancho/2, alto/2);
		
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("Cambiando color de fondo");
		
		Image icono = pantalla.getImage("src/graficos/acuarela.gif");
		
		setIconImage(icono);
		
		LaminaBotones4 lamina = new LaminaBotones4();
		
		add(lamina);
		
	}
	
}

class LaminaBotones4 extends JPanel {
	
	public LaminaBotones4() {
		
		add(botonRojo);
		
		botonRojo.addActionListener(new ColorFondo(Color.RED));
		
		add(botonAzul);
		
		botonAzul.addActionListener(new ColorFondo(Color.BLUE));
		
		add(botonVerde);
		
		botonVerde.addActionListener(new ColorFondo(Color.GREEN));
		
		add(botonNegro);
		
		botonNegro.addActionListener(new ColorFondo(Color.BLACK));
		
	}
	
	private JButton botonRojo = new JButton("Rojo");
	
	private JButton botonAzul = new JButton("Azul");
	
	private JButton botonVerde = new JButton("Verde");
	
	private JButton botonNegro = new JButton("Negro");
	
	private class ColorFondo implements ActionListener {
		
		public ColorFondo(Color c) {
			
			this.c = c;
			
		}
		
		public void actionPerformed(ActionEvent e) {
			
			setBackground(c);
			
		}
		
		private Color c;
		
	}
	
}