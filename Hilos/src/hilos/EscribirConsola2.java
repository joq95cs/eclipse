package hilos;

public class EscribirConsola2 {

	public static void main(String[] args) {
		
		try {
		
			Thread t1 = new Thread(new Alumno2("Ángel"));
			
			Thread t2 = new Thread(new Alumno2("Joqsan"));
			
			Thread t3 = new Thread(new Alumno2("Brian"));
			
			Thread t4 = new Thread(new Alumno2("Jonas"));
			
			t1.start();
			
			t2.start();
			
			t3.start();
			
			t4.start();
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}

	}

}

class Alumno2 implements Runnable {
	
	public Alumno2(String nombre) {
		
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
			
			Thread.yield();
			
		}
		
	}
	
	private String nombre;
	
}
