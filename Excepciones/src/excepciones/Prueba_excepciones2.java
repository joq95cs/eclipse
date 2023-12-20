package excepciones;

import java.util.*;

public class Prueba_excepciones2 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Ingresa un n�mero: ");
		
		try {
			
			int n = entrada.nextInt();
			
			System.out.println("\nN�mero generado: " + n*Math.random());
			
		} catch(InputMismatchException e) {
			
			System.out.println("\nError...");
			
		}
		
		entrada.close();

	}

}
