package poo;

import java.awt.Toolkit;
import java.awt.event.*;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Prueba_temporizador {

	public static void main(String[] args) {
		
		DameLaHora oyente = new DameLaHora();
		
		//ActionListener oyente = new DameLaHora();
		
		Timer mi_temporizador = new Timer(5000, oyente); //CADA 5 SEGUNDOS LLAMA AL METODO DE LA INTERFAZ
		
		mi_temporizador.start(); //PONE EN MARCHA EL TEMPORIZADOR
		
		JOptionPane.showMessageDialog(null, "Pulsa aceptar para detener"); //MUESTRA MENSAJE

		System.exit(0); //DETIENE LA EJECUCIÓN DEL PROGRAMA
		
	}

}

class DameLaHora implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		
		Date ahora = new Date();
		
		System.out.println("Te pongo la hora cada 5 segundos: " + ahora);
		
		Toolkit.getDefaultToolkit().beep();
		
	}
	
}