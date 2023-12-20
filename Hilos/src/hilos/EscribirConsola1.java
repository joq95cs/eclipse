package hilos;

public class EscribirConsola1 {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Alumno1("Ángel"));
		
		Thread t2 = new Thread(new Alumno1("Joqsan"));
		
		Thread t3 = new Thread(new Alumno1("Brian"));
		
		Thread t4 = new Thread(new Alumno1("Jonas"));
		
		t1.start();
		
		try {
			
			t1.join();
			
		} catch(InterruptedException e) {
			
			e.printStackTrace();
			
		}
		
		t2.start();
		
		try {
			
			t2.join();
			
		} catch(InterruptedException e) {
			
			e.printStackTrace();
			
		}
		
		t3.start();
		
		try {
			
			t3.join();
			
		} catch(InterruptedException e) {
			
			e.printStackTrace();
			
		}
		
		t4.start();

	}

}

class Alumno1 implements Runnable {
	
	public Alumno1(String nombre) {
		
		this.nombre = nombre;
		
	}
	
	public void run() {
		
		for(int i=0; i<5; i++) {
			
			System.out.println("Hola, soy " + nombre + ", y este es mi mensaje número " + (i+1));
			
			try {
				
				Thread.sleep(500);
				
			} catch(InterruptedException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}
	
	private String nombre;
	
}