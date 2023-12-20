import java.util.*;

public class AdivinaNumero {

	public static void main(String[] args) {
		
		int aleatorio = (int)(Math.random() * 100), numero = 0, intentos = 0;
		
		Scanner entrada = new Scanner(System.in);
				
		do {
			
			intentos++;
			
			System.out.print("Introduce un n�mero por favor: ");
			
			numero = entrada.nextInt();
			
			if(aleatorio < numero) {
				
				System.out.println("M�s bajo...");
			}
			
			else if(aleatorio>numero) {
				
				System.out.println("M�s alto...");
				
			}
		} while(numero != aleatorio);
		
		System.out.println("Correcto... Lo has conseguido tras " + intentos + " intentos...");
		
		entrada.close();
	}

}
