import java.util.Scanner;

public class Entrada_ejemplo4 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Ingrese el nombre del cantante: ");
		
		String cantante = entrada.nextLine();
		
		System.out.print("Ingrese el género: ");
		
		String genero = entrada.nextLine();
		
		System.out.print("Ingrese el nombre de la canción: ");
		
		String cancion = entrada.nextLine();
		
		System.out.println("\nLa canción " + cancion + " de " + genero + " pertenece a " +
							cantante + "...");
		
		entrada.close();
		
	}

}
