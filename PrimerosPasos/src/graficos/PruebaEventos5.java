package graficos;

import java.util.*;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class PruebaEventos5 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		MarcoRGB marco = new MarcoRGB();
		
		LaminaRGB lamina = new LaminaRGB();
		
		System.out.print("Ingrese tono de Rojo: ");
		
		lamina.setTonoRojo(entrada.nextInt());
		
		System.out.print("Ingrese tono de Verde: ");
		
		lamina.setTonoVerde(entrada.nextInt());
		
		System.out.print("Ingrese tono de Azúl: ");
		
		lamina.setTonoAzul(entrada.nextInt());
		
		lamina.fijarColor();
		
		marco.add(lamina);
		
		marco.setVisible(true);
		
	}

}

class MarcoRGB extends JFrame {
	
	public MarcoRGB() {
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		
		Dimension dimensionesPantalla = pantalla.getScreenSize();
		
		int anchoPantalla = dimensionesPantalla.width;
		
		int altoPantalla = dimensionesPantalla.height;
		
		setBounds(3*anchoPantalla/8, 3*altoPantalla/8, anchoPantalla/4, altoPantalla/4);
		
		setResizable(false);
		
		Image icono = pantalla.getImage("src/graficos/acuarela.gif");
		
		setIconImage(icono);
		
		setTitle("Poniendo un color RGB");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}

class LaminaRGB extends JPanel implements ActionListener {
	
	public LaminaRGB() {
		
		add(boton);
		
		boton.addActionListener(this);
		
		add(botonCierre);
		
		botonCierre.addActionListener(this);
		
	}
	
	public void setTonoRojo(int tonoRojo) {
		
		this.tonoRojo = tonoRojo;
		
	}
	
	public void setTonoVerde(int tonoVerde) {
		
		this.tonoVerde = tonoVerde;
		
	}
	
	public void setTonoAzul(int tonoAzul) {
		
		this.tonoAzul = tonoAzul;
		
	}
	
	public void fijarColor() {
		
		setBackground(new Color(tonoRojo, tonoVerde, tonoAzul));
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		Object botonPresionado = e.getSource();
		
		if(botonPresionado == boton) {
			
			System.out.print("\n\nIngrese tono de Rojo: ");
			
			tonoRojo = entrada.nextInt();
			
			System.out.print("Ingrese tono de Verde: ");
			
			tonoVerde = entrada.nextInt();
			
			System.out.print("Ingrese tono de Azúl: ");
			
			tonoAzul = entrada.nextInt();
			
			setBackground(new Color(tonoRojo, tonoVerde, tonoAzul));
			
		}
		
		else {
			
			System.exit(0);
			
		}
		
	}
	
	private int tonoRojo;
	
	private int tonoVerde;
	
	private int tonoAzul;
	
	private JButton boton = new JButton("Ingresar nuevo color");
	
	private JButton botonCierre = new JButton("Terminar programa");
	
	private Scanner entrada = new Scanner(System.in);
	
}