package edd;

import javax.swing.*;

public class PruebaExcepciones3 {

	public static void main(String[] args) {
		
		int opcion = 0;
		
		do {
			
			try {
				
				opcion = Integer.parseInt(JOptionPane.showInputDialog("1) Opci�n 1\n2) Opci�n 2\n3) Salir"));
				
				switch(opcion) {
				
				case 1:
					
					break;
					
				case 2:
					
					break;
					
				case 3:
					
					break;
					
				default:
					
					JOptionPane.showMessageDialog(null, "Opci�n incorrecta");
					
				}
				
			} catch(NumberFormatException e) {
				
				JOptionPane.showMessageDialog(null, "Ingrese un valor v�lido");
				
			}
			
		} while(opcion != 3);

	}

}
