package hilos;

public class SincronizacionExamen {

	public static void main(String[] args) {
		
		MSE m = new MSE();
		
		new Thread(new RSE(m, "Joqsan")).start();
		
		new Thread(new RSE(m, "Tere")).start();
		
		new Thread(new RSE(m, "Lalo")).start();
		
		new Thread(new RSE(m, "Gil")).start();
		
		new Thread(new RSE(m, "Pedro")).start();
		
		new Thread(new RSE(m, "maestro")).start();
		
		new Thread(new RSE(m, "Jonás")).start();
		
		new Thread(new RSE(m, "Brian")).start();

	}

}

class MSE {
	
	public synchronized void llegarAlumno(String n) throws InterruptedException {
		
		//synchronized (this) {
			
			System.out.println("El alumno " + n + " ha llegado");
			
			if(RSE.llegoMaestro) {
				
				irse(n);
				
			} else {
				
				wait();

				empezarExamen(n);
				
			}
			
		//}
		
	}
	
	public synchronized void llegarMaestro() {
		
		//synchronized (this) {
			
			notifyAll();
			
			System.out.println("El maestro ha llegado... hora de empezar el examen");
			
			RSE.llegoMaestro = true;
			
		//}
		
	}

	private synchronized void empezarExamen(String n) {
		
		System.out.println("El alumno " + n + " ha empezado el examen");
		
	}
	
	private synchronized void irse(String n) {
		
		System.out.println("El alumno " + n + " ha llegado tarde y no podrá hacer el examen");
		
	}
	
}

class RSE implements Runnable {
	
	public RSE(MSE m, String n) {
		
		this.m = m;
		
		this.n = n;
		
	}
	
	public void run() {
		
		try {
		
			if(n.equalsIgnoreCase("maestro")) {
				
				m.llegarMaestro();
				
			} else {
				
				m.llegarAlumno(n);
				
			}
			
		} catch(InterruptedException e) {}
		
	}
	
	private MSE m;
	
	private String n;
	
	public static boolean llegoMaestro = false;
	
}