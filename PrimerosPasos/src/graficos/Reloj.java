package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.util.*;

import javax.swing.Timer;

public class Reloj {
	
	public static void main(String[] args) {
		
		MarcoReloj marco = new MarcoReloj();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		marco.setVisible(true);
		
	}
	
}

class MarcoReloj extends JFrame {
	
	public MarcoReloj() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(3*ancho/8, 3*alto/8, ancho/4, alto/4);
		
		setTitle("Reloj");
		
		setResizable(false);
		
		LaminaReloj lamina = new LaminaReloj();
		
		add(lamina);
		
	}
	
}

class LaminaReloj extends JPanel {
	
	public LaminaReloj() {
		
		setLayout(new BorderLayout());
		
		etiqueta = new JLabel("", JLabel.CENTER);
		
		add(etiqueta, BorderLayout.CENTER);
		
		ActionListener oyente = new OyenteReloj();
		
		Timer temporizador = new Timer(1000, oyente);
		
		temporizador.start();
		
	}
	
	private class OyenteReloj implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			etiqueta.setText("" + new Date());
			
		}
		
	}
	
	private JLabel etiqueta;
	
}