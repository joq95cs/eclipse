import java.util.*;

public class Entrada_ejemplo1 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Introduce tu nombre por favor: ");
		
		String nombre_usuario = entrada.nextLine();
		
		System.out.print("Introduce tu edad por favor: ");
		
		byte edad_usuario = (byte)entrada.nextInt();
		
		System.out.print("Hola " + nombre_usuario + " el proximo a�o tendr�s "
				+ (edad_usuario +1) + " a�os de edad...");
		
		entrada.close();

	}

}
