package hilos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class Semaforo {

	public static void main(String[] args) {
		
		MarcoSemaforo marco = new MarcoSemaforo();
		
		marco.setVisible(true);

	}

}

class MarcoSemaforo extends JFrame {
	
	public MarcoSemaforo() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(ancho/3, alto/3, ancho/3, alto/3);
		
		setTitle("Semáforo");
		
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		LaminaSemaforo lamina = new LaminaSemaforo();
		
		add(lamina);
		
	}
	
}

class LaminaSemaforo extends JPanel {
	
	public LaminaSemaforo() {
		
		iniciarHilos();
		
		setLayout(new BorderLayout());
		
		JPanel lamina_oeste = new JPanel();
		
		lamina_oeste.setLayout(new GridLayout(3, 1));
		
		lamina_rojo = new JPanel();
		
		lamina_rojo.setLayout(new GridLayout(1,1));
		
		JTextField campo = new JTextField(15);
		
		campo.setEnabled(false);
		
		campo.setVisible(false);
		
		lamina_rojo.add(campo);
		
		lamina_rojo.setBackground(Color.RED.darker().darker().darker());
		
		lamina_amarillo = new JPanel();
		
		lamina_amarillo.setBackground(Color.YELLOW.darker().darker().darker());
		
		lamina_verde = new JPanel();
		
		lamina_verde .setBackground(Color.GREEN.darker().darker().darker());
		
		lamina_oeste.add(lamina_rojo);
		
		lamina_oeste.add(lamina_amarillo);
		
		lamina_oeste.add(lamina_verde);
		
		add(lamina_oeste, BorderLayout.WEST);
		
		JPanel lamina_centro = new JPanel();
		
		lamina_centro.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridwidth = 1;
		
		c.gridheight = 1;
		
		c.gridy = 0;
		
		c.weightx = 1;
		
		OyenteSemaforo oyente = new OyenteSemaforo();
		
		boton_iniciar = new JButton("Iniciar");
		
		boton_iniciar.addActionListener(oyente);
		
		c.gridx = 0;
		
		lamina_centro.add(boton_iniciar, c);
		
		boton_salir = new JButton("Salir");
		
		boton_salir.addActionListener(oyente);
		
		c.gridx = 2;
		
		lamina_centro.add(boton_salir, c);
		
		add(lamina_centro, BorderLayout.CENTER);
		
	}
	
	public void iniciarHilos() {
		
		hilo_iniciar = new HiloIniciar();
		
		hilo_salir = new HiloSalir();
		
		hilo_ciclo = new HiloCiclo();
		
	}
	
	private class OyenteSemaforo implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == boton_iniciar) {
				
				try {
					
					hilo_iniciar.start();
					
				} catch(Exception ex) {
					
					JOptionPane.showMessageDialog(null, "El semáforo ya está funcionando");
					
				}
				
			} else {
				
				hilo_salir.start();
				
			}
			
		}
		
	}
	
	private class HiloIniciar extends Thread {
		
		public HiloIniciar() {
			
			super(new Runnable() {
				
				public void run() {
					
					if(hilo_ciclo.isAlive()) {
						
					} else {
						
						hilo_ciclo.start();
						
					}
					
				}
				
			});
			
		}
		
	}
	
	private class HiloSalir extends Thread {
		
		public HiloSalir() {
			
			super(new Runnable() {
				
				public void run() {
					
					System.exit(0);
					
				}
				
			});
			
		}
		
	}
	
	private class HiloCiclo extends Thread {	
		
		public HiloCiclo() {
			
			super(new Runnable() {
				
				public void run() {
					
					do {
						
						try {
							
							lamina_rojo.setBackground(Color.RED);
							
							Thread.sleep(2000);
							
							lamina_amarillo.setBackground(Color.YELLOW);
								
							Thread.sleep(2000);
							
							lamina_rojo.setBackground(Color.RED.darker().darker().darker());
							
							lamina_amarillo.setBackground(Color.YELLOW.darker().darker().darker());
							
							lamina_verde.setBackground(Color.GREEN);
								
							Thread.sleep(4000);
							
							lamina_verde.setBackground(Color.GREEN.darker().darker().darker());
							
						} catch(InterruptedException e) {}
						
					} while(true);
					
				}
				
			});
			
		}
		
	}
	
	private JPanel lamina_rojo;
	
	private JPanel lamina_amarillo;
	
	private JPanel lamina_verde;
	
	private JButton boton_iniciar;
	
	private JButton boton_salir;
	
	private HiloIniciar hilo_iniciar;
	
	private HiloSalir hilo_salir;
	
	private HiloCiclo hilo_ciclo;
	
}
