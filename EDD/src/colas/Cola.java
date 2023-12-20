package colas;

public class Cola {
	
	public Cola() {
		
		inicio = fin = null;
		t = 0;
	}
	
	public boolean colaVacia() {
		
		return inicio == null;
	}
	
	public void insertar(int e) {
		
		NodoCola nuevo = new NodoCola(e);
		
		if(colaVacia()) {
			
			inicio = nuevo;
			
		} else {
			
			fin.siguiente = nuevo;
		}
		
		fin = nuevo;
		t++;
	}
	
	public int quitar() {
		
		int aux = inicio.dato;
		inicio = inicio.siguiente;
		t--;
		return aux;
	}
	
	public int inicioCola() {
		
		return inicio.dato;
	}
	
	public int tamagnoCola() {
		
		return t;
	}
	
	NodoCola inicio, fin;
	int t;
}