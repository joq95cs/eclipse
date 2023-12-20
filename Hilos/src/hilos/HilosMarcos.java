package hilos;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class HilosMarcos {

	public static void main(String[] args) {
		
		System.out.println("Hilo 1 se ha iniciado...");
		
		MarcoHM marco = new MarcoHM();
		
		marco.setVisible(true);
		
	}

}

class MarcoHM extends JFrame {
	
	public MarcoHM() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(3*ancho/8, 3*alto/8, ancho/4, alto/4);
		
		setTitle("Prueba de hilos");
		
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new LaminaHM());
		
	}
	
}

class LaminaHM extends JPanel {
	
	public LaminaHM() {
		
		boton_iniciar = new JButton("Iniciar hilo");
		
		boton_salir = new JButton("Salir");
		
		OyenteHM oyente = new OyenteHM();
		
		boton_iniciar.addActionListener(oyente);
		
		boton_salir.addActionListener(oyente);
		
		add(boton_iniciar);
		
		add(boton_salir);
		
	}
	
	private class OyenteHM implements ActionListener {
		
		public OyenteHM() {
			
			contador = 1;
			
		}
		
		public void actionPerformed(ActionEvent e) {
			
			Thread hilo = null;
			
			if(e.getSource() == boton_iniciar) {
				
				hilo = new Thread(new HiloHM(1));
				
			} else {
				
				hilo = new Thread(new HiloHM(2));
				
			}
			
			hilo.start();
			
			contador ++;
			
			System.out.println();
			
			System.out.println("Hilo " + contador + " se ha iniciado...");
			
			System.out.println();
			
		}
		
	}
	
	private JButton boton_iniciar;
	
	private JButton boton_salir;
	
	private static int contador;
	
}

class HiloHM implements Runnable {
	
	public HiloHM(int boton_presionado) {
		
		this.boton_presionado = boton_presionado;
		
	}
	
	public void run() {
		
		if(boton_presionado == 1) {
			
			JFrame marco = new JFrame();
			
			marco.setSize(300, 250);
			
			marco.setResizable(false);
			
			marco.setVisible(true);
			
			do {
				
				System.out.println("Hilo ejecutandose: " + Thread.currentThread().getName());
				
				try {
				
					Thread.sleep(500);
					
				} catch(InterruptedException e) {}
				
			} while(true);
			
		} else {
			
			System.exit(0);
			
		}
		
	}
	
	int boton_presionado;
	
}
