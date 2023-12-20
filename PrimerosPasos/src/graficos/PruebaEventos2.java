package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class PruebaEventos2 {

	public static void main(String[] args) {
		
		MarcoBotones2 miMarco = new MarcoBotones2();

	}

}

class MarcoBotones2 extends JFrame {
	
	public MarcoBotones2() {
		
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		
		Dimension tamagno = miPantalla.getScreenSize();
		
		int anchoPantalla = tamagno.width;
		
		int altoPantalla = tamagno.height;
		
		setBounds(anchoPantalla/4, altoPantalla/4, anchoPantalla/2, altoPantalla/2);
		
		setTitle("BOTONES Y EVENTOS 2");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(false);
		
		setVisible(true);
		
		LaminaBotones2 miLamina = new LaminaBotones2();
		
		add(miLamina);
		
	}
	
}

class LaminaBotones2 extends JPanel implements ActionListener {

	JButton botonVerde = new JButton("VERDE");
	
	JButton botonMorado = new JButton("MORADO");
	
	JButton botonNegro = new JButton("NEGRO");
	
	JButton botonBlanco = new JButton("BLANCO");
	
	JButton botonX = new JButton("COLOR X");
	
	JButton botonY = new JButton("COLOR Y");
	
	public LaminaBotones2() {
		
		add(botonBlanco);
		
		add(botonMorado);
		
		add(botonNegro);
		
		add(botonVerde);
		
		add(botonX);
		
		add(botonY);
		
		botonBlanco.addActionListener(this);
		
		botonMorado.addActionListener(this);
		
		botonNegro.addActionListener(this);
		
		botonVerde.addActionListener(this);
		
		botonX.addActionListener(this);
		
		botonY.addActionListener(this);	
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		Object botonPresionado = e.getSource();
		
		if(botonPresionado == botonBlanco) {
			
			setBackground(Color.white);
			
		}
		
		else if(botonPresionado == botonMorado) {
			
			setBackground(Color.magenta);
			
		}
		
		else if(botonPresionado == botonNegro) {
			
			setBackground(Color.black);
			
		}
		
		else if(botonPresionado == botonVerde) {
			
			setBackground(Color.green);
			
		}
		
		else if(botonPresionado == botonX) {
			
			setBackground(new Color(123, 99, 244));
			
		}
		
		else {
			
			setBackground(new Color(98, 12, 45));
			
		}
		
	}
	
}

