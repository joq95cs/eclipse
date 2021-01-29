package recursividad;

public class TorresHanoi_recursividad {

	public static void main(String[] args) {
		
		TorresHanoi_recursividad objeto = new TorresHanoi_recursividad();
		
		objeto.torresHanoi(5, 1, 2, 3);
		
		System.out.println("\nJuego terminado");
		
	}
	
	public void torresHanoi(int discos, int torre1, int torre2, int torre3) {
		
		if(discos == 1) {
			
			System.out.println("Mover disco de torre " + torre1 + " a torre " + torre3); //Caso base
			
		} else {
			
			torresHanoi(discos-1, torre1, torre3, torre2);
			
			System.out.println("Mover disco de torre " + torre1 + " a torre " + torre3);
			
			torresHanoi(discos-1, torre2, torre1, torre3);
			
		}
		
	}

}
