package hilos;

public class PruebaSincronizacion2 {

	public static void main(String[] args) {
		
		MetodosSincronizados ms = new MetodosSincronizados();
		
		HS2 h1 = new HS2("Hilo 1", ms, false);
		
		HS2 h2 = new HS2("Hilo 2", ms, false);
		
		HS2 h3 = new HS2("Hilo 3", ms, false);
		
		HS2 h4 = new HS2("Hilo 4", ms, false);
		
		HS2 h5 = new HS2("Hilo 5", ms, true);
		
		h1.start();
		
		h2.start();
		
		h3.start();
		
		h4.start();
		
		h5.start();

	}

}

class MetodosSincronizados {
	
	public synchronized void listo() {
		
		System.out.println(Thread.currentThread().getName() + " en ejecuci�n");
		
		notifyAll();
		
		System.out.println(Thread.currentThread().getName() + " finalizando su ejecuci�n");
		
	}
	
	public synchronized void noListo() throws Exception {
		
		System.out.println(Thread.currentThread().getName() + " en ejecuci�n");
		
		//while(true);
		
		System.out.println(Thread.currentThread().getName() + " entrando en estado de espera");
		
		wait();
		
		System.out.println(Thread.currentThread().getName() + " finalizando su ejecuci�n");
		
	}
	
}

class HS2 extends Thread {
	
	public HS2(String n, MetodosSincronizados ms, boolean listo) {
		
		super(n);
		
		this.ms = ms;
		
		this.listo = listo;
		
	}
	
	public void run() {
		
		try {
		
			if(listo) {
				
				ms.listo();
				
			} else {
				
				ms.noListo();
				
			}
			
		} catch(Exception e) {}
		
	}
	
	private MetodosSincronizados ms;
	
	private boolean listo;
	
}