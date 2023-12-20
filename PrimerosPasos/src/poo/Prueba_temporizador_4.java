package poo;

import javax.swing.Timer;

import java.awt.Toolkit;

import java.awt.event.*;

import javax.swing.JOptionPane;

public class Prueba_temporizador_4 {

	public static void main(String[] args) {
		
		Cronometro cronometro = new Cronometro(0, 0, true);
		
		cronometro.activaCronometro();

	}

}

class Cronometro {
	
	public Cronometro(int minutos, int segundos, boolean sonido) {
		
		this.minutos = minutos;
		
		this.segundos = segundos;
		
		this.sonido = sonido;
		
	}
	
	public void activaCronometro() {
		
		ActionListener oyente = new Tiempo();
		
		Timer temporizador = new Timer(1000, oyente);
		
		JOptionPane.showMessageDialog(null, "Presione aceptar para iniciar");
		
		temporizador.start();
		
		JOptionPane.showMessageDialog(null, "Presione aceptar para detener");
		
		temporizador.stop();
		
	}
	
	private class Tiempo implements ActionListener {
		
		public void actionPerformed(ActionEvent evento) {
			
			if(segundos==60) {
				
				segundos = 0;
				
				minutos++;
				
			}
			
			System.out.println(minutos + " : " + segundos);
			
			if(sonido) {
				
				Toolkit.getDefaultToolkit().beep();
				
			}
			
			segundos++;
			
		}
		
	}
	
	private int minutos;
	
	private int segundos;
	
	private boolean sonido;
	
}
