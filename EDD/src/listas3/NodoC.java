package listas3;

public class NodoC {
	
	public NodoC(int d) {
		
		dato = d;
		siguiente = this; //Apunta a sí mismo
		
	}
	
	int dato; //Dato
	NodoC siguiente; //Puntero siguiente

}