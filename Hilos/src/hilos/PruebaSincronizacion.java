package hilos;

public class PruebaSincronizacion {

	public static void main(String[] args) {
		
		RecursoSincronizado rs = new RecursoSincronizado();
		
		Thread a1 = new Thread("Hatsune Miku") {
			
			public void run() {
				
				rs.cantando();
				
			}
			
		};
		
		Thread a2 = new Thread("Kagamine Rin") {
			
			public void run() {
				
				rs.cantando();
				
			}
			
		};
		
		Thread a3 = new Thread("Megurine Luka") {
			
			public void run() {
				
				rs.cantando();
				
			}
			
		};
		
		Thread a4 = new Thread("Kagamine Len") {
			
			public void run() {
				
				rs.cantando();
				
			}
			
		};
		
		a1.start();
		
		a2.start();
		
		a3.start();
		
		a4.start();

	}

}

class RecursoSincronizado {
	
	public RecursoSincronizado() {
		
		x = 0;
		
	}
	
	public void cantando() {
		
		synchronized (this) {
			
			x ++;
			
			System.out.println(Thread.currentThread().getName() + " está cantando");
			
			System.out.println("No. canción: " + x + "\n");
			
			try {
				
				Thread.sleep(3000);
				
			} catch(Exception e) {}
			
			if(x == 4) {
				
				System.out.println("\nFin del concierto");
				
			}
			
		}
		
	}
	
	private int x;
	
}