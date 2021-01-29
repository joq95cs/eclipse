package hilos;

import java.util.concurrent.locks.*;

public class SincronizacionBanco {

	public static void main(String[] args) {
		
		Banco b = new Banco();
		
		for(int i=0; i<100; i++) {
			
			Transferencias run = new Transferencias(b, i, 2000);
			
			Thread t = new Thread(run);
			
			t.start();
			
		}

	}

}

class Banco {
	
	public Banco() {
		
		cuentas = new double[100];
		
		for(int i=0; i<cuentas.length; i++) {
			
			cuentas[i] = 2000;
			
		}
		
		bloqueoBanco = new ReentrantLock(); //Clase ReentrantLock que incluye los métodos lock() y unlock()
		
		saldoSuficiente = bloqueoBanco.newCondition(); //Se obtiene un objeto de tipo Condition por medio del método del objeto Lock
		
	}
	
	public void transferir(int cuentaOrigen, int cuentaDestino, double cantidad) {
		
		bloqueoBanco.lock();
		
		try { //El try se usa para delimitar el trozo de código a bloquear y asegurarse de que se desbloquee sea que haya un error o no
		
			/*if(cuentas[cuentaOrigen] < cantidad) { //Evalúa que el saldo de la cuenta no es menor que la cantidad a transferir
				
				return;
				
			}*/
			
			while(cuentas[cuentaOrigen] < cantidad) { //Se evalúa la condición cada vez que el hilo se despierta
				
				try {
					
					saldoSuficiente.await(); //Se usa para indicar que mientras la condición de while sea cierta el hilo permanezca a la espera
					
					//Se libera el bloqueo
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
					
				}
				
			}
			
			System.out.println("Hilo actual: " + Thread.currentThread());
			
			cuentas[cuentaOrigen] -= cantidad; //Dinero que sale de la cuenta de orígen
			
			System.out.printf("Transferidos %10.2f de cuenta %d a cuenta %d\n", cantidad, cuentaOrigen, cuentaDestino); //Imprimir con formato
			
			cuentas[cuentaDestino] += cantidad;
			
			System.out.printf("Saldo total: %10.2f\n", getSaldoTotal());
			
			saldoSuficiente.signalAll(); //Debe colocarse en un punto donde sea seguro que se haya hecho la transferencia
			
			//Se pueden colocar varias condiciones para que un hilo pueda ejecutarse
			
		} finally { //Se usa para indicar que el trozo de código debe desbloquearse siempre haya error o no
			
			bloqueoBanco.unlock();
			
		}
			
	}
	
	public double getSaldoTotal() {
		
		double saldo = 0;
		
		for(double each: cuentas) {
			
			saldo += each;
			
		}
		
		return saldo;
		
	}
	
	private final double[] cuentas;
	
	private Lock bloqueoBanco; //Interfaz Lock
	
	private Condition saldoSuficiente; //Interfaz Condition, se le suele dar nombre descriptivo al objeto
	
}

class Transferencias implements Runnable {
	
	public Transferencias(Banco b, int cuentaOrigen, double cantidadMaxima) {
		
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
	
	private Banco b;
	
	private int cuentaOrigen;
	
	private double cantidadMaxima;
	
}