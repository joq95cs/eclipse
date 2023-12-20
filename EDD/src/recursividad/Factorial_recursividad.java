package recursividad;

public class Factorial_recursividad {

	public static void main(String[] args) {
		
		System.out.println("Factorial de 5 mediante recursividad: " + factorialRecursivo(5));

		System.out.println("Factorial de 5 mediante ciclo: " + factorialCiclo(5));
		
	}
	
	public static int factorialRecursivo(int n) {
		
		if(n >= 0) {
			
			if(n == 0) { //Caso base (Respuesta explícita)
				
				return 1;
				
			} else {
				
				return n * factorialRecursivo(n - 1); //Dominio (problema - 1)
				
			}
			
		}
		
		return 0;
		
	}
	
	public static int factorialCiclo(int n) {
		
		if(n >= 0) {
			
			int factor = 1;
			
			while(n != 0) {
				
				factor = n * factor;
				
				n--;
				
			}
			
			return factor;
			
		} else return 0;
		
	}
	
}
