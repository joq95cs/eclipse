package programaciongenerica3;

import java.util.*;

public class MetodosGenericos {

	public static void main(String[] args) {
		
		String[] nombres = {"Jader", "Soanny", "Linda", "Alexis"};
		
		//String longitud = Matrices.<String>getElementos(nombres);
		
		/*System.out.println(Arreglos.getElementos(nombres));
		
		Integer[] numeros = {Integer.valueOf(78), Integer.valueOf(9), Integer.valueOf(5), Integer.valueOf(45)};
		
		System.out.println(Arreglos.getElementos(numeros));*/
		
		GregorianCalendar[] fechas = {new GregorianCalendar(1995, 14, 10), new GregorianCalendar(2016, 14, 10)};
		
		System.out.println("Elemento menor: " + Arreglos.getMenor(nombres));
		
	}

}

class Arreglos {
	
	public static <T> String getElementos(T[] a) {
		
		return "El array tiene una longitud de: " + a.length;
		
	}
	
	public static <T extends Comparable> T getMenor(T[] a) { //Se indica que se va a trabajar con un tipo genérico que debe ser del tipo especificado
		
		if(a==null || a.length==0) {
			
			return null;
			
		}
		
		T elementoMenor = a[0];
		
		for(int i=0; i<a.length; i++) {
			
			if(elementoMenor.compareTo(a[i]) > 0) {
				
				elementoMenor = a[i];
				
			}
			
		}
		
		return elementoMenor;
		
	}
	
}
