package colecciones;

import java.util.*;

public class Prueba_LinkedList {

	public static void main(String[] args) {
		
		LinkedList<String> personas = new LinkedList<String>();
		
		personas.add("Pepe");
		
		personas.add("Sandra");
		
		personas.add("Ana");
		
		personas.add("Laura");
		
		System.out.println(personas.size());
		
		ListIterator<String> it = personas.listIterator(); //Iterador para linkedlist
		
		it.next();
		
		it.add("Juan");
		
		for(String persona: personas) {
			
			System.out.println(persona);
			
		}
		
	}

}
