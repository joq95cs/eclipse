package colecciones;

import java.util.*;

public class Prueba_ListaEnlazada {

	public static void main(String[] args) {
		
		LinkedList<String> paises = new LinkedList<String>();
		
		paises.add("España");
		paises.add("Colombia");
		paises.add("México");
		paises.add("Peru");
		
		LinkedList<String> capitales = new LinkedList<String>();
		
		capitales.add("Madrid");
		capitales.add("Bogotá");
		capitales.add("Ciudad de México");
		capitales.add("Lima");
		
		/*System.out.println(paises);
		System.out.println(capitales);*/
		
		ListIterator<String> itA = paises.listIterator();
		
		ListIterator<String> itB = capitales.listIterator();
		
		while(itB.hasNext()) {
			
			if(itA.hasNext()) {
				
				itA.next();
				
			}
			
			itA.add(itB.next());
			
		}
		
		System.out.println(paises);
		
		itB = capitales.listIterator();
		
		while(itB.hasNext()) {
			
			itB.next();
			
			if(itB.hasNext()) {
				
				itB.next();
				
				itB.remove();
				
			}
			
		}
		
		System.out.println(capitales);
		
		paises.removeAll(capitales);
		
		System.out.println(paises);
		
	}

}
