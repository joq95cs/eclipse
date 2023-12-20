package poo;

import javax.swing.*;

import java.awt.event.*;

import java.util.*;

import javax.swing.Timer;

import java.awt.Toolkit;

public class Prueba_temporizador_6 {

	public static void main(String[] args) {
		
		Reloj3 reloj = new Reloj3();
		
		reloj.enMarcha(3000, true);
		
		JOptionPane.showMessageDialog(null, "Presiona aceptar para detener");
		
		System.exit(0);

	}	
	
}

class Reloj3 {
	
	public void enMarcha(int intervalo, final boolean sonido) {
		
		class DameLaHora2 implements ActionListener { //Clase interna local.
			
			public void actionPerformed(ActionEvent evento) {
				
				Date ahora = new Date();
				
				System.out.println("Te pongo la hora cada 3 segundos: " + ahora);
				
				if(sonido) {
					
					Toolkit.getDefaultToolkit().beep();
					
				}
				
			}
			
		}
		
		ActionListener oyente = new DameLaHora2();
		
		Timer temporizador = new Timer(intervalo, oyente);
		
		temporizador.start();
			
	}
	
}