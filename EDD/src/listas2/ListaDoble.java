package listas2;

import javax.swing.JOptionPane;

public class ListaDoble {
	
	public ListaDoble() { //Constructor por defecto
		
		inicio = fin = null;
		
	}
	
	public boolean listaVacia() { //Para saber si la lista está vacía
		
		return inicio == null;
		
	}
	
	public void agregarAlFinal(int d) {
		
		if(!listaVacia()) {
			
			fin = new NodoDoble(d, null, fin);
			
			fin.anterior.siguiente = fin;
			
		} else {
			
			inicio = fin = new NodoDoble(d);
			
		}
		
	}
	
	public void agregarAlInicio(int d) {
		
		if(!listaVacia()) {
			
			inicio = new NodoDoble(d, inicio, null);
			
			inicio.siguiente.anterior = inicio;
			
		} else {
			
			inicio = fin = new NodoDoble(d);
			
		}
		
	}
	
	public void mostrarListaInicioFin() {
		
		if(!listaVacia()) {
			
			String datos = "<=>";
			
			NodoDoble aux = inicio;
			
			while(aux != null) {
				
				datos += "[" + aux.dato + "]<=>";
				
				aux = aux.siguiente;
				
			}
			
			JOptionPane.showMessageDialog(null, datos, "Lista de inicio a fin", JOptionPane.INFORMATION_MESSAGE);
			
		} else {
			
			JOptionPane.showMessageDialog(null, "Lista vacía", "Error", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}
	
	public void mostrarListaFinInicio() {
		
		if(!listaVacia()) {
			
			String datos = "<=>";
			
			NodoDoble aux = fin;
			
			while(aux != null) {
				
				datos += "[" + aux.dato + "]<=>";
				
				aux = aux.anterior;
				
			}
			
			JOptionPane.showMessageDialog(null, datos, "Lista de fin a inicio", JOptionPane.INFORMATION_MESSAGE);
		
		} else {
			
			JOptionPane.showMessageDialog(null, "Lista vacía", "Error", JOptionPane.ERROR_MESSAGE);
			
		}
			
	}
	
	private NodoDoble inicio, fin;

}