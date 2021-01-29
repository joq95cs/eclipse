package tap;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class Matriz_bidimensional {

	public static void main(String[] args) {
		
		MarcoMB marco = new MarcoMB();
		
		marco.setVisible(true);

	}

}

class MarcoMB extends JFrame {
	
	public MarcoMB() {
		
		ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(3*ancho/8, 3*alto/8, ancho/4, alto/4);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("Matriz bidimensional");
		
		setResizable(false);
		
		LaminaMB lamina = new LaminaMB();
		
		add(lamina);
		
	}
	
	private int ancho;
	
	private int alto;
	
}

class LaminaMB extends JPanel {
	
	public LaminaMB() {
		
		setLayout(new BorderLayout());
		
		lamina_norte = new JPanel();
		
		lamina_norte.setLayout(new GridLayout());
		
		add(lamina_norte, BorderLayout.NORTH);
		
		boton_cambiar = new JButton("Cambiar");
		
		boton_cambiar.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				String[][] aux = new String[4][4];
				
				for(int i=0; i<4; i++) {
					
					for(int j=0; j<4; j++) {
						
						aux[i][j] = campos[j][i].getText();
						
					}
					
				}
				
				for(int i=0; i<4; i++) {
					
					for(int j=0; j<4; j++) {
						
						campos[i][j].setText(aux[i][j]);
						
					}
					
				}
				
			}
			
		});
		
		lamina_norte.add(boton_cambiar, BorderLayout.NORTH);
		
		boton_llenar = new JButton("Llenar");
		
		boton_llenar.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				int contador = 1;
				
				for(int i=0; i<4; i++) {
					
					for(int j=0; j<4; j++) {
						
						campos[i][j].setText("" + contador);
						
						contador++;
						
					}
					
				}
				
			}
			
		});
		
		lamina_norte.add(boton_llenar);
		
		lamina_centro = new JPanel();
		
		lamina_centro.setLayout(new GridLayout(4, 4));
		
		add(lamina_centro, BorderLayout.CENTER);
		
		campos = new JTextField[4][4];
		
		for(int i=0; i<4; i++) {
			
			for(int j=0; j<4; j++) {
				
				campos[i][j] = new JTextField();
				
				lamina_centro.add(campos[i][j]);
				
			}
			
		}
		
	}
	
	private JPanel lamina_norte;
	
	private JPanel lamina_centro;
	
	private JButton boton_cambiar;
	
	private JButton boton_llenar;
	
	private JTextField[][] campos;
	
}
