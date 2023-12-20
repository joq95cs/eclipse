package menu;

import javax.swing.JOptionPane;

public class Menu {
	
	public static void main(String[] args) {
		
		int opcion = 0;
		
		do {
			
			try {
				
				String aux = JOptionPane.showInputDialog(null, 
						"1. \n" +
						"2. \n" +
						"3. \n" +
						"4. \n" +
						"5. \n" +
						"6. Salir", "Menú de opciones", JOptionPane.QUESTION_MESSAGE);
				
				opcion = aux==null? 6: Integer.parseInt(aux);
				
				switch(opcion) {
				
				case 1:
					
					JOptionPane.showInputDialog(null, "", "", JOptionPane.QUESTION_MESSAGE);
					break;
					
				case 2:
					break;
					
				case 3:
					break;
					
				case 4:
					break;
					
				case 5:
					break;
					
				case 6:
					
					System.out.println("Saliendo...");
					break;
					
				default:
					
					//JOptionPane.showMessageDialog(null, "", "", JOptionPane.INFORMATION_MESSAGE);
					//JOptionPane.showMessageDialog(null, "", "", JOptionPane.WARNING_MESSAGE);
					JOptionPane.showMessageDialog(null, "Opción incorrecta", "Error", 0);
				}
				
			} catch(Exception e) {
				
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
			}
			
		} while(opcion != 6);
	}
}