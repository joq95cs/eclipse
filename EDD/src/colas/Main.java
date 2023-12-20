package colas;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		int opc = 0, e = 0;
		Cola c = new Cola();
		
		do {
			
			try {
				
				String aux = JOptionPane.showInputDialog(null, 
						"1. Insertar\n" +
						"2. Quitar\n" +
						"3. ¿Vacía?\n" +
						"4. Inicio\n" +
						"5. Tamaño\n" +
						"6. Salir\n", "Menú de opciones", JOptionPane.QUESTION_MESSAGE);
				
				if(aux == null) {
					
					opc = 6;
					
				} else {
					
					opc = Integer.parseInt(aux);
				}
				
				switch(opc) {
					
				case 1:
					
					e = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el elemento", "Insertando", JOptionPane.QUESTION_MESSAGE));
					c.insertar(e);
					break;
					
				case 2:
					
					if(!c.colaVacia()) {
						
						JOptionPane.showMessageDialog(null, "Elemento quitado: " + c.quitar(), "Quitando", JOptionPane.WARNING_MESSAGE);
					
					} else {
						
						JOptionPane.showMessageDialog(null, "Cola vacía", "Error", 0);
					}
					
					break;
					
				case 3:
					
					if(c.colaVacia()) {
						
						JOptionPane.showMessageDialog(null, "Cola vacía", "Comprobando", JOptionPane.WARNING_MESSAGE);
					
					} else {
						
						JOptionPane.showMessageDialog(null, "Cola no vacía", "Comprobando", JOptionPane.WARNING_MESSAGE);
					}
					
					break;
					
				case 4:
					
					if(!c.colaVacia()) {
						
						JOptionPane.showMessageDialog(null, "Inicio: " + c.inicio, "Comprobando", JOptionPane.INFORMATION_MESSAGE);
					
					} else {
						
						JOptionPane.showMessageDialog(null, "Cola vacía", "Error", 0);
					}
					
					break;
					
				case 5:
					
					JOptionPane.showMessageDialog(null, "Tamaño: " + c.tamagnoCola(), "Comprobando", JOptionPane.INFORMATION_MESSAGE);
					break;
					
				case 6:
					
					System.out.println("Saliendo...");
					break;
					
				default:
					
					JOptionPane.showMessageDialog(null, "Opción incorrecta", "Error", 0);
				}
				
			} catch(NumberFormatException ex) {
				
				JOptionPane.showMessageDialog(null, "Error", ex.getMessage(), 0);
			}
			
		} while(opc != 6);
	}

}
