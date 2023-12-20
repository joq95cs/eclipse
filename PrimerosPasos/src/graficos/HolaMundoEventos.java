package graficos;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;


public class HolaMundoEventos {
	
	public static void main(String[] args) {
		
		MarcoHolaMundo marco = new MarcoHolaMundo();
		
	}
	
}

class MarcoHolaMundo extends JFrame {
	
	public MarcoHolaMundo() {
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		
		Dimension tamagno = pantalla.getScreenSize();
		
		int ancho = tamagno.width, alto = tamagno.height;
		
		setBounds(3*ancho/8, 3*alto/8, ancho/4, alto/4);
		
		setTitle("HOLA MUNDO");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(false);
		
		setVisible(true);
		
		LaminaHolaMundo lamina = new LaminaHolaMundo();
		
		add(lamina);
		
	}
	
}

class LaminaHolaMundo extends JPanel implements ActionListener {
	
	public LaminaHolaMundo() {
		
		add(boton);
		
		boton.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("HOLA MUNDO");
		
	}
	
	private JButton boton = new JButton("CLIC");
	
}
