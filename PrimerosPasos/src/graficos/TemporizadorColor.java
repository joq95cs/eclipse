package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class TemporizadorColor {

	public static void main(String[] args) {

		MarcoTColor marco = new MarcoTColor();
		
		marco.setVisible(true);
		
	}

}

class MarcoTColor extends JFrame {
	
	public MarcoTColor() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(ancho/3, alto/3, ancho/3, alto/3);
		
		setTitle("Temporizador Color");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(false);
		
		LaminaTColor lamina = new LaminaTColor();
		
		add(lamina);
		
	}
	
}

class LaminaTColor extends JPanel {
	
	public LaminaTColor() {
		
		rojo = 0;
		
		verde = 0;
		
		azul = 0;
		
		setLayout(new BorderLayout());
		
		JPanel laminaNorte = new JPanel();
		
		OyenteLaminaTColor1 oyente1 = new OyenteLaminaTColor1();
		
		botonIniciar = new JButton("Iniciar");
		
		botonIniciar.addMouseListener(oyente1);
		
		botonDetener = new JButton("Detener");
		
		botonDetener.addMouseListener(oyente1);
		
		laminaNorte.add(botonIniciar);
		
		laminaNorte.add(botonDetener);
		
		laminaCentro = new JPanel();
		
		laminaCentro.setBackground(Color.BLACK);
		
		add(laminaNorte, BorderLayout.NORTH);
		
		add(laminaCentro, BorderLayout.CENTER);
		
		OyenteLaminaTColor2 oyente2 = new OyenteLaminaTColor2();
		
		temporizador = new Timer((int)(120000/Math.pow(255, 3)), oyente2);
		
	}
	
	private class OyenteLaminaTColor1 extends MouseAdapter {
		
		public void mouseClicked(MouseEvent e) {
			
			if(e.getSource() == botonIniciar) {
				
				temporizador.start();
				
			} else {
				
				temporizador.stop();
				
			}
			
		}
		
	}
	
	private class OyenteLaminaTColor2 extends AbstractAction {
		
		public void actionPerformed(ActionEvent e) {
			
			azul ++;
		
			if(azul == 256) {
				
				verde ++;
				
				azul = 0;
				
				if(verde == 256) {
					
					rojo ++;
					
					verde = 0;
					
					if(rojo == 256) {
						
						rojo = 0;
						
					}
					
				}
				
			}
			
			laminaCentro.setBackground(new Color(rojo, verde, azul));
			
		}
		
	}
	
	private JButton botonIniciar;
	
	private JButton botonDetener;
	
	private Timer temporizador;
	
	private JPanel laminaCentro;
	
	private static int rojo;
	
	private static int verde;
	
	private static int azul;
	
}