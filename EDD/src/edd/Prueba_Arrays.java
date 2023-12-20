package edd;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class Prueba_Arrays {

	public static void main(String[] args) {
		
		int[] numeros = new int[5];
		
		int[] numeros2 = new int[numeros.length];
		
		String[] palabras = new String[5];
		
		int i;
		
		for(i=0; i<5; i++) {
			
			numeros[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el elemento del índice " + i + ": "));
			
		}

		System.out.println("DATOS SIN ORDENAR\n");
		
		for(i=0; i<5; i++) {
			
			System.out.print("[" + numeros[i] + "]");
			
		}
		
		System.out.println("\n\nDATOS ORDENADOS\n");
		
		Arrays.sort(numeros);
		
		for(i=0; i<5; i++) {
			
			System.out.print("[" + numeros[i] + "]");
			
		}
		
		Arrays.fill(palabras, "Bienvenido a la fiesta"); //Pone el mensaje en todas las posiciones
		
		System.out.println("\n\nELEMENTOS DEL ARREGLO PALABRAS\n");
		
		for(i=0; i<5; i++) {
			
			System.out.print("[" + palabras[i] + "]");
			
		}
		
		System.arraycopy(numeros, 0, numeros2, 0, numeros.length);
		
		System.out.println("\n\nELEMENTOS DEL ARREGLO NUMEROS2\n");
		
		for(i=0; i<5; i++) {
			
			System.out.print("[" + numeros2[i] + "]");
			
		}
		
	}

}
