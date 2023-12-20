package colecciones;

import java.util.*;

public class Prueba_TreeSet {

	public static void main(String[] args) {
		
		/*TreeSet<String> ordenaPersonas = new TreeSet<String>();
		
		ordenaPersonas.add("Sandra");
		
		ordenaPersonas.add("Amanda");
		
		ordenaPersonas.add("Diana");
		
		//Ordena Strings de forma alfabética
		
		for(String s: ordenaPersonas) {
			
			System.out.println(s);
			
		}*/
		
		//Ordenan objetos en relación a la interfaz comparable
		
		Articulo ar1 = new Articulo(1, "Primer artículo");
		
		Articulo ar2 = new Articulo(2, "Segundo artículo");
		
		Articulo ar3 = new Articulo(3, "Tercer artículo");
		
		TreeSet<Articulo> ordenaArticulos = new TreeSet<Articulo>();
		
		ordenaArticulos.add(ar3);
		
		ordenaArticulos.add(ar1);
		
		ordenaArticulos.add(ar2);
		
		for(Articulo ar: ordenaArticulos) {
			
			System.out.println(ar.getDescripcion());
			
		}
		
		/*Articulo comparadorArticulos = new Articulo();
		
		TreeSet<Articulo> ordenaArticulos2 = new TreeSet<Articulo>(comparadorArticulos);*/
		
		//ComparadorArticulos compara_ar = new ComparadorArticulos();
		
		TreeSet<Articulo> ordenaArticulos2 = new TreeSet(new Comparator<Articulo>() {
			
			public int compare(Articulo o1, Articulo o2) {
				
				String desc1 = o1.getDescripcion();
				
				String desc2 = o2.getDescripcion();
				
				return desc1.compareTo(desc2);
				
			}
			
		});
		
		ordenaArticulos2.add(ar3);
		
		ordenaArticulos2.add(ar1);
		
		ordenaArticulos2.add(ar2);
		
		System.out.println();
		
		for(Articulo ar: ordenaArticulos2) {
			
			System.out.println(ar.getDescripcion());
			
		}
		
	}

}

class Articulo implements Comparable<Articulo> {
	
	public Articulo(int num, String desc) {
		
		numero = num;
		
		descripcion = desc;
		
	}

	public int compareTo(Articulo o) {
		
		return numero - o.numero;
		
	}
	
	public String getDescripcion() {
		
		return descripcion;
		
	}
	
	private int numero;
	
	private String descripcion;
	
}

class ComparadorArticulos implements Comparator<Articulo> {
	
	
	public int compare(Articulo o1, Articulo o2) {
		
		String desc1 = o1.getDescripcion();
		
		String desc2 = o2.getDescripcion();
		
		return desc1.compareTo(desc2);
		
	}
		
}
