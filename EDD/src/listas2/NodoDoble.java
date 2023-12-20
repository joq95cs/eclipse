package listas2;

public class NodoDoble {
	
	public NodoDoble(int d, NodoDoble s, NodoDoble a) { //Cuando hay nodos
		
		dato = d;
		
		siguiente = s;
		
		anterior = a;
		
	}
	
	public NodoDoble(int d) { //No hay nodos
		
		this(d, null, null); //Llama al otro constructor
		
	}
	
	public int dato;
	
	NodoDoble siguiente, anterior;

}