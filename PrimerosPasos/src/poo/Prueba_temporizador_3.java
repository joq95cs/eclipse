package poo;

import javax.swing.*;

import java.awt.event.*;

import java.util.*;

import javax.swing.Timer;

import java.awt.Toolkit;

public class Prueba_temporizador_3 {

	public static void main(String[] args) {
		
		Reloj2 reloj = new Reloj2(3000, true);
		
		reloj.enMarcha();
		
		JOptionPane.showMessageDialog(null, "Presiona aceptar para detener");
		
		System.exit(0);

	}	
	
}

class Reloj2 {
	
	public Reloj2(int intervalo, boolean sonido) {
		
		this.intervalo = intervalo;
		
		this.sonido = sonido;
		
	}
	
	public void enMarcha() {
		
		ActionListener oyente = new DameLaHora2();
		
		Timer temporizador = new Timer(intervalo, oyente);
		
		temporizador.start();
			
	}
	
	private int intervalo;
	
	private boolean sonido;
	
	private class DameLaHora2 implements ActionListener { //Las clases internas aceptan modificador private.
		
		public void actionPerformed(ActionEvent evento) {
			
			Date ahora = new Date();
			
			System.out.println("Te pongo la hora cada 3 segundos: " + ahora);
			
			if(sonido) { //Accede a la variable sonido que pertenece a la clase contenedora.
				
				Toolkit.getDefaultToolkit().beep();
				
			}
			
		}
		
	}
	
}