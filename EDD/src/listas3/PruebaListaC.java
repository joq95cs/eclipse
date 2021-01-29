package listas3;

import javax.swing.JOptionPane;

import listas2.ListaDoble;

public class PruebaListaC {

	public static void main(String[] args) {
		
		ListaC lc = new ListaC();
		
		int opcion = 0, elemento;
		
		do {
			
			try {
				
				opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Agregar un nodo\n2. Eliminar un nodo\n3. Mostrar la lista\n4. Salir", "Elija una opción", JOptionPane.QUESTION_MESSAGE));
				
				switch(opcion) {
				
				case 1:
					
					elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese dato", "Agregando nodo", JOptionPane.QUESTION_MESSAGE));
					
					lc.insertar(elemento);
					
					break;
					
				case 2:
					
					break;
					
				case 3:
					
					if(!lc.listaVacia()) {
						
						lc.mostrarLista();
						
					} else {
						
						JOptionPane.showMessageDialog(null, "Lista vacía", "Error", JOptionPane.ERROR_MESSAGE);
						
					}
					
					break;
					
				case 4:
					
					break;
					
				default:
					
					JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
				
				}
				
			} catch(NumberFormatException e) {
				
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				
			}
			
		} while(opcion != 4);

	}

}
