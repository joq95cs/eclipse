package hilos;

import java.util.*;

public class ControlHiloPrincipal {

	public static void main(String[] args) {
		
		Thread hp = Thread.currentThread();
		
		hp.setName("Mi hilo principal");
		
		System.out.println(hp.isAlive() ? "El hilo principal est� vivo y se llama " + hp.getName() : "");
		
		hp.interrupt();
		
		//hp.stop();
		
	}

}
