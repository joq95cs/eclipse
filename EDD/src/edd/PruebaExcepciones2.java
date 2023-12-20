package edd;

import javax.swing.*;

public class PruebaExcepciones2 {

	public static void main(String[] args) {
		
		int numero;
		
		do {
			
			try {
				
				numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese n�mero"));
				
				System.out.println("El n�mero ingresado es: " + numero);
				
				break;
				
			} catch(Exception e) {
				
				JOptionPane.showMessageDialog(null, "Debe ingresar un n�mero");
				
			}
			
		} while(true);

	}

}
