package menu_final;

import java.util.*;

import javax.swing.*;

import tema_1.Transformaciones_lineales;

import tema_2.Ruta_mas_corta;

import tema_3.Maximos_minimos;

import tema_4.Inventarios;

import tema_5.LineasDeEspera;

public class IOMenu {

	public static void main(String[] args) {
		
		Scanner escaner = new Scanner(System.in);
		
		System.out.print("BIENVENIDO");

		System.out.print("\n\nINVESTIGACIÓN DE OPERACIONES\n");
		
		String opcion_final = "";
		
		String opcion_programa = "";
		
		do {
			
			System.out.print("\nA) Tema 1: Transformaciones lineales\nB) Tema 2: Ruta más corta\nC) Tema 3: Máximos y mínimos\nD) Tema 4: Inventarios\nE) Tema 5: Líneas de espera\nF) Salir");
			
			System.out.print("\n\nElija una opción: ");
			
			opcion_programa = escaner.next().toUpperCase();
			
			if (opcion_programa.equals("A")) {
				
				do {
					
					System.out.println();
					
					Transformaciones_lineales.main(null);
					
					System.out.print("\nA) Repetir programa\nB) Regresar al menú\nC) Salir");
					
					System.out.print("\n\nElija una opción: ");
					
					opcion_final = escaner.next().toUpperCase();
					
					if (opcion_final.equals("A") == false) break;
					
				} while (true);
				
			} else if (opcion_programa.equals("B")) {
				
				do {
					
					System.out.println();
					
					Ruta_mas_corta.main(null);
					
					System.out.print("\nA) Repetir programa\nB) Regresar al menú\nC) Salir");
					
					System.out.print("\n\nElija una opción: ");
					
					opcion_final = escaner.next().toUpperCase();
					
					if (!opcion_final.equals("A")) break;
					
				} while (true);
				
			} else if (opcion_programa.equals("C")) {
				
				do {
					
					System.out.println();
					
					Maximos_minimos.main(null);
					
					System.out.print("\nA) Repetir programa\nB) Regresar al menú\nC) Salir");
					
					System.out.print("\n\nElija una opción: ");
					
					opcion_final = escaner.next().toUpperCase();
					
					if (!opcion_final.equals("A")) break;
					
				} while (true);
				
			} else if (opcion_programa.equals("D")) {
				
				do {
					
					System.out.println();
					
					Inventarios.main(null);
					
					System.out.print("\nA) Repetir programa\nB) Regresar al menú\nC) Salir");
					
					System.out.print("\n\nElija una opción: ");
					
					opcion_final = escaner.next().toUpperCase();
					
					if (!opcion_final.equals("A")) break;
					
				} while (true);
				
			} else if (opcion_programa.equals("E")) {
				
				do {
					
					System.out.println();
					
					LineasDeEspera.main(null);
					
					System.out.print("\nA) Repetir programa\nB) Regresar al menú\nC) Salir");
					
					System.out.print("\n\nElija una opción: ");
					
					opcion_final = escaner.next().toUpperCase();
					
					if (!opcion_final.equals("A")) break;
					
				} while (true);
				
			} else break;
			
			if (opcion_final.equals("C")) break;
			
		} while (true);
		
		System.out.print("\nFIN");
		
	}
	
}
