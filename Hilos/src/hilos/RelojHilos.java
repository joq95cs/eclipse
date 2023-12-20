package hilos;

import javax.swing.*;

import java.awt.*;

import java.util.*;

import java.text.*;

public class RelojHilos {

	public static void main(String[] args) {
		
		new MarcoRH().setVisible(true);
		
	}

}

class MarcoRH extends JFrame {
	
	public MarcoRH() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(false);
		
		setTitle("Reloj");
		
		add(new LaminaRH());
		
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(w/3, h/3, w/3, h/3);
		
	}
	
}

class LaminaRH extends JPanel{
	
	public LaminaRH() {
		
		setLayout(new GridLayout(2, 1));
		
		JPanel l1 = new JPanel();
		
		JPanel l2 = new JPanel();
		
		add(l1);
		
		add(l2);
		
		JLabel e1 = new JLabel("Hora ");
		
		c1 = new JTextField(5);
		
		c1.setEditable(false);
		
		l1.add(e1);
		
		l1.add(c1);
		
		JLabel e2 = new JLabel("Fecha ");
		
		c2 = new JTextField(6);
		
		c2.setEditable(false);
		
		l2.add(e2);
		
		l2.add(c2);
		
		iniciarHilos();
		
	}

	private void iniciarHilos() {
		
		new Thread(new RunHF(1)).start();
		
		new Thread(new RunHF(2)).start();
		
	}
	
	private JTextField c1, c2;
	
	class RunHF implements Runnable {
		
		public RunHF(int x) {
			
			this.x = x;
			
		}
		
		public void run() {
			
			if(x == 1) {
				
				while(true) {
					
					c1.setText(new SimpleDateFormat("hh:m:ss").format(new Date()));
					
					try {
						
						Thread.sleep(1000);
						
					} catch(InterruptedException e) {
						
						System.err.println("Error: " + e.getCause());
						
					}
					
				}
				
			} else {
				
				while(true) {
					
					c2.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
					
					try {
						
						Thread.sleep(1000);
						
					} catch(InterruptedException e) {
						
						System.err.println("Error: " + e.getCause());
						
					}
					
				}
				
			}
			
		}
		
		private int x;
		
	}
	
}