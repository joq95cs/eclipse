package listas2;

import javax.swing.*;

public class PruebaListaDoble {

	public static void main(String[] args) {
		
		ListaDoble ld = new ListaDoble();
		
		int opcion = 0, d;
		
		do {
			
			try {
				
				opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Agregar nodo al inicio\n" + "2. Agregar nodo al final\n3. Mostrar lista de inicio a fin\n4. Mostrar lista de fin a inicio\n5. Salir", "Elija una opción", JOptionPane.QUESTION_MESSAGE));
				
				switch(opcion) {
				
				case 1:
					
					d = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese dato", "Agregando al inicio", JOptionPane.QUESTION_MESSAGE));
					
					ld.agregarAlInicio(d);
					
					break;
					
				case 2:
					
					d = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese dato", "Agregando al final", JOptionPane.QUESTION_MESSAGE));
					
					ld.agregarAlFinal(d);
					
					break;
					
				case 3:
					
					ld.mostrarListaInicioFin();
					
					break;
					
				case 4:
					
					ld.mostrarListaFinInicio();
					
					break;
					
				case 5:
					
					break;
					
				default:
					
					JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
				
				}
				
			} catch(NumberFormatException e) {
				
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				
			}
			
		} while(opcion != 5);
		
	}

}