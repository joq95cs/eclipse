package recursividad;

public class Potencia_recursividad {

	public static void main(String[] args) {
		
		System.out.println("Resultado: " + potencia(2, 5));
		
	}
	
	public static int potencia(int b, int e) {
		
		if(e >= 0) {
			
			if(e == 0) { //Caso base
				
				return 1;
				
			} else {
				
				return b * potencia(b, e-1); //Dominio
				
			}
			
		}
		
		return b;
		
	}
	
}
