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
	
	private int i = 0; //Contador no es est�tico ya que cada objeto tendr� su contador

}
