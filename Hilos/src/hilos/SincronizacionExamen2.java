package hilos;

import java.util.concurrent.locks.*;

public class SincronizacionExamen2 {

	public static void main(String[] args) {
		
		Llegar objetoLlegar = new Llegar();
		
		Thread[] hilos = new Thread[6];
		
		hilos[0] = new Thread() {
			
			public void run() {
				
				objetoLlegar.llegar("Joqsan", false);
				
			}
			
		};
		
		hilos[1] = new Thread() {
			
			public void run() {
				
				objetoLlegar.llegar("Jonas", false);
				
			}
			
		};
		
		hilos[2] = new Thread() {
			
			public void run() {
				
				objetoLlegar.llegar("Alberto", false);
				
			}
			
		};
		
		hilos[3] = new Thread() {
			
			public void run() {
				
				objetoLlegar.llegar(null, true);
				
			}
			
		};
		
		hilos[4] = new Thread() {
			
			public void run() {
				
				objetoLlegar.llegar("Brian", false);
				
			}
			
		};
		
		hilos[5] = new Thread() {
			
			public void run() {
				
				objetoLlegar.llegar("Gil", false);
				
			}
			
		};
		
		for(int i=0; i<5; i++) {
			
			hilos[i].start();
			
		}
		
	}

}

class Llegar {
	
	public Llegar() {
		
		bloqueo = new ReentrantLock();
		
		maestroNoHaLlegado = bloqueo.newCondition();
		
		maestroLlego = false;
		
	}
	
	public void llegar(String nombre, boolean esMaestro) {
		
		bloqueo.lock();
		
		try {
			
			if(!esMaestro) {
				
				System.out.println("El alumno \"" + nombre +"\" ha llegado");
				
				while(!maestroLlego) {
					
					maestroNoHaLlegado.await();
					
					System.out.println("El alumno \"" + nombre +"\" ha empezado a hacer el examen");
					
				}
				
			} else {
				
				System.out.println("El maestro ha llegado");
				
				maestroLlego = true;
				
				maestroNoHaLlegado.signalAll();
				
			}
			
		} catch(InterruptedException e) {
			
			e.printStackTrace();
			 
		} finally {
			
			bloqueo.unlock();
			
		}
		
	}
	
	private Lock bloqueo;
	
	private Condition maestroNoHaLlegado;
	
	private boolean maestroLlego;
	
}
