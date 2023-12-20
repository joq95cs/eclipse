import java.util.Scanner;

public class Evalua_edad2 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Introduce tu edad: ");
		
		int edad = entrada.nextInt();
		
		if(edad < 13) {
			
			System.out.println("Eres un niño...");
		}
		
		else if(edad < 18) {
			
			System.out.println("Eres un adolescente...");
		}
		
		else if(edad < 30) {
			
			System.out.println("Eres un jóven adulto...");
			
		}
		
		else if(edad < 45) {
			
			System.out.println("Eres un adulto...");
		}
		
		else if(edad < 70 ) {
			
			System.out.println("Eres maduro...");
		}
		
		else if(edad < 100) {
			
			System.out.println("Cuidate...");
		}
		
		else {
			
			System.out.println("¡NO PUEDES TENER ESA EDAD!");
		}

		entrada.close();
	}

}
