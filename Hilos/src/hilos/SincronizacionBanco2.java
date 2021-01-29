package hilos;

import java.util.concurrent.locks.*;

public class SincronizacionBanco2 {

	public static void main(String[] args) {
		
		Banco2 b = new Banco2();
		
		for(int i=0; i<100; i++) {
			
			Transferencias2 run = new Transferencias2(b, i, 2000);
			
			Thread t = new Thread(run);
			
			t.start();
			
		}

	}

}

class Banco2 {
	
	public Banco2() {
		
		cuentas = new double[100];
		
		for(int i=0; i<cuentas.length; i++) {
			
			cuentas[i] = 2000;
			
		}
		
	}
	
	public synchronized void transferir(int cuentaOrigen, int cuentaDestino, double cantidad) {
		
		while(cuentas[cuentaOrigen] < cantidad) {
			
			try {
				
				wait(); //Indica al hilo que se ponga en espera indefinida
				
			} catch (InterruptedException e) {

				e.printStackTrace();
				
			}
			
		}
		
		System.out.println("Hilo actual: " + Thread.currentThread());
			
		cuentas[cuentaOrigen] -= cantidad; //Dinero que sale de la cuenta de orígen
			
		System.out.printf("Transferidos %10.2f de cuenta %d a cuenta %d\n", cantidad, cuentaOrigen, cuentaDestino); //Imprimir con formato
			
		cuentas[cuentaDestino] += cantidad;
			
		System.out.printf("Saldo total: %10.2f\n", getSaldoTotal());
		
		notifyAll(); //Notifica a todos los hilos en espera que continúen
		
		//Sólo se puede usar una condición con los métodos wait() y notifyAll()
		
	}
	
	public double getSaldoTotal() {
		
		double saldo = 0;
		
		for(double each: cuentas) {
			
			saldo += each;
			
		}
		
		return saldo;
		
	}
	
	private final double[] cuentas;
	
}

class Transferencias2 implements Runnable {
	
	public Transferencias2(Banco2 b, int cuentaOrigen, double cantidadMaxima) {
		
		this.b = b;
		
		this.cuentaOrigen = cuentaOrigen;
		
		this.cantidadMaxima = cantidadMaxima;
		
	}
	
	public void run() {
		
		while(true) {
			
			int cuentaDestino = (int)Math.round((99*Math.random()));
			
			double cantidad = cantidadMaxima*Math.random();
			
			b.transferir(cuentaOrigen, cuentaDestino, cantidad);
			
			try {
				
				Thread.sleep((int)(Math.random()*10));
				
			} catch (InterruptedException e) {
		
				e.printStackTrace();
				
			}
			
		}
		
	}
	
	private Banco2 b;
	
	private int cuentaOrigen;
	
	private double cantidadMaxima;
	
}