package hilos;

import javax.swing.*;

import java.awt.*;

public class UsoHilos {

	public static void main(String[] args) {
		
		new MarcoUH().setVisible(true);
		
		new Hilo1("Hilo 1").start();
		
		new Hilo2("Hilo 2").start();
		
		new Hilo3("Hilo 3").start();

	}

}

class MarcoUH extends JFrame {
	
	public MarcoUH() {
		
		setSize(600, 450);
		
		setTitle("Hilos");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new LaminaUH());
		
	}
	
}

class LaminaUH extends JPanel {
	
	public LaminaUH() {
		
		setLayout(new GridLayout(1, 3));
		
		a1 = new JTextArea();
		
		add(new JScrollPane(a1));
		
		a2 = new JTextArea();
		
		add(new JScrollPane(a2));
		
		a3 = new JTextArea();
		
		add(new JScrollPane(a3));
		
	}
	
	public static JTextArea a1, a2, a3;
	
}

class Hilo1 extends Thread {
	
	public Hilo1(String nombre) {
		
		super(nombre);
		
	}
	
	public void run() {
		
		for(int i=0; i<10; i++) {
			
			LaminaUH.a1.append(i + "\n");
			
			try {
				
				Thread.sleep(1000);
				
			} catch(InterruptedException e) {}
			
		}
		
	}
	
}

class Hilo2 extends Thread {
	
	public Hilo2(String nombre) {
		
		super(nombre);
		
	}
	
	public void run() {
		
		for(int i=0; i<50; i++) {
			
			LaminaUH.a2.append(i + "\n");
			
			try {
				
				Thread.sleep(500);
				
			} catch(InterruptedException e) {}
			
		}
		
	}
	
}

class Hilo3 extends Thread {
	
	public Hilo3(String nombre) {
		
		super(nombre);
		
	}
	
	public void run() {
		
		for(int i=0; i<100; i++) {
			
			LaminaUH.a3.append(i + "\n");
			
			try {
				
				Thread.sleep(200);
				
			} catch(InterruptedException e) {}
			
		}
		
	}
	
}