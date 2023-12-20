package programaciongenerica2;

public class ArrayList {
	
	public ArrayList(int p) {
		
		elementos = new Object[p];
		
	}
	
	public Object get(int i) {
		
		return elementos[i];
		
	}
	
	public void add(Object o) {
		
		elementos[i] = o;
		
		i ++;
		
	}
	
	private Object[] elementos;
	
	private int i = 0; //Contador no es estático ya que cada objeto tendrá su contador

}
