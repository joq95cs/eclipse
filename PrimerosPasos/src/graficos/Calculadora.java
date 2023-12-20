package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class Calculadora {

	public static void main(String[] args) {
		
		MarcoCalculadora marco = new MarcoCalculadora();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);
		
	}

}

class MarcoCalculadora extends JFrame {
	
	public MarcoCalculadora() {
		
		setSize(300, 450);
		
		setTitle("Calculadora");
		
		setResizable(false);
		
		LaminaCalculadora lamina = new LaminaCalculadora();
		
		add(lamina);
		
		//pack(); 
		
	}
	
}

class LaminaCalculadora extends JPanel {
	
	public LaminaCalculadora() {
		
		inicial = true;
		
		setLayout(new BorderLayout());
		
		pantalla = new JButton("0");
		
		pantalla.setEnabled(false);
		
		add(pantalla, BorderLayout.NORTH);
		
		lamina2 = new JPanel();
		
		lamina2.setLayout(new GridLayout(4, 4));
		
		ActionListener oyente = new OyenteCalculadora();
		
		ActionListener oyente2 = new OyenteCalculadora2();
		
		ponerBoton("7", oyente);
		
		ponerBoton("8", oyente);
		
		ponerBoton("9", oyente);
		
		ponerBoton("/", oyente2);
		
		ponerBoton("4", oyente);
		
		ponerBoton("5", oyente);
		
		ponerBoton("6", oyente);
		
		ponerBoton("*", oyente2);
		
		ponerBoton("1", oyente);
		
		ponerBoton("2", oyente);
		
		ponerBoton("3", oyente);
		
		ponerBoton("-", oyente2);
		
		ponerBoton("0", oyente);
		
		ponerBoton(".", oyente);
		
		ponerBoton("=", oyente2);
		
		ponerBoton("+", oyente2);
		
		add(lamina2, BorderLayout.CENTER);
		
		ultima_operacion  = "=";
		
	}
	
	private void ponerBoton(String rotulo, ActionListener oyente) {
		
		JButton boton = new JButton(rotulo);
		
		boton.addActionListener(oyente);
		
		lamina2.add(boton);
		
	}
	
	private class OyenteCalculadora implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			String entrada = e.getActionCommand(); //Almacena el texto del botón pulsado
			
			if(inicial) {
				
				pantalla.setText("");
				
				inicial = false;
				
			}
			
			pantalla.setText(pantalla.getText() + entrada);
			
		}
		
	}
	
	private class OyenteCalculadora2 implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			String operacion = e.getActionCommand();
			
			calcular(Double.parseDouble(pantalla.getText()));
			
			ultima_operacion = operacion;
			
			inicial = true;
			
		}
		
		public void calcular(double x) {
			
			if(ultima_operacion.equals("+")) {
				
				resultado += x;
				
			}
			
			else if(ultima_operacion.equals("-")) {
				
				resultado -= x;
				
			}
			
			else if(ultima_operacion.equals("*")) {
				
				resultado *= x;
				
			}
			
			else if(ultima_operacion.equals("/")) {
				
				resultado /= x;
				
			}
			
			else if(ultima_operacion.equals("=")) {
				
				resultado = x;
				
			}
			
			pantalla.setText("" + resultado);
			
		}
		
	}
	
	private JPanel lamina2;
	
	private JButton pantalla;
	
	private boolean inicial; // Cuando no se inicia una variable de tipo boolean es false por defecto
	
	private double resultado;
	
	private String ultima_operacion;
	
}