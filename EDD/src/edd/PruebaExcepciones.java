package edd;

import javax.swing.*;

public class PruebaExcepciones {

	public static void main(String[] args) {
		
		int numero;
		
		boolean aux = false;
		
		do {
			
			aux = false;
			
			try {
				
				numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número"));
				
				System.out.println("El número ingresado es: " + numero);
				
			} catch(Exception e) {
				
				aux = true;
				
			}
			
		} while(aux == true);
		
	}

}
