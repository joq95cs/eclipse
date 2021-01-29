package tap;

import java.util.*;

public class ListaObjetos {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
		
		int i = 0;
		
		do {
			
			listaPersonas.add(new Persona());
			
			System.out.print("Ingresa los datos (Nombre, sexo, edad): ");
			
			listaPersonas.get(i).setDatos(entrada.next(), entrada.next(), entrada.nextInt());
			
			i ++;
			
			System.out.print("\n¿Agregar otro elemento? (S/N): ");
			
			if(entrada.next().toUpperCase().equals("N")) break;
			
			System.out.println();
				
		} while(true);
		
		i = 0;
		
		while(i < listaPersonas.size()) {
			
			System.out.println();
			
			listaPersonas.get(i).getDatos();
			
			i++;
			
		}
			
	}

}
