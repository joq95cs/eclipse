package tap;

import java.util.*;

public class ArregloObjetos {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		Persona[] arrayPersonas = new Persona[5];
		
		for(int i=0; i<5; i++) {
			
			arrayPersonas[i] = new Persona();
			
			System.out.print("Ingresa los datos (Nombre, sexo, edad): ");
			
			arrayPersonas[i].setDatos(entrada.next(), entrada.next(), entrada.nextInt());
			
		}
		
		for(int i=0; i<5; i++) {
			
			System.out.println();
			
			arrayPersonas[i].getDatos();
			
		}

	}

}
