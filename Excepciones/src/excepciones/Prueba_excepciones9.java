package excepciones;

public class Prueba_excepciones9 {

	public static void main(String[] args) {
		
		try {
			
			iniciarEntrada();
			
			System.out.println("El objeto de tipo Scanner se ha iniciado\n");
			
			calcularPeso();
			
		} catch(java.util.InputMismatchException e) {
			
			System.out.println("\nHa ocurrido un error de tipo: " + e.getClass().getName());
			
			System.out.println("Motivo: Dato introducido de tipo erroneo");
			
		} catch(Exception e) {
			
			System.out.println("\nHa ocurrido un error de tipo: " + e.getClass().getName());
			
			System.out.println("Motivo: " + e.getMessage());
			
		} finally {
			
			entrada.close();
			
			System.out.println("\nEl objeto de tipo Scanner se ha cerrado");
			
		}
		
	}	
	
	public static void calcularPeso() throws Exception {
		
		System.out.print("1) Hombre\n2) Mujer\n\nElige tu sexo: ");
		
		int sexo = entrada.nextInt();
		
		int altura = 0;
		
		if(sexo == 1) {
			
			System.out.print("\nIngresa tu altura en cm: ");
			
			altura = entrada.nextInt();
			
			System.out.println("\nTu peso ideal es de: " + (altura-100) + " kg");
			
		} else if(sexo == 2) {
			
			System.out.print("\nIngresa tu altura en cm: ");
			
			altura = entrada.nextInt();
			
			System.out.println("\nTu peso ideal es de: " + (altura-110) + " kg");
			
			
		} else {
			
			throw new OpcionIncorrectaException("Opción incorrecta");
			
		}
		
	}
	
	public static void iniciarEntrada() {
		
		entrada = new java.util.Scanner(System.in);
		
	}
	
	private static java.util.Scanner entrada;
	
}

class OpcionIncorrectaException extends Exception {
	
	public OpcionIncorrectaException() {}
	
	public OpcionIncorrectaException(String mensaje) {
		
		super(mensaje);
		
	}
	
}
