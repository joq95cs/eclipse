package hilos;

public class AutoIniciarHilos {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Hilo 1\n");
		
		new HiloAI().join();
		
		System.out.println("\nHilo 2\n");
		
		new HiloAI().join();;

	}

}

class HiloAI extends Thread {
	
	public HiloAI() {
		
		start();
		
	}
	
	public void run() {
		
		for(int i=0; i<10; i++) {
			
			System.out.println(i);
			
		}
		
	}
	
}