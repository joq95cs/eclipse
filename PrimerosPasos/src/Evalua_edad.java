import java.util.*;

public class Evalua_edad {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Introduce tu edad: ");
		
		int edad = entrada.nextInt();
		
		if(edad >= 18) {
			
			System.out.println("Eres mayor de edad...");
			
		}
		
		else {
			
			System.out.println("Eres menor de edad...");
		}
		
		entrada.close();
	}

}
