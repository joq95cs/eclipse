package programaciongenerica4;

public class Nodo<T> {
	
	public Nodo(T elemento) {
		
		this.elemento = elemento;
		
		siguiente = null;
		
	}
	
	public void setElemento(T elemento) {
		
		this.elemento = elemento;
		
	}
	
	public T getElemento() {
		
		return elemento;
		
	}
	
	private T elemento;
	
	public Nodo siguiente;

}