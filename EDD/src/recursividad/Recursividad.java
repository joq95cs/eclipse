package recursividad;

public class Recursividad {

	public static void main(String[] args) {
		
		Recursividad objeto = new Recursividad();
		
		objeto.bajarEscalera(-5);

	}
	
	public void bajarEscalera(int escalones) {
		
		if (escalones >= 0) {
			
			if (escalones == 0) System.out.println("Has terminado de bajar la escalera"); //Caso base, respuesta explicita
			
			else { //Dominio, divisi�n del problema original (problema - 1)
				
				try {
					
					Thread.sleep(500);
					
					System.out.println("Bajando escal�n " + escalones);
					
					//Usando la recursividad
					
					bajarEscalera(escalones - 1); //Recursividad, el m�todo se llama a s� mismo
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				
			}
			
		} else System.out.println("No hay escalones que bajar");
		
	}
	
}
