package listas3;

import javax.swing.JOptionPane;

public class ListaC {
	
	public ListaC() {
		
		ultimo = null;
		
	}
	
	//Saber si la lista está vacía
	public boolean listaVacia() {
		
		return ultimo == null;
		
	}
	
	//Método para insertar nodos
	public ListaC insertar(int elemento) {
		
		NodoC nuevo = new NodoC(elemento);
		
		if(ultimo != null) {
			
			nuevo.siguiente = ultimo.siguiente;
			ultimo.siguiente = nuevo;
			
		}
		
		ultimo = nuevo;
		
		return this;
		
	}
	
	//Mostrar lista
	
	public void mostrarLista() {
		
		NodoC recorrer = ultimo.siguiente; //Apunta al primero
		String cadena = "";
		
		do {
			
			cadena += "[" + recorrer.dato + "] -> ";
			recorrer = recorrer.siguiente;
			
		} while(recorrer != ultimo.siguiente);
		
		JOptionPane.showMessageDialog(null, cadena, "Mostrar lista circular", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	NodoC ultimo;
	
}