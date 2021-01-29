package poo;

import javax.swing.Timer;

import java.awt.event.*;

import javax.swing.JOptionPane;

public class Prueba_temporizador_2 {

	public static void main(String[] args) {
		
		ActionListener oyente = new Reloj(0, 0);
		
		Timer temporizador = new Timer(1000, oyente);
		
		JOptionPane.showMessageDialog(null, "Presione aceptar para iniciar");
		
		System.out.println("Temporizador inciado\n");
		
		temporizador.start();
		
		JOptionPane.showMessageDialog(null, "Presione aceptar para detener");
		
		temporizador.stop();
		
		System.out.println("\nTemporizador detenido");
		
	}

}

class Reloj implements ActionListener {
	
	public Reloj(int segundos, int minutos) {
		
		this.segundos = segundos;
		
		this.minutos = minutos;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(segundos==60) {
			
			segundos = 0;
			
			minutos++;
			
		}
		
		System.out.println(minutos + " : " + segundos);
		
		segundos++;
		
	}
	
	private int segundos;
	
	private int minutos;
	
}