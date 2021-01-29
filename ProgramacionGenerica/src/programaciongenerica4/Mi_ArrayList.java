package programaciongenerica4;

public class Mi_ArrayList<T> {
	
	public Mi_ArrayList() {
		
		inicio = fin = null;
		
	}
	
	public void add(T elemento) {
		
		if(inicio == null && fin == null) {
			
			inicio = fin = new Nodo<T>(elemento);
			
		} else {
			
			fin = fin.siguiente = new Nodo<T>(elemento);
			
		}
		
	}
	
	public void set(int i, T elemento) {
		
		int c = 0;
		
		if(i >= 0) {
			
			for(Nodo n=inicio; n!=null; n=n.siguiente) {
				
				if(c == i) {
					
					n.setElemento(elemento);
					
					break;
					
				}
				
				c ++;
				
			}
			
		}
		
		if(c != i) {
			
			throw new IndexOutOfBoundsException();
			
		}
		
	}
	
	public T get(int i) {
		
		if(i >= 0) {
		
			int c = 0;
			
			for(Nodo n=inicio; n!=null; n=n.siguiente) {
				
				if(c == i) {
					
					return (T)n.getElemento();
					
				}
				
				c ++;
				
			}
			
		}
		
		throw new IndexOutOfBoundsException();
		
	}
	
	public int size() {
		
		int c = 0;
		
		for(Nodo n=inicio; n!=null; n=n.siguiente) {
			
			c ++;
			
		}
		
		return c;
		
	}
	
	public boolean isEmpty() {
		
		return inicio == null && fin == null;
		
	}
	
	private Nodo inicio, fin;

}
