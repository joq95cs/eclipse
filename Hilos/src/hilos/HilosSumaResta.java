package hilos;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class HilosSumaResta {

	public static void main(String[] args) {
		
		MarcoHSR marco = new MarcoHSR();
		
		marco.setVisible(true);

	}

}

class MarcoHSR extends JFrame {
	
	public MarcoHSR() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(3*ancho/8, 3*alto/8, ancho/4, alto/4);
		
		setTitle("Suma y resta con hilos");
		
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new LaminaHSR());
		
	}
	
}

class LaminaHSR extends JPanel {
	
	public LaminaHSR() {
		
		botonSumar = new JButton("Sumar");
		
		botonRestar = new JButton("Restar");
		
		botonDetener = new JButton("Detener");
		
		OyenteHSR oyente = new OyenteHSR();
		
		botonSumar.addMouseListener(oyente);
		
		botonRestar.addMouseListener(oyente);
		
		botonDetener.addMouseListener(oyente);
		
		add(botonSumar);
		
		add(botonRestar);
		
		add(botonDetener);
		
	}
	
	private class OyenteHSR extends MouseAdapter {
		
		public OyenteHSR() {
			
			resultado = 0;
			
		}
		
		public void mouseClicked(MouseEvent e) {
			
			if(e.getSource() == botonSumar) {
				
				hiloSumar = new Thread(new HiloSuma());
				
				hiloSumar.start();
				
			} else if(e.getSource() == botonRestar) {
				
				hiloRestar = new Thread(new HiloResta());
				
				hiloRestar.start();
				
			} else {
				
				Thread hiloDetener = new Thread(new HiloDetener());
				
				hiloDetener.start();
				
			}
			
		}
		
	}
	
	private class HiloSuma implements Runnable {
		
		public void run() {
			
			do {
				
				try {
					
					Thread.sleep(1000);
					
				} catch (InterruptedException e) {
					
				}
				
				resultado ++;
				
			} while(true);
			
		}
		
	}
	
	private class HiloResta implements Runnable {
		
		public void run() {
			
			do {
				
				try {
					
					Thread.sleep(1000);
					
				} catch (InterruptedException e) {

				}
				
				resultado --;
				
			} while(true);
			
		}
		
	}
	
	private class HiloDetener implements Runnable {
		
		public void run() {
			
			System.out.println(resultado);
			
			System.exit(0);
			
		}
		
	}
	
	private JButton botonSumar;
	
	private JButton botonRestar;
	
	private JButton botonDetener;
	
	private int resultado;
	
	private Thread hiloSumar;
	
	private Thread hiloRestar;
	
}
