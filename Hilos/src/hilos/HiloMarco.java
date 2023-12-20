package hilos;

import javax.swing.*;

public class HiloMarco extends JFrame {
	
	public HiloMarco() {
		
		setSize(500, 350);
		
		setTitle("Hilo Marco");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		
		new Thread() {
			
			public void run() {
				
				new HiloMarco().setVisible(true);
				
			}
			
		}.start();

	}

}
