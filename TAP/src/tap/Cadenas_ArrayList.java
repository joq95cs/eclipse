package tap;

import java.util.*;

public class Cadenas_ArrayList {

	public static void main(String[] args) {
		
		Cadenas objetoCadenas = new Cadenas();
		
		objetoCadenas.setNombre("Kimera");
		
		objetoCadenas.setNombre("Simbel");
		
		objetoCadenas.setNombre("Heli");
		
		objetoCadenas.setNombre("Nicolás");
		
		objetoCadenas.setNombre("Mentuhotep");
		
		objetoCadenas.setNombre("Elazibel");
		
		objetoCadenas.setLongitudes();
		
		objetoCadenas.mostrarLongitudes();

	}

}

class Cadenas {
	
	public Cadenas() {
		
		nombres = new ArrayList<String>();
		
		longitudes = new ArrayList<Integer>();
		
	}
	
	public void setNombre(String nombre) {
		
		nombres.add(nombre);
		
	}
	
	public void setLongitudes() {
		
		for(int i=0; i<nombres.size(); i++) {
			
			longitudes.add(Integer.valueOf(nombres.get(i).length()));
			
		}
		
	}
	
	public void mostrarLongitudes() {
		
		for(int i=0; i<nombres.size(); i++) {
			
			System.out.println(nombres.get(i) + ": " + longitudes.get(i) + " caracteres");
			
		}
		
	}
	
	private ArrayList<String> nombres;
	
	private ArrayList<Integer> longitudes;
	
}
