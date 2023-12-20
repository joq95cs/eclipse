package hilos;

public class SincronizacionOrquesta {

	public static void main(String[] args) {
		
		RSO r = new RSO();
		
		HOrquesta musico1 = new HOrquesta("Ángel", "Violín", r, false);
		
		HOrquesta musico2 = new HOrquesta("Joqsan", "Flauta", r, false);
		
		HOrquesta musico3 = new HOrquesta("Tere", "Chelo", r, false);
		
		HOrquesta musico4 = new HOrquesta("Karla", "Clarinete", r, false);
		
		HOrquesta director = new HOrquesta("Joqsan", "", r, true);
		
		musico1.start();
		
		musico2.start();
		
		musico3.start();
		
		musico4.start();
		
		director.start();

	}

}

class RSO {
	
	public synchronized void iniciarConcierto(String nombre, String instrumento) {
		
		try {
			
			System.out.println("Llegó el/la músico(a) " + nombre);
			
			wait();
			
			System.out.println("El/La músico(a) " + nombre + " ha empezado a tocar el/la " + instrumento);
			
			
		} catch(InterruptedException e) {}
		
	}
	
	public synchronized void llegarDirector() {
		
		notifyAll();
		
		System.out.println("\nEl director ha llegado... ¡Qué comience el concierto!\n");
		
	}
	
}

class HOrquesta extends Thread {
	
	public HOrquesta(String nombre, String instrumento, RSO r, boolean esDirector) {
		
		setName(nombre);
		
		this.instrumento = instrumento;
		
		this.r = r;
		
		this.esDirector = esDirector;
		
	}
	
	public void run() {
		
		if(esDirector) {
			
			r.llegarDirector();
			
		} else {
			
			r.iniciarConcierto(getName(), instrumento);
			
		}
		
	}
	
	private RSO r;
	
	private String instrumento;
	
	private boolean esDirector;
	
} 
