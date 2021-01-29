package edd;

import java.util.ArrayList;

public class Prueba_ArrayList_5 {

	public static void main(String[] args) {
		
		ArrayList<int[]> lista = new ArrayList<int[]>();
		
		int[] numeros = {6, 7, 9, 0, 1};
		
		int[] edades = {14, 16, 21, 30, 45};
		
		int[] telefonos = {5283228, 5082030};
		
		lista.add(numeros);
		
		lista.add(edades);
		
		lista.add(telefonos);
		
		for(int i=0; i<lista.size(); i++) {
			
			for(int j=0; j<lista.get(i).length; j++) {
				
				System.out.print(lista.get(i)[j] + "  ");
				
			}
			
			System.out.println("\n");
			
		}
		
	}

}
