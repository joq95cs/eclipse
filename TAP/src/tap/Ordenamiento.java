package tap;

import java.util.*;

public class Ordenamiento {

	public static void main(String[] args) {
		
		Arreglo arreglo_1 = new Arreglo();
		
		Arreglo arreglo_2 = new Arreglo();
		
		arreglo_1.definirNumeros(8);
		
		arreglo_2.definirNumeros(5);
		
		for(int i=0; i<8; i++) {
			
			arreglo_1.setNumero(i, (int)(Math.random()*100));
			
		}
		
		for(int i=0; i<5; i++) {
			
			arreglo_2.setNumero(i, (int)(Math.random()*100));
			
		}
		
		arreglo_1.cambiarNumerosRepetidos();
		
		arreglo_2.cambiarNumerosRepetidos();
		
		System.out.println("ARREGLO 1\n");
		
		for(int i=0; i<8; i++) {
			
			System.out.print(arreglo_1.getNumero(i) + "  ");
			
		}
		
		System.out.println("\n\nARREGLO 2\n");
		
		for(int i=0; i<5; i++) {
			
			System.out.print(arreglo_2.getNumero(i) + "  ");
			
		}
		
		int contador = 8;
		
		boolean aux;
		
		for(int i=0; i<5; i++) {
			
			aux = true;
			
			for(int j=0; j<8; j++) {
				
				if(arreglo_2.getNumero(i) == arreglo_1.getNumero(j)) {
					
					aux = false;
					
				}
				
			}
			
			if(aux) {
				
				contador++;
				
			}
			
		}
		
		Arreglo arreglo_3 = new Arreglo();
		
		arreglo_3.definirNumeros(contador);
		
		for(int i=0; i<8; i++) {
			
			arreglo_3.setNumero(i, arreglo_1.getNumero(i));
			
		}
		
		int i = 8;
		
		for(int j=0; j<5; j++) {
			
			aux = true;
			
			for(int k=0; k<8; k++) {
				
				if(arreglo_2.getNumero(j) == arreglo_1.getNumero(k)) {
					
					aux = false;
					
				}
				
			}
			
			if(aux) {
				
				arreglo_3.setNumero(i, arreglo_2.getNumero(j));
				
				i++;
				
			}
			
		}
		
		arreglo_3.ordenarNumeros();
		
		System.out.println("\n\nARREGLO 3\n");
		
		for(int j=0; j<contador; j++) {
			
			System.out.print(arreglo_3.getNumero(j) + "  ");
			
		}
		
	}
	
}

class Arreglo {
	
	public void definirNumeros(int n) {
		
		numeros = new int[n];
		
	}
	
	public void setNumero(int i, int numero) {
		
		numeros[i] = numero;
		
	}
	
	public int getNumero(int i) {
		
		return numeros[i];
		
	}
	
	public void ordenarNumeros() {
		
		Arrays.sort(numeros);
		
	}
	
	public void cambiarNumerosRepetidos() {
		
		for(int i=0; i<numeros.length; i++) {
			
			for(int j=0; j<numeros.length-1; j++) {
				
				if(i != j) {
					
					if(numeros[i] == numeros[j]) {
						
						numeros[i] = (int)(Math.random()*100);
						
					}
					
				}
				
			}
			
		}
		
	}
	
	private int[] numeros;
	
}
