package hilos;

import java.awt.geom.*;

import javax.swing.*;

import java.util.*;

import java.awt.*;

import java.awt.event.*;

public class PelotaHilos {

	public static void main(String[] args) {
		
		JFrame marco=new MarcoRebote();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

//Movimiento de la pelota-----------------------------------------------------------------------------------------

class Pelota {
	
	//Mueve la pelota invirtiendo posición si choca con límites
	
	public void mueve_pelota(Rectangle2D limites) {
		
		x += dx;
		
		y += dy;
		
		if(x < limites.getMinX()) {
			
			x = limites.getMinX();
			
			dx =- dx;
		}
		
		if(x + TAMX>=limites.getMaxX()) {
			
			x = limites.getMaxX() - TAMX;
			
			dx =- dx;
		}
		
		if(y<limites.getMinY()) {
			
			y = limites.getMinY();
			
			dy =- dy;
		}
		
		if(y + TAMY>=limites.getMaxY()) {
			
			y = limites.getMaxY()-TAMY;
			
			dy =- dy;
			
		}
		
	}
	
	//Forma de la pelota en su posición inicial
	
	public Ellipse2D getShape() {
		
		return new Ellipse2D.Double(x,y,TAMX,TAMY);
		
	}	
	
	private static final int TAMX=15;
	
	private static final int TAMY=15;
	
	private double x=0;
	
	private double y=0;
	
	private double dx=1;
	
	private double dy=1;
	
}

// Lámina que dibuja las pelotas----------------------------------------------------------------------

class LaminaPelota extends JPanel {
	
	//Añadimos pelota a la lámina
	
	public void add(Pelota b) {
		
		pelotas.add(b);
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D)g;
		
		for(Pelota b: pelotas) {
			
			
			g2.fill(b.getShape());
			
		}
		
	}
	
	private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();
}

//Marco con lámina y botones------------------------------------------------------------------------------

class MarcoRebote extends JFrame {
	
	public MarcoRebote() {
		
		setSize(400,350);
		
		setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 - 200, Toolkit.getDefaultToolkit().getScreenSize().height/2 - 175);
		
		setTitle ("Pelotas");
		
		lamina = new LaminaPelota();
		
		add(lamina, BorderLayout.CENTER);
		
		JPanel laminaBotones=new JPanel();
		
		ponerBoton(laminaBotones, "¡Clic!", new ActionListener() {
			
			public void actionPerformed(ActionEvent evento) {
				
				comienza_el_juego();
				
			}
			
		});
		
		ponerBoton(laminaBotones, "Detener", new ActionListener() {
			
			public void actionPerformed(ActionEvent evento) {
				
				detener();
				
			}
			
		});
		
		ponerBoton(laminaBotones, "Salir", new ActionListener() {
			
			public void actionPerformed(ActionEvent evento) {
				
				System.exit(0);
				
			}
			
		});
		
		add(laminaBotones, BorderLayout.SOUTH);
		
	}
	
	//Ponemos botones
	
	public void ponerBoton(Container c, String titulo, ActionListener oyente) {
		
		JButton boton=new JButton(titulo);
		
		c.add(boton);
		
		boton.addActionListener(oyente);
		
	}
	
	//Añade pelota y la bota 1000 veces
	
	public void comienza_el_juego () {
				
		Pelota pelota=new Pelota();
			
		lamina.add(pelota);
		
		Runnable rp = new RunPelota(pelota, lamina);
		
		tp = new Thread(rp);
		
		tp.start();
		
	}
	
	public void detener() {
		
		tp.interrupt();
		
	}
	
	private LaminaPelota lamina;
	
	private Thread tp;
	
}

class RunPelota implements Runnable {
	
	public RunPelota(Pelota p, JPanel l) {
		
		this.p = p;
		
		this.l = l;
		
	}
	
	public void run() {
		
		System.out.println("Hilo interrumpido: " + Thread.currentThread().isInterrupted());
		
		//for (int i=1; i<=3000; i++) {
		
		//while(!Thread.interrupted()) {
		
		while(!Thread.currentThread().isInterrupted()) {
		
			p.mueve_pelota(l.getBounds());
				
			l.paint(l.getGraphics());
			
			try {
				
				Thread.sleep(3);
				
			} catch(InterruptedException e) {
				
				System.err.println(e.getMessage());
				
			}
				
		}
		
		System.out.println("Hilo interrumpido: " + Thread.currentThread().isInterrupted());
		
	}
	
	private Pelota p;
	
	private JPanel l;
	
}