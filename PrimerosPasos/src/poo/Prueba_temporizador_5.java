package poo;

import javax.swing.Timer;

import java.awt.Toolkit;

import java.awt.event.*;

import javax.swing.JOptionPane;

public class Prueba_temporizador_5 {

	public static void main(String[] args) {
		
		Cronometro2 cronometro = new Cronometro2();
		
		cronometro.activaCronometro(true);

	}

}

class Cronometro2 {
	
	public Cronometro2() {
		
		this.minutos = 0;
		
		this.segundos = 0;
		
	}
	
	public void activaCronometro(final boolean sonido) {
		
		class Tiempo implements ActionListener {
			
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
		
		ActionListener oyente = new Tiempo();
		
		Timer temporizador = new Timer(1000, oyente);
		
		JOptionPane.showMessageDialog(null, "Presione aceptar para iniciar");
		
		temporizador.start();
		
		JOptionPane.showMessageDialog(null, "Presione aceptar para detener");
		
		temporizador.stop();
		
	}
	
	private int minutos;
	
	private int segundos;
	
}
