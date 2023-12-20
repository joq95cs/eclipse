package programaciongenerica4;

public class Prueba {

	public static void main(String[] args) {
		
		Mi_ArrayList<String> a = new Mi_ArrayList<String>();
		
		a.add("Adalid");
		
		a.add("Adalid");
		
		a.add("Alicea");
		
		a.add("Castellanos");
		
		a.set(0, "Joqsan");
		
		a.set(2, a.get(3));
		
		a.set(3, "Alicea");
		
		if(a.isEmpty()) {
			
			System.out.println("No hay elementos");
			
		} else {
			
			for(int i=0; i<a.size(); i++) {
				
				System.out.println("Elemento " + (i+1) + ": " + a.get(i));
				
			}
			
		}

	}

}
