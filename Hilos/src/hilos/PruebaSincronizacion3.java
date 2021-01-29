package hilos;

public class PruebaSincronizacion3 {

	public static void main(String[] args) {
		
		HiloS3_1 h1 = new HiloS3_1();
		
		HiloS3_2 h2 = new HiloS3_2(h1);
		
		h2.start(); //No comienza hasta que h1 termine
		
		h1.start();
		
		System.out.println("Tareas terminadas");

	}

}

class HiloS3_1 extends Thread {
	
	public void run() {
		
		for(int i=0; i<15; i++) {
			
			System.out.println("Ejecutando hilo: " + getName());
			
			try {
				
				Thread.sleep(500);
				
			} catch (InterruptedException e) {

				e.printStackTrace();
				
			}
			
		}
		
	}
	
}

class HiloS3_2 extends Thread {
	
	public HiloS3_2(Thread h1) {
		
		this.h1 = h1;
		
	}
	
	public void run() {
		
		try {
			
			h1.join(); //Le indicamos que no se ejecute hasta que este hilo termine su ejecución
			
		} catch (InterruptedException e1) {
	
			e1.printStackTrace();
			
		}
		
		for(int i=0; i<15; i++) {
			
			System.out.println("Ejecutando hilo: " + getName());
			
			try {
				
				Thread.sleep(500);
				
			} catch (InterruptedException e) {

				e.printStackTrace();
				
			}
			
		}
		
	}
	
	private Thread h1;
	
}