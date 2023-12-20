package listas1;

public class Nodo {
	
	public Nodo(int d) { //Para un nodo final
		
		dato = d;
		
		siguiente = null;
		
	}
	
	public Nodo(int d, Nodo s) { //Para insertar al inicio de la lista
		
		dato = d;
		
		siguiente = s;
		
	}
	
	public int dato;
	
	public Nodo siguiente; //Puntero enlace

}
