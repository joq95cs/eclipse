package hilos;

public class SuspenderReanudar {

	public static void main(String[] args) {
		
		h = new HiloSR1();
		
		h.start();

	}
	
	static HiloSR1 h;

}

class HiloSR1 extends Thread {
	
	public void run() {
		
		for(int i=0; i<15; i++) {
			
			if(i == 9) {
				
				System.out.println("\nHilo suspendido");
				
				new HiloSR2().start();
				
				suspend();
				
			}
			
			System.out.println(i);
			
			try {
				
				Thread.sleep(500);
				
			} catch(InterruptedException e) {
				
			}
			
		}
		
	}
	
}

class HiloSR2 extends Thread {
	
	public void run() {
		
		try {
			
			Thread.sleep(3000);
			
		} catch(InterruptedException e) {
			
		}
		
		System.out.println("\nHilo reanudado\n");
		
		SuspenderReanudar.h.resume();
		
	}
	
}