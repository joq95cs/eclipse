package hilos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class OperacionesHilos {

	public static void main(String[] args) {
		
		new MarcoOH().setVisible(true);
		
	}

}

class MarcoOH extends JFrame {
	
	public MarcoOH() {
		
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width/3, Toolkit.getDefaultToolkit().getScreenSize().height/3);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("Operaciones Hilos");
		
		setResizable(false);
		
		add(new LaminaOH());
		
	}
	
}

class LaminaOH extends JPanel {
	
	public LaminaOH() {
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.weightx = 1;
		
		c.weighty = 1;
		
		c.gridx = 0;
		
		c.gridy = 0;
		
		add(new JLabel("Número 1"), c);
		
		c.gridx = 1;
		
		cn1 = new JTextField(5);
		
		add(cn1, c);
		
		c.gridx = 2;
		
		add(new JLabel("Número 2"), c);
		
		c.gridx = 3;
		
		cn2 = new JTextField(5);
		
		add(cn2, c);
		
		c.gridwidth = 2;
		
		c.gridx = 0;
		
		c.gridy = 1;
		
		bti = new JButton("Iniciar hilos");
		
		OyenteOH o = new OyenteOH();
		
		bti.addActionListener(o);
		
		add(bti, c);
		
		c.gridx = 2;
		
		btp = new JButton("Parar hilos");
		
		btp.addActionListener(o);
		
		add(btp, c);
		
		c.gridwidth = 1;
		
		c.gridx = 0;
		
		c.gridy = 2;
		
		add(new JLabel("Resultado suma"), c);
		
		c.gridx = 1;
		
		crs = new JTextField(5);
		
		crs.setEditable(false);
		
		add(crs, c);
		
		c.gridx = 2;
		
		add(new JLabel("Resultado resta"), c);
		
		c.gridx = 3;
		
		crr = new JTextField(5);
		
		crr.setEditable(false);
		
		add(crr, c);
		
		
		
	}
	
	private JTextField cn1, cn2, crs, crr;
	
	private JButton bti, btp;
	
	private Hilo1 h1;
	
	private Hilo2 h2;
	
	private Hilo3 h3;
	
	private boolean listo;
	
	private class OyenteOH implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == bti) {
				
				h1 = new Hilo1();
				
				h1.start();
				
				System.out.println("Hilo 1 iniciado");
				
				h2 = new Hilo2();
				
				h2.start();
				
				System.out.println("Hilo 2 iniciado");
				
				h3 = new Hilo3();
				
				h3.start();
				
				System.out.println("Hilo 3 iniciado");
				
				System.out.println();
	
			} else {
				
				h1.stop();
				
				System.out.println("Hilo 1 detenido");
				
				h2.stop();
				
				System.out.println("Hilo 2 detenido");
				
				h3.stop();
				
				System.out.println("Hilo 3 detenido");
				
				System.out.println();
				
			}
			
		}
		
	}
	
	class Hilo1 extends Thread {
		
		public Hilo1() {
			
			super(new Runnable() {
				
				public void run() {
					
					do {
						
						if(!cn1.getText().equals("") && !cn2.getText().equals("")) {
							
							listo = true;
							
						} else {
							
							listo = false;
							
						}
						
						try {
							
							Thread.sleep(500);
							
						} catch(InterruptedException e) {}
						
					} while(true);
					
				}
				
			});
			
		}
		
	}
	
	class Hilo2 extends Thread {
		
		public Hilo2() {
			
			super(new Runnable() {
				
				public void run() {
					
					do {
						
						if(listo) {
							
							try {
							
								crs.setText("" + (Integer.parseInt(cn1.getText()) + Integer.parseInt(cn2.getText()))); 
								
							} catch(Exception e) {}
								
						}
						
						try {
							
							Thread.sleep(1000);
							
						} catch(InterruptedException e) {}

						
					} while(true);
					
				}
				
			});
			
		}
		
	}

	class Hilo3 extends Thread {
		
		public Hilo3() {
			
			super(new Runnable() {
				
				public void run() {
					
					do {
						
						if(listo) {
							
							try {
							
								crr.setText("" + (Integer.parseInt(cn1.getText()) - Integer.parseInt(cn2.getText()))); 
								
							} catch(Exception e) {}
								
						}
						
						try {
							
							Thread.sleep(1000);
							
						} catch(InterruptedException e) {}

						
					} while(true);
					
				}
				
			});
			
		}
		
	}
	
}