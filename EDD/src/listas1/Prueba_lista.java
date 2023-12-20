package listas1;

import javax.swing.JOptionPane;

public class Prueba_lista {

	public static void main(String[] args) {
		
		Lista objetoLista = new Lista();
		
		int opcion = 0, elemento;
		
		do {
			
			try {
				
				opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "1) Agregar un elemento al inicio de la lista\n2) Agregar un elemento al final de la lista\n3) Mostrar los elementos de la lista\n4) Eliminar elemento del inicio de la lista\n5) Eliminar elemento del final de la lista\n6) Eliminar un elemento en específico\n7) Buscar un elemento en la lista\n8) Salir", "Menú de opciones", JOptionPane.QUESTION_MESSAGE));
				
				switch(opcion) {
				
				case 1:
					
					try {
						
						elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el elemento", "Insertando al inicio", JOptionPane.QUESTION_MESSAGE));
						
						objetoLista.agregarAlInicio(elemento);
						
					} catch(NumberFormatException n) {
						
						JOptionPane.showMessageDialog(null, "Error " + n.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						
					}
					
					break;
					
				case 2:
					
					try {
						
						elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el elemento", "Insertando al final", JOptionPane.QUESTION_MESSAGE));
						
						objetoLista.agregarAlFinal(elemento);
						
					} catch(NumberFormatException n) {
						
						JOptionPane.showMessageDialog(null, "Error " + n.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						
					}
					
					break;
					
				case 3:
					
					if(!objetoLista.listaVacia()) {
						
						objetoLista.mostrarLista();
						
					} else {
						
						JOptionPane.showMessageDialog(null, "Lista vacía", "Error", JOptionPane.ERROR_MESSAGE);
						
					}
					
					break;
					
				case 4:
					
					if(!objetoLista.listaVacia()) {
						
						elemento = objetoLista.borrarDelInicio();
						
						JOptionPane.showMessageDialog(null, "El elemento eliminado es: " + elemento, "Elemento eliminado", JOptionPane.INFORMATION_MESSAGE);
						
					} else {
						
						JOptionPane.showMessageDialog(null, "Lista vacía", "Error", JOptionPane.ERROR_MESSAGE);
						
					}
					
					break;
					
				case 5:
					
					if(!objetoLista.listaVacia()) {
					
						elemento = objetoLista.borrarDelFinal();
					
						JOptionPane.showMessageDialog(null, "El elemento eliminado es: " + elemento, "Elemento eliminado", JOptionPane.INFORMATION_MESSAGE);
					
					} else {
						
						JOptionPane.showMessageDialog(null, "Lista vacía", "Error", JOptionPane.ERROR_MESSAGE);
						
					}
						
					break;
					
				case 6:
					
					try {
						
						if(!objetoLista.listaVacia()) {
							
							elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el elemento a eliminar", "Eliminando elemento en específico", JOptionPane.QUESTION_MESSAGE));
							
							if(objetoLista.elementoEncontrado(elemento)) {
								
								objetoLista.borrar(elemento);
								
								JOptionPane.showMessageDialog(null, "El elemento eliminado es: " + elemento, "Elemento eliminado", JOptionPane.INFORMATION_MESSAGE);
								
							} else {
								
								JOptionPane.showMessageDialog(null, "El elemento [" + elemento + "] no se encuentra en la lista", "Error", JOptionPane.ERROR_MESSAGE);
								
							}
							
						} else {
							
							JOptionPane.showMessageDialog(null, "Lista vacía", "Error", JOptionPane.ERROR_MESSAGE);
							
						}
						
					} catch(NumberFormatException n) {
						
						JOptionPane.showMessageDialog(null, "Error " + n.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						
					}
					
					break;
					
				case 7:
					
					try {
						
						if(!objetoLista.listaVacia()) {
							
							elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el elemento a buscar", "Buscando nodo en la lista", JOptionPane.QUESTION_MESSAGE));
							
							if(objetoLista.elementoEncontrado(elemento)) {
								
								JOptionPane.showMessageDialog(null, "El elemento [" + elemento + "] se encuentra en la lista", "Nodo encontrado", JOptionPane.INFORMATION_MESSAGE);
								
							} else {
								
								JOptionPane.showMessageDialog(null, "El elemento [" + elemento + "] no se encuentra en la lista", "Nodo no encontrado", JOptionPane.ERROR_MESSAGE);
								
							}
							
						} else {
							
							JOptionPane.showMessageDialog(null, "Lista vacía", "Error", JOptionPane.ERROR_MESSAGE);
							
						}
						
					} catch(NumberFormatException e) {
						
						JOptionPane.showMessageDialog(null, "Error " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						
					}
					
					break;
					
				case 8:
					
					JOptionPane.showMessageDialog(null, "Programa finalizado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
					
					break;
					
				default: 
					
					JOptionPane.showMessageDialog(null, "Opción incorrecta ", "Error", JOptionPane.ERROR_MESSAGE);
				
				}
				
			} catch(Exception e) {
				
				JOptionPane.showMessageDialog(null, "Error " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			
			}

		} while(opcion != 8);
		
	}

}
