package listas1;

import javax.swing.JOptionPane;

public class Lista {
	
	public Lista() {
		
		inicio = null;
		
		fin = null;
		
	}
	
	public void agregarAlInicio(int d) {
		
		inicio = new Nodo(d, inicio);
		
		if(fin == null) {
			
			fin = inicio;
			
		}
		
	}
	
	public boolean listaVacia() {
		
		if(inicio == null) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	public void agregarAlFinal(int d) {
		
		if(!listaVacia()) {
			
			fin.siguiente = new Nodo(d);
			
			fin = fin.siguiente;
			
		} else {
			
			inicio = fin = new Nodo(d);
			
		}
		
	}
	
	public void mostrarLista() {
		
		Nodo recorrer = inicio;
		
		while(recorrer != null) {
			
			System.out.print("[" + recorrer.dato + "]--->");
			
			recorrer = recorrer.siguiente; 
			
		}
		
		System.out.println();
		
	}
	
	public int borrarDelInicio() {
		
		int elemento = inicio.dato;
		
		if(inicio == fin) {
			
			inicio = fin = null;
			
		} else {
			
			inicio = inicio.siguiente;
			
		}
		
		return elemento;
		
	}
	
	public int borrarDelFinal() {
		
		int elemento = fin.dato;
		
		if(inicio == fin) {
			
			inicio = fin = null;
			
		} else {
			
			Nodo temporal = inicio;
			
			while(temporal.siguiente != fin) {
				
				temporal = temporal.siguiente;
				
			}
			
			fin = temporal;
			
			fin.siguiente = null;
			
		}
		
		return elemento;
		
	}
	
	public void borrar(int elemento) {
		
		if(inicio == fin && elemento == inicio.dato) {
			
			inicio = fin = null;
			
		} else if(elemento == inicio.dato) {
			
			inicio = inicio.siguiente;
			
		} else {
			
			Nodo anterior, temporal;
			
			anterior = inicio;
			
			temporal = inicio.siguiente;
			
			while(temporal != null && temporal.dato != elemento) {
				
				anterior = anterior.siguiente;
				
				temporal = temporal.siguiente;
				
			}
			
			if(temporal != null) {
				
				anterior.siguiente = temporal.siguiente;
				
				if(temporal == fin) {
					
					fin = anterior;
					
				}
				
			}
			
		}
		
	}
	
	public boolean elementoEncontrado(int elemento) {
		
		Nodo temporal = inicio;
		
		while(temporal != null && temporal.dato != elemento) {
			
			temporal = temporal.siguiente;
			
		}
		
		return temporal != null;
		
	}
	
	protected Nodo inicio, fin; //Punteros para saber donde están el inicio y el fin
	
}
