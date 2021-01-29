package hilos;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class InterrupcionHilos {

	public static void main(String[] args) {
		
		MarcoIH m = new MarcoIH();
		
		m.setVisible(true);
		
		h1 = new Thread() {
			
			public void run() {
				
				while(true) {
					
					m.a1.append("Hilo 1 en ejecución\n");
					
					try {
						
						Thread.sleep(500);
						
						
					} catch(Exception e) {
						
						//Thread.currentThread().interrupt();
						
						//h1.interrupt();
						
						break;
						
					}
					
				}
				
			}
			
		};
		
		h2 = new Thread() {
			
			public void run() {
				
				while(true) {
					
					m.a2.append("Hilo 2 en ejecución\n");
					
					try {
						
						Thread.sleep(500);
						
					} catch(Exception e) {
						
						Thread.currentThread().interrupt();
						
						//h2.interrupt();
						
						//break;
						
					}
					
				}
				
			}
			
		};

	}
	
	public static Thread h1, h2;

}

class MarcoIH extends JFrame {
	
	public MarcoIH() {
		
		setSize(600, 450);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("Interrupción de hilos");
		
		JPanel lc = new JPanel();
		
		lc.setLayout(new GridLayout(1, 2));
		
		a1 = new JTextArea();
		
		a1.setBackground(Color.green);
		
		a1.setEditable(false);
		
		lc.add(a1);
		
		a2 = new JTextArea();
		
		a2.setBackground(Color.cyan);
		
		a2.setEditable(false);
		
		lc.add(a2);
		
		add(lc, BorderLayout.CENTER);
		
		JPanel ls = new JPanel();
		
		b1 = new JButton("Iniciar hilo 1");
		
		OyenteIH o = new OyenteIH();
		
		b1.addActionListener(o);
		
		ls.add(b1);
		
		b2 = new JButton("Detener hilo 1");
		
		b2.addActionListener(o);
		
		ls.add(b2);
		
		b3 = new JButton("Iniciar hilo 2");
		
		b3.addActionListener(o);
		
		ls.add(b3);
		
		b4 = new JButton("Detener hilo 2");
		
		b4.addActionListener(o);
		
		ls.add(b4);
		
		add(ls, BorderLayout.SOUTH);
		
	}
	
	private class OyenteIH implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource().equals(b1)) {
				
				InterrupcionHilos.h1.start();
				
			} else if(e.getSource().equals(b2)) {
				
				InterrupcionHilos.h1.interrupt();
				
			} else if(e.getSource().equals(b3)) {
				
				InterrupcionHilos.h2.start();
				
			} else {
				
				InterrupcionHilos.h2.interrupt();
				
			}
			
		}
		
	}
	
	
	public JTextArea a1, a2;
	
	private JButton b1, b2, b3, b4;
	
}